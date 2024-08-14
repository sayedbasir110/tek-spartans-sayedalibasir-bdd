package tek.bdd.utility;

import java.util.Random;

public class RandomEmailGenerator {

    public static String generateRandomEmail() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder localPart = new StringBuilder(10);
        for (int i = 0; i < 10; i++){
            localPart.append(characters.charAt(random.nextInt(characters.length())));
        }
        return localPart + "@gmail.com";
    }

    public static void main(String[] args) {
        for ( int i=1;i<11;i++){
            String randomEmail = generateRandomEmail();
            System.out.println(randomEmail);
        }
    }

}
