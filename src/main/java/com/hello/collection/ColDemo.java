package com.hello.collection;

import java.util.*;
import java.util.function.Consumer;

public class ColDemo {


    public static void main(String args[]) {

        Consumer<String> log = (e) -> System.out.println(e);

        String[] arr = {"cat", "dog", "cow", "hen", "cow", "pig","dog"};

        //Arraylist
        List<String> list = Arrays.asList(arr);
        Iterator itr = list.iterator();
        while (itr.hasNext()) log(itr.next().toString());
        ln();
        for (String str : list) log(str);
        ln();
        list.stream().forEach(e-> log(e));

        //Stack
        Stack<String> stk = new Stack<>();
        for (String str :list) stk.push(str);
        ln("stack");
        while (stk.size() > 0) log("pop:" + stk.pop());


        //Set: HashSet, TreeSet, LinkedHashSet
        Set<String> hset = new HashSet(list);
        ln();
        for (String str : hset) log(str);

        Set<String> tset = new TreeSet(list);
        ln();
        for (String str : tset) log(str);

        Set<String> lset = new LinkedHashSet<>();
        lset.add("cow");
        lset.add("dog");
        ln();
        for (String str : lset) log(str);

        //Queue: PriorityQueue, ArrayDeque
        Queue<String> queue = new PriorityQueue<>();
        queue.addAll(tset); //provide ordered collection, cat is always removed
        queue.remove();
        ln();
        for (String str : queue) log(str);

        //The Deque interface supports insertion, removal and retrieval of elements at both ends.
        //The ArrayDeque class is the resizeable array implementation of the Deque interface

        //Map: HashMap, TreeMap
        Map<String,Integer> map = new HashMap<>();
        SortedMap<String,Integer> tmap = new TreeMap<>();
        for (int i= 0; i< list.size(); i++) {
            map.put(list.get(i),i);
            tmap.put(list.get(i),i);
        }
        ln("HashMap");
        map.entrySet().stream().forEach( (e) -> log (e.getKey() + ":" + e.getValue()));
        ln("TreeMap");
        tmap.entrySet().stream().forEach( (e) -> log (e.getKey() + ":" + e.getValue()));



    }

    static void ln () {
        ln ("");
    }
    static void ln (String header) {
        System.out.print("\n-----" + header + "-----\n");
    }

    static void log (String str) {
        System.out.print(str + ",");
    }
}
