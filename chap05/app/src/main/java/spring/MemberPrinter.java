package spring;

import java.time.format.DateTimeFormatter;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.lang.Nullable;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    }

    /**
     * @param member
     */
    public void print(Member member) {
        if(dateTimeFormatter == null) {
            System.out.printf(
                "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                member.getId(), member.getEmail(),
                member.getName(), member.getRegisterDateTime());
        } else {
            System.out.printf(
                "회원 정보: 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                member.getId(), member.getEmail(),
                member.getName(),
                dateTimeFormatter.format(member.getRegisterDateTime()));
        }
        
    }

    /**
     * @param dateTimeFormatter
     */
    @Autowired(required = false)
    public void setDateFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    // public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
    //     if(formatterOpt.isPresent()) {
    //         this.dateTimeFormatter = formatterOpt.get();
    //     } else {
    //         this.dateTimeFormatter = null;
    //     }
    // } -> java 8에서 제공하는 Optional
    // 일치하는 빈이 존재하지 않으면 값이 없는 Optional을 인자로 전달
    // 일치하는 빈이 존재하면 해당 빈을 값으로 갖는 Optional을 인자로 전달
    
    // public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
    //     this.dateTimeFormatter = dateTimeFormatter;
    // } -> spring 제공 어노테이션
    // 자동주입할 빈이 존재하면 빈을 인자로 전달
    // 없으면 null 전달
}