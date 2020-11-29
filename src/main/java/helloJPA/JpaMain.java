package helloJPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        /*
        * EntityManagerFactory는 어플리케이션 실행될 때 딱 한개만 만들어야한다.
        * EntityManager 생성하는 건 데이터베이스 커넥션 1개 받아왔다고 생각하면 쉽다.
        * emf : 하나만 생성해서 애플리케이션 전체 공유 / em : 쓰레드 간에 공유 x

        * 데이터가 변경되는 모든 작업은 트랜잭션안에서 해야한다 !!
        * 트랜잭션 커밋 시점에 변경된 데이터가 있으면 Update Query를 생성한다.

        * JPQL은 SQL을 추상화한 객체 지향 쿼리 언어이다.
        * SQL과 문법 유사, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 지원
        * JPQL은 엔티티 객체를 대상으로 쿼리 / SQL은 데이터베이스 테이블 대상으로 쿼리
        */

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // 비영속
            Member member = new Member();
            member.setName("Hello");
            member.setId(1L);

            // 양속
            em.persist(member);

            // JPQL example
            List<Member> result = em.createQuery("select m from Member m", Member.class)
                .setFirstResult(5)
                .setMaxResults(8)
                .getResultList();

            // 1차 캐시 예시, 동일성 보장
            Member findMember1 = em.find(Member.class, 1L);
            Member findMember2 = em.find(Member.class, 1L);
            System.out.println("result = " + (findMember1 == findMember2));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
