/*
 * HeadFirst, page 180
 */
package dotcombust;

import java.util.*;

public class DotCom {
    //  переменные экземпляра класса DotCom:
    //- ArrayList с ячейками, описывающими месоположение;
    //- имя "сайта"
    private ArrayList<String> locationCells;
    private String name;
    
    //сеттер, который обновляет местоположение "сайта" (случайный адрес, 
    //предоставляемый методом placeDotCom() из класса GameHelper)
    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }
    
    //простой сеттер
    public void setName(String n){
        name=n;
    }
    
    public String checkYourself(String userInput){
        String result="Мимо";
        //метод indexOf() из ArrayList в действии;
        //если ход пользователя совпал с одним из элементов ArrayList, то
        //метод indexOf() вернет его местоположение;
        //если нет, то indexOf() вернет -1
        int index=locationCells.indexOf(userInput);
        if (index>=0){
            //применяем метод remove() из ArrayList для удаления элемента
            locationCells.remove(index);
            //метод isEmpty() для проверки, все ли адреса были угаданы
            if (locationCells.isEmpty()){
                result="Потопил";
                //сообщаем пользователю о потоплении "сайта"
                System.out.println("Ой! Вы потопили " + name + " :(");
            }
            else{
                result="Попал";
            }//конец if
        }//конец if
        return result;//возвращаем "Мимо", "Попал" или "Потопил"
    }//конец метода
}//конец класса
