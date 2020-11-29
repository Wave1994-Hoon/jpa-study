# JPA ??
- JPA는 애플리케이션괴 JDBC 사이에서 동작
    - JAVA Application > JPA > JDBC <------- SQL ------> DB

- JPA는 JDBC API 사용해서 DB로 쿼리 날림

- JPA는 인터페이스의 모임
    - JPA 2.1 표준 명세서를 구현한 3가지 구현체 : hibernate, EclipseLink, DataNucleus

- JPA 성능 최적화 기능
    - 1차 캐시와 동일성 보장
        - 같은 트랜잭션 안에서는 같은 엔티티 반환 -> 트랜잭션 내에서 동일한 객체를 조회 시 캐싱-> 약간의 조회 성능 향상
    - 트랜잭션을 지원하는 쓰지 지연
           - 커밋할 때까지 INSERT SQL 모음

    - 지연 로딩
