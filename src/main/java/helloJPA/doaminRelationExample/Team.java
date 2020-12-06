package helloJPA.doaminRelationExample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @OneToMany(mappedBy = "team") // Member 클래스에 있는 team과 매핑이 되어 있다.
    private List<Member> members = new ArrayList<>(); // add 할 때, NPE 방지

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
