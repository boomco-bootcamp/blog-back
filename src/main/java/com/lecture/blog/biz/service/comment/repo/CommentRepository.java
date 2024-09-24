package com.lecture.blog.biz.service.comment.repo;

import com.lecture.blog.biz.service.comment.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentRepository {

    // 게시글 댓글 목록 조회
    List<CommentResVO> selectPostCommentList(CommentReqVO reqVO);

    // 게시글 댓글 카운트 조회
    int selectPostCommentListCnt(@Param("blogPostId")String blogPostId);

}
