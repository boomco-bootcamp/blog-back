package com.lecture.blog.biz.service.tag.repo;

import com.lecture.blog.biz.service.tag.vo.TagVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TagRepository {

    // 스터디 태그 목록 조회
    List<TagVO> selectBlogTagList(@Param("blogPostId")String blogPostId);

//    // 인기 스터디 태그 목록 조회
//    List<TagVO> selctTagFavoriteList();
//
//    // 스터디 태그 저장
//    int insertStudyTag(TagVO tagVO);
//
//    // 스터디 태그 삭제
//    int deleteStudyTag(TagVO tagVO);

}
