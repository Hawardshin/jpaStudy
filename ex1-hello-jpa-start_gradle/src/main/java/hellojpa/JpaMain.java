package hellojpa;

import java.util.List;

import jakarta.persistence.*;

public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        //엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 획득
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            logic(em);
            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }
    }
    private static void logic(EntityManager em){
        String id = "id1";
        Member member = new Member();
        member.setId(id);
        member.setUsername("지한");
        member.setAge(2);
        System.out.println("등록!!!");
        //등록
        em.persist(member);
        System.out.println("등록 완료!!!");
        //수정
        System.out.println("수정!!!");
        member.setAge(20);
        System.out.println("수정 완료!!!");
        //한 건 조회
        System.out.println("한 건 조회!!!");
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember = " + findMember.getUsername() + ", age=" + findMember.getAge());

        //목록 조회
        System.out.println("목록 조회!!!");
        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println("members.size = " + members.size());

        //삭제
        System.out.println("삭제!!!");
        em.remove(member);
        System.out.println("삭제 완료!!!");
    }
}
