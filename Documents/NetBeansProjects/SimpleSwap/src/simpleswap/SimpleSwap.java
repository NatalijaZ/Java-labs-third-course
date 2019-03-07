/*
 * Реализовать метод boolean swap(int i, int j, int[] anArray), 
 * меняющий местами элементы по индексам i и j в массиве anArray и 
 * возвращающий false, если индексы выходят за пределы массива.
 */
package simpleswap;

public class SimpleSwap {
    public static void main(String[] args) {
        int[] firstArray  = {9,7,5,3,1};
        for (int k=0;k<firstArray.length;k++){
            System.out.print(firstArray[k]+" ");
        }
        System.out.println ("\n---------");
        swap (4, 3, firstArray);
        
    } 
    
    public static boolean swap (int i, int j, int[] anArray) {
        if (i<anArray.length&j<anArray.length){
            int temp;
            temp=anArray[i];
            anArray[i]=anArray[j];
            anArray[j]=temp;
            for (int k=0;k<anArray.length;k++){
                System.out.print(anArray[k]+" ");
            }
            return true;
        }
        else {
            System.out.println ("Индекс выходит за пределы массива!");
            return false;
        }
    }
}
