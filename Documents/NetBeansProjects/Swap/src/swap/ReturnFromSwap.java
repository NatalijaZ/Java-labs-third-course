package swap;

import java.util.ArrayList;

public class ReturnFromSwap {
    private int i, j;
    private ArrayList<String> myFirstList=new ArrayList<String>();
        
    public void setList (ArrayList<String> myFirstL){
            this.myFirstList=myFirstL;
    }
    
    public ArrayList<String> getList(){
            return myFirstList;
    }
    
    public void setI_J(int indI, int indJ){
        if (indI>=0&&indI<myFirstList.size()&&indJ>=0&&indJ<myFirstList.size()&&
                indI!=indJ){
            i=indI;
            j=indJ;
        }
        else {
            System.out.println("Значения индексов должны быть больше или равны "
                    + "нулю, меньше размера списка, и не равны между собой!");
        }
    }
    
    public int getI(){
        return i;
    }
    
    public int getJ(){
        return j;
    }
    
    public  boolean listSwap (ArrayList<String> myL, int k, int n){
        if(!myL.isEmpty()){
            if (k>=0&&k<myL.size()&&n>=0&n<myL.size()&&k!=n){
                String temp=myL.get(k);
                myL.remove(k);
                //все элементы списка сдвинулись влево из-за удаления элемента 
                //по индексу k, поэтому меняем уже с элементом, индекс которого 
                //меньше на 1
                myL.add(k,myL.get(n-1));
                myL.remove(n);
                myL.add(n,temp);
                myFirstList=myL;
                return true;
            }
            else if (k<0|n<0|k<0&&n<0){
                System.out.println("Индексы должны быть больше или равны нулю!");
                return false;
            }
            else if (k>=myL.size()|n>=myL.size()|k>=myL.size()&&
                    n>=myL.size()){
                System.out.println("Индекс выходит за пределы списка!");
                return false;
            }
            else if(k==n){
                System.out.println("Индексы должны иметь разные значения!");
                return false;
            }
            else return false;
        }
        else {
            System.out.println("Список не должен быть пустым!");
            return false;
        }
    }
}
