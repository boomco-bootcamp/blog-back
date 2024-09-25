package com.lecture.blog.biz.service.comment.vo;

import com.lecture.blog.biz.service.comon.vo.PageVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("CommentReqVO")
public class CommentReqVO extends PageVO {

    // 게시글 ID
    private String blogPostId;

    // 게시글 부모 댓글 ID
    private String blogParentCommentId;
}
