package com.hello.problems;

import java.util.*;

//Print the count of clicks for subdomains
public class DomainCounter {

    //["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
    //["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]

    public static void main(String args[]) {
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> list = Arrays.asList(domains);
        list.stream().forEach(System.out::println);
        System.out.println("~~~~~~");
        countDomains(list)
                .entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));

    }

    static Map<String, Integer>  countDomains(List<String> cpdomains) {
        if (cpdomains == null || cpdomains.size() == 0) {
            return new HashMap<>();
        }

        Map<String, Integer> map = new HashMap<>();

        for (String pair : cpdomains) {
            String[] arr = pair.split(" ");
            int count = Integer.parseInt(arr[0]);
            String[] subdomains = arr[1].split("[.]");

            //subdomains [mail,yahoo,com] => com, yahoo, mail => com, com.yahoo, com.mail.yahoo etc.
            for (int i = subdomains.length - 1; i >= 0; i--) {
                String curr = String.join(".", Arrays.copyOfRange(subdomains, i, subdomains.length - 1));
                if (map.get(curr) != null) {
                    map.put(curr, map.get(curr) + 1);
                } else {
                    map.put(curr, +1);
                }
            }
        }
        return map;
    }

}
