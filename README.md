# springboot-webservice
스프링부트와 AWS로 혼자 구현하는 웹 서비스  
2022.05.31 ~ 2022.06.26

📑 [노션 스터디페이지](https://eeeyooon.notion.site/Spring-study-97b16a12bf33484a968a616254f9bfec)

<br>

### 📘 책의 구성
이 책은 인텔리제이에 스프링 부트 개발환경 구축, 테스트 코드를 작성하는 방법, 스프링 부트에서 데이터베이스 다루기, OAuth2를 이용한 로그인 기능 구현, AWS 배포와 365일 24시간 무중단 서비스를 만드는 방법의 순서로 이루어져 있다. 스프링 부트의 다양한 어노테이션들을 활용하면서, 간단한 게시판 페이지를 만들고, 필수라고 할 수 있는 소셜 로그인 기능의 구현, 그리고 AWS에 배포하는 방법을 배울 수 있다. 또한 각 코드에서 사용되는 어노테이션이나 메소드의 기능이 코드 아래에 적혀있어서 코드 전체를 이해하는데 더욱 도움을 준다. 

<br>


### 🛠 실습 환경
- JAVA (1.8, Zulu Open JDK)
- Spring Boot (2.3.3)
- Mustache (2.3.3)
- Gradle 
- IntelliJ 
- H2 Database (1.4.197)
- Maria DB (10.4.8)

<br>

<br>

### 💻 서비스 구현 화면
#### 소셜로그인(구글, 네이버) 후 글 작성/수정/삭제
![Inked스프링부트-웹서비스-사이트_mark_](https://user-images.githubusercontent.com/102462534/182026539-b06d3d7f-3a0f-48ca-9923-76fa1da66d98.gif)

<br>

#### 로그인한 사용자 리스트 DB로 확인(user테이블)
<br>

![user테이블](https://user-images.githubusercontent.com/102462534/182026546-8108325d-5fd9-4f35-b537-305fff95b401.png)

<br>


#### 글 작성 목록 (post테이블)
<br>

![post테이블](https://user-images.githubusercontent.com/102462534/182026561-4fbd47ee-f607-4a84-a12f-34319f11969f.png)

<br>

#### travis CI를 사용한 배포 자동화 (자동화 빌드 히스토리)
<br>

![travis CI 자동화 빌드 히스토리](https://user-images.githubusercontent.com/102462534/182026553-ac70ebe3-9261-430b-82c1-34f98bd597ec.png)

<br>

#### trvais CI 최근 빌드 목록
<br>

![travis CI 최근 빌드](https://user-images.githubusercontent.com/102462534/182026549-8ba3a300-eb5c-4e7a-93fa-893f0e6b4ab0.png)



