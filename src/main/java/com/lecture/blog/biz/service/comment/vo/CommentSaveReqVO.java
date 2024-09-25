package com.lecture.blog.biz.service.comment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("StudyCommentSaveReqVO")
public class CommentSaveReqVO {

    // 게시글 댓글 ID
    private String blogCommentId;

    // 게시글 ID
    private String blogPostId;

    // 게시글 댓글 내용
    private String blogCommentCon;

    // 게시글 부모 댓글 ID
    private String blogParentCommentId;

    // 등록 사용자
    private String rgsnUserId;

    // 수정 사용자
    private String amnnUserId;
}
