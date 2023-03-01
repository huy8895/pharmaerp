package DKSPACE.PhamarERP.auth.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapUtils<K,V> {
    private Map<K,V> kvMap;

    public MapUtils() {
        kvMap = new LinkedHashMap<>();
    }

    @SuppressWarnings("unchecked")
    public static <K, V> MapUtils<K, V> build(){
        return (MapUtils<K,V>) new MapUtils();
    }
    public MapUtils<K,V> put(K key, V value){
        this.kvMap.put(key, value);
        return this;
    }

    public Map<K,V> ok(){
        return this.kvMap;
    }
}
