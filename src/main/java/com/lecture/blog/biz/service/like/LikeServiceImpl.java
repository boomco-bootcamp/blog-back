package com.lecture.blog.biz.service.like;

import com.lecture.blog.biz.service.comon.vo.PagingListVO;
import com.lecture.blog.biz.service.like.repo.LikeRepository;
import com.lecture.blog.biz.service.like.vo.LikeReqVO;
import com.lecture.blog.biz.service.like.vo.LikeSaveReqVO;
import com.lecture.blog.biz.service.post.vo.PostResVO;
import com.lecture.blog.biz.service.tag.TagService;
import com.lecture.blog.biz.service.tag.vo.TagVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("LikeService")
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final TagService tagService;

    public LikeServiceImpl(LikeRepository likeRepository, TagService tagService) {
        this.likeRepository = likeRepository;
        this.tagService = tagService;
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

    /**
     * 게시글 좋아요 체크
     * @param reqVO
     * @return
     * @throws Exception
     */
    @Override
    public boolean checkPostLike(LikeSaveReqVO reqVO) throws Exception {
        try {
            // 좋아요 여부 확인
            Boolean isLikeChecked = likeRepository.isPostLike(reqVO);

            return isLikeChecked != null && isLikeChecked;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 관심 게시글 목록 조회
     * @param reqVO
     * @return
     */
    @Override
    public PagingListVO<PostResVO> searchMyPostLikeList(LikeReqVO reqVO) throws Exception {
        try {
            List<PostResVO> resultList = likeRepository.selectMyPostLikeList(reqVO);

            int totalCnt = likeRepository.selectMyPostLikeTotal(reqVO);

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


}
