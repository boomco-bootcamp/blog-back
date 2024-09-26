package com.lecture.blog.biz.service.like;

import com.lecture.blog.biz.service.comment.CommentService;
import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.like.repo.LikeRepository;
import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("LikeService")
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    /**
     * 게시글 좋아요 추가
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public int savePostLike(LikeSaveReqVO reqVO) throws Exception {
        try {
            // 좋아요 여부 확인
            Boolean isLikeChecked = likeRepository.isPostLike(reqVO);

            // 좋아요가 존재하면 삭제, 존재하지 않으면 저장
            if (isLikeChecked) {
                return likeRepository.deletePostLike(reqVO);  // 좋아요 삭제
            } else {
                return likeRepository.insertPostLike(reqVO);  // 좋아요 추가
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }



}
