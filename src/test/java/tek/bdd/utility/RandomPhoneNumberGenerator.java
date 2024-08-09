package tek.bdd.utility;

import java.util.Random;

public class RandomPhoneNumberGenerator {
    public static String generateRandomPhoneNumber(){
        Random random = new Random();
        return  random.nextInt(1000) +"-" + random.nextInt(1000) + "-" + random.nextInt(10000);
    }
}
