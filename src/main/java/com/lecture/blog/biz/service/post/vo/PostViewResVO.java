package com.lecture.blog.biz.service.post.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("PostViewResVO")
public class PostViewResVO {

    // 날짜 (YYYY-MM-DD)
    private String viewDate;

    // 방문객 숫자
    private int viewCnt;
}
