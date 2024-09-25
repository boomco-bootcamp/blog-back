package com.lecture.blog.biz.service.comment;

import com.lecture.blog.biz.service.comment.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

public interface CommentService {

    /**
     * 스터디 댓글 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    PagingListVO<CommentResVO> searchPostCommentList(CommentReqVO reqVO) throws Exception;



}
