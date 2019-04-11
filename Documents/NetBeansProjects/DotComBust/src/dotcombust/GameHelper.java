/*
 * HeadFirst, page 182
 */
package dotcombust;

import java.io.*;
import java.util.*;

public class GameHelper {
    
    private static final String alphabet="abcdefg";
    private int gridLength=7;
    private int gridSize=49;
    private int[] grid=new int[gridSize];
    private int comCount;
    
    public String getUserInput(String prompt){
        String inputLine=null;
        System.out.print(prompt+" ");
        try{
            BufferedReader is=new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine=is.readLine();
            if (inputLine.length()==0) return null;
        } 
        catch(IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine.toLowerCase();
    }
    
    public ArrayList<String> placeDotCom(int comSize){
        ArrayList<String> alphaCells=new ArrayList<String>();
        String[] alphacoords=new String[comSize];//хранит кооррдинаты типа f6
        String temp=null;//временая строка для конкатенации
        int[] coords=new int[comSize];//координаты текущего "сайта"
        int attempts=0;//счетчик текущих попыток
        boolean success=false;//нашли подходящее местоположение?
        int location=0;//текущее начальное положение
        
        comCount++;//энный "сайт" для размещения
        int incr=1;//устанавливаем горизонтальный инкремент
        if((comCount%2)==1){//если нечетный (размещаем вертикально)
            incr=gridLength;//устанавливаем вертикальный инкемент
        }
        
        while(!success&attempts++<200){//главный поисковый цикл (32)
            //получаем случайную стартовую точку
            location=(int)(Math.random()*gridSize);
            //System.out.print("пробуем"+location);
            int x=0;//энная позиция в "сайте", который нужно разместить
            success=true;//предполагаем успешный исход
            while(success&&x<comSize){//ищем соседнюю неиспользованную ячейку
                if(grid[location]==0){//если еще не используется
                    coords[x++]=location;//сохраняем местоположение
                    location+=incr;//пробуем "следующую" соседнюю ячейку
                    if (location>=gridSize){//вышли за рамки - низ
                        success=false;//неудача
                    }
                    //вышли за рамки - правый край
                    if(x>0&&(location%gridLength==0)){
                        success=false;//неудача
                    }
                }
                else{//нашли уже использующееся местопложение
                    //System.out.print("используется"+location;
                    success=false;//неудача
                }
            }
        }//конец while
        
        int x=0;//переводим местоположение в символьные координаты
        int row=0;
        int column=0;
        //System.out.println("\n");
        while(x<comSize){
            //помечаем ячейки на главной сетке как "использованные"
            grid[coords[x]]=1;
            row=(int)(coords[x]/gridLength);//получаем значение строки
            column=coords[x]%gridLength;//получаем числовое значение столбца
            //преобразуем его в строковый символ
            temp=String.valueOf(alphabet.charAt(column));
            
            alphaCells.add(temp.concat(Integer.toString(row)));
            x++;
            //это выражение говорит вам о том, где именно находится "сайт"
            //System.out.print(" coord "+x+" = "+alphaCells.get(x-1));
        }
        
        //System.out.println("\n");
        
        return alphaCells;
    }
}
