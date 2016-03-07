package tools;

import java.util.*;

/**
 * Created by Hairuo on 2016-03-06.
 */
public class Utils {

    public static <T> List<T> newList(){
        return new ArrayList<T>();
    }

    public static <K, V> Map<K, V> newMap(){
        return new Hashtable<K, V>();
    }
}
