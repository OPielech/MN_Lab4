public class FunctionTest implements ScalarFunction {

    @Override
    public double function(double x) {
        double y=Math.exp(-x)-x;
        return y;
    }
}
