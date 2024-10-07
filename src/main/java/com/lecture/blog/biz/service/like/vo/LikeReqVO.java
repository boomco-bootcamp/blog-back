package com.lecture.blog.biz.service.like.vo;

import com.lecture.blog.biz.service.comon.vo.PageVO;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("LikeReqVO")
public class LikeReqVO extends PageVO {

    // 유저 ID
    private String userId;

}
