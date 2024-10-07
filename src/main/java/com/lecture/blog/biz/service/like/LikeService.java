package com.lecture.blog.biz.service.like;

import com.lecture.blog.biz.service.like.vo.LikeReqVO;
import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;

public interface LikeService {

    /**
     * 게시글 좋아요 추가
     * @param reqVO
     * @return
     * @throws Exception
     */
    int savePostLike(LikeSaveReqVO reqVO) throws Exception;

    /**
     * 게시글 좋아요 체크
     * @param reqVO
     * @return
     * @throws Exception
     */
    boolean checkPostLike(LikeSaveReqVO reqVO) throws Exception;

    /**
     * 관심 게시글 목록 조회
     * @param reqVO
     * @return
     */
    PagingListVO<PostResVO> searchMyPostLikeList(LikeReqVO reqVO) throws Exception;

}
