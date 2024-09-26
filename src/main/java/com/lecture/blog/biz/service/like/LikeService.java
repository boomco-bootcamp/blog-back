package com.lecture.blog.biz.service.like;

import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

public interface LikeService {

    /**
     * 게시글 좋아요 추가
     * @param reqVO
     * @return
     * @throws Exception
     */
    int savePostLike(LikeSaveReqVO reqVO) throws Exception;

}
