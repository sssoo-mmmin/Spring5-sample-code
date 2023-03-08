package config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
//import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
//import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
public class AppCtx2 {
    // @Autowired
    // private MemberDao memberDao;
    // @Autowired
    // private MemberPrinter memberPrinter;
    // @Autowired
    // private MemberSummaryPrinter summaryPrinter;


    /**
     * @return MemberRegisterService
     */
    @Bean
    public MemberRegisterService memberRegSvc() {
        // MemberRegisterService class에서 
        // memberDao에 대한 의존성 주입을 자동화했기 때문에
        // 이 부분에서 인자 없는 생성자로 호출하여 return값으로 보낸다
        return new MemberRegisterService(/*memberDao*/);
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        ChangePasswordService pwdSvc = new ChangePasswordService();
        // pwdSvc.setMemberDao(memberDao);
        // 의존을 주입하지 않아도 스프링이 @Autowired가 붙인 필드에
        // 해당 타입의 빈 객체를 찾아서 주입한다
        return pwdSvc;
        // 더 줄이면
        // return new ChangePasswordService();
        // 가 된다
    }

    /**
     * @return MemberListPrinter
     */
    @Bean
    public MemberListPrinter listPrinter() {
        // MemberListService class에서 
        // memberDao와 memberPrinter 대한 의존성 주입을 자동화했기 때문에
        // 이 부분에서 인자 없는 생성자로 호출하여 return값으로 보낸다
        return new MemberListPrinter(/*memberDao, memberPrinter*/);
    }
    
    /**
     * @return
     */
    @Bean
    public MemberInfoPrinter infoPrinter() {
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        // infoPrinter.setMemberDao(memberDao);
        // infoPrinter.setPrinter(memberPrinter);
        // @Autowired는 메서드에도 붙일 수 있다.
        return infoPrinter;
        // 더 줄이면
        // return new MemberInfoPrinter();
        // 가 된다
    }

    /**
     * @return
     */
    @Bean
    public VersionPrinter versionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }

    @Bean
    public VersionPrinter oldVersionPrinter() {
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(4);
        versionPrinter.setMinorVersion(3);
        return versionPrinter;
    }
    
}
