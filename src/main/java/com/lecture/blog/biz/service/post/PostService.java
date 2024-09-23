package com.lecture.blog.biz.service.post;

import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

/**
 * 스터디 관련 서비스
 */
public interface PostService {

    /**
     * 스터디 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    PagingListVO<PostResVO> searchPostInfoList(PostReqVO reqVO) throws Exception;

}
