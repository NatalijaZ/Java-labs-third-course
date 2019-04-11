/*
 * 1) Создать приложение с 2 классами - Book, Shoe  и  интерфейсом Product. 
 * Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах. 
 * 2) Определить новый интерфейс Present, расширяющий интерфейс Product и содержащий  
 * метод itCanBePresented(), который может возвращать строку.
 * 3) Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.
 * 4) В приложении создать массив объектов Product - (Book, Shoe, Toy, Picture), 
 * состоящий из количества элементов, заданного параметром.
 * 5) Найти в массиве те объекты, которые реализуют интерфейс Present и выполнить для них 
 * метод itCanBePresented().
 *
 * Вывод должен содержать названия всех продуктов из массива, затем только тех продуктов, 
 * которые реализуют интерфейс Present.
 */

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
import java.util.Scanner;//импорт класса Scanner для ввода кол-ва элементов массива

interface Product {
    String whoAmI();
}
        
class Book implements Product {
    String name = new String ("Book");
    public String whoAmI() {
        return name;
    }
}
            
class Shoe implements Product {
    String name = new String ("Shoe");
    public String whoAmI() {
        return name;
    }
}
            
interface Present extends Product{
    String itCanBePresented();
}
        
class Toy implements Present {
    String name = new String ("Toy");
    public String whoAmI() {
        return name;
    }
    public String itCanBePresented(){
        String s = "A toy can be presented for you!";
        return s;
    }
}
            
class Picture implements Present {
    String name = new String ("Picture");
    public String whoAmI() {
        return name;
    }
    public String itCanBePresented(){
        String s = "A picture can be presented for you!";
        return s;
    }  
}


public class Task2 {
    public static void main(String[] args) {
        int i, parameter;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите значение параметра, определяющего количество элементов массива объектов Product:");
        parameter = scan.nextInt();
        scan.close();
        
        if (parameter<4){
            System.out.println("Ведите значение, не меньшее 4!");
        }
        else {
            //создание массива объектов Product - (Book, Shoe, Toy, Picture)
            Product products[]= new Product[parameter];
            for (i=0; i<parameter; i++){
                if (i==0){
                    products[i]= new Book();
                }
                else if (i==1){
                    products[i]= new Shoe();
                }
                else if (i==2){
                    products[i]= new Toy();
                }
                else if (i==3){
                    products[i]= new Picture();
                }
                else {
                    if (i%2==0){
                        products[i]=new Toy();
                    }
                    else {
                        products[i]=new Book();
                    }
                }
                System.out.println(products[i].whoAmI());
            }
            
            System.out.println("***********************************");
            
            /*
             * поиск в массиве объектов (с помощью instanceof), реализующих интерфейс Present
             * и выполнение для них метода itCanBePresented()
             */
            for (Product item : products) {
                if (item instanceof Present){
                        System.out.println(((Present) item).whoAmI());
                        System.out.println(((Present) item).itCanBePresented());
                }
            }
        }
    }
    
}
