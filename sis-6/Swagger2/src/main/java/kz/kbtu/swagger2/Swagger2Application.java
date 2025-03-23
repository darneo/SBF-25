package kz.kbtu.swagger2;

import com.example.petstore.client.api.PetApi;
import com.example.petstore.client.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class Swagger2Application {
    @Autowired
    private PetApi petApi;

    @GetMapping("/api")
    public List<Pet> getAvailablePets() {
        return petApi.findPetsByStatus(Arrays.asList("available"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Swagger2Application.class, args);
    }

}
