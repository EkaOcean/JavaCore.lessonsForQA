package lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
        private Map<String, String> phonebook;
        PhoneBook(Map<String, String> map) {
            phonebook = map;
        }
        void add(String phone, String surname) {
            phonebook.put(phone, surname);
        }
        void print() {
            System.out.println("\nPhone Book: \n");

            for (String name: phonebook.keySet()) {
                String key = name.toString();
                String value = phonebook.get(name).toString();
                System.out.println(key + " " + value);
            }
        }
        ArrayList<String> get(String surname) {
            ArrayList<String> result = new ArrayList<>();
            phonebook.forEach((key, value) -> {
                if (surname.equalsIgnoreCase(value)) {
                    result.add(value + ": " + key);
                }
            });
            return result;
        }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        PhoneBook phonebook = new PhoneBook(map);
        phonebook.add("71-72-73", "Ivanov");
        phonebook.add("70-91-01", "Petrov");
        phonebook.add("73-94-53", "Sidorov");
        phonebook.add("74-00-54", "Smirnov");
        phonebook.add("25-43-81", "Ivanov");
        phonebook.add("53-96-90", "Sokolova");
        phonebook.add("24-25-24", "Popova");
        phonebook.add("53-61-28", "Smirnov");
        phonebook.add("73-91-71", "Sokolova");
        phonebook.add("74-00-53", "Petrov");

        phonebook.print();

        System.out.println("\nIvanov phone numbers: " + phonebook.get("Ivanov"));
        System.out.println("Petrov phone numbers: " + phonebook.get("Petrov"));
        System.out.println("Smirnov phone numbers: " + phonebook.get("Smirnov"));
    }

}



