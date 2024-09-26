package com.lecture.blog.biz.service.blog.vo;


import com.lecture.blog.biz.service.comon.vo.PageVO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 블로그 조회 관련 Req VO
 */
@Data
@Alias("BlogReqVO")
public class BlogReqVO extends PageVO {

    /*
     * 조회 검색 조건
     */
    // 검색어(게시글 명, 테그)
    private String searchCon;

    // 정렬 조건
    private String orderType;

    /*
     * 상세 검색 조건
     */

    // 블로그 ID
    private String blogId;

    /*
     * 유저 확인용
     */
    // 유저 ID
    private String userId;
    
}
