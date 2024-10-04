package com.lecture.blog.biz.controller.sample;

import com.lecture.blog.biz.service.sample.SampleService;
import com.lecture.blog.biz.service.sample.vo.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/sample", produces = {MediaType.APPLICATION_JSON_VALUE})
public class SampleController {

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/test/db")
    public ResponseEntity dbConeectCheck() {
        try {
            SampleVO result = sampleService.dbConeectCheck();
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
