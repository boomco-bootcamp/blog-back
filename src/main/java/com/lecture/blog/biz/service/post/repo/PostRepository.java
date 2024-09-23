package com.lecture.blog.biz.service.post.repo;

import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostRepository {

    /**************************************************
     * 게시글 정보
     **************************************************/

    // 게시글 정보 목록조회
    List<PostResVO> selectPostInfoList(PostReqVO reqVO);


}
