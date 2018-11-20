import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("Hello World!");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<Double>> list = new ArrayList<Future<Double>>();
        double field = 0;
        double number = 2.;
        double x0 = 0.;
        double xn = Math.PI;
        double dx = (xn-x0)/number;
        for (int i = 0; i < number; i++) {
            Calka_callable tmp = new Calka_callable(x0 +i*dx,x0+(i+1)*dx);
            Future<Double> future = executor.submit(tmp);
            list.add(future);
        }
        for (int i = 0; i < number; i++) {
            try {
                field += list.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum is: " + field);
    }
}
