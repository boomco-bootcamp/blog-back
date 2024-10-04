package com.lecture.blog.biz.service.file.repo;

import com.lecture.blog.biz.service.file.vo.FileSaveReqVO;
import com.lecture.blog.biz.service.file.vo.FileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FileRepository {

    // 파일 정보 조회
    FileVO selectFileInfo(@Param("fileId") String fileId);

    // 파일 정보 등록
    int insertFileInfo(FileSaveReqVO fileVO);

}
