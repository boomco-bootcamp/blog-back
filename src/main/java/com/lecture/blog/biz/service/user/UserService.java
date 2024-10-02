package com.lecture.blog.biz.service.user;

import com.lecture.blog.biz.service.user.vo.LoginReqVO;
import com.lecture.blog.biz.service.user.vo.UserInfoVO;
import com.lecture.blog.biz.service.user.vo.UserReqVO;
import com.lecture.blog.biz.service.user.vo.UserSaveReqVO;

public interface UserService {

    /**
     * 로그인
     * @param loginReqVO
     * @return
     * @throws Exception
     */
    String login(LoginReqVO loginReqVO) throws Exception;

    /**
     * 로그인 for kakao
     * @param kakaoCode
     * @return
     * @throws Exception
     */
    String loginKakao(String kakaoCode) throws Exception;

    /**
     * 로그아웃 for kakao
     * @param kakaoCode
     * @return
     * @throws Exception
     */
    int logoutKakao(String kakaoCode) throws Exception;

    /**
     * 유저 정보 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    UserInfoVO searchUserInfo(UserReqVO reqVO) throws Exception;

    /**
     * 회원 가입
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int addUserInfo(UserSaveReqVO saveReqVO) throws Exception;

    /**
     * 회원 정보 변경
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int updateUserInfo(UserSaveReqVO saveReqVO) throws Exception;

    /**
     * 회원 탈퇴
     * @param userId
     * @return
     * @throws Exception
     */
    int deleteUserInfo(String userId) throws Exception;
}
