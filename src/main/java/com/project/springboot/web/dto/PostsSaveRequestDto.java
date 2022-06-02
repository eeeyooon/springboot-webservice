package com.project.springboot.web.dto;

import com.project.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;

    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

    /*
        06/02

        Entity 클래스와 거의 유사한 Dto 클래스를 추가로 생성한 이유
        -> Entity 클래스를 Request/Response 클래스로 사용하면 안됨.
           Entity 클래스는 데이터베이스와 맞닿은 핵심 클래스임. 수많은 서비스 클래스나 비지니스 로직들이
           Entity 클래스를 기준으로 동작함. 근데 Reqeust와 Response 용 Dto는 view를 위한 클래스라 정말 자주 변경됨.
           View Layer와 DB Layer의 역할 분리는 철저하게 하는 것이 좋음.

        => 꼭 Entity 클래스와 Controller에 쓸 Dto는 분리해서 사용해야 함.
     */
}
