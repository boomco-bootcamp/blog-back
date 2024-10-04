package com.lecture.blog.biz.service.file.vo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("FileVO")
public class FileVO {

    // 파일 ID
    private String fileId;

    // 파일 명
    private String fileNm;

    // 파일 경로
    private String filePath;

    // 파일 확장자
    private String fileEnts;

    // 파일 유형
    private String filePtrn;

    // 파일 크기
    private int fileSize;

    // 등록 사용자 ID
    private String rgsnUserId;

    // 등록 일시
    private String rgsnTs;

    // 수정 사용자 ID
    private String amnnUserId;

    // 수정 일시
    private String amnnTs;

}
