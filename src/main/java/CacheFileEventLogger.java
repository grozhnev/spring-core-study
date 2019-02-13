import javax.annotation.PreDestroy;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {

    Integer cacheSize;
    List<Event> cache;

    public CacheFileEventLogger(String fileName, Integer cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    @PreDestroy
    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            logEvent(event);
        }
    }
}
