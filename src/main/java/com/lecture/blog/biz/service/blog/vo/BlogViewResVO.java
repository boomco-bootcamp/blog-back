package com.lecture.blog.biz.service.blog.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("BlogViewResVO")
public class BlogViewResVO {

    // 날짜 (YYYY-MM-DD)
    private String viewDate;

    // 방문객 숫자
    private int viewCnt;

}
