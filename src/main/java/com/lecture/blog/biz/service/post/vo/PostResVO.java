package com.lecture.blog.biz.service.post.vo;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

import com.lecture.blog.biz.service.tag.vo.TagVO;

/**
 * 게시글 조회 관련 Res VO
 */
@Data
@Alias("PostResVO")
public class PostResVO {

    // 블로그 게시글 ID
    private String blogPostId;
    // 블로그 ID
    private String blogId;
    // 블로그 게시글 카테고리 ID
    private String blogPostCatId;
    // 블로그 게시글 제목
    private String blogPostTitle;
    // 블로그 게시글 내용
    private String blogPostCon;
    // 삭제 여부
    private String delYn;

    // 등록 사용자
    private String rgsnUserId;
    // 등록 일시
    private Timestamp rgsnTs;

    // 수정 사용자
    private String amnnUserId;
    // 수정 일시
    private Timestamp amnnTs;

    // 카테고리 이름
    private String blogPostCatNm;
    // 태그 목록
    private List<TagVO> tagList;

    // 총 방문자 수
    private int postViewsCnt;

    // 총 댓글 수
    private int postCommentCnt;

}