package com.lecture.blog.biz.service.blog;

import com.lecture.blog.app.utils.EncryptionUtils;

import com.lecture.blog.biz.service.blog.repo.BlogRepository;

import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * 블로그 관련 서비스 Impl
 */
@Slf4j
@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;


    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * 블로그 정보 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public BlogInfoVO searchBlogInfo(BlogReqVO reqVO) throws Exception {
        try {
            BlogInfoVO result = blogRepository.selectBlogInfo(reqVO);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 블로그 정보 변경
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    @Override
    public int updateBlogInfo(BlogSaveReqVO saveReqVO) throws Exception {
        try {
            int result = blogRepository.updateBlogInfo(saveReqVO);
            return result;

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
