package com.lecture.blog.biz.service.blog.vo;


import com.lecture.blog.biz.service.comon.vo.PageVO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * 블로그 저장 관련 Req VO
 */
@Data
@Alias("BlogSaveReqVO")
public class BlogSaveReqVO extends PageVO {

    // 블로그 ID
    private String blogId;

    // 블로그 명
    private String blogNm;

    // 블로그 소개
    private String blogCon;

    // 블로그 배너 파일 ID
    private String blogBannerFileId;

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


    /*
     * 방문자 저장용
     */

    // 블로그 방문자 ID
    private String blogViewId;

    /*
     * 유저 확인용
     */
    // 유저 ID
    private String userId;
    
}
