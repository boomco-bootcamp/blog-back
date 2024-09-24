package com.lecture.blog.biz.service.tag.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 게시글 태그 목록
 * blog_post_tag_l
 */
@Data
@Alias("TagVO")
public class TagVO {

	// 게시글 태그 ID
	private String blogPostTagId;

	// 게시글 ID
	private String blogPostId;

	// 게시글 태그 내용
	private String blogTagCon;

	// 삭제 여부	여부
	private String delYn;

	// 등록 사용자 ID
	private String rgsnUserId;


	// 등록 일시
	private String rgsnTs;

	// 수정 사용자 ID
	private String amnnUserId;


	// 수정 일시
	private String amnnTs;
}
