/*
 * Создать приложение, позволяющее читать *.properties-файлы. 
 * Физическое чтение файла должно происходить только один раз.
 * Результаты чтения храните в коллекции типа Map. 
 * После прочтения файла, пользователь может работать с ним через консоль, 
 * запрашивая значения по ключам, пока не нажата клавиша ESC.
 */

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
import java.io.*;
import java.util.Properties;//импорт класса Properties для работы с *.properties-файлом
import java.util.Scanner;//импорт класса Scanner для ввода через консоль
import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) throws IOException{
        String key;
        Properties properties = new Properties();
        Scanner scan = new Scanner(System.in);//создание объекта класса Scanner для ввода через консоль
        
        try{
            FileInputStream in = new FileInputStream("src\\config1.properties");
            properties.load(in);
            //создаем коллекцию Map
            Map<Object, Object> collection = new HashMap<>();
            //проход по каждой паре ключ-значение
            //Map.Entry - описываем пару (ключ - значение)
            //entrySet - возращает множество со значениями из *.properties-файла
            for (Map.Entry entry : properties.entrySet())
                collection.put(entry.getKey(), entry.getValue());//присваиваем элементам коллекции значения
                                                                 //из *.properties-файла (метод put())
            System.out.print("Введите название одного из ключей (directory, email, login или password),"
                            + "чтобы получить его значение:\n");
            key = scan.next();
            //работаем со значениями по ключам, пока не нажата клавиша выхода
            while (!key.equals("q")){
                switch (key) {
                    case "directory":
                        //вывод значения ключа (метод get())
                        System.out.println("Значение ключа: " + collection.get(key));
                        break;
                    case "email":
                        System.out.println("Значение ключа: " + collection.get(key));
                        break;
                    case "login":
                        System.out.println("Значение ключа: " + collection.get(key));
                        break;
                    case "password":
                        System.out.println("Значение ключа: " + collection.get(key));
                        break;
                    default:
                        throw new NoSuchFieldException();//генерация исключения NoSuchFieldException, если
                                                         //введенного ключа не существует
                }
                key = scan.next();
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
            System.out.println("Веденный ключ не существует!\nЗавершение работы программы.");
        }
        catch (IOException exceptionObject) {
            System.out.println(exceptionObject.getMessage());
        }
        scan.close();
        System.out.println("Завершение работы программы: нажата клавиша выхода!");
    } 
}
