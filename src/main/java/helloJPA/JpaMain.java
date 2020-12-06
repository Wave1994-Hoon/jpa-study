package helloJPA;

import helloJPA.doaminRelationExample.Member;
import helloJPA.doaminRelationExample.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Team team = new Team();
            team.setUserName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUserName("member1");
            member.changeTeam(team); // ** 연관관계 편의 메서드 생성
            em.persist(member);

            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시 때문에, em.flush / clear 해줘야함
            List<Member> members = findTeam.getMembers(); // 따라서 빈 값 있을거임, 따라서 JPA가 commit 시점에 값을 세팅 해줄지라도 양쪽에 값 세팅해야

            for (Member m : members) {
                System.out.println("m = " + m.getUserName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
