package by.it.seledtsova.zadacha;

import java.util.ArrayList;

public class Point {
    public static void main(String args[ ]) {
        ArrayList<String> list = new ArrayList<>();
// ArrayList<int> b = new ArrayList<int>(); // ошибка компиляции
        list.add("Java"); /* компилятор "знает"
допус тимый тип передаваемого значения */
        list.add("JavaFX 2");
        String res = list.get(0); /* компилятор "знает"
допустимый тип возвращаемого значения */
// list.add(new StringBuilder("C#")); // ошибка компиляции
// компилятор не позволит добавить "посторонний" тип
        System.out.print(list.get(0)); // удобный вывод
    }
}
