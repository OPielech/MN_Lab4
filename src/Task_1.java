public class Task_1 implements ScalarFunction {

    public static void main(String[] args) {

//        System.out.println();
//        solverRegulaFalsi(-1,3,0.0001,1000,0.6);
        solverFixedPointsIteration(0.01,10,0.0001,10000);

    }//end of main

    public static double solverRegulaFalsi (double xl, double xu, double relativeError, int maxIteration, double xr1){
        Task_1 test=new Task_1();

        double ea;
        double et;
        double xr=0;
        double[]xrs=new double[maxIteration];
        xrs[0]=xr1;

        for (int i=1; i<maxIteration; i++){
            xr=xu-(test.function(xu)*(xl-xu))/(test.function(xl)- test.function(xu));
            xrs[i]=xr;

            if (test.function(xl)*test.function(xr)<0)
                xu=xr;

            else if (test.function(xr)*test.function(xu)<0)
                xl=xr;
            else
                i=maxIteration;

            System.out.println("xr = "+xr);

            ea = Math.abs((xrs[i] - xrs[i - 1]) / xrs[i] * 100);
            System.out.printf("Ea = %.2e%c\n", ea, '%');

            et=Math.abs((xrs[i]-0.56714329)/xrs[i]*100);
            System.out.printf("Et = %.2e%c\n",et,'%');

            if (ea<=relativeError)
                i=maxIteration;

        }//end of for

        return xr;
    }//end of solverRegulaFalsi

    public static double solverFixedPointsIteration (double m, double x0, double relativeError, int maxIteration){
        Task_1 test=new Task_1();

        double ea;
        double et;
        double xn=x0*m;
        double xn1=0;
        double[]xns=new double[maxIteration];
        xns[0]=xn;

        for (int i=1; i<maxIteration; i++){
            xn1=test.function(xn)+xn;
            xns[i]=xn1;
            xn=xn1;

            if(xn==0.5671432904097838)
                i=maxIteration;

            System.out.println("xn+1= "+xn);

            ea = Math.abs((xns[i] - xns[i - 1]) / xns[i] * 100);
            System.out.printf("Ea = %.2e%c\n", ea, '%');

            et=Math.abs((xns[i]-0.56714329)/xns[i]*100);
            System.out.printf("Et = %.2e%c\n",et,'%');

            if (ea<=relativeError)
                i=maxIteration;
        }//end of for
        return xn;
    }//end of solverFixedPointsIteration

    @Override
    public double function(double x) {
            double y=Math.exp(-x)-x;
            return y;
    }
}//end of class
