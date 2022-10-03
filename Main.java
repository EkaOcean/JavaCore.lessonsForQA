package lesson3;

public class Main {
    public static void main(String[] args) {

        Box<Orange> orange1 = new Box<>();
        Box<Orange> orange2 = new Box<>();
        Box<Apple> apple3 = new Box<>();
        Box<Apple> apple4 = new Box<>();

        System.out.println("Добавляем фрукты в коробки: ");
        orange1.addFruit(new Orange(),10);
        orange2.addFruit(new Orange(),12);
        apple3.addFruit(new Apple(),15);
        apple4.addFruit(new Apple(),4);

        System.out.println("Вес коробки 1 с апельсинами: "+orange1.getWeight() + "\nВес коробки 2 с апельсинами: "+orange2.getWeight()
                           + "\nВес коробки 3 с яблоками: "+apple3.getWeight() + "\nВес коробки 4 с яблоками: "+apple4.getWeight());

        System.out.println("\nСравниваем вес коробок: " +
                           "\nВес коробки 1 с апельсинами равен весу коробки 3 с яблоками? - "+ orange1.compare(apple3) +
                           "\nВес коробки 2 с апельсинами равен весу коробки 4 с яблоками? - "+ orange2.compare(apple4));

        System.out.println("\nПересыпаем фрукты из одной коробки в другую и получаем: ");
        orange1.transferTo(orange2);
        apple3.transferTo(apple4);
        System.out.println("Вес коробки 1 с апельсинами: "+orange1.getWeight() + "\nВес коробки 2 с апельсинами: "+orange2.getWeight()
                + "\nВес коробки 3 с яблоками: "+apple3.getWeight() + "\nВес коробки 4 с яблоками: "+apple4.getWeight());
    }
}

