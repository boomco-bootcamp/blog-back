package com.lecture.blog.biz.service.sample.repo;

import com.lecture.blog.biz.service.sample.vo.SampleVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleRepository {

    // DB 연결 확인 샘플 레포지토리
    SampleVO dbConeectCheck();

}
