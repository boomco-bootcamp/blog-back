package com.lecture.blog.biz.service.like.repo;

import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LikeRepository {

    // 게시글 좋아요 추가
    int insertPostLike(LikeSaveReqVO reqVO);

    // 게시글 댓글 삭제
    int deletePostLike(LikeSaveReqVO reqVO);

    // 게시글 좋아요 여부 검색
    Boolean isPostLike(LikeSaveReqVO reqVO);

}
