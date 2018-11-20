import java.util.concurrent.Callable;

public class Calka_callable implements Callable<Double> {

    double field = 0;
    double xp = 0;
    double xn;
    double xk;
    double dx;


    public Calka_callable(double x0, double xk) {
         this.xn = x0;
         this.dx = (xk-x0)/10;
         this.xk = xk;
    }

    public double intagratingByTrapeze(double x0, double xk, double dx) {
        double xp = 0;
        double xn = x0;
        double field = 0;
        for (double i = 0; i <= xk; i += dx) {
            xp = xn;
            xn = xp + dx;
            field += ((Math.sin(xn) + Math.sin(xp)) * dx) / 2.0;
        }
        return field;
    }

    @Override
    public Double call() throws Exception {
        for (double i = 0; i <= xk; i += dx) {
            xp = xn;
            xn = xp + dx;
            field += ((Math.sin(xn) + Math.sin(xp)) * dx) / 2.0;
        }
        System.out.println("counted");
        return field;
    }
}
