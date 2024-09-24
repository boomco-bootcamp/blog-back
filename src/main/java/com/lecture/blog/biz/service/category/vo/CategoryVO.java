package com.lecture.blog.biz.service.category.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * 게시글 카테고리 정보
 * blog_post_cat_info_m
 */
@Data
@Alias("CategoryVO")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO {

    // 게시글 카테고리 ID
    private String blogPostCatId;

    // 게시글 카테고리 명
    private String blogPostCatNm;

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

}
