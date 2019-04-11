/*
 * Создать приложение, позволяющее читать значение по ключу из *.properties-файлов.
 * В качестве входных параметров (в консоли) задаются: 
 * имя файла и ключ, для которого нужно получить значение.
 * Обработать все возможные исключительные ситуации.
 */

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
import java.io.*;
import java.util.Properties;//импорт класса Properties для работы с *.properties-файлом
import java.util.Scanner;//импорт класса Scanner для ввода через консоль

public class Task3 {
    public static void main(String[] args) throws IOException{
        String filepath = "src\\";
        String key;
        Properties properties = new Properties();
        Scanner scan = new Scanner(System.in);//создание объекта класса Scanner для ввода через консоль
        System.out.print("Введите имя файла *.properties (config.properties):");
        
        try{
            filepath+= scan.next();
            FileInputStream in = new FileInputStream(filepath);
            properties.load(in);
            System.out.print("Введите название одного из ключей (directory, email, login или password),"
                            + "чтобы получить его значение:");
            key = scan.next();
            if ("directory".equals(key)|"email".equals(key)|"login".equals(key)|"password".equals(key)) {  
                System.out.println(properties.getProperty(key));//вывод значения ключа
            }
            else {
                throw new NoSuchFieldException();//генерация исключения NoSuchFieldException, если
                                                 //введенного ключа не существует
            }
            in.close();
        }
        catch(FileNotFoundException exceptionObject){
            System.out.println("Некорректный путь к файлу!\nЗавершение работы программы.");
        }
        catch(SecurityException exceptionObject){
            System.out.println("Предпринята попытка нарушения безопасности!\nЗавершение работы программы.");
        }
        catch(NoSuchFieldException exceptionObject){
            System.out.println("Введенный ключ не существует!\nЗавершение работы программы.");
        }
        catch (IOException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
        scan.close();
        System.out.println("Цель задания достигнута!");
    } 
}
