package com.lecture.blog.biz.service.blog;

import com.lecture.blog.app.utils.EncryptionUtils;

import com.lecture.blog.biz.service.blog.repo.BlogRepository;

import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;
import com.lecture.blog.biz.service.user.vo.UserReqVO;
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

            // 블로그 방문자 추가
            if (reqVO.getUserId() != null) {
                // 방문 정보가 이미 존재하는지 확인
                boolean checkBlogView = blogRepository.checkBlogViewed(reqVO);

                // 중복되지 않은 경우에만 방문자 추가
                if (!checkBlogView) {
                    // UUID 발급
                    String blogViewId = UUID.randomUUID().toString();
                    reqVO.setBlogViewId(blogViewId);

                    blogRepository.insertBlogView(reqVO);
                }
            }

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
