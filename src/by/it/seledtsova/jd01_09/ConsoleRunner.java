package by.it.seledtsova.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line; // будем читать строку

        Parsel parser=new Parsel(); // будем передавать вычисления
        Printer printer=new Printer(); // будем передавать их результат

       while (!(line=scanner.nextLine()).equals("end")) { // до тех пор, пока это выражение НЕ разняеся end , мы их будм читать
           Var result=parser.calc(line); // передадим вычисления в parser
           printer.print(result); // печатаем , то что посчитали
       }

    }

}
