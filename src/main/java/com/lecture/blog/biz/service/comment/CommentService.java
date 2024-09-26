package com.lecture.blog.biz.service.comment;

import com.lecture.blog.biz.service.comment.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;

public interface CommentService {

    /**
     * 게시글 댓글 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    PagingListVO<CommentResVO> searchPostCommentList(CommentReqVO reqVO) throws Exception;

    /**
     * 게시글 댓글 작성
     * @param reqVO
     * @return
     * @throws Exception
     */
    int savePostComment(CommentSaveReqVO reqVO) throws Exception;

    /**
     * 게시글 댓글 삭제
     * @param reqVO
     * @return
     * @throws Exception
     */
    int deletePostComment(CommentSaveReqVO reqVO) throws Exception;



}
