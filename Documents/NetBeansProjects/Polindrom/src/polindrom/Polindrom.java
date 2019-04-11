/*
 * Напишите функцию boolean isPolindrom(String input), проверяющую, 
 * является ли строка полиндромом. Протестируйте.
 */
package polindrom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Polindrom {
    private static String userInput;
    
    public static void main(String[] args) {
        setUserInput();
        isPolindrom(userInput);
    }
    
    public static void setUserInput(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Write an expression:");
        //используем nextLine(), т.к. next() вернет только то, что до пробела
        userInput=scan.nextLine();
        scan.close();
    }
    
    public static boolean isPolindrom(String input){
        ArrayList<String> stringToList=new ArrayList<String>(Arrays.asList(input.split("")));
        int i,j;
        
        boolean temp=false;
        //i равно первому элементу списка, j - последнему
        //в цикле двигаемся к середине
            for (i=0, j=stringToList.size()-1;i<=j;i++,j--){
                if (stringToList.get(i).equals(stringToList.get(j))){
                    temp=true;
                }
                else {
                    System.out.println("\""+input+"\":"+" isn`t a polindrom.");
                    temp=false;
                    break;
                }
            }
        if (temp==true){
            System.out.println("\""+input+"\":"+" is a polindrom.");
        }
        return temp;
    }
    
}
