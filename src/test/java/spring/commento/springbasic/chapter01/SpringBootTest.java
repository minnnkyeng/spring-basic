package spring.commento.springbasic.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.commento.springbasic.SpringBasicApplication;

// 빈이 등록되는 것을 확인 하기 위한 테스트 클래스
@Slf4j
public class SpringBootTest {

    @Test
    @DisplayName(" 빈_등록_테스트")
    void beanNameTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringBasicApplication.class);
        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
            log.info("빈 이름 {} 타입 {}", beanDefinitionName, applicationContext.getBean(beanDefinitionName).getClass().getSimpleName());
        }
    }
}