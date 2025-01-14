package com.lecture.blog.biz.service.post.repo;

import com.lecture.blog.biz.service.post.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostRepository {

    /**************************************************
     * 게시글 정보
     **************************************************/

    // 게시글 정보 목록조회
    List<PostResVO> selectPostInfoList(PostReqVO reqVO);

    int selectPostInfoTotal(PostReqVO reqVO);

    // 게시글 상세 정보 조회
    PostResVO selectPostInfo(@Param("blogPostId")String blogPostId, @Param("userId")String userId);

    // 게시글 조회수 체크
    boolean checkPostViewed(PostReqVO reqVO);

    // 게시글 조회수 추가
    int insertPostView(PostReqVO reqVO);

    // 블로그 정보 작성
    int insertPostInfo(PostSaveReqVO saveReqVO);

    // 블로그 정보 수정
    int updatePostInfo(PostSaveReqVO saveReqVO);

    // 블로그 정보 삭제
    int deletePostInfo(PostSaveReqVO saveReqVO);

    // 블로그 게시글 방문자 수 통계
    List<PostViewResVO> selectPostViewList(@Param("blogPostId") String blogPostId);

    // 블로그 게시글 좋아요 수 통계
    List<PostLikeResVO> selectPostLikeList(@Param("blogPostId") String blogPostId);
}
