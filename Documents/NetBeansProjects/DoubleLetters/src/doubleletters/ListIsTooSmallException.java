/*
 * Класс для обработки пользовательского исключения 
 * (если длина списка меньше двух символов)
 */
package doubleletters;

public class ListIsTooSmallException extends Exception{
    String message="Необходимо ввести не менее двух символов!"
            + "\nЗавершение работы программы.";
    //конструктор исключения
    public ListIsTooSmallException(){
        System.out.println(message);
    }
}