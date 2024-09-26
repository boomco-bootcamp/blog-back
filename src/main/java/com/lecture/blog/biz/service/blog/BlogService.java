package com.lecture.blog.biz.service.blog;

import com.lecture.blog.biz.service.blog.vo.BlogInfoVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.blog.vo.BlogReqVO;
import com.lecture.blog.biz.service.blog.vo.BlogResVO;
import com.lecture.blog.biz.service.blog.vo.BlogSaveReqVO;


/**
 * 블로그 관련 서비스
 */
public interface BlogService {

    /**
     * 블로그 정보 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    BlogInfoVO searchBlogInfo(BlogReqVO reqVO) throws Exception;

    /**
     * 블로그 정보 변경
     * @param saveReqVO
     * @return
     * @throws Exception
     */
    int updateBlogInfo(BlogSaveReqVO saveReqVO) throws Exception;




}
