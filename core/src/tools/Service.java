package tools;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by Hairuo on 2016-03-02.
 */
public class Service<E> {
    /**
     * Service list object in replace of an arraylist
     */
    ArrayList<E> sList;

    public Service(){
        sList = new ArrayList<>();
    }

    public void trimToSize() {
        sList.trimToSize();
    }

    public boolean contains(Object o) {
        return sList.contains(o);
    }

    public int lastIndexOf(Object o) {
        return sList.lastIndexOf(o);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return sList.subList(fromIndex, toIndex);
    }

    public Iterator<E> iterator() {
        return sList.iterator();
    }

    public E remove(int index) {
        return sList.remove(index);
    }

    public boolean remove(Object o) {
        return sList.remove(o);
    }

    public void replaceAll(UnaryOperator<E> operator) {
        sList.replaceAll(operator);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return sList.addAll(index, c);
    }

    public boolean removeAll(Collection<?> c) {
        return sList.removeAll(c);
    }

    public void clear() {
        sList.clear();
    }

    public ListIterator<E> listIterator(int index) {
        return sList.listIterator(index);
    }

    public E get(int index) {
        return sList.get(index);
    }

    public boolean retainAll(Collection<?> c) {
        return sList.retainAll(c);
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return sList.removeIf(filter);
    }

    public int size() {
        return sList.size();
    }

    public boolean isEmpty() {
        return sList.isEmpty();
    }

    public ListIterator<E> listIterator() {
        return sList.listIterator();
    }

    public <T> T[] toArray(T[] a) {
        return sList.toArray(a);
    }

    public int indexOf(Object o) {
        return sList.indexOf(o);
    }

    public Object[] toArray() {
        return sList.toArray();
    }

    public void sort(Comparator<? super E> c) {
        sList.sort(c);
    }

    public Stream<E> stream() {
        return sList.stream();
    }

    public E set(int index, E element) {
        return sList.set(index, element);
    }

    public void forEach(Consumer<? super E> action) {
        sList.forEach(action);
    }

    public Stream<E> parallelStream() {
        return sList.parallelStream();
    }

    public boolean containsAll(Collection<?> c) {
        return sList.containsAll(c);
    }

    public void ensureCapacity(int minCapacity) {
        sList.ensureCapacity(minCapacity);
    }

    public Spliterator<E> spliterator() {
        return sList.spliterator();
    }

    public boolean add(E e) {
        return sList.add(e);
    }

    public void add(int index, E element) {
        sList.add(index, element);
    }

    public boolean addAll(Collection<? extends E> c) {
        return sList.addAll(c);
    }
}
