public class App {
    Client client;
    ConsoleEventLogger eventLogger ;

    private void logEvent(String msg){
        String message = msg.replaceAll(client.getId(), client.getFullName());

        eventLogger = new ConsoleEventLogger();
        eventLogger.logEvent(message);

    }

    public static void main(String[] args) {
        App app = new App();
        app.client = new Client("1", "Ziggy Stardust");

        app.logEvent("I'm a starman, 1 !!!");

    }
}
