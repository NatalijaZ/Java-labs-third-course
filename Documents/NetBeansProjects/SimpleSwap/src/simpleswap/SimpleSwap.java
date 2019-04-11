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
        for (int i=0;i<firstArray.length;i++){
            System.out.print(firstArray[i]+" ");
        }
        System.out.println ("\n---------");
        ReturnFromSwap result=new ReturnFromSwap();//создаем объект result
        result.swap (4, 3, firstArray);//вызываем метод swap из объекта result
        System.out.println ("Массив после применения метода swap:");
            for (int i=0;i<firstArray.length;i++){
                System.out.print(firstArray[i]+" ");
            }
    } 
    
    public static class ReturnFromSwap {
        int temp;
        
        public boolean swap (int i, int j, int[] anArray) {
            if (i>=0&&i<anArray.length&&j>=0&j<anArray.length&&i!=j){
                temp=anArray[i];
                anArray[i]=anArray[j];
                anArray[j]=temp;
                return true;
            }
        
            else if (i<0|j<0){
                System.out.println ("Значения индексов должны быть больше нуля "
                    + "или равняться нулю!");
                return false;
            }
        
            else if (i==j){
                System.out.println ("Значения индексов должны быть различны!");
                return false;
            }
        
            else {
                System.out.println ("Индекс выходит за пределы массива!");
                return false;
            }
        }
    }
}