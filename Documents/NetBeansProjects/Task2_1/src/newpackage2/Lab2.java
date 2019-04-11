/*
* 1) Создать приложение с 2 классами - Book, Shoe  и  интерфейсом Product. 
*    Интерфейс содержит метод whoAmI, который будет реализован в имплементирующих классах. 
* 2) Определить новый интерфейс Present, расширяющий интерфейс Product 
*    и содержащий метод itCanBePresented(), который может возвращать строку.
* 3) Объявить 2 новых класса (например Toy, Picture), реализующих  интерфейс Present.
* 4) В приложении создать массив объектов Product - (Book, Shoe, Toy, Picture),
*    состоящий из количества элементов, заданного параметром.
* 5) Найти в массиве те объекты, которые реализуют интерфейс Present 
*    и выполнить для них метод itCanBePresented().
*
* Вывод должен содержать названия всех продуктов из массива, 
* затем только тех продуктов, которые реализуют интерфейс Present.
*/

/**
 * @author N. Zhilkevich
 * group 23531/21
 */
package newpackage2;	
		
public interface Product {
    public abstract void whoAmI();
}

public class Book implements Product {
    public void whoAmI() {
	System.out.println("Book");
    }
}

public class Shoe implements Product {
    public void whoAmI() {
	System.out.println("Shoe");
    }
}
                
public interface Present extends Product {
    public abstract String itCanBePresented();
}
                
public class Toy implements Present {
    public void whoAmI() {
	System.out.println("Toy");
    }

    public String itCanBePresented() {
        return "A toy can be presented";
    }
}
		
public class Picture implements Present {
    public void whoAmI() {
	System.out.println("Picture");
    }

    public String itCanBePresented() {
	return "A picture can be presented";
	}
}

public class Lab2 {
    public static void main(String[] args) {
        
	int quantity = Integer.parseInt(args[0]);
        int temp;
        Product[] products = new Product[quantity];

        for (int i = 0; i < quantity; i++) {
            switch(temp = i % 4) {
                case 0:
                    products[i] = new Book();
                    break;
                case 1:
                    products[i] = new Shoe();
                    break;
                case 2:
                    products[i] = new Toy();
                    break;
                case 3:
                    products[i] = new Picture();
                    break;
            }
        }

        for (int i = 0; i < quantity; i++) {
            products[i].whoAmI();
        }

        System.out.println("");
        
        for (int i = 0; i < quantity; i++) {
            if (products[i] instanceof Present) {
                System.out.println(((Present) products[i]).itCanBePresented());
            }
        }
    }
}