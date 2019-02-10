import org.springframework.beans.factory.annotation.Value;

public class Client {

    @Value("${id}")
    String id;

    @Value("${name}")
    String fullName;

    @Value("${greeting}")
    String greeting;

    public Client() {

    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }


    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
