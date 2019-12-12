public class RegulaFalsi {
    private double xl;
    private double xu;
    private double relativeError;
    private int maxIteration;
    private double xr1;
    private ScalarFunction function;

    public RegulaFalsi(double xl, double xu, double relativeError, int maxIteration, double xr1, ScalarFunction function) {
        this.xl = xl;
        this.xu = xu;
        this.relativeError = relativeError;
        this.maxIteration = maxIteration;
        this.xr1 = xr1;
        this.function = function;
    }

    public double solver() {

        int i = 1;
        double ea;
        double et;
        double xr = 0;
        double[] xrs = new double[maxIteration];
        xrs[0] = xr1;


        do {
            xr = xu - (function.function(xu) * (xl - xu)) / (function.function(xl) - function.function(xu));
            xrs[i] = xr;

            if (function.function(xl) * function.function(xr) < 0)
                xu = xr;

            else if (function.function(xr) * function.function(xu) < 0)
                xl = xr;
            else
                i = maxIteration;

            System.out.println("xr = " + xr);

            ea = Math.abs((xrs[i] - xrs[i - 1]) / xrs[i] * 100);
            System.out.printf("Ea = %.2e%c\n", ea, '%');

            et = Math.abs((xrs[i] - 0.56714329) / xrs[i] * 100);
            System.out.printf("Et = %.2e%c\n", et, '%');
            i++;
        } while (i < maxIteration && ea >= relativeError);

        return xr;
    }//end of solver
}//end of class
