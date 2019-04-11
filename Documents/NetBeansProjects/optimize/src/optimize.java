import static java.lang.Math.*;
        
public class optimize {
    public static void main(String[] args) {
        //double x0=0.0, y0=1.0,
               //x1=0.52029, y1=y0,
               //x2=0.53,  y2=1.498;
        //*********Функция Розенброка*********
        double x0=-1.2, y0=1,
               x1=-2.5, y1=3,
               x2=-0.3,  y2=1.5;
        //////////////////////////////////////
        double xRef=0.0,
               yRef=0.0,
               fRef=0.0;
        System.out.println ("*****minBest***************goodValue*************badValue");
        //for (int i=0; i<4; i++){
        for (int i=0; i<56; i++){
            /////////////////////////////////////////////////////
            //double f1=Math.pow(x0-y0,2)+Math.pow(x0+y0-10,2)/9.0;
            //double f2=Math.pow(x1-y1,2)+Math.pow(x1+y1-10,2)/9.0;
            //double f3=Math.pow(x2-y2,2)+Math.pow(x2+y2-10,2)/9.0;
            /////////////////////////////////////////////////////
            //*********Функция Розенброка*********
            double f1=100*Math.pow(Math.pow(x0,2)-y0,2)+Math.pow(1-x0,2);
            double f2=100*Math.pow(Math.pow(x1,2)-y1,2)+Math.pow(1-x1,2);
            double f3=100*Math.pow(Math.pow(x1,2)-y2,2)+Math.pow(1-x2,2);
            double minBest=0.0,
                   goodValue=0.0,
                   badValue=0.0;
            double xBest=0.0,
                   yBest=0.0,
                   xGood=0.0,
                   yGood=0.0,
                   xBad=0.0,
                   yBad=0.0;
            if (f1<f2&f1<f3) {
                minBest=f1;
                xBest=x0;
                yBest=y0;
                if (f2<f3){
                    goodValue=f2;
                    xGood=x1;
                    yGood=y1;
                    badValue=f3;
                    xBad=x2;
                    yBad=y2;
                }
                else {
                    goodValue=f3;
                    xGood=x2;
                    yGood=y2;
                    badValue=f2;
                    xBad=x1;
                    yBad=y1;
                }
            }
            else if (f2<f1&f2<f3) {
                minBest=f2;
                xBest=x1;
                yBest=y1;
                if (f1<f3){
                    goodValue=f1;
                    xGood=x0;
                    yGood=y0;
                    badValue=f3;
                    xBad=x2;
                    yBad=y2;
                }
                else {
                    goodValue=f3;
                    xGood=x2;
                    yGood=y2;
                    badValue=f1;
                    xBad=x0;
                    yBad=y0;
                }
            }
            else if (f3<f1&f3<f2) {
                minBest=f3;
                xBest=x2;
                yBest=y2;
                if (f1<f2){
                    goodValue=f1;
                    xGood=x0;
                    yGood=y0;
                    badValue=f2;
                    xBad=x1;
                    yBad=y1;
                }
                else {
                    goodValue=f2;
                    xGood=x1;
                    yGood=y1;
                    badValue=f1;
                    xBad=x0;
                    yBad=y0;
                }
            }
            
        
            //середина отрезка Best-Good
            double xMid=(xBest+xGood)/2.0;
            double yMid=(yBest+yGood)/2.0;
            //отражение
            xRef= 2*xMid-xBad;
            yRef= 2*yMid-yBad;
            ////////////////////////////////////////////////////////
            //fRef=Math.pow(xRef-yRef,2)+Math.pow(xRef+yRef-10,2)/9.0;
            ////////////////////////////////////////////////////////
            //*********Функция Розенброка*********
            fRef=100*Math.pow(Math.pow(xRef,2)-yRef,2)+Math.pow(1-xRef,2);
            //растяжение
            double xExpansion=0.0,
                   yExpansion=0.0,
                   xContr=0.0,
                   yContr=0.0;
            if (fRef<minBest) {
                xExpansion=2*xRef-xMid;
                yExpansion=2*yRef-yMid;
                /////////////////////////////////////////////////////////////////////////////////////////////
                //double fExpansion=Math.pow(xExpansion-yExpansion,2)+Math.pow(xExpansion+yExpansion-10,2)/9.0;
                /////////////////////////////////////////////////////////////////////////////////////////////
                //*********Функция Розенброка*********
                double fExpansion=100*Math.pow(Math.pow(xExpansion,2)-yExpansion,2)+Math.pow(1-xExpansion,2);
                if (fExpansion<fRef) {
                    x0=xExpansion;
                    y0=yExpansion;
                    x1=xBest;
                    y1=yBest;
                    x2=xGood;
                    y2=yGood;
                }
                else {
                    //сжатие
                    xContr=xMid+0.5*(xBad-xMid);
                    yContr=yMid+0.5*(yBad-yMid);
                    /////////////////////////////////////////////////////////////////////////
                    //double fContr=Math.pow(xContr-yContr,2)+Math.pow(xContr+yContr-10,2)/9.0;
                    /////////////////////////////////////////////////////////////////////////
                    //*********Функция Розенброка*********
                    double fContr=100*Math.pow(Math.pow(xContr,2)-yContr,2)+Math.pow(1-xContr,2);
                    //System.out.printf ("%.5f \n",fContr);
                    if (fContr<fRef) {
                        x0=xContr;
                        y0=yContr;
                        x1=xBest;
                        y1=yBest;
                        x2=xGood;
                        y2=yGood;
                    }
                    else{
                        x0=xRef;
                        y0=yRef;
                        x1=xBest;
                        y1=yBest;
                        x2=xGood;
                        y2=yGood;    
                    }
                }
            }
            else {
                //сжатие
                    xContr=xMid+0.5*(xBad-xMid);
                    yContr=yMid+0.5*(yBad-yMid);
                    /////////////////////////////////////////////////////////////////////////
                    //double fContr=Math.pow(xContr-yContr,2)+Math.pow(xContr+yContr-10,2)/9.0;
                    /////////////////////////////////////////////////////////////////////////
                    //*********Функция Розенброка*********
                    double fContr=100*Math.pow(Math.pow(xContr,2)-yContr,2)+Math.pow(1-xContr,2);
                    //System.out.printf ("%.5f \n",fContr);
                    if (fContr<fRef) {
                        x0=xContr;
                        y0=yContr;
                        x1=xBest;
                        y1=yBest;
                        x2=xGood;
                        y2=yGood;
                    }
                    else{
                        x0=xRef;
                        y0=yRef;
                        x1=xBest;
                        y1=yBest;
                        x2=xGood;
                        y2=yGood;    
                    }
                
            }
        System.out.printf ("(");
            System.out.printf ("%.2f",xBest);
            System.out.printf (";");
            System.out.printf ("%.2f", yBest);
            System.out.printf (")");
            System.out.printf ("%.3f",minBest);
            System.out.printf ("****** (");
            System.out.printf ("%.2f",xGood);
            System.out.printf (";");
            System.out.printf ("%.2f", yGood);
            System.out.printf (")");
            System.out.printf ("%.3f", goodValue);
            System.out.printf ("****** (");
            System.out.printf ("%.2f",xBad);
            System.out.printf (";");
            System.out.printf ("%.2f", yBad);
            System.out.printf (")");
            System.out.printf ("%.3f \n", badValue);
			}
		
    }
    
}