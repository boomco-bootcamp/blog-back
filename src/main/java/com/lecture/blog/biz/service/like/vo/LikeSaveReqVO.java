package com.lecture.blog.biz.service.like.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("LikeSaveReqVO")
public class LikeSaveReqVO {

    // 블로그 게시글 ID
    private String blogPostId;

    // 유저 ID
    private String userId;

    // 등록 사용자
    private String rgsnUserId;

    // 등록 일시
    private String rgsnTs;

}
