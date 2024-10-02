package com.lecture.blog.biz.service.user;

import com.lecture.blog.app.utils.EncryptionUtils;
import com.lecture.blog.app.utils.JwtTokenUtil;
import com.lecture.blog.biz.service.sns.kakao.KakaoService;
import com.lecture.blog.biz.service.sns.kakao.vo.KakaoUserInfoVO;
import com.lecture.blog.biz.service.user.repo.UserRepository;
import com.lecture.blog.biz.service.user.vo.*;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 스터디 유저 관련 서비스 Impl
 */
@Slf4j
@Service("UserService")
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final JwtTokenUtil jwtTokenUtil;

    private final KakaoService kakaoService;

    public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil, KakaoService kakaoService) {
        this.userRepository = userRepository;
        this.jwtTokenUtil = jwtTokenUtil;
        this.kakaoService = kakaoService;
    }

    /**
     * 로그인
     * @param loginReqVO
     * @return
     * @throws Exception
     */
    @Override
    public String login(LoginReqVO loginReqVO) throws Exception {

        if(StringUtils.isBlank(loginReqVO.getUserId()) || StringUtils.isBlank(loginReqVO.getUserPswd())) {
            throw new Exception("아이디 혹은 패스워드를 입력해주세요.");
        }

        UserReqVO reqVO = new UserReqVO();
        reqVO.setUserId(loginReqVO.getUserId());
        reqVO.setPasswordYn("Y");
        UserInfoVO userInfo = this.searchUserInfo(reqVO);

        if(userInfo == null) {
            throw new Exception("해당 유저가 존재하지 않습니다.");
        }

        if(!EncryptionUtils.sha256Encode(loginReqVO.getUserPswd()).equals(userInfo.getUserPswd())){
            throw new Exception("아이디 혹은 패스워드를 확인해주세요.");
        }

        String jwt = jwtTokenUtil.makeJwt(userInfo.getUserId());

        return jwt;
    }

    /**
     * 로그인 for kakao
     * @param kakaoCode
     * @return
     * @throws Exception
     */
    @Override
    public String loginKakao(String kakaoCode) throws Exception {
        try {

            String jwt = "";

            // 카카오 code 로 accessToken 발급
            String accessToken = kakaoService.getAccessToken(kakaoCode);

            // 발급 받은 accessToken 으로 kakao 유저정보 조회
            KakaoUserInfoVO kakaoUserInfo = kakaoService.getUserInfo(accessToken);

            // kakao 유저 정보 파라메터 체크
            if(StringUtils.isBlank(kakaoUserInfo.getId())) throw new Exception("회원 정보가 존재하지 않습니다.");

            // 해당 유저가 회원 가입이 되어있는지 체크
            UserReqVO reqVO = new UserReqVO();
            reqVO.setUserSnsId(kakaoUserInfo.getId());
            reqVO.setUserSnsType("kakao");
            UserInfoVO userInfoVO = userRepository.selectUserInfoForSNS(reqVO);

            // 회원 가입이 되어있는 경우, jwt 토큰 발급
            if(userInfoVO != null) {
                jwt = jwtTokenUtil.makeJwt(userInfoVO.getUserId());
            }

            // 회원 가입이 되어있지 않은 경우, 회원 가입 후, jwt 토큰 발급
            else {
                // 회원 가입
                UserSaveReqVO saveReqVO = new UserSaveReqVO();
                // 랜덤 문자, 숫자 ID 생성
                String generatedString = RandomStringUtils.randomAlphanumeric(15);
                saveReqVO.setUserId(generatedString);
                saveReqVO.setUserNm(kakaoUserInfo.getNickname());
                saveReqVO.setUserSnsId(kakaoUserInfo.getId());
                saveReqVO.setUserSnsType("kakao");

                int insertResult = userRepository.insertUserInfo(saveReqVO);
                if(insertResult != 1) throw new Exception("카카오 회원연동에 실패했습니다.");

                // 유저 정보 재조회
                userInfoVO = userRepository.selectUserInfoForSNS(reqVO);
                jwt = jwtTokenUtil.makeJwt(userInfoVO.getUserId());
            }

            return jwt;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 로그아웃 for kakao
     * @param kakaoCode
     * @return
     * @throws Exception
     */
    @Override
    public int logoutKakao(String kakaoCode) throws Exception {
        try {
            // 카카오 code 로 accessToken 발급
            String accessToken = kakaoService.getAccessToken(kakaoCode);

            kakaoService.logout(accessToken);

            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 유저 정보 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public UserInfoVO searchUserInfo(UserReqVO reqVO) throws Exception {
        try {
            UserInfoVO result = userRepository.selectUserInfo(reqVO);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 회원 가입
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    @Override
    public int addUserInfo(UserSaveReqVO saveReqVO) throws Exception {
        try {

            UserReqVO userReqVO = new UserReqVO();
            userReqVO.setUserId(saveReqVO.getUserId());
            userReqVO.setDelCheck("Y");
            UserInfoVO userInfoVO = this.searchUserInfo(userReqVO);

            if(userInfoVO != null) throw new Exception("이미 존재하는 아이디 입니다.");

            // 패스워드 암호화
            saveReqVO.setUserPswd(EncryptionUtils.sha256Encode(saveReqVO.getUserPswd()));

            int result = userRepository.insertUserInfo(saveReqVO);

            // 회원 가입에 성공했을 때 블로그 생성
            if (result > 0) {
                BlogSaveReqVO blogSaveReqVO = new BlogSaveReqVO();
                // 블로그 생성시 기본값 설정
                blogSaveReqVO.setBlogId(saveReqVO.getUserId());
                blogSaveReqVO.setUserId(saveReqVO.getUserId());
                blogSaveReqVO.setBlogNm(saveReqVO.getUserId() + " 님의 블로그입니다.");
                blogSaveReqVO.setBlogCon("블로그의 소개글을 작성해보세요.");

                int blogResult = userRepository.insertBlogInfo(blogSaveReqVO);

                // 블로그 생성 확인
                if (blogResult <= 0) {
                    throw new Exception("블로그 생성에 실패했습니다.");
                }
            }


            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 회원 정보 변경
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    @Override
    public int updateUserInfo(UserSaveReqVO saveReqVO) throws Exception {
        try {
            if(!StringUtils.isBlank(saveReqVO.getUserPswd())) {
                // 패스워드 암호화
                saveReqVO.setUserPswd(EncryptionUtils.sha256Encode(saveReqVO.getUserPswd()));
            }
            int result = userRepository.updateUserInfo(saveReqVO);

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 회원 탈퇴
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public int deleteUserInfo(String userId) throws Exception {
        try {
            int result = userRepository.deleteUserInfo(userId);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 패스워드 찾기(임시 패스워드 발급)
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public int findPassword(UserFindReqVO reqVO) throws Exception {
        try {
            // 입력 받은 ID, 이메일 파라메터 체크
            if(StringUtils.isBlank(reqVO.getUserId()) && StringUtils.isBlank(reqVO.getUserEml())) {
                throw new Exception("아이디 혹은 이메일을 입력해주세요");
            }

            // 입력 받은 메일 체크
            UserReqVO userReqVO = new UserReqVO();
            userReqVO.setUserId(reqVO.getUserId());
            UserInfoVO userInfoVO = this.searchUserInfo(userReqVO);
            // 회원정보 체크
            if(userInfoVO == null) throw new Exception("해당 유저가 존재하지 않습니다.");
            // 등록한 이메일과 입력 받은 이메일 일치 확인
            if(!userInfoVO.getUserEml().equals(reqVO.getUserEml())) throw new Exception("아이디 혹은 이메일을 확인해주세요.");

            // 임시 패드워드 발급 후, 유저 정보 변경
            String tempPw = RandomStringUtils.randomAlphanumeric(20);
            UserSaveReqVO saveReqVO = new UserSaveReqVO();
            saveReqVO.setUserId(userInfoVO.getUserId());
            saveReqVO.setUserPswd(tempPw);
            saveReqVO.setUserNm(userInfoVO.getUserNm());
            saveReqVO.setUserEml(userInfoVO.getUserEml());
            saveReqVO.setUserTel(userInfoVO.getUserTel());
            saveReqVO.setUserSnsType(userInfoVO.getUserSnsType());
            saveReqVO.setUserSnsId(userInfoVO.getUserSnsId());
            this.updateUserInfo(saveReqVO);

            // 임시 패스워드 이메일 발송




        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
