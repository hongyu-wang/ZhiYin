package tools;

import java.io.Serializable;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-03-04.
 */
public class ServiceTable<K, V> extends Dictionary<K, V>{
    Dictionary<K, V> dict = new Hashtable<K, V>();

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public boolean isEmpty() {
        return dict.isEmpty();
    }

    @Override
    public Enumeration<K> keys() {
        return dict.keys();
    }

    @Override
    public Enumeration<V> elements() {
        return dict.elements();
    }

    @Override
    public V get(Object key) {
        return dict.get(key);
    }

    @Override
    public V put(K key, V value) {
        return dict.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return dict.remove(key);
    }
}
