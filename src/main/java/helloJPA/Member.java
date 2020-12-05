package helloJPA;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    // 데이터 베이스는 DATE, TIME, TIMESTAMP를 구분하기 때문에 매핑 정보가 필요
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    // Varchar보다 큰 값을 넣고 싶으면 Lob 사용 -> 문자 타입은 Clob으로 생성됨
    @Lob
    private String description;

    // JPA는 내부적으로 리플렉션을 하기때문에 기본 생성자가 있어야함
    public Member() {
    }
}


