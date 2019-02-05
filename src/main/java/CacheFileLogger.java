import java.util.List;

public class CacheFileLogger extends FileEventLogger {

    Integer cacheSize;
    List<Event> cache;

    public CacheFileLogger(Integer cacheSize) {
        this.cacheSize = cacheSize;
    }

    public CacheFileLogger() {

    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void destroy(){
        if(!cache.isEmpty()){
            writeEventsFromCache();
        }
    }

    private void writeEventsFromCache() {
    }
}
