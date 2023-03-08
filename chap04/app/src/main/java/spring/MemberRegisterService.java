package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {
    
    @Autowired
    private MemberDao memberDao;

    public MemberRegisterService(/*MemberDao memberDao*/) {
        // this.memberDao = memberDao;
        // 위의 @Autowired 어노테이션이 붙은 변수 선언을 통해
        // memberDao의 의존성이 자동 주입되므로
        // 인자가 없는 기본생성자만으로도 충분함
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if(member != null) {
            //throw new DuplicateMemberException("dup email " + req.getEmail());
            throw new AlreadyExistingMemberException("dup email " + req.getEmail());
            /*
             * Assembler용 exception 처리: DuplicateMemberException
             * Spring용 exception 처리: AlreadyExcistingMemberException
             */
        }
        Member newMember = new Member(
            req.getEmail(), req.getPassword(), req.getName(),
            LocalDateTime.now());
        memberDao.insert(newMember);
        return newMember.getId();
    }

}
