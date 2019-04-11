/*
 * HeadFirst, page 178
 */
package dotcombust;

import java.util.*;

public class DotComBust {
    //объявляем и инициализируем переменные
    private GameHelper helper=new GameHelper();
    //создаем ArrayList ТОЛЬКО для объектов DotCom
    private ArrayList<DotCom> dotComsList=new ArrayList<DotCom>();
    private int numOfGuesses=0;
    
    public static void main(String[] args) {
        //создаем игровой объект
        DotComBust game=new DotComBust();
        //говорим игровому объекту подготовить игру
        game.setUpGame();
        //говорим игровому объекту начать главный игровой цикл(продолжаем 
        //запрашивать пользовательский ввод и проверять полученные данные)
        game.startPlaying();
    }//конец метода
    
    private void setUpGame(){
        //создадим несколько "сайтов" и присвоим им адреса
        //создаем три объекта DotCom, даем им имена и помещаем в ArrayList
        DotCom one=new DotCom();
        one.setName("Pets.com");
        DotCom two=new DotCom();
        two.setName("eToys.com");
        DotCom three=new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        
        //выводим краткие инструкции для пользователя
        System.out.println("Ваша цель - потопить три \"сайта\".");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь потопить их за минимальное количество "
                + "ходов");
        
        //повторяем с каждым объектом DotCom в списке
        for (DotCom dotComToSet:dotComsList){
            //запрашиваем у вспомогательного объекта адрес "сайта"
            ArrayList<String> newLocation=helper.placeDotCom(3);
            //вызываем сеттер из объекта DotCom, чтобы передать ему 
            //местоположение, которое только что получили от вспомогательного 
            //объекта
            dotComToSet.setLocationCells(newLocation);
        }//конец цикла
        
    }//конец метода setUpGame
            
    private void startPlaying(){
        //до тех пор, пока список объектов DotCom не станет пустым
        while(!dotComsList.isEmpty()){
            //получаем пользовательский ввод
            String userGuess=helper.getUserInput("Сделайте ход");
            //вызываем метод checkUserGuess
            checkUserGuess(userGuess);
        }//конец while
        //вызываем метод finishGame()
        finishGame();
    }//конец метода startPlaying
    
    public void checkUserGuess (String userGuess){
        //инкрементируем количество попыток, которые сделал пользователь
        numOfGuesses++;
        //подразумеваем промах, пока не выяснили обратного
        String result="Мимо";
        //повторяем это для всех объектов DotCom в списке
        for (DotCom dotComToTest:dotComsList){
            //просим DotCom проверить ход пользователя, ищем попадание
            //(или потопление)
            result=dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")){
                //выбираемся из цикла раньше времени, нет смысла проверять 
                //другие "сайты"
                break;
            }
            if (result.equals("Потопил")){
                //ему пришел конец, удаляем его из списка "сайтов" и выходим 
                //из цикла
                dotComsList.remove(dotComToTest);
                break;
            }
        }//конец for
        //выводим для пользователя результат
        System.out.println(result);
    }//конец метода
    
    private void finishGame(){
        //выводим сообщение, как пользователь прошел игру
        System.out.println("Все \"сайты\" ушли ко дну! Ваши акции теперь "
                + "ничего не стоят.");
        if (numOfGuesses<=18){
            System.out.println("Это заняло у вас всего " + numOfGuesses 
                    + " попыток.");
            System.out.println("Вы успели выбраться до того, как ваши вложения "
                    + "утонули.");
        }
        else{
            System.out.println ("Это заняло у вас довольно много времени. " 
                    + numOfGuesses + " попыток.");
            System.out.println ("Рыбы водят хороводы вокруг ваших вложений.");
        }
    }//конец метода
}
