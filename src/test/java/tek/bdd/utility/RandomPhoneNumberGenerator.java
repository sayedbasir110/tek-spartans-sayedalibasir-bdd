package tek.bdd.utility;

import java.util.Random;

public class RandomPhoneNumberGenerator {
    public static String generateRandomPhoneNumber(){
        Random random = new Random();
        return  "(" + (random.nextInt(900) + 100) +") " +
                (random.nextInt(900) + 100) + "-" +
                (random.nextInt(9000) + 1000 );
    }
}
