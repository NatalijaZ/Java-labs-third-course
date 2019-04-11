/*
 * Напишите метод для перестановки двух элементов в списке по индексам. 
 * Напишите junit-тесты.
 */
package swap;
import java.util.ArrayList;

public class Swap {
    public static void main(String[] args) {
        ArrayList<String> myList=new ArrayList<String>();
        myList.add("Cat");
        myList.add("Dog");
        myList.add("Rabbit");
        myList.add("Mouse");
        myList.add("Giraffe");
        ReturnFromSwap swap=new ReturnFromSwap();
        swap.setList(myList);
        System.out.println(myList);
        swap.setI_J(2, 3);
        int a=swap.getI();
        int b=swap.getJ();
        swap.listSwap(myList, a,b);
        myList=swap.getList();
        System.out.println(myList);
    }
}