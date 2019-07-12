package com.vivolvle.fundation;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class FundationApplicationTests {

    @Test
    public void contextLoads() {
        String str = "asd";
        boolean result = StringUtils.isEmpty(str);
        String[] split = str.split(",");
        System.out.println(split.length);
    }

    //map的computeIfAbsent的用法
    @Test
    public void testMap() {
        Map<Object, Object> map = new ConcurrentHashMap<>();
        //map.computeIfAbsent("name", k->new HashSet<>());
        //map.computeIfAbsent("name", k -> "123");
        map.computeIfAbsent("name", k -> k+"_extra");
        System.out.println(map.get("name"));
    }

    @Test
    public void testListContain(){
        List<Integer> target = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        target.add(1);
        target.add(3);
        target.add(5);
        target.add(7);
        List<Integer> list = target.stream()
                .filter(num -> queue.contains(num)).collect(Collectors.toList());
        for(Integer item:list){
            System.out.println(item);
        }
    }

    @Test
    public void testLinkedList(){
        // create a LinkedList
        LinkedList list = new LinkedList();

        // add some elements
        list.add("Hello");
        list.add(2);
        list.add("Chocolate");
        list.add("10");

        // print the list
        System.out.println("LinkedList:" + list);

        // peek at the head of the list
        System.out.println("Head of the list:" + list.peek());

        // print the list
        System.out.println("LinkedList:" + list);

        // pop at the head of the list
        System.out.println("Head of the list:" + list.pop());

        // print the list
        System.out.println("LinkedList:" + list);
    }

}
