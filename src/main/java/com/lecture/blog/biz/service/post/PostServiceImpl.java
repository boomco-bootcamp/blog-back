package com.lecture.blog.biz.service.post;

import com.lecture.blog.biz.service.comment.CommentService;
import com.lecture.blog.biz.service.comment.CommentServiceImpl;
import com.lecture.blog.biz.service.tag.TagService;

import com.lecture.blog.biz.service.post.vo.PostReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.tag.vo.TagVO;
import com.lecture.blog.biz.service.comment.vo.CommentResVO;
import com.lecture.blog.biz.service.comment.vo.CommentReqVO;
import com.lecture.blog.biz.service.comment.vo.CommentSaveReqVO;

import com.lecture.blog.biz.service.post.repo.PostRepository;
import com.lecture.blog.biz.service.comment.repo.CommentRepository;
import com.lecture.blog.biz.service.comment.CommentServiceImpl;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시글 관련 서비스 Impl
 */
@Slf4j
@Service("PostService")
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final TagService tagService;
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final CommentServiceImpl commentServiceImpl;



    public PostServiceImpl(PostRepository postRepository, TagService tagService, CommentService commentService, CommentRepository commentRepository, CommentServiceImpl commentServiceImpl) {
        this.postRepository = postRepository;
        this.tagService = tagService;
        this.commentService = commentService;
        this.commentRepository = commentRepository;
        this.commentServiceImpl = commentServiceImpl;
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

            // 게시글 태그 조회
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

    /**
     * 게시글 상세 정보 조회
     *
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public PostResVO searchPostInfo(PostReqVO reqVO) throws Exception {

        try {

            if(StringUtils.isBlank(reqVO.getBlogPostId())) return new PostResVO();

            // 게시글 상세 정보 조회
            PostResVO result = postRepository.selectPostInfo(reqVO.getBlogPostId());


            if (result != null) {
                // 태그 리스트 조회
                List<TagVO> tagList = tagService.searchTagList(result.getBlogPostId());
                result.setTagList(tagList);

                // 댓글 리스트 조회
                CommentReqVO commentReqVO = new CommentReqVO();
                commentReqVO.setBlogPostId(result.getBlogPostId());

                // 댓글 및 자식 댓글 조회 (searchPostCommentList 메서드 사용)
                PagingListVO<CommentResVO> commentPagingList = commentServiceImpl.searchPostCommentList(commentReqVO);
                List<CommentResVO> commentList = commentPagingList.getList();

                result.setCommentList(commentList); // PostResVO에 댓글 목록 필드가 있다고 가정

            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
