package com.project.springboot.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)

@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    // 테스트가 통과함 > 검증용으로 선언했던 .andExpect(status().isOK())와 .andExpect(content().string(hello))가 모두 통과했다는 뜻.

    /*
        05/31

        1. @ExtendWith(SpringExtension.class)
            - 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킴.
            - 여기서는 SpringExtension이라는 스프링 실행자를 사용함.
            - 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
        
        2. @WebMvcTest
            - 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션임.
            - 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음.
            - 단, @Service, @Component, @Resitory 등은 사용할 수 없음.
            - 여기서는 컨트롤러만 사용하기 때문에 선언함.
        
        3. @AutoWired
            - 스프링이 관리하는 빈(Bean)을 주입 받음.
        
        4. private MockMvc mvc
            - 웹 API를 테스트할 때 사용함.
            - 스프링 MVC 테스트이 시작점.
            - 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음.
            
        5. mvc.perform(get("/hello"))
            - MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함.
            - 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있음.
            
        6. .andExpect(status().isOk())
            - mvc.perform의 결과를 검증함.
            - HTTP Header의 Status를 검증함.
            - 우리가 흔히 알고 있는 200, 404, 500 등의 상태를 검증함.

         7. .andExpect(content().string(hello))
            - mvc.perform의 결과를 검증함.
            - 응답 본문의 내용을 검증함.
            - Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증함.
            
     */

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name", name)
                                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


        // 추가된 API도 테스트 실행 > JSON이 리턴되는 API 역시 정상적으로 테스트가 통과하는 것을 확인할 수 있음.

        /*
               06/02

            1. param
                - API 테스트할 때 사용될 요청 파라미터를 설정합니다.
                - 단, 값은 String만 허용됩니다.
                - 그래서 숫자/날짜 드으이 데이터도 등록할 때는 문자열로 변경해야만 가능합니다.

            2. jsonPath
                - JSON 응답값을 필드별로 검증할 수 있는 메소드입니다.
                - $를 기준으로 필드명을 명시합니다.
                - 여기서는 name과 amount를 검증하니 $.name, $.amount로 검증합니다.



         */


    }
}
