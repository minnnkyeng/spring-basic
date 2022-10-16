package spring.commento.springbasic.chapter02;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 로그 찍는 방법 실습
 */
@Slf4j
public class LogService {

    private final Logger log1 = LoggerFactory.getLogger(getClass());

    private final Logger log2 = LoggerFactory.getLogger(LogService.class);

    public void testLog() {

        log1.info("\n 로그 첫 번째 방식 입니다.");

        log2.info("\n 로그 두 번째 방식 입니다");

        log.info("\n 로그 세 번째 방식 (롬복 입니다 )");
    }

}
