package com.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        
        
    /*    
        05/31
        
        Application 클래스 : 앞으로 만들 프로젝트의 메인 클래스
        
         - @SpringBootApplication으로 인해 스플이 부트의 자동 설정, 스프링 Bean 읽기와 생성을 자동으로 설정함.
           특히나 @SpringBootApplication이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 함.
            
         - main 메소드에서 실행하는 SpringApplication.run으로 인해 내장 WAS를 실행함.
            -> 이렇게 되면 항상 서버에 톰캣을 설치할 필요가 없게 되고, 스프링부트로 만들어진 Jar 파일로 실행하면 됨.

            => 스프링 부트에서는 내장 WAS를 사용하는 것을 권장함. > 언제 어디서나 같은 환경에서 스프링 부트를 배포할 수 있기 때문에


                내장 WAS(Web Application Server, 웹 애플리케이션 서버)
                : 별도로 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 말함.
                Jar 파일 
                : 실행 가능한 Java 패키징 파일
          
     */
        
    }
}
