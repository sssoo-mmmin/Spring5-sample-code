package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration  // 스프링 설정 클래스임을 알려주는 Annotation
public class AppCtx1 {   // spring framework 적용 후, Assembler class 역할을 함
    
    /*
     * 어떤 객체를 생성하고 의존을 주입할지 정의한 설정 정보 작성
     * @Bean으로 각 method가 생성한 객체를 스프링 빈으로 설정
     * 메서드 이름을 빈 객체의 이름으로 사용함
     * 설정 클래스만을 생성하면 되는것이 아니고 
     * AnnotationConfigApplicationContext 클래스를 이용하여
     * 스프링 컨테이너를 생성해야 사용할 수 있다.
     */
    @Bean
    public MemberDao memberDao() {
        return new MemberDao();
    }

    @Bean
    public MemberPrinter memberPrinter() {
        return new MemberPrinter();
    }
    
}
