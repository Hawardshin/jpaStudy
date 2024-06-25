package hellojpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberMapper memberMapper = context.getBean(MemberMapper.class);

        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);
        System.out.println("등록!!!");
        // 등록
        memberMapper.insertMember(member);
        System.out.println("등록 완료!!!");
        // 수정
        System.out.println("수정!!!");
        member.setAge(20);
        memberMapper.updateMember(member);
        System.out.println("수정 완료!!!");
        // 한 건 조회
        System.out.println("한 건 조회!!!");
        Member findMember = memberMapper.selectMember(id);
        System.out.println("findMember = " + findMember.getUsername() + ", age=" + findMember.getAge());

        // 목록 조회
        System.out.println("목록 조회!!!");
        List<Member> members = memberMapper.selectAllMembers();
        System.out.println("members.size = " + members.size());

        // 삭제
        System.out.println("삭제!!!");
        memberMapper.deleteMember(id);
        System.out.println("삭제 완료!!!");
    }
}