package tools.utilities;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * Created by Hairuo on 2016-03-02.
 */
public class ServiceList<E> implements List<E>, Collection<E>, Iterable<E>{
    /**
     * ServiceList list object in replace of an arraylist
     */
    List<E> sList;

    public ServiceList(){
        sList = new ArrayList<>();
    }

    @Override
    public int size() {
        return sList.size();
    }

    @Override
    public boolean isEmpty() {
        return sList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return sList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return sList.iterator();
    }

    @Override
    public Object[] toArray() {
        return sList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return sList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return sList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return sList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return sList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return sList.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return sList.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return sList.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return sList.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        sList.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        sList.sort(c);
    }

    @Override
    public void clear() {
        sList.clear();
    }

    @Override
    public boolean equals(Object o) {
        return sList.equals(o);
    }

    @Override
    public int hashCode() {
        return sList.hashCode();
    }

    @Override
    public E get(int index) {
        return sList.get(index);
    }

    @Override
    public E set(int index, E element) {
        return sList.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        sList.add(index, element);
    }

    @Override
    public E remove(int index) {
        return sList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return sList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return sList.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return sList.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return sList.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return sList.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<E> spliterator() {
        return sList.spliterator();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return sList.removeIf(filter);
    }

    @Override
    public Stream<E> stream() {
        return sList.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return sList.parallelStream();
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        sList.forEach(action);
    }
}
