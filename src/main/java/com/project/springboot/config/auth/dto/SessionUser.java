package com.project.springboot.config.auth.dto;

import com.project.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;


//SessionUser에는 인증된 사용자 정보만 필요함. 그외 필요한 정보들이 없으니 name, email, picture만 필드로 선언함.

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }

    /*
        06/09
        1. (SessionUser) httpSession.getAttribute("user")
            - 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했음.
            - 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있음.

        2. if (User != null)
            - 세션에 저장된 값이 있을 때만 model에 userName으로 등록함.
            - 세션에 저장된 값이 없으면 model에 아무런 값이 없는 상태이니 로그인 버튼이 보이게 됨.
     */
}
