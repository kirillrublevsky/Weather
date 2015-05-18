import java.util.concurrent.*;

public class Application {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(9);

        Future<Integer> kievGismeteo = executor.submit(new Weather("Kiev", "gismeteo.ua"));
        Future<Integer> kievSinoptik = executor.submit(new Weather("Kiev", "sinoptik.ua"));

        executor.shutdown();

        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>();
        System.out.println("Waiting for data from server...");

        while(!kievGismeteo.isDone() && !kievSinoptik.isDone()){
        }
            list.add(kievGismeteo.get());
            list.add(kievSinoptik.get());


        double average = (double)(list.get(0) + list.get(1)) / 2;
        System.out.println("First temperature is " + list.get(0));
        System.out.println("Second temperature is " + list.get(1));
        System.out.println("Average temperature is " + average);




    }
}
