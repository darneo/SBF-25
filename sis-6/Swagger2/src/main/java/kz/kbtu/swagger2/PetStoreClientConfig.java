package kz.kbtu.swagger2;

import com.example.petstore.client.api.PetApi;
import com.example.petstore.client.invoker.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetStoreClientConfig {

    @Bean
    public PetApi petApi() {
        return new PetApi(apiClient());
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }
}
