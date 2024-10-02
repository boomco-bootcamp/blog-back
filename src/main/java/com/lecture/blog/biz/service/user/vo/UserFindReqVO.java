package com.lecture.blog.biz.service.user.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("UserFindReqVO")
public class UserFindReqVO {

    private String userId;

    private String userEml;
}
