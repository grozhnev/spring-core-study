import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class App {

    @Autowired
    private Client client;

    @Autowired
    @Qualifier("fileEventLogger")
    private EventLogger defaultLogger;

    private Map<EventType, EventLogger> loggers;

    public App(Map<EventType, EventLogger> loggers) {
        this.loggers = loggers;
    }

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

//    public App(Client client, EventLogger logger) {
//        this.client=client;
//        this.eventLogger=logger;
//    }
//
//    public App(Client client, Map<EventType, EventLogger> map) {
//        this.client=client;
//        this.loggers = map;
//    }

//    public App(Client client, ConsoleEventLogger consoleEventLogger, String s) {
//
//    }




//    private void logEvent(String msg, EventType eventType){
//        String message = msg.replaceAll(client.getId(), client.getFullName());
//
//        if(eventType == EventType.ERROR){
//            eventLogger = new CacheFileEventLogger();
//
//        }else if (eventType == EventType.INFO){
//            eventLogger = new ConsoleEventLogger();
//        }else {
//
//        }
//
//        eventLogger.logEvent(message);
//
//
//        EventLogger logger = loggers.get(eventType);
//        if (logger == null){
//            logger = new CombinedEventLogger(loggers);
//        }
//        logger.logEvent(msg);
//    }

    private void logEvent(EventType eventType, String msg) throws IOException {

        EventLogger logger = loggers.get(eventType);

        if (logger == null){
            logger = defaultLogger;
        }

        Event event = new Event(new Date());
        event.setMsg(msg);

        logger.logEvent(event);
    }





    public static void main(String[] args) throws IOException {
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
//        App app = (App) context.getBean("app");
////        app.logEvent("I'm a starman, 1 !!!");
//
//        app.logEvent(EventType.INFO, "INFO");
//        app.logEvent(EventType.ERROR, "ERROR");
//
//
//        context.close();


        ApplicationContext context = new AnnotationConfigApplicationContext(/*AppConfiguration.class*/);

        ((AnnotationConfigApplicationContext) context).register(AppConfiguration.class);
        ((AnnotationConfigApplicationContext) context).refresh();

        ((AnnotationConfigApplicationContext) context).scan("/home/morgan/Code/java/spring-core_2019/src/main/java");
        ((AnnotationConfigApplicationContext) context).refresh();


    }
}
