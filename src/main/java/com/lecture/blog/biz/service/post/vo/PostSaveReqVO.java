package com.lecture.blog.biz.service.post.vo;

import com.lecture.blog.biz.service.tag.vo.TagVO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

@Data
@Alias("PostSaveReqVO")
public class PostSaveReqVO {

    // 블로그 게시글 ID
    private String blogPostId;
    // 블로그 게시글 제목
    private String blogPostTitle;
    // 블로그 게시글 내용
    private String blogPostCon;

    // 블로그 게시글 카테고리 ID
    private String blogPostCatId;

    // 블로그 게시글 태그 리스트
    private List<TagVO> tagList;

    // 등록 사용자
    private String rgsnUserId;

    // 수정 사용자
    private String amnnUserId;
}

