public class RegulaFalsi{

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Er = "+solver(-1,3,0.01,1000,0.6));

    }//end of main

    public static double solver (double xl, double xu, double relativeError, int maxIteration, double xr1){
        FunctionTest test=new FunctionTest();
        double ea;
        double xr=0;
        double[]xrs=new double[maxIteration];
        xrs[0]=xr1;

        for (int i=1; i<=maxIteration; i++){
            xr=xu-(test.function(xu)*(xl-xu))/(test.function(xl)- test.function(xu));
            xrs[i]=xr;

            if (test.function(xl)*test.function(xr)<0)
                xu=xr;

            else if (test.function(xr)*test.function(xu)<0)
                xl=xr;
            else
                i=maxIteration;

            System.out.println("xr = "+xr);

            if (i==1) {
                ea = Math.abs((xrs[1] - xrs[0]) / xrs[1] * 100);
                System.out.printf("Ea = %.2e%c\n", ea, '%');
            }//end of if
            else {
                ea = Math.abs((xrs[i] - xrs[i - 1]) / xrs[i] * 100);
                System.out.printf("Ea = %.2e%c\n", ea, '%');
            }//end of else

            if (ea<=relativeError)
                i=maxIteration;

        }//end of for

        return xr;
    }//end of solver
}//end of class
