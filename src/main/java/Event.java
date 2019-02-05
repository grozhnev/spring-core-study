import java.util.Date;

public class Event {
    Integer id;
    String msg;
    Date date;

    public Event(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", msg='" + msg + '\'' + ", date=" + date + '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
