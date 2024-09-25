package com.lecture.blog.biz.service.user.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("LoginReqVO")
public class LoginReqVO {

    // 유저 ID
    private String userId;
    // 유저 패스워드
    private String userPswd;
}
