package com.lecture.blog.biz.service.mail;

import com.lecture.blog.biz.service.mail.vo.MailSendVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MailServiceImpl implements MailService {

    /**
     * 메일 전송
     * @param mailSendVO
     * @throws Exception
     */
    @Override
    public void mailSend(MailSendVO mailSendVO) throws Exception {
        SimpleMailMessage
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        message.setFrom("wisejohn950330@gmail.com");
        message.setReplyTo("wisejohn950330@gmail.com");

        System.out.println("message"+message);
        javaMailSender.send(message);
    }
}
