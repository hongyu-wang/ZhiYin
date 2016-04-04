package server.sorting;

import java.util.List;
import java.util.Map;

/**
 * Created by Kevin Zheng on 2016-04-04.
 */
public interface Sort<T, V> {
    List<V> sort();
}
