/**
 * @author N. Zhilkevich
 * group 33534/21
 */
public class Mersedes_1 {
    public static void main(String[] args) {
        int[][] profit =decisionMatrix();
        int maximum=optimalProfit(profit);
        mersedesShouldBeOrdered(profit,maximum);
    }
    //метод для нахождения матрицы решений, мат ожидания для каждого заказа
    public static int[][] decisionMatrix(){
        String text="_________________МАТРИЦА РЕШЕНИЙ:__________________"
                + "\n|            Спрос в 1-ю половину года"
                + "\n|       100       150       200       250        300  "
                + "\n|p      0.1       0.25      0.25      0.3        0.1  "
                + "\n|Заказ                                                   "
                + "    Мат ожидание"      
                + "\n-------------------------------------------------------"
                + "-----------------";
        
        int profit[][]=new int[5][7];//прибыль
        int order=100;//заказ
        int i,j;
        for (i=0;i<profit.length;i++){
            profit[i][0]=order;
            text+="\n"+"| "+profit[i][0]+"   ";
            double m=0;//мат ожидание
            double p=0;//вероятность
            switch(i){
                case 0: p=0.1;
                break;
                case 1: p=0.25;
                break;
                case 2: p=0.25;
                break;
                case 3: p=0.3;
                break;
                case 4: p=0.1;
                break;
                default: break;
            }
            int demandFirstHalfOfYear=100;//спрос в первую половину года
                for (j=1;j<profit[0].length-1;j++){
                    //продано во 2-ю половину года
                    int soldSecondHalfOfYear=order
                        -demandFirstHalfOfYear;
                
                    if (soldSecondHalfOfYear>0){
                            profit[i][j]=49000*demandFirstHalfOfYear
                                +15000*soldSecondHalfOfYear-25000*order;
                    }
                    else {
                        if (order>demandFirstHalfOfYear)
                            profit[i][j]=49000*demandFirstHalfOfYear
                                +15000*soldSecondHalfOfYear-25000*order;
                        else profit[i][j]=49000*order-25000*order;
                    } 
                    m+=p*profit[i][j];//находим мат ожидание по строкам
                    profit[i][6]=(int)m;//пишем мат ожидание в последний столбец
                    text+=profit[i][j]+"   ";
                    demandFirstHalfOfYear+=50;
                }
            text+="  "+"| "+profit[i][6];      
            order+=50;//
        }
        System.out.println (text);
        return profit;
    }
    //метод для определения оптимальной ожидаемой прибыли
    public static int optimalProfit(int profit[][]){
        //находим наибольший элемент столбца с мат ожиданием
        int max=profit[0][6];
            for (int i=0;i<profit.length;i++){
                if (max<profit[i][6]) max=profit[i][6];
            }
        System.out.println ("------------------------------------------------"
            + "------------------------\n"
            +"Оптимальная ожидаемая прибыль равна:"+max);  
        return max;
    }
    //метод для определения числа мерседесов, которое следует заказывать
    //ежегодно
    public static void mersedesShouldBeOrdered(int profit[][], int max){
        //определяем номер строки с наибольшим мат ожиданием
        int maxIndex=0;
        for (int i=0;i<profit.length;i++){
            if (max==profit[i][6]) maxIndex=i;
            }
        System.out.println ("Оптимальное число мерседесов, которое следует "
            +"заказывать ежегодно:" +profit[maxIndex][0]);
    }
}