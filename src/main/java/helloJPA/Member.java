package helloJPA;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {
    // Identity 전략은 디비에 직접 PK를 넣으면 안, DB에서 Insert를 해야함 -> null로 들어오면 DB에서 값을 세팅함 -> DB에 값이 들어가야 PK 값을 알 수 있
    // 따라서 영속성 컨택스트에서는 ID 값을 1차 캐시에서 사용해야하기 때문에 예외적으로 persist 시점에 데이터베이스에 Insert 쿼리를 날린다.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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


