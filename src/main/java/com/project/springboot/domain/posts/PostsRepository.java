package com.project.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDESC();


    /*
        06/02

        - 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자임.
          JPA에선 Repository라고 부르며 인터페이스로 생성함. 단순 인터페이스를 생성한 후,
          JpaRepository<Entity 클래스, PK 타입>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨.

        - @Repository를 추가할 필요도 없음. 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치해야한다는 점임.
          둘은 아주 밀접한 관계고, Entity 클래스는 기본 Repository없이는 제대로 역할을 할 수가 없음.

        06/06

        - SpringDataJap에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 되는 것을 보여드리고자 @Query를 사용함.
        - 실제로 앞의 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있지만,
          @Query가 훨씬 가독성이 좋으니 선택해서 사용하면 됨.
     */
}
