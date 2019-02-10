import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig2.class)
public class AppConfiguration {

    @Bean
    public Client client(){
        return new Client();
    }
}
