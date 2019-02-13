import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Component("Event")
@Scope("prototype")
public class  Event {
    Integer id;
    String msg;
    Date date;
//    DateFormat dateFormat;

    public Event(Date date) {
        this.date = date;
    }

//    public Event(Date date, DateFormat dateFormat) {
//        this.date = date;
//        this.dateFormat = dateFormat;
//    }

    public static boolean isDay(){
        int time = LocalDateTime.now().getHour() * 60 + LocalDateTime.now().getMinute();

        if((8 * 60 < time) || (17 * 60 > time)){
            return true;
        } else {
            return false;
        }
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", msg='" + msg + '\'' + ", date=" + date + /*", dateFormat=" + dateFormat + */'}';
    }
}
