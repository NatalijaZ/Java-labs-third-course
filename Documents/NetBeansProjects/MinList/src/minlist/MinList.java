/*
 * Напишите обобщенный метод для поиска минимального элемента списка 
 * в диапазоне [begin, end). Где [ – включительно, ) – исключительно. 
 * Напишите junit-тесты.
 */
package minlist;

import java.util.ArrayList;
import java.util.Arrays;

public class MinList {
    private static int begin, end;
    
    public static void main(String[] args) {
        ArrayList<Integer> myL=new ArrayList<>(Arrays.asList(2,18,16,7,-1,4,8,7,5));
        commonMin(myL,-5,-4);
    }
    
    public static <T extends Comparable> T commonMin(ArrayList<T> myList,int a,int b){
        //устанавливаем значения begin, end
        if (a>=0&&a<=myList.size()-2&&a<b){
            begin=a;
        }
        else begin=0;
        if (b>=0&&b<=myList.size()-1&&b>a){
            end=b;
        }
        else end=myList.size()-1;
        
        System.out.println(myList);
        
        T temp;
        //сортируем список, упорядоченный по возрастанию
        for (int i=begin;i<end;i++){
            for (int j=begin;j<end-1;j++){
                //сравниваем объекты
                if(myList.get(j).compareTo(myList.get(j+1))>0){
                    temp=myList.get(j);
                    myList.remove(j);
                    //после удаления элемента j соседний элемент j+1 подвинулся 
                    //на его место, поэтому добавляем значение temp (бывший эл-т 
                    //j) по соседнему индексу
                    myList.add(j+1,temp);
                }  
            }
        }
        System.out.println(myList);
        T min=myList.get(begin);
        System.out.println("The minimum of list in the interval ["+begin+";"+
                end+") "+"is: "+min);
        return min;
    }
}
