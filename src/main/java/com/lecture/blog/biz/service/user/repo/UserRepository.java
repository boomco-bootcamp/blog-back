package com.lecture.blog.biz.service.user.repo;

import com.lecture.blog.biz.service.user.vo.UserInfoVO;
import com.lecture.blog.biz.service.user.vo.UserReqVO;
import com.lecture.blog.biz.service.user.vo.UserSaveReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    // 유저 정보 조회
    UserInfoVO selectUserInfo(UserReqVO reqVO);

    // 회원 가입
    int insertUserInfo(UserSaveReqVO saveReqVO);

    // 회원 정보 변경
    int updateUserInfo(UserSaveReqVO saveReqVO);

    // 회원 탈퇴
    int deleteUserInfo(@Param("userId") String userId);

    // 블로그 정보 생성
    int insertBlogInfo (BlogSaveReqVO blogSaveReqVO);

}
