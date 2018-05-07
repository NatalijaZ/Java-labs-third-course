/*
 * Составить программу для вычисления значений функции F(x) на отрезке [а, b] с шагом h. 
 * Размеры отрезка и параметры задаются в качестве параметров в консоли.
 * Результат представить в виде таблицы, первый столбец которой – значения аргумента, 
 * второй - соответствующие значения функции:
 * F(x) = tg(2x) - 3
 */

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
import java.util.Scanner;//импорт класса Scanner для ввода чисел

public class Task1 {
    public static void main(String[] args) {
    double a,b,h,x;
    
    Scanner scan = new Scanner(System.in);//создание объекта класса Scanner для ввода чисел а,b,h
    
    System.out.print("Введите левую границу отрезка (а):");
    a = scan.nextDouble();
    
    System.out.print("Введите правую границу отрезка (b):");
    b = scan.nextDouble();
    
    System.out.print("Введите шаг (h):");
    h = scan.nextDouble();
    scan.close();
    
    if (a>=b){
        System.out.println("Число \"a\" должно быть меньше числа \"b\"");
        }
    else if (h>=b-a){
        System.out.println("Число \"h\" должно быть больше или равно \"b-a\"");
    }
    else {
        for (x=a;x<=b;x=x+h){
            if (x!=(3.14 / 2 + 3.14 * 1)/2&x!=(3.14 / 2 + 3.14 * 2)/2){//проверка на область определения функции tg
                double FunctionValue= Math.tan(2*x) - 3;
                System.out.println(x + "   |   " + FunctionValue + "\n");
            }
            else {
                System.out.print(x + "   |   " + "Нарушена область определения функции!\n");
            }
        }
    }
    }  
}
