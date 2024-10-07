package com.lecture.blog.biz.service.category.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("MyCategoryReqVO")
public class MyCategoryReqVO {

    // 유저 ID
    private String userId;

    // 블로그 카테고리 ID
    private String blogPostCatId;
}
