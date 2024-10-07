package com.lecture.blog.biz.service.tag;

import com.lecture.blog.biz.service.tag.repo.TagRepository;
import com.lecture.blog.biz.service.tag.vo.MyTagSaveReqVO;
import com.lecture.blog.biz.service.tag.vo.MyTagVO;
import com.lecture.blog.biz.service.tag.vo.TagVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("TagService")
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    /**
     * 스터디 태그 목록 조회
     * @param blogPostId
     * @return
     * @throws Exception
     */
    @Override
    public List<TagVO> searchTagList(String blogPostId) throws Exception {
        try {
            List<TagVO> resultList = tagRepository.selectBlogTagList(blogPostId);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 관심 태그 목록 조회
     * @param loginUserId
     * @return
     * @throws Exception
     */
    @Override
    public List<MyTagVO> searchMyTagList(String loginUserId) throws Exception {
        try {
            // 관심 태그 목록 조회
            List<MyTagVO> resultList = tagRepository.selectMyTagList(loginUserId);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 게시글 태그 저장
     * @param tag
     * @return
     * @throws Exception
     */
    @Override
    public int insertTag(TagVO tag) throws Exception {
        try {
            return tagRepository.insertPostTag(tag);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 스터디 태그 삭제
     * @param tag
     * @return
     * @throws Exception
     */
    @Override
    public int deleteTag(TagVO tag) throws Exception {
        try {
            return tagRepository.deletePostTag(tag);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 관심 태그 추가
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    @Override
    public int addMyTag(MyTagSaveReqVO saveReqVO) throws Exception {
        try {
            saveReqVO.setBlogLikeTagId(UUID.randomUUID().toString());
            return tagRepository.insertMyTag(saveReqVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 관심 태그 삭제
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    @Override
    public int deleteMyTag(MyTagSaveReqVO saveReqVO) throws Exception {
        try {
            return tagRepository.deleteMyTag(saveReqVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
