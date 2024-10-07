package com.lecture.blog.biz.service.category.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("MyCategorySaveReqVO")
public class MyCategorySaveReqVO {

    // 유저 ID
    private String userId;

    // 블로그 카테고리 ID
    private String blogPostCatId;

    // 등록 사용자
    private String rgsnUserId;

    // 등록 일시
    private Timestamp rgsnTs;
}
