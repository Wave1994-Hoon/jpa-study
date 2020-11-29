package helloJPA;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {


    @Id
    private long id;
    private String name;

    // JPA는 내부적으로 리플렉션을 하기때문에 기본 생성자가 있어야함
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
