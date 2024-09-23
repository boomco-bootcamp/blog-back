-- 블로그 유저 계정 정보
CREATE TABLE blog.BLOG_USER_INFO_M
(
    USER_ID       VARCHAR(50)   NOT NULL, -- 유저 ID
    USER_PSWD     VARCHAR(1000) NULL,     -- 유저 패스워드
    USER_NM       VARCHAR(50)   NULL,     -- 유저명
    USER_EML      VARCHAR(255)  NULL,     -- 유저 이메일 주소
    USER_TEL      VARCHAR(30)   NULL,     -- 유저 전화번호
    USER_SNS_ID   VARCHAR(300)  NULL,     -- 유저 SNS ID
    USER_SNS_TYPE VARCHAR(50)   NULL,     -- 유저 SNS 타입
    DEL_YN        VARCHAR(1)    NULL,     -- 삭제 여부
    RGSN_USER_ID  VARCHAR(50)   NULL,     -- 등록 사용자
    RGSN_TS       TIMESTAMP     NULL,     -- 등록 일시
    AMNN_USER_ID  VARCHAR(50)   NULL,     -- 수정 사용자
    AMNN_TS       TIMESTAMP     NULL      -- 수정 일시
);

-- 블로그 유저 계정 정보
COMMENT ON TABLE blog.BLOG_USER_INFO_M IS '블로그 유저 계정 정보';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_ID IS '유저 ID';

-- 유저 패스워드
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_PSWD IS '소셜 로그인 시, NULL 가능';

-- 유저명
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_NM IS '유저명';

-- 유저 이메일 주소
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_EML IS 'char()';

-- 유저 전화번호
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_TEL IS '유저 전화번호';

-- 유저 SNS ID
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_SNS_ID IS '유저 SNS ID';

-- 유저 SNS 타입
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.USER_SNS_TYPE IS '유저 SNS 타입';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_USER_INFO_M.AMNN_TS IS '수정 일시';

-- 블로그 유저 계정 정보 기본키
CREATE UNIQUE INDEX PK_BLOG_USER_INFO_M
    ON blog.BLOG_USER_INFO_M
        ( -- 블로그 유저 계정 정보
         USER_ID ASC NULLS LAST -- 유저 ID
            );

-- 블로그 유저 계정 정보 기본키
COMMENT ON INDEX blog.PK_BLOG_USER_INFO_M IS '블로그 유저 계정 정보 기본키';

-- 블로그 유저 계정 정보
ALTER TABLE blog.BLOG_USER_INFO_M
    ADD CONSTRAINT PK_BLOG_USER_INFO_M
        -- 블로그 유저 계정 정보 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_USER_INFO_M
    NOT DEFERRABLE;

-- 블로그 유저 계정 정보 기본키
COMMENT ON CONSTRAINT PK_BLOG_USER_INFO_M ON blog.BLOG_USER_INFO_M IS '블로그 유저 계정 정보 기본키';

-- 블로그 정보
CREATE TABLE blog.BLOG_INFO_M
(
    BLOG_ID      VARCHAR(50)  NOT NULL, -- 블로그 ID
    USER_ID      VARCHAR(50)  NOT NULL, -- 유저 ID
    BLOG_NM      VARCHAR(100) NULL,     -- 블로그 명
    BLOG_CON     VARCHAR(500) NULL,     -- 블로그 내용
    DEL_YN       VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS      TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS      TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 정보
COMMENT ON TABLE blog.BLOG_INFO_M IS '블로그 정보';

-- 블로그 ID
COMMENT ON COLUMN blog.BLOG_INFO_M.BLOG_ID IS '블로그 ID';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_INFO_M.USER_ID IS '유저 ID';

-- 블로그 명
COMMENT ON COLUMN blog.BLOG_INFO_M.BLOG_NM IS 'NULL 인 경우, 유저 명 + 님의 블로그';

-- 블로그 내용
COMMENT ON COLUMN blog.BLOG_INFO_M.BLOG_CON IS '블로그 소개';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_INFO_M.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_INFO_M.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_INFO_M.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_INFO_M.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_INFO_M.AMNN_TS IS '수정 일시';

-- 블로그 정보 기본키
CREATE UNIQUE INDEX PK_BLOG_INFO_M
    ON blog.BLOG_INFO_M
        ( -- 블로그 정보
         BLOG_ID ASC NULLS LAST -- 블로그 ID
            );

-- 블로그 정보 기본키
COMMENT ON INDEX blog.PK_BLOG_INFO_M IS '블로그 정보 기본키';

-- 블로그 정보
ALTER TABLE blog.BLOG_INFO_M
    ADD CONSTRAINT PK_BLOG_INFO_M
        -- 블로그 정보 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_INFO_M
    NOT DEFERRABLE;

-- 블로그 정보 기본키
COMMENT ON CONSTRAINT PK_BLOG_INFO_M ON blog.BLOG_INFO_M IS '블로그 정보 기본키';

-- 블로그 방문자 목록
CREATE TABLE blog.BLOG_VIEWS_L
(
    BLOG_VIEWS_ID VARCHAR(100) NOT NULL, -- 블로그 방문자 ID
    BLOG_ID       VARCHAR(50)  NOT NULL, -- 블로그 ID
    RGSN_USER_ID  VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS       TIMESTAMP    NULL      -- 등록 일시
);

-- 블로그 방문자 목록
COMMENT ON TABLE blog.BLOG_VIEWS_L  IS '블로그 방문자 목록';

-- 블로그 방문자 ID
COMMENT ON COLUMN blog.BLOG_VIEWS_L .BLOG_VIEWS_ID IS '블로그 방문자 ID';

-- 블로그 ID
COMMENT ON COLUMN blog.BLOG_VIEWS_L .BLOG_ID IS '블로그 ID';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_VIEWS_L .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_VIEWS_L .RGSN_TS IS '등록 일시';

-- 블로그 방문자 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_VIEWS_L
    ON blog.BLOG_VIEWS_L
        ( -- 블로그 방문자 목록
         BLOG_VIEWS_ID ASC NULLS LAST -- 블로그 방문자 ID
            );

-- 블로그 방문자 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_VIEWS_L  IS '블로그 방문자 목록 기본키';

-- 블로그 방문자 목록
ALTER TABLE blog.BLOG_VIEWS_L
    ADD CONSTRAINT PK_BLOG_VIEWS_L
        -- 블로그 방문자 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_VIEWS_L
    NOT DEFERRABLE;

-- 블로그 방문자 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_VIEWS_L  ON blog.BLOG_VIEWS_L  IS '블로그 방문자 목록 기본키';

-- 블로그 게시글 목록
CREATE TABLE blog.BLOG_POST_L
(
    BLOG_POST_ID     VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    BLOG_ID          VARCHAR(50)  NOT NULL, -- 블로그 ID
    BLOG_POST_CAT_ID VARCHAR(100) NULL,     -- 블로그 게시글 카테고리 ID
    BLOG_POST_TITLE  VARCHAR(500) NULL,     -- 블로그 게시글 제목
    BLOG_POST_CON    TEXT         NULL,     -- 블로그 게시글 내용
    DEL_YN           VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID     VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS          TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID     VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS          TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 목록
COMMENT ON TABLE blog.BLOG_POST_L IS '블로그 게시글 목록';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_L.BLOG_POST_ID IS '블로그 게시글 ID';

-- 블로그 ID
COMMENT ON COLUMN blog.BLOG_POST_L.BLOG_ID IS '블로그 ID';

-- 블로그 게시글 카테고리 ID
COMMENT ON COLUMN blog.BLOG_POST_L.BLOG_POST_CAT_ID IS '블로그 게시글 카테고리 ID';

-- 블로그 게시글 제목
COMMENT ON COLUMN blog.BLOG_POST_L.BLOG_POST_TITLE IS '블로그 게시글 제목';

-- 블로그 게시글 내용
COMMENT ON COLUMN blog.BLOG_POST_L.BLOG_POST_CON IS '블로그 게시글 내용';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_L.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_L.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_L.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_L.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_L.AMNN_TS IS '수정 일시';

-- 블로그 게시글 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_L
    ON blog.BLOG_POST_L
        ( -- 블로그 게시글 목록
         BLOG_POST_ID ASC NULLS LAST -- 블로그 게시글 ID
            );

-- 블로그 게시글 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_L IS '블로그 게시글 목록 기본키';

-- 블로그 게시글 목록
ALTER TABLE blog.BLOG_POST_L
    ADD CONSTRAINT PK_BLOG_POST_L
        -- 블로그 게시글 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_L
    NOT DEFERRABLE;

-- 블로그 게시글 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_L ON blog.BLOG_POST_L IS '블로그 게시글 목록 기본키';

-- 블로그 게시글 태그 목록
CREATE TABLE blog.BLOG_POST_TAG_L
(
    BLOG_POST_TAG_ID VARCHAR(100) NOT NULL, -- 블로그 태그 ID
    BLOG_POST_ID     VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    BLOG_TAG_CON     VARCHAR(100) NULL,     -- 블로그 태그 내용
    DEL_YN           VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID     VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS          TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID     VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS          TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 태그 목록
COMMENT ON TABLE blog.BLOG_POST_TAG_L  IS '블로그 게시글 태그 목록';

-- 블로그 태그 ID
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .BLOG_POST_TAG_ID IS '블로그 태그 ID';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .BLOG_POST_ID IS '블로그 게시글 ID';

-- 블로그 태그 내용
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .BLOG_TAG_CON IS '블로그 태그 내용';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_TAG_L .AMNN_TS IS '수정 일시';

-- 블로그 게시글 태그 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_TAG_L
    ON blog.BLOG_POST_TAG_L
        ( -- 블로그 게시글 태그 목록
         BLOG_POST_TAG_ID ASC NULLS LAST -- 블로그 태그 ID
            );

-- 블로그 게시글 태그 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_TAG_L  IS '블로그 게시글 태그 목록 기본키';

-- 블로그 게시글 태그 목록
ALTER TABLE blog.BLOG_POST_TAG_L
    ADD CONSTRAINT PK_BLOG_POST_TAG_L
        -- 블로그 게시글 태그 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_TAG_L
    NOT DEFERRABLE;

-- 블로그 게시글 태그 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_TAG_L  ON blog.BLOG_POST_TAG_L  IS '블로그 게시글 태그 목록 기본키';

-- 블로그 게시글 댓글 목록
CREATE TABLE blog.BLOG_POST_COMMENT_L
(
    BLOG_POST_COMMENT_ID   VARCHAR(100) NOT NULL, -- 블로그 게시글 댓글 ID
    BLOG_POST_ID           VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    BLOG_COMMENT_CON       VARCHAR(500) NULL,     -- 블로그 댓글 내용
    BLOG_PARENT_COMMENT_ID VARCHAR(100) NULL,     -- 블로그 부모 댓글 ID
    DEL_YN                 VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID           VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS                TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID           VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS                TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 댓글 목록
COMMENT ON TABLE blog.BLOG_POST_COMMENT_L  IS '블로그 게시글 댓글 목록';

-- 블로그 게시글 댓글 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .BLOG_POST_COMMENT_ID IS '블로그 게시글 댓글 ID';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .BLOG_POST_ID IS '블로그 게시글 ID';

-- 블로그 댓글 내용
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .BLOG_COMMENT_CON IS '블로그 댓글 내용';

-- 블로그 부모 댓글 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .BLOG_PARENT_COMMENT_ID IS '블로그 부모 댓글 ID';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_L .AMNN_TS IS '수정 일시';

-- 블로그 게시글 댓글 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_COMMENT_L
    ON blog.BLOG_POST_COMMENT_L
        ( -- 블로그 게시글 댓글 목록
         BLOG_POST_COMMENT_ID ASC NULLS LAST -- 블로그 게시글 댓글 ID
            );

-- 블로그 게시글 댓글 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_COMMENT_L  IS '블로그 게시글 댓글 목록 기본키';

-- 블로그 게시글 댓글 목록
ALTER TABLE blog.BLOG_POST_COMMENT_L
    ADD CONSTRAINT PK_BLOG_POST_COMMENT_L
        -- 블로그 게시글 댓글 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_COMMENT_L
    NOT DEFERRABLE;

-- 블로그 게시글 댓글 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_COMMENT_L  ON blog.BLOG_POST_COMMENT_L  IS '블로그 게시글 댓글 목록 기본키';

-- 블로그 게시글 좋아요 목록
CREATE TABLE blog.BLOG_POST_LIKE_L
(
    BLOG_POST_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    USER_ID      VARCHAR(50)  NOT NULL, -- 유저 ID
    RGSN_USER_ID VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS      TIMESTAMP    NULL      -- 등록 일시
);

-- 블로그 게시글 좋아요 목록
COMMENT ON TABLE blog.BLOG_POST_LIKE_L  IS '블로그 게시글 좋아요 목록';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_LIKE_L .BLOG_POST_ID IS '블로그 게시글 ID';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_POST_LIKE_L .USER_ID IS '유저 ID';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_LIKE_L .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_LIKE_L .RGSN_TS IS '등록 일시';

-- 블로그 게시글 좋아요 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_LIKE_L
    ON blog.BLOG_POST_LIKE_L
        ( -- 블로그 게시글 좋아요 목록
         BLOG_POST_ID ASC NULLS LAST, -- 블로그 게시글 ID
         USER_ID ASC NULLS LAST -- 유저 ID
            );

-- 블로그 게시글 좋아요 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_LIKE_L  IS '블로그 게시글 좋아요 목록 기본키';

-- 블로그 게시글 좋아요 목록
ALTER TABLE blog.BLOG_POST_LIKE_L
    ADD CONSTRAINT PK_BLOG_POST_LIKE_L
        -- 블로그 게시글 좋아요 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_LIKE_L
    NOT DEFERRABLE;

-- 블로그 게시글 좋아요 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_LIKE_L  ON blog.BLOG_POST_LIKE_L  IS '블로그 게시글 좋아요 목록 기본키';

-- 블로그 게시글 카테고리 정보
CREATE TABLE blog.BLOG_POST_CAT_INFO_M
(
    BLOG_POST_CAT_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 카테고리 ID
    BLOG_POST_CAT_NM VARCHAR(50)  NULL,     -- 블로그 게시글 카테고리 명
    DEL_YN           VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID     VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS          TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID     VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS          TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 카테고리 정보
COMMENT ON TABLE blog.BLOG_POST_CAT_INFO_M   IS '블로그 게시글 카테고리 정보';

-- 블로그 게시글 카테고리 ID
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .BLOG_POST_CAT_ID IS '블로그 게시글 카테고리 ID';

-- 블로그 게시글 카테고리 명
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .BLOG_POST_CAT_NM IS '블로그 게시글 카테고리 명';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_CAT_INFO_M  .AMNN_TS IS '수정 일시';

-- 블로그 게시글 카테고리 정보 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_CAT_INFO_M
    ON blog.BLOG_POST_CAT_INFO_M
        ( -- 블로그 게시글 카테고리 정보
         BLOG_POST_CAT_ID ASC NULLS LAST -- 블로그 게시글 카테고리 ID
            );

-- 블로그 게시글 카테고리 정보 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_CAT_INFO_M   IS '블로그 게시글 카테고리 정보 기본키';

-- 블로그 게시글 카테고리 정보
ALTER TABLE blog.BLOG_POST_CAT_INFO_M
    ADD CONSTRAINT PK_BLOG_POST_CAT_INFO_M
        -- 블로그 게시글 카테고리 정보 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_CAT_INFO_M
    NOT DEFERRABLE;

-- 블로그 게시글 카테고리 정보 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_CAT_INFO_M   ON blog.BLOG_POST_CAT_INFO_M   IS '블로그 게시글 카테고리 정보 기본키';

-- 블로그 게시글 첨부파일 목록
CREATE TABLE blog.BLOG_POST_FILE_L
(
    BLOG_POST_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    FILE_ID      VARCHAR(100) NOT NULL, -- 파일 ID
    DEL_YN       VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS      TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS      TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 첨부파일 목록
COMMENT ON TABLE blog.BLOG_POST_FILE_L IS '블로그 게시글 첨부파일 목록';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.BLOG_POST_ID IS '블로그 게시글 ID';

-- 파일 ID
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.FILE_ID IS '파일 ID';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_FILE_L.AMNN_TS IS '수정 일시';

-- 블로그 게시글 첨부파일 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_FILE_L
    ON blog.BLOG_POST_FILE_L
        ( -- 블로그 게시글 첨부파일 목록
         BLOG_POST_ID ASC NULLS LAST, -- 블로그 게시글 ID
         FILE_ID ASC NULLS LAST -- 파일 ID
            );

-- 블로그 게시글 첨부파일 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_FILE_L IS '블로그 게시글 첨부파일 목록 기본키';

-- 블로그 게시글 첨부파일 목록
ALTER TABLE blog.BLOG_POST_FILE_L
    ADD CONSTRAINT PK_BLOG_POST_FILE_L
        -- 블로그 게시글 첨부파일 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_FILE_L
    NOT DEFERRABLE;

-- 블로그 게시글 첨부파일 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_FILE_L ON blog.BLOG_POST_FILE_L IS '블로그 게시글 첨부파일 목록 기본키';

-- 첨부파일 정보
CREATE TABLE blog.FILE_ATCH_M
(
    FILE_ID      VARCHAR(100)  NOT NULL, -- 파일 ID
    FILE_NM      VARCHAR(1000) NULL,     -- 파일 명
    FILE_PATH    VARCHAR(4000) NULL,     -- 파일 경로
    FILE_ENTS    VARCHAR(10)   NULL,     -- 파일 확장자
    FILE_PTRN    VARCHAR(100)  NULL,     -- 파일 유형
    FILE_SIZE    NUMERIC(15)   NULL,     -- 파일 크기
    DEL_YN       VARCHAR(1)    NULL,     -- 삭제 여부
    RGSN_USER_ID VARCHAR(50)   NULL,     -- 등록 사용자
    RGSN_TS      TIMESTAMP     NULL,     -- 등록 일시
    AMNN_USER_ID VARCHAR(50)   NULL,     -- 수정 사용자
    AMNN_TS      TIMESTAMP     NULL      -- 수정 일시
);

-- 첨부파일 정보
COMMENT ON TABLE blog.FILE_ATCH_M IS '첨부파일 정보';

-- 파일 ID
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_ID IS '파일 ID';

-- 파일 명
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_NM IS '파일 명';

-- 파일 경로
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_PATH IS '파일 경로';

-- 파일 확장자
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_ENTS IS '파일 확장자';

-- 파일 유형
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_PTRN IS '파일 유형';

-- 파일 크기
COMMENT ON COLUMN blog.FILE_ATCH_M.FILE_SIZE IS '파일 크기';

-- 삭제 여부
COMMENT ON COLUMN blog.FILE_ATCH_M.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.FILE_ATCH_M.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.FILE_ATCH_M.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.FILE_ATCH_M.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.FILE_ATCH_M.AMNN_TS IS '수정 일시';

-- 첨부파일 정보 기본키
CREATE UNIQUE INDEX PK_FILE_ATCH_M
    ON blog.FILE_ATCH_M
        ( -- 첨부파일 정보
         FILE_ID ASC NULLS LAST -- 파일 ID
            );

-- 첨부파일 정보 기본키
COMMENT ON INDEX blog.PK_FILE_ATCH_M IS '첨부파일 정보 기본키';

-- 첨부파일 정보
ALTER TABLE blog.FILE_ATCH_M
    ADD CONSTRAINT PK_FILE_ATCH_M
        -- 첨부파일 정보 기본키
        PRIMARY KEY
    USING INDEX PK_FILE_ATCH_M
    NOT DEFERRABLE;

-- 첨부파일 정보 기본키
COMMENT ON CONSTRAINT PK_FILE_ATCH_M ON blog.FILE_ATCH_M IS '첨부파일 정보 기본키';

-- 블로그 게시글 댓글 알림 목록
CREATE TABLE blog.BLOG_POST_COMMENT_ALARM_L
(
    BLOG_POST_COMMENT_ALARM_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 댓글 알림 목록 ID
    USER_ID                    VARCHAR(50)  NOT NULL, -- 유저 ID
    BLOG_POST_COMMENT_ID       VARCHAR(100) NOT NULL, -- 블로그 게시글 댓글 ID
    CHECK_YN                   VARCHAR(1)   NULL,     -- 확인 여부
    DEL_YN                     VARCHAR(1)   NULL,     -- 삭제 여부
    RGSN_USER_ID               VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS                    TIMESTAMP    NULL,     -- 등록 일시
    AMNN_USER_ID               VARCHAR(50)  NULL,     -- 수정 사용자
    AMNN_TS                    TIMESTAMP    NULL      -- 수정 일시
);

-- 블로그 게시글 댓글 알림 목록
COMMENT ON TABLE blog.BLOG_POST_COMMENT_ALARM_L IS '블로그 게시글 댓글 알림 목록';

-- 블로그 게시글 댓글 알림 목록 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.BLOG_POST_COMMENT_ALARM_ID IS '블로그 게시글 댓글 알림 목록 ID';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.USER_ID IS '유저 ID';

-- 블로그 게시글 댓글 ID
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.BLOG_POST_COMMENT_ID IS '블로그 게시글 댓글 ID';

-- 확인 여부
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.CHECK_YN IS '확인 여부';

-- 삭제 여부
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.DEL_YN IS '삭제 여부';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.RGSN_TS IS '등록 일시';

-- 수정 사용자
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.AMNN_USER_ID IS '수정 사용자';

-- 수정 일시
COMMENT ON COLUMN blog.BLOG_POST_COMMENT_ALARM_L.AMNN_TS IS '수정 일시';

-- 블로그 게시글 댓글 알림 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_COMMENT_ALARM_L
    ON blog.BLOG_POST_COMMENT_ALARM_L
        ( -- 블로그 게시글 댓글 알림 목록
         BLOG_POST_COMMENT_ALARM_ID ASC NULLS LAST -- 블로그 게시글 댓글 알림 목록 ID
            );

-- 블로그 게시글 댓글 알림 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_COMMENT_ALARM_L IS '블로그 게시글 댓글 알림 목록 기본키';

-- 블로그 게시글 댓글 알림 목록
ALTER TABLE blog.BLOG_POST_COMMENT_ALARM_L
    ADD CONSTRAINT PK_BLOG_POST_COMMENT_ALARM_L
        -- 블로그 게시글 댓글 알림 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_COMMENT_ALARM_L
    NOT DEFERRABLE;

-- 블로그 게시글 댓글 알림 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_COMMENT_ALARM_L ON blog.BLOG_POST_COMMENT_ALARM_L IS '블로그 게시글 댓글 알림 목록 기본키';

-- 블로그 게시글 방문자 목록
CREATE TABLE blog.BLOG_POST_VIEWS_L
(
    BLOG_POST_VIEWS_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 방문자 ID
    BLOG_POST_ID       VARCHAR(100) NOT NULL, -- 블로그 게시글 ID
    RGSN_USER_ID       VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS            TIMESTAMP    NULL      -- 등록 일시
);

-- 블로그 게시글 방문자 목록
COMMENT ON TABLE blog.BLOG_POST_VIEWS_L IS '블로그 게시글 방문자 목록';

-- 블로그 게시글 방문자 ID
COMMENT ON COLUMN blog.BLOG_POST_VIEWS_L.BLOG_POST_VIEWS_ID IS '블로그 게시글 방문자 ID';

-- 블로그 게시글 ID
COMMENT ON COLUMN blog.BLOG_POST_VIEWS_L.BLOG_POST_ID IS '블로그 게시글 ID';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_POST_VIEWS_L.RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_POST_VIEWS_L.RGSN_TS IS '등록 일시';

-- 블로그 게시글 방문자 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_POST_VIEWS_L
    ON blog.BLOG_POST_VIEWS_L
        ( -- 블로그 게시글 방문자 목록
         BLOG_POST_VIEWS_ID ASC NULLS LAST -- 블로그 게시글 방문자 ID
            );

-- 블로그 게시글 방문자 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_POST_VIEWS_L IS '블로그 게시글 방문자 목록 기본키';

-- 블로그 게시글 방문자 목록
ALTER TABLE blog.BLOG_POST_VIEWS_L
    ADD CONSTRAINT PK_BLOG_POST_VIEWS_L
        -- 블로그 게시글 방문자 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_POST_VIEWS_L
    NOT DEFERRABLE;

-- 블로그 게시글 방문자 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_POST_VIEWS_L ON blog.BLOG_POST_VIEWS_L IS '블로그 게시글 방문자 목록 기본키';

-- 블로그 관심 태그 목록
CREATE TABLE blog.BLOG_LIKE_TAG_L
(
    BLOG_LIKE_TAG_ID  VARCHAR(100) NOT NULL, -- 블로그 관심 태그 목록 ID
    USER_ID           VARCHAR(50)  NOT NULL, -- 유저 ID
    BLOG_LIKE_TAG_CON VARCHAR(100) NULL,     -- 관심 태그 내용
    RGSN_USER_ID      VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS           TIMESTAMP    NULL      -- 등록 일시
);

-- 블로그 관심 태그 목록
COMMENT ON TABLE blog.BLOG_LIKE_TAG_L  IS '블로그 관심 태그 목록';

-- 블로그 관심 태그 목록 ID
COMMENT ON COLUMN blog.BLOG_LIKE_TAG_L .BLOG_LIKE_TAG_ID IS '블로그 관심 태그 목록 ID';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_LIKE_TAG_L .USER_ID IS '유저 ID';

-- 관심 태그 내용
COMMENT ON COLUMN blog.BLOG_LIKE_TAG_L .BLOG_LIKE_TAG_CON IS '관심 태그 내용';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_LIKE_TAG_L .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_LIKE_TAG_L .RGSN_TS IS '등록 일시';

-- 블로그 관심 태그 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_LIKE_TAG_L
    ON blog.BLOG_LIKE_TAG_L
        ( -- 블로그 관심 태그 목록
         BLOG_LIKE_TAG_ID ASC NULLS LAST -- 블로그 관심 태그 목록 ID
            );

-- 블로그 관심 태그 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_LIKE_TAG_L  IS '블로그 관심 태그 목록 기본키';

-- 블로그 관심 태그 목록
ALTER TABLE blog.BLOG_LIKE_TAG_L
    ADD CONSTRAINT PK_BLOG_LIKE_TAG_L
        -- 블로그 관심 태그 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_LIKE_TAG_L
    NOT DEFERRABLE;

-- 블로그 관심 태그 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_LIKE_TAG_L  ON blog.BLOG_LIKE_TAG_L  IS '블로그 관심 태그 목록 기본키';

-- 블로그 관심 카테고리 목록
CREATE TABLE blog.BLOG_LIKE_CAT_R
(
    USER_ID          VARCHAR(50)  NOT NULL, -- 유저 ID
    BLOG_POST_CAT_ID VARCHAR(100) NOT NULL, -- 블로그 게시글 카테고리 ID
    RGSN_USER_ID     VARCHAR(50)  NULL,     -- 등록 사용자
    RGSN_TS          TIMESTAMP    NULL      -- 등록 일시
);

-- 블로그 관심 카테고리 목록
COMMENT ON TABLE blog.BLOG_LIKE_CAT_R  IS '블로그 관심 카테고리 목록';

-- 유저 ID
COMMENT ON COLUMN blog.BLOG_LIKE_CAT_R .USER_ID IS '유저 ID';

-- 블로그 게시글 카테고리 ID
COMMENT ON COLUMN blog.BLOG_LIKE_CAT_R .BLOG_POST_CAT_ID IS '블로그 게시글 카테고리 ID';

-- 등록 사용자
COMMENT ON COLUMN blog.BLOG_LIKE_CAT_R .RGSN_USER_ID IS '등록 사용자';

-- 등록 일시
COMMENT ON COLUMN blog.BLOG_LIKE_CAT_R .RGSN_TS IS '등록 일시';

-- 블로그 관심 카테고리 목록 기본키
CREATE UNIQUE INDEX PK_BLOG_LIKE_CAT_R
    ON blog.BLOG_LIKE_CAT_R
        ( -- 블로그 관심 카테고리 목록
         USER_ID ASC NULLS LAST, -- 유저 ID
         BLOG_POST_CAT_ID ASC NULLS LAST -- 블로그 게시글 카테고리 ID
            );

-- 블로그 관심 카테고리 목록 기본키
COMMENT ON INDEX blog.PK_BLOG_LIKE_CAT_R  IS '블로그 관심 카테고리 목록 기본키';

-- 블로그 관심 카테고리 목록
ALTER TABLE blog.BLOG_LIKE_CAT_R
    ADD CONSTRAINT PK_BLOG_LIKE_CAT_R
        -- 블로그 관심 카테고리 목록 기본키
        PRIMARY KEY
    USING INDEX PK_BLOG_LIKE_CAT_R
    NOT DEFERRABLE;

-- 블로그 관심 카테고리 목록 기본키
COMMENT ON CONSTRAINT PK_BLOG_LIKE_CAT_R  ON blog.BLOG_LIKE_CAT_R  IS '블로그 관심 카테고리 목록 기본키';