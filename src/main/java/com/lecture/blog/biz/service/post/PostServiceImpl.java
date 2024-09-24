package com.lecture.blog.biz.service.post;

import com.lecture.blog.biz.service.tag.TagService;

import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.tag.vo.TagVO;

import com.lecture.blog.biz.service.post.repo.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 게시글 관련 서비스 Impl
 */
@Slf4j
@Service("PostService")
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final TagService tagService;

    public PostServiceImpl(PostRepository postRepository, TagService tagService) {
        this.postRepository = postRepository;
        this.tagService = tagService;

    }

    /**
     * 게시글 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public PagingListVO<PostResVO> searchPostInfoList(PostReqVO reqVO) throws Exception {
        try {
            // 게시글 조회
            List<PostResVO> resultList = postRepository.selectPostInfoList(reqVO);
            // 게시글 토탈 카운트 조회
            int totalCnt = postRepository.selectPostInfoTotal(reqVO);

            // 게시글 테그 조회
            for(PostResVO x : resultList){
                List<TagVO> tagList = tagService.searchTagList(x.getBlogPostId());
                x.setTagList(tagList);
            }

            return new PagingListVO(reqVO, resultList, totalCnt);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
