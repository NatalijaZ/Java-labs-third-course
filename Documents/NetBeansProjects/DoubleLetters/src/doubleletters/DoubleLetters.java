/*
 * Реализовать метод, который принимает на вход String, удаляет рядом стоящие 
 * парные буквы и возвращает остаток. 
 * Примеры ожидаемого поведения программы:
 * "aab" -> "b", "aabb" -> "", "abfbaf" -> "abfbaf”, "abccbaf" -> "f"
 * Реализовать метод и описать его алгоритмическую сложность. 
 * Написать junit-тесты.
 */
package doubleletters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DoubleLetters {
    //предупреждаем с помощью throws, что метод может выбросить исключение
    public static void main(String[] args) throws Exception{
        Scanner scan=new Scanner(System.in);
        System.out.println("Please, write some symbols (two or more):");
        //используем nextLine(), т.к. next() вернет только то, что до пробела
        String s=scan.nextLine();
        returnFromDoubleLetters(s);
        scan.close();
    }
    
    public static String returnFromDoubleLetters(String str) throws Exception{
        // преобразуем строку str в ArrayList
        ArrayList<String> listFromStr = new ArrayList <String>(Arrays.asList(str.split("")));
        //генерируем пользовательское исключение
        if (listFromStr.size()<2) throw new ListIsTooSmallException();
        //два вложенных цикла for, чтобы удалять вновь появляющиеся повторы 
        //после каждого прохода по строке
        for (int i=0; i<listFromStr.size(); i++){
            //отнимаем 1 от размера ArrayList, чтобы не выйти за пределы списка
            for (int j=0; j<listFromStr.size()-1; j++){
                if (listFromStr.get(j).equals(listFromStr.get(j+1))){
                    listFromStr.remove(j+1);
                    listFromStr.remove(j);
                } 
            }
        }
        //преобразуем ArrayList в строку (то, что осталось от первой строки 
        //после преобразования) 
        String listString = String.join("", listFromStr);
        System.out.println(listString);
        return listString;
    }
}
