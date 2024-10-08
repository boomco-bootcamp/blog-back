package com.lecture.blog.biz.service.comment.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("MyPostCommentResVO")
public class MyPostCommentResVO {

    // 게시글 댓글 ID
    private String blogPostCommentId;

    // 게시글 ID
    private String blogPostId;

    // 댓글 내용
    private String blogCommentCon;

    // 게시글 명
    private String blogPostTitle;

    // 삭제 여부
    private String delYn;

    // 등록 사용자
    private String rgsnUserId;
    // 등록 사용자 명
    private String rgsnUserNm;

    // 등록 일시
    private Timestamp rgsnTs;

    // 수정 사용자
    private String amnnUserId;
    // 수정 사용자 명
    private String amnnUserNm;

    // 수정 일시
    private Timestamp amnnTs;
}
