package com.project.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
        //when
        String body = this.restTemplate.getForObject("/", String.class);

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}

/*
    06/06
    이번 테스트는 실제로 URL 호출시 페이지의 내용이 제대로 호출되는지에 대한 테스트임.
    HTML도 결국은 규칙이 있는 문자열임. TestRestTemplate를 통해 "/"로 호출했을 때 index.mustache에 포함된 코드들이
    있는지 확인하면 됨. 전체 코드를 검증할 필요는 없으니 "스프링 부트로 시작하는 웹 서비스"문자열이 포함되어 있는지만 비교하면 됨.

 */
