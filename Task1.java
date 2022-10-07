package lesson4;

import java.util.*;

    public class Task1 {
        public static void main(String[] args) {
            ArrayList<String> list = new ArrayList<>();

            list.add("апельсин");
            list.add("манго");
            list.add("яблоко");
            list.add("огурец");
            list.add("морковь");
            list.add("гранат");
            list.add("апельсин");
            list.add("томат");
            list.add("манго");
            list.add("лимон");
            list.add("яблоко");
            list.add("манго");
            list.add("виноград");
            list.add("апельсин");
            list.add("лимон");
            list.add("папайя");
            list.add("ананас");
            list.add("абрикос");
            list.add("яблоко");
            list.add("манго");
            System.out.println("Всего в списке " + list.size() + " слов: " + list);
            Set<String> uniquewords = new HashSet<String>(list);
            System.out.println("\nКоличество уникальных слов: " + uniquewords.size());
            System.out.println("Список уникальных слов:" + uniquewords);

            System.out.println("\nСписок уникальных слов c указанием, сколько раз они встречаются:");
            for (String key : uniquewords) {
                System.out.println(key + ": " + Collections.frequency(list, key));
            }
        }
    }



