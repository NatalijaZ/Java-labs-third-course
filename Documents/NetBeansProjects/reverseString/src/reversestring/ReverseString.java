/*
 * Напишите программу, отображающую переданную строку задом наперёд. 
 * Напишите тесты.
 */
package reversestring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {
    private static String userInput;
    
    public static void main(String[] args) {
        setUserInput();
        reverseStr(userInput);
    }
    
    public static void setUserInput(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Write an expression:");
        //используем nextLine(), т.к. next() вернет только то, что до пробела
        userInput=scan.nextLine();
        scan.close();
    }
    
    public static String reverseStr(String input){
        ArrayList<String> stringToList=new ArrayList<String>(Arrays.asList(input.split("")));
        int i,j;
        String temp;
            for (i=0, j=stringToList.size()-1;i<=j;i++,j--){
                temp=stringToList.get(i);
                stringToList.remove(i);
                stringToList.add(i,stringToList.get(j-1));
                stringToList.remove(j);
                stringToList.add(j,temp);
            }   
        String listString = String.join("", stringToList);
        System.out.println(listString);
        return listString;
    }
}
