package ru.sbt.course.lesson4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("Тест MyLinkedList");

        List<String> strList = new MyLinkedList<>();
        List<Integer> intList = new MyLinkedList<>();

        strList.add("Сергей");
        strList.add("Петр");
        strList.add("Алекс");
        strList.add("Максим");
        strList.add("Игорь");
        strList.add("Валерий");
        strList.add("Влад");
        System.out.println(strList);

        intList.add(10);
        intList.add(21);
        intList.add(32);
        intList.add(43);
        intList.add(54);
        intList.add(65);
        intList.add(76);
        System.out.println(intList);

        strList.add(2, "Мария");
        strList.add(4, "Елена");
        System.out.println(strList);

        intList.add(3, 1000);
        intList.add(5, 5000);
        System.out.println(intList);

        System.out.println("2 = " + strList.get(2) + ", 1 = " + strList.get(1));
        System.out.println("1 = " + intList.get(1) + ", 3 = " + intList.get(3));

        strList.remove(2);
        intList.remove(3);
        System.out.println(strList);
        System.out.println(intList);

        Iterator itr = strList.iterator();
        int i = 0;
        while (itr.hasNext())
            System.out.println("[" + (i++) + "] = "+itr.next());

        List<String> addList = new ArrayList<>();
        addList.add("Джон");
        addList.add("Вильям");
        addList.add("Брюс");
        strList.addAll(addList);
        System.out.println(strList);

        ((MyLinkedList)strList).copy(addList);
        System.out.println("Copy :" + addList);
    }
}
