package com.project.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //JPA Auditing 활성화 (application.java에서 옮겨옴)
public class JpaConfig {
}
