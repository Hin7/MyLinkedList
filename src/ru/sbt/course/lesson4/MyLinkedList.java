package ru.sbt.course.lesson4;

import java.util.*;

/**
 * Самостоятельно реализованный LinkedList
 * MyLinkedList.
 * <p>
 * Задание на 4 лексции СБТ по дженерикам
 *
 * @param <T> - тип элемента в листе
 * @author Hin7
 * @version 1.0 12/03/2020
 */

public class MyLinkedList<T> implements List<T> {
    int size = 0;

    private class Cover {
        private Cover previos;
        private Cover next;
        private T item;

        Cover(T item) {
            this.item = item;
            previos = null;
            next = null;
        }
    }

    private Cover firstItem = null;
    private Cover lastItem = null;

    //не реализованные методы
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    //реализованные методы
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        if (size == 0) {
            firstItem = new Cover(t);
            lastItem = firstItem;
        } else {
            Cover item = new Cover(t);
            lastItem.next = item;
            item.previos = lastItem;
            lastItem = item;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index <= 0) {
            Cover item = new Cover(element);
            firstItem.previos = item;
            item.next = firstItem;
            firstItem = item;
            size++;
            return;
        }
        if (index >= size) {
            add(element);
        } else {
            Cover shiftItem = firstItem;
            Cover item = new Cover(element);
            while (index-- > 0)
                shiftItem = shiftItem.next;
            Cover previosItem = shiftItem.previos;
            previosItem.next = item;
            shiftItem.previos = item;
            item.previos = previosItem;
            item.next = shiftItem;
            size++;
        }
    }

    @Override
    public T get(int index) {
        if (size == 0)
            return null;
        if (index <= 0)
            return firstItem.item;
        if (index > size)
            return lastItem.item;

        Cover result = firstItem;
        while (index-- > 0)
            result = result.next;
        return result.item;
    }

    @Override
    public T remove(int index) {
        if (size == 0 || index < 0 || index >= size)
            return null;
        Cover remItem = firstItem;
        while (index-- > 0)
            remItem = remItem.next;
        remItem.previos.next = remItem.next;
        remItem.next.previos = remItem.previos;
        size--;
        return remItem.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Cover activItem = firstItem;

            @Override
            public boolean hasNext() {
                if (activItem == null) return false;
                return activItem.next != null;
            }

            @Override
            public T next() {
                if(activItem == null)
                    return null;
                Cover result = activItem;
                activItem = result.next;
                return result.item;
            }
        };
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Iterator<? extends T> iterator = c.iterator();
        while (iterator.hasNext())
            add(iterator.next());
        return true;
    }

    public boolean copy(Collection<? super T> c){
        c.clear();
        // return c.addAll(this); - для ArrayList надо, чтобы toArray было реализовано
        for(T item : this)
            c.add(item);
        return true;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(T item : this)
            result.append(item).append(" ");
        return result.toString();
    }
}
