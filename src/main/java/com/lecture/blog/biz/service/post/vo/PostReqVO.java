package com.lecture.blog.biz.service.post.vo;


import com.lecture.blog.biz.service.comon.vo.PageVO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 블로그 조회 관련 Req VO
 */
@Data
@Alias("PostReqVO")
public class PostReqVO extends PageVO {

    /*
     * 조회 검색 조건
     */
    // 검색어(게시글 명, 테그)
    private String searchCon;

    // 게시글 카테고리 ID
    private String blogPostCatId;

    // 정렬 조건
    private String orderType;

    /*
     * 상세 검색 조건
     */
    // 게시글 ID
    private String blogPostId;
    // 블로그 ID
    private String blogId;

    
}
