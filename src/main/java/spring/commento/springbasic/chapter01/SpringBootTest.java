package spring.commento.springbasic.chapter01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.commento.springbasic.SpringBasicApplication;
import spring.commento.springbasic.chapter01.config.AppConfig;
import spring.commento.springbasic.chapter01.repository.MemberRepository;

// 빈이 등록되는 것을 확인 하기 위한 테스트 클래스
@Slf4j
public class SpringBootTest {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        for (String beanDefinitionName : applicationContext.getBeanDefinitionNames()) {
//            log.info("빈 이름 {} 타입 {}", beanDefinitionName, applicationContext.getBean(beanDefinitionName).getClass().getSimpleName());
//        }

        MemberRepository companyMemberRepository1 = applicationContext.getBean("companyMemberRepository", MemberRepository.class);
        MemberRepository companyMemberRepository2 = applicationContext.getBean("companyMemberRepository", MemberRepository.class);

        log.info("\n 둘은 싱글톤일까요? {} ",companyMemberRepository1 == companyMemberRepository2);
    }
}
