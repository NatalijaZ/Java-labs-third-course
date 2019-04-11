package simpledotcomgame;

public class SimpleDotComGame {
    public static void main(String[] args) {
        //создаем переменную, чтобы следить за кол-вом ходов пользователя
        int numOfGuesses=0;
        //специальный класс, содержащий метод для приема пользовательского ввода
        GameHelper helper=new GameHelper();
        //создаем объект "сайт"
        SimpleDotCom theDotCom=new SimpleDotCom();
        //генерируем случайное число для первой ячейки ииспользуем его для 
        //формирования массива ячеек
        int randomNum=(int) (Math.random()*5);
        int[] locations={randomNum, randomNum+1, randomNum+2};
        //передаем "сайту" местоположение его ячеек (массив)
        theDotCom.setLocationCells(locations);
        //создаем булеву переменную, чтобы проверять в цикле, 
        //не закончилась ли игра
        boolean isAlive=true;
        
        while (isAlive==true){
            //получаем строку, вводимую пользователем
            String guess=helper.getUserInput("Введите число");
            //просим "сайт" проверить полученные данные, 
            //сохраняем возвращенный результат в переменную типа String
            String result=theDotCom.checkYourself(guess);
            //инкрементируем кол-во попыток
            numOfGuesses++;
            //потоплен ли "сайт"? если да, то присваиваем isAlive значение false
            //(так как не хотим продолжать цикл) 
            //и выводим на экран кол-во попыток
            if (result.equals("Потопил")){
                isAlive=false;
                System.out.println("Вам потребовалось "+numOfGuesses+
                        " попыток(и)");
            }//завершаем if
        }//завершаем while
    }//завершаем метод main
    
} 
