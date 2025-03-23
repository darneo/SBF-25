package kz.kbtu.annotationawtowired;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnotationAwtowiredApplication {
    private static final Logger log = LoggerFactory.getLogger(AnnotationAwtowiredApplication.class);

    private final FooService fooService;

    @Autowired  // Внедряем зависимость через конструктор
    public AnnotationAwtowiredApplication(FooService fooService) {
        this.fooService = fooService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AnnotationAwtowiredApplication.class, args);
    }

    @PostConstruct
    public void init() {
        log.info(fooService.toString());
    }
}
