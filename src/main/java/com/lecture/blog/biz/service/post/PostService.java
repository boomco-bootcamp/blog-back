package com.lecture.blog.biz.service.post;

import com.lecture.blog.biz.service.post.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

import java.util.List;

/**
 * 게시글 관련 서비스
 */
public interface PostService {

    /**
     * 게시글 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    PagingListVO<PostResVO> searchPostInfoList(PostReqVO reqVO) throws Exception;

    /**
     * 게시글 상세 정보 조회
     *
     * @param reqVO
     * @return
     * @throws Exception
     */
    PostResVO searchPostInfo(PostReqVO reqVO) throws Exception;

    /**
     * 게시글 작성 및 수정
     * @param reqVO
     * @return
     * @throws Exception
     */
    int savePostInfo(PostSaveReqVO reqVO) throws Exception;

    /**
     * 게시글 삭제
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int deletePostInfo(PostSaveReqVO saveReqVO) throws Exception;

    /**
     * 블로그 게시글 방문자 수 통계
     * @param blogPostId
     * @return
     * @throws Exception
     */
    List<PostViewResVO> searchPostViewList(String blogPostId) throws Exception;

    /**
     * 블로그 게시글 좋아요 수 통계
     * @param blogPostId
     * @return
     * @throws Exception
     */
    List<PostLikeResVO> searchPostLikeList(String blogPostId) throws Exception;


}
