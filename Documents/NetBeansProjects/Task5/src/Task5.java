/*
 * Создать приложение с 3 потоками для следующей задачи: 
 *		3 работника выполняют следующую работу: 
 *			1-ый копает яму, 
 * 			2-ой сажает дерево,  
 * 			3-ий подвязывает саженец к кольям. 
 * Работа идет строго по очереди. Число саженцев задается параметром.  
 * Выводить на дисплей номер работника и номер саженца. 
 */

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
import java.util.Date;// импорт класса Date для вывода даты
import java.util.Scanner;// импорт класса Scanner для ввода параметра
// класс для создания потоков
class MyThreads extends Thread{//класс MyThreads наследует класс Thread
    String numberOfWorker;
    String dutiesOfWorker;
    
    @Override//аннотация, указывающая, что далее мы собираемся переопределять метод базового класса
    // переопределение метода run()
    public void run(){
        System.out.println(numberOfWorker + " работник начинает " + dutiesOfWorker);
    
        for(int i=1;i<=5;i++){
            try{
                sleep(200);
                System.out.println("Идет работа: "+ new Date());
            }
            catch(InterruptedException exceptionObject){ // Обработка исключения
                System.out.println(exceptionObject);
            }
        }
        //поток заканчивает выполнение, когда завершается его метод run()
        System.out.println("Поток завершил работу" + "\n");
    }
    // конструктор класса для создания потоков
    MyThreads(String number, String str){
        numberOfWorker = number;
        dutiesOfWorker = str;
        // Создание и запуск потока (методом start() вызываем метод run()):
        start();
    }
}
public class Task5{
    // главный метод может выбрасывать исключение
    public static void main(String[] args) throws InterruptedException{
        int parameter;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значение параметра, определяющего количество саженцев:");
        parameter = scan.nextInt();
        scan.close();

        for(int i=0;i<parameter;i++){
            System.out.println ("Саженец № " + (i+1) + ":");
            
            try{
                // запуск потоков
                MyThreads pit = new MyThreads("Первый", "копать яму");
                pit.join();
                MyThreads plant = new MyThreads("Второй", "сажать дерево");
                plant.join();
                MyThreads tie = new MyThreads("Третий", "подвязывать саженец к кольям");
                tie.join();
            }
            catch(InterruptedException exceptionObject){ // Обработка исключения
                System.out.println(exceptionObject);
            }
            System.out.println("*********************************************");
        }
        
        System.out.println("Вся работа закончена!");
    }
}

