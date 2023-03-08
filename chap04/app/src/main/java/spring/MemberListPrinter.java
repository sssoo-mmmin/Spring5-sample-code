package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
    
    private MemberDao memberDao;
    private MemberPrinter printer;

    /**
     * 
     */
    public MemberListPrinter(/*MemberDao memberDao, MemberPrinter printer*/) {
        // this.memberDao = memberDao;
        // this.printer = printer;
        // 밑의 @Autowired 어노테이션이 붙은 set~메서드를 통해 의존성 주입되므로
        // 인자가 없는 기본생성자만으로도 충분함
    }

    // @Autowired 메서드 추가
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    /**
     * @param memberPrinter
     */
    @Autowired
    @Qualifier("summaryPrinter")
    public void setMemberPrinter(MemberSummaryPrinter printer) {
        this.printer = printer;
    }

    public void printAll() {
        Collection<Member> members = memberDao.selectAll();
        members.forEach(m -> printer.print(m));
    }
}
