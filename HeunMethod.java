public class HeunMethod extends EulerMethod { // we love inheritance in this household!
    
    public static void main(String[] args) {
        comparison(1, 0, 2, 1); // computes both approximations with all steps, true value, and error
        comparison(0.5, 0, 2, 1);
        comparison(0.2, 0, 2, 1);
        comparison(0.1, 0, 2, 1);
        comparison(0.05, 0, 2, 1);
    }

    // approximates y(end) using Heun's method with h = stepSize, initial condition y(init) = initVal
    public static double heunMethod(double stepSize, double init, double end, double initVal) {
        int numSteps = (int) ((end - init) / stepSize);
        double currT = init;
        double approx = initVal;
        System.out.println("Heun's Method:");
        for (int i = 0; i < numSteps; i++) {
            double euler = eulerIter(approx, currT, stepSize);
            double nextT = currT + stepSize;
            approx = approx + (stepSize / 2) * (function2(currT, approx) + function2(nextT, euler)); // change to function() as necessary
            currT = nextT;
            System.out.println("  f(" + (Math.round(nextT * 1000.0) / 1000.0) + ")≈" + approx);
        }
        return approx;
    }

    // parts (b) and (c) of written homework
    public static double trueValue(double t) {
        return 2 * Math.exp(t) - t - 1; // y = 2e^t - t - 1 || solution to y' = t + y
    }

    // part (d) of written homework
    public static double trueValue2(double t) {
        return Math.exp((Math.pow(t, 2)) / 6.0); // y = e^((t^2)/6) || solution to y' = (ty) / 3
    }

    // approximates y(end) with both Euler's and Heun's methods, with h = stepSize and initial condition 
    // y(init) = initVal. computes true value of y(end) and the percentage error of each method. 
    // warning: prints a *lot* when stepSize gets small. make sure your terminal is ready!
    public static void comparison(double stepSize, double init, double end, double initVal) {
        double euler = eulerMethod(stepSize, init, end, initVal);
        System.out.println();
        double heun = heunMethod(stepSize, init, end, initVal);
        System.out.println();
        double trueV = trueValue2(end); // change to trueValue() as necessary
        System.out.println("Euler's Method Approximation: " + euler);
        System.out.println("Heun's Method Approximation: " + heun);
        System.out.println("Actual Value: " + trueV);
        System.out.println();
        double rawEulerError = (((euler - trueV) / trueV) * 100.0);
        double rawHeunError = (((heun - trueV) / trueV) * 100.0);
        System.out.println("Euler's Method Error: " + Math.abs((Math.round(rawEulerError * 100.0) / 100.0)) + "%");
        System.out.println("Heun's Method Error: " + Math.abs((Math.round(rawHeunError * 100.0) / 100.0)) + "%");
        System.out.println();
    }

}
