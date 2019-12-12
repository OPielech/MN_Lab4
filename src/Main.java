public class Main {

    public static void main(String[] args) {
        new RegulaFalsi(-1, 3, 0.01, 1000, 0.6, x -> x = Math.exp(-x) - x).solver();
//        new FixedPointsIteration(10, 0.0001, 1000, x -> x = Math.exp(-x) - x).solver();
//        new NewtonRaphsonMethod(10, 0.0001, 1000, x -> x = Math.exp(-x) - x).solver();
//        new SecandMethod(10, 0.00001, 1000, x -> x = Math.exp(-x) - x).solver();
    }


//    public static void main(String[] args) {
//
//        new RegulaFalsi(-1, 3, 0.01, 1000, 0.6, x -> x = Math.exp(-x) - x).solver();
//        new FixedPointsIteration(10, 0.0001, 1000, x -> x = Math.exp(-x) - x).solver();
//        new NewtonRaphsonMethod(10, 0.0001, 1000, x -> x = Math.exp(-x) - x).solver();
//        new SecandMethod(10, 0.00001, 1000, x -> x = Math.exp(-x) - x).solver();
//
//    }//end of main
}
