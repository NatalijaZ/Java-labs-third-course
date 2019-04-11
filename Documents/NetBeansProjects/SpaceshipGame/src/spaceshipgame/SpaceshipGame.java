/*
 * Имеется класс Spaceship. Создайте 3 экземпляра. Напишите методы, 
 * которые находят:
 * a) среднюю скорость кораблей
 * б) минимальную скорость кораблей
 * Класс Spaceship сохраните в отдельном файле
 */
package spaceshipgame;

public class SpaceshipGame {

    public static void main(String[] args) {
        Spaceship ship1=new Spaceship(154);
        Spaceship ship2=new Spaceship(165);
        Spaceship ship3=new Spaceship(148);
        double speed1=ship1.getSpeed();
        double speed2=ship2.getSpeed();
        double speed3=ship3.getSpeed();
        averageSpeed(speed1,speed2,speed3); 
        minSpeed(speed1,speed2,speed3);
    } 
    
    public static double averageSpeed (double s1, double s2, double s3){
        double avSpeed=(s1+s2+s3)/3;
        System.out.println("The average speed is: "+avSpeed); 
        return avSpeed;
    } 
    
    public static double minSpeed (double s1, double s2, double s3){
        double mSpeed=Math.min(s1,Math.min(s2, s3));
        System.out.println("The min speed is: "+mSpeed); 
        return mSpeed;
    } 
}
