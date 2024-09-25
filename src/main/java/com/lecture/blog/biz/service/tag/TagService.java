package com.lecture.blog.biz.service.tag;

import com.lecture.blog.biz.service.tag.vo.TagVO;

import java.util.List;

public interface TagService {

    /**
     * 게시글 태그 목록 조회
     * @param blogPostId
     * @return
     * @throws Exception
     */
    List<TagVO> searchTagList(String blogPostId) throws Exception;

//    /**
//     * 인기 스터디 태그 목록 조회
//     * @return
//     * @throws Exception
//     */
//    List<TagVO> searchTagFavoriteList() throws Exception;
//
    /**
     * 게시글 태그 저장
     * @param tag
     * @return
     * @throws Exception
     */
    int insertTag(TagVO tag) throws Exception;

    /**
     * 게시글 태그 삭제
     * @param tag
     * @return
     * @throws Exception
     */
    int deleteTag(TagVO tag) throws Exception;

}
