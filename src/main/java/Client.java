public class Client {
    String id;
    String fullName;

    String greeting;

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
