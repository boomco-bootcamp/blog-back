package com.lecture.blog.biz.service.mail;

import com.lecture.blog.biz.service.mail.vo.MailSendVO;

public interface MailService {

    /**
     * 메일 전송
     * @param mailSendVO
     * @throws Exception
     */
    void mailSend(MailSendVO mailSendVO) throws Exception;


}
