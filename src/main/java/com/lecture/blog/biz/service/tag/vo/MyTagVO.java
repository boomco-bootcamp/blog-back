package com.lecture.blog.biz.service.tag.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@Alias("MyTagVO")
public class MyTagVO {

    // 스터디 관심 태그 목록 ID
    private String blogLikeTagId;

    // 유저 ID
    private String userId;

    // 관심 태그 내용
    private String blogLikeTagCon;

    // 등록 사용자
    private String rgsnUserId;

    // 등록 일시
    private Timestamp rgsnTs;
}
