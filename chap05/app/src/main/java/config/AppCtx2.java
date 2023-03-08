package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
public class AppCtx2 {
    /**
     * @return MemberRegisterService
     */
    @Bean
    public MemberRegisterService memberRegSvc() {
        return new MemberRegisterService();
    }

    @Bean
    public ChangePasswordService changePwdSvc() {
        return new ChangePasswordService();

    }

    /**
     * @return MemberListPrinter
     */
    @Bean
    public MemberListPrinter listPrinter() {
        return new MemberListPrinter();
    }
    
    /**
     * @return
     */
    @Bean
    public MemberInfoPrinter infoPrinter() {
        return new MemberInfoPrinter();
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
