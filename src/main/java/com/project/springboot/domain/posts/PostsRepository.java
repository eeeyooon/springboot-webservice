package com.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {


    /*
        06/02

        - 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자임.
          JPA에선 Repository라고 부르며 인터페이스로 생성함. 단순 인터페이스를 생성한 후,
          JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.

        - @Repository를 추가할 필요도 없음. 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야한다는 점임.
          둘은 아주 밀접한 관계고, Entity 클래스는 기본 Repository없이는 제대로 역할을 할 수가 없음.

     */
}
