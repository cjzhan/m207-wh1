public class EulerMethod {
    
    public static void main(String[] args) {
        eulerMethod(0.5, 0, 2, 1); // for testing purposes, or for computing only Euler's approximations

    }

    // approximates y(end) using Euler's method with h = stepSize, initial condition y(init) = initVal
    public static double eulerMethod(double stepSize, double init, double end, double initVal) {
        int numSteps = (int) ((end - init) / stepSize);
        double currT = init;
        double approx = initVal;
        System.out.println("Euler's Method:");
        for (int i = 0; i < numSteps; i++) {
            approx = eulerIter(approx, currT, stepSize);
            currT += stepSize;
            System.out.println("  f(" + (Math.round(currT * 1000.0) / 1000.0) + ")≈" + approx);
        }
        return approx;
    }

    // parts (b) and (c) of written homework
    public static double function(double t, double y) {
        return t + y; // y' = t + y
    }

    // part (d) of written homework
    public static double function2(double t, double y) {
        return (t * y) / 3.0; // y' = (ty) / 3
    }

    // this computes *just* one iteration of Euler's method (because it makes the code for Heun's method
    // easier xD) and also cuts down on redundancy. yay helper methods!
    public static double eulerIter(double approx, double currT, double stepSize) {
        return approx + stepSize * (function2(currT, approx)); // change to function() as necessary
    }
}
