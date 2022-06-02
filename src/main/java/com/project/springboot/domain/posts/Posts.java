package com.project.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;

    }

    public void update(String title, String content) {

        this.title = title;
        this.content = content;
    }

     /*

        06/02

        - domain 패키지는 도메인을 담을 패키지임. 여기서 도메인은 게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한
          요구사항 혹은 문제 영역이라고 생각하면 됨.

        - @Entity는 JPA의 어노테이션이며, @Getter와 @NoArgsConstructor는 롬복의 어노테이션임.
        롬복은 코드를 단순화시켜주지만 필수 어노테이션은 아님.

        - Posts 클래스는 실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고도 함. JPA를 사용하시면 DB 데이터에
          DB데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업함.

        - Posts 클래스에는 JPA에서 제공하는 어노테이션들이 몇 개 있음.

            1. @Entity
                - 테이블과 링크될 클래스임을 나타냄.
                - 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭함.
                    ex) SalesManger.java > sales_manager table
            2. @id
                - 해당 태이블의 PK 필드를 나타냄.
            3. @GenerateValue
                - PK의 생성 규칙을 나타냄.
                - 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 됨.
                - 웬만하면 Entity의 PK는 Long 타입의 Auto_increment를 추천함. (**)
            4. @Column
                - 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됨.
                - 사용하는 이유는, 기본값 이외에 추가로 변경이 필요한 옵션이 있으면 사용함.
                - 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex. title),
                 타입을 TEXT로 변경하고 싶은 경우(ex. content) 등에 사용됨.
            5. @NoArgsConstructor
                - 기본 생성자 자동 추가
                - public Posts() {}와 같은 효과
            6. @Getter
                - 클래스 내 모든 필드의 Getter 메소드를 자동 생성
            7. @Builder
                - 해당 클래스의 빌더 패턴 클래스를 생성
                - 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함


              **** Entity 클래스에서는 절대 Setter 메소드를 만들지 않음.
                   대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도롤 나타낼 수 있는 메소드를 추가해야 함.

     */


}
