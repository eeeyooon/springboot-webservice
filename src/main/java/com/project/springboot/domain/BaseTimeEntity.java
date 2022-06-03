package com.project.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}

//Posts 클래스가 BaseTimeEntity를 상속받도록 변경
//Application 클래스에 JPA Auditing 활성화 어노테이션 추가 (EnableJpaAuditing)

/*
    06/03
    BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할

    1. @MappedSuperclass
        - JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우필드들(createdDate, modifiedDate)도 칼럼으로 인식하게 함.

    2. @EntityListeners(AuditingEntityListener.class)
        - BaseTimeEntity 클래스에 Auditing 기능을 포함시킴.

    3. @CreateDate
        - Entity가 생성되어 저장될 때 시간이 자동 저장됨.

    4. @LastModifiedDate
        - 조회한 Entity의 값을 변경할때 시간이 자동 저장됨.



 */