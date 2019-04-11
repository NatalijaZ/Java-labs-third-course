/*
 * реализуйте метод int min(int a, int b, int c), 
 * находящий минимальный из трех аргументов
 */
package min3;

public class Min3 {
    
    public static void main(String[] args) {
        int minArg=min(7,6,4);
        System.out.println("Наименьшее число:"+minArg);
    } 
    
    public static int min(int a, int b, int c){
        return Math.min(Math.min (a,b), c);
    } 
}
