import java.text.DateFormat;
import java.util.Date;

public class Event {
    Integer id;
    String msg;
    Date date;
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", msg='" + msg + '\'' + ", date=" + date + ", dateFormat=" + dateFormat + '}';
    }
}
