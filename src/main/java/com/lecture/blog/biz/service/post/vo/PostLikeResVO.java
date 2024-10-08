package com.lecture.blog.biz.service.post.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("PostLikeResVO")
public class PostLikeResVO {

    // 날짜 (YYYY-MM-DD)
    private String likeDate;

    // 방문객 숫자
    private int likeCnt;
}
