/*
 * Реализовать метод boolean swap(int i, int j, int[] anArray), 
 * меняющий местами элементы по индексам i и j в массиве anArray и 
 * возвращающий false, если индексы выходят за пределы массива.
 */
package simpleswap;

public class SimpleSwap {
    public static void main(String[] args) {
        int[] firstArray  = {9,7,5,3,1};
        System.out.println ("Исходный массив:");
        for (int k=0;k<firstArray.length;k++){
            System.out.print(firstArray[k]+" ");
        }
        System.out.println ("\n---------");
        swap (4, 3, firstArray);
        
    } 
    
    public static boolean swap (int i, int j, int[] anArray) {
        if (i>=0&i<anArray.length&j>=0&j<anArray.length&i!=j){
            int temp;
            temp=anArray[i];
            anArray[i]=anArray[j];
            anArray[j]=temp;
            System.out.println ("Массив после применения метода swap:");
            for (int k=0;k<anArray.length;k++){
                System.out.print(anArray[k]+" ");
            }
            return true;
        }
        
        else if (i<0|j<0){
            System.out.println ("Значения индексов должны быть больше нуля "
                    + "или равняться нулю!");
            return false;
        }
        
        else if (i==j){
            System.out.println ("Необходимо задать разные значения индексов!");
            return false;
        }
        
        else {
            System.out.println ("Индекс выходит за пределы массива!");
            return false;
        }
    }
}
