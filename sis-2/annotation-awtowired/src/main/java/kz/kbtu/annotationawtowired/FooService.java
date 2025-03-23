package kz.kbtu.annotationawtowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FooService {
    private FooFormatter fooFormatter;
    private FooDB fooDb;

    @Autowired
    public FooService(FooFormatter fooFormatter, FooDB fooDb) {
        this.fooFormatter = fooFormatter;
        this.fooDb = fooDb;
    }

    public String toString(){
        return fooFormatter.format() + " " + fooDb.getName();
    }
}
