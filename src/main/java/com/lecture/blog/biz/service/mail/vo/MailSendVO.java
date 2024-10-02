package com.lecture.blog.biz.service.mail.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("MailSendVO")
public class MailSendVO {
    // 보내는 주소
    private String from;
    // 받는 주소
    private String to;
    // 제목
    private String subject;
    // 내용
    private String content;
}