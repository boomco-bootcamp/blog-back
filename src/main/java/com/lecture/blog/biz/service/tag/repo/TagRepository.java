package com.lecture.blog.biz.service.tag.repo;

import com.lecture.blog.biz.service.tag.vo.MyTagSaveReqVO;
import com.lecture.blog.biz.service.tag.vo.MyTagVO;
import com.lecture.blog.biz.service.tag.vo.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagRepository {

    // 블로그 게시글 태그 목록 조회
    List<TagVO> selectBlogTagList(@Param("blogPostId")String blogPostId);

    // 게시글 태그 저장
    int insertPostTag(TagVO tagVO);

    // 블로그 태그 삭제
    int deletePostTag(TagVO tagVO);

    /**************************************************
     * 관심 태그 목록
     **************************************************/

    // 관심 태그 목록 조회
    List<MyTagVO> selectMyTagList(@Param("loginUserId") String loginUserId);

    // 관심 태그 추가
    int insertMyTag(MyTagSaveReqVO saveReqVO);

    // 관심 태그 삭제
    int deleteMyTag(MyTagSaveReqVO saveReqVO);

}
