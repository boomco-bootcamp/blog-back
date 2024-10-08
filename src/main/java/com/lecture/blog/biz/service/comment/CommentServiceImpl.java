package com.lecture.blog.biz.service.comment;

import com.lecture.blog.biz.service.comment.repo.CommentRepository;
import com.lecture.blog.biz.service.comment.vo.*;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("CommentService")
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    /**
     * 댓글 목록 조회
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public PagingListVO<CommentResVO> searchPostCommentList(CommentReqVO reqVO) throws Exception {
        try {
            // 게시글 댓글 목록 조회
            List<CommentResVO> resultList = commentRepository.selectPostCommentList(reqVO);
            // 게시글 댓글 카운트 조회
            int totalCnt = commentRepository.selectPostCommentListCnt(reqVO.getBlogPostId());

            // 댓글 목록이 존재하는 경우, 자식 댓글 조회
            for (CommentResVO x : resultList) {
                reqVO.setBlogParentCommentId(x.getBlogPostCommentId());
                reqVO.setPage(null); // 페이징 처리 하지 않음
                List<CommentResVO> childList = commentRepository.selectPostCommentList(reqVO);
                x.setBlogChildCommentList(childList);
            }

            return new PagingListVO<>(reqVO, resultList, totalCnt);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 게시글 댓글 작성
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public int savePostComment(CommentSaveReqVO reqVO) throws Exception {
        try {
            // UUID 생성
            reqVO.setBlogCommentId(UUID.randomUUID().toString());
            return commentRepository.insertPostComment(reqVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 게시글 댓글 삭제
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public int deletePostComment(CommentSaveReqVO reqVO) throws Exception {
        try {
            return commentRepository.deletePostComment(reqVO);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 내 게시글 댓글 조회
     * @param userId
     * @return
     */
    @Override
    public List<MyPostCommentResVO> searchMyPostCommentList(String userId, int limit) {
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("limit", limit);
            List<MyPostCommentResVO> resultList = commentRepository.selectMyPostCommentList(map);
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
