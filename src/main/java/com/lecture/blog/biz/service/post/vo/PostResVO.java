package com.lecture.blog.biz.service.post.vo;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

import com.lecture.blog.biz.service.tag.vo.TagVO;
import com.lecture.blog.biz.service.comment.vo.CommentResVO;
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
    // 블로그 게시글 등록자 ID;
    private String userId;
    // 블로그 명;
    private String blogNm;

    // 블로그 게시글 등록자;
    private String blogUserNm;


    // 삭제 여부
    private String delYn;

    // 이전 게시글 ID
    private String previousBlogPostId;
    // 다음 게시글 ID
    private String nextBlogPostId;



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
    // 댓글 목록
    private List<CommentResVO> commentList;


    // 총 방문자 수
    private int postViewsCnt;

    // 총 댓글 수
    private int postCommentCnt;

    // 총 좋아요 수
    private int postLikeCnt;

    // 좋아요 여부
    private String likeYn = "N";
}