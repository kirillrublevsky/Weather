import java.util.Random;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class Weather implements Callable<Integer> {

    private String city;
    private String api;
    private Random random = new Random();

    public Weather(String city, String api) {
        this.city = city;
        this.api = api;
    }

    @Override
    public Integer call(){
        System.out.println("Receiving data from " + api + " for " + city + "...");
        try {
            sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return random.nextInt(15) + 15;
    }
}
