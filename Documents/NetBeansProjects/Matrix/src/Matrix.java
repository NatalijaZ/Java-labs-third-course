public class Matrix {

    private static int Max(int[] Array ){
        int max = Array[0];
        for (int i = 1; i  < Array.length ; i++) {
            if(Array[i] > max){
                max = Array[i];
            }
        }
        return max;
    }

    private static double maxD(double[] Array ){
        double max = Array[0];
        for (int i = 1; i  < Array.length ; i++) {
            if(Array[i] > max){
                max = Array[i];
            }

        }
        return max;
    }

    private static int Min(int[] Array){
        int min = Array[0];
        for (int i = 1; i  < Array.length ; i++) {
            if(Array[i] < min){
                min = Array[i];
            }
        }
        return min;
    }

    private static void print(int[] Array){
        for (int i = 0; i < Array.length ; i++) {
            System.out.print(Array[i] + "  ");
        }
        System.out.println();
    }

    private static final int p0[] = new int[]{ 15, 10,  0, -6, 17};
    private static final int p1[] = new int[]{ 3, 14,  8,  9,  2};
    private static final int p2[] = new int[]{ 1,  5, 14, 20, -3};
    private static final int p3[] = new int[]{ 7, 19, 10,  2,  0};
    private final static  double c = 0.44;
    
    public static void main(String[] args) {
        System.out.println("Минимаксный критерий:");
        int[] minArray = new int[]{Min(p0),Min(p1),Min(p2),Min(p3)};
        int MinMaxСriterion = Max(minArray);
        print(minArray);
        System.out.println("MinMax Сriterion:"+ MinMaxСriterion);
        System.out.println("*********************");
        
        System.out.println("Критерий Сэвиджа");
        System.out.println("Матрица рисков:");
        int[] a0 = new int[]{p0[0],p1[0],p2[0],p3[0]};
        int[] a1 = new int[]{p0[1],p1[1],p2[1],p3[1]};
        int[] a2 = new int[]{p0[2],p1[2],p2[2],p3[2]};
        int[] a3 = new int[]{p0[3],p1[3],p2[3],p3[3]};
        int[] a4 = new int[]{p0[4],p1[4],p2[4],p3[4]};
        int max0 = Max(a0);
        int max1 = Max(a1);
        int max2 = Max(a2);
        int max3 = Max(a3);
        int max4 = Max(a4);
        int[] b0 = new int[]{max0 - p0[0],max1 - p0[1],max2 - p0[3],max3 - p0[3],max4 - p0[4]};
        int[] b1 = new int[]{max0 - p1[0],max1 - p1[1],max2 - p1[3],max3 - p1[3],max4 - p1[4]};
        int[] b2 = new int[]{max0 - p2[0],max1 - p2[1],max2 - p2[3],max3 - p2[3],max4 - p2[4]};
        int[] b3 = new int[]{max0 - p3[0],max1 - p3[1],max2 - p3[3],max3 - p3[3],max4 - p3[4]};
        print(b0);
        print(b1);
        print(b2);
        print(b3);
        int[] maxArray = new int[]{Max(b0),Max(b1),Max(b2),Max(b3)};
        print(maxArray);
        int SavageСriterion = Min(maxArray);
        System.out.println("Savage Сriterion:" + SavageСriterion);
        System.out.println("*********************");
        System.out.println("Критерий Гурвица");
        double[] gur = new double[]{c*Min(p0)+(1-c)*Max(p0),
                                  c*Min(p1)+(1-c)*Max(p1),
                                  c*Min(p2)+(1-c)*Max(p2),
                                  c*Min(p3)+(1-c)*Max(p3)};
        for (int i = 0; i < gur.length ; i++) {
            System.out.println(gur[i]);

        }
        double GurwizСriterion = maxD(gur);
        System.out.println("Gurwiz Сriterion:" + GurwizСriterion);

        }
    }
