package com.hello.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Coll {

    public Coll() {
    }

    public static void main(String args[]) {
        new Coll().demoCol();
    }

    private  void demoCol() {

        int[] arr = {1,2,3,4,5,6};
        List<Integer> arrList1  = Arrays.stream(arr).boxed().collect(Collectors.toList());
        arrList1.forEach(System.out::println);

        List<Pojo> list1 = Arrays.stream(arr).mapToObj(e -> new Pojo(e, e + "val")).collect(Collectors.toList());
        list1.forEach(System.out::println);

        Map<Integer,String> map1 = list1.stream().collect(Collectors.toMap(Pojo::getId, Pojo::getName));
        map1.forEach( (k,v) -> System.out.println(k + "--" + v));

        List<Integer> intArr = Arrays.asList(3,4,7,8,9,10);
        intArr.stream().forEach((e) -> System.out.println(e));
        intArr.stream().filter(e -> e%2 !=0).map(e -> "odd:" + e).forEach(System.out::println);

    }

    private class Pojo {
        private int id;
        private String name;

        public Pojo(int e, String s) {
            id = e;
            name = s;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Pojo.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .toString();
        }
    }
}
