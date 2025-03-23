package kz.kbtu.annotationvalue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class SomeBean {
    @Value("${priority}")
    private String someValue;
    public String getSomeValue() {
        return someValue;
    }
}
