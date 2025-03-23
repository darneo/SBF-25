package kz.kbtu.annotationvalue;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AnnotationValueApplication {
    private static final Logger log =LoggerFactory.getLogger(AnnotationValueApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AnnotationValueApplication.class, args);
    }

    @Value("#{someBean.someValue}")
    private String someBeanValue;

    @PostConstruct
    public void init() {
        log.info(someBeanValue);
    }
}
