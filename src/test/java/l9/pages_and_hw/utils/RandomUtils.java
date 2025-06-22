package l9.pages_and_hw.utils;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandomEmail());

        String[] names = {"a", "b", "c", "d", "e"};
        System.out.println(getRandomItemFromStringArray(names));
    }

    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }

    public static String getRandomEmail(){
        return getRandomString(10) + "@example.com";
    }

    public static String getRandomItemFromStringArray(String[] values){
        int index = getRandomInt(0, values.length-1);
        return values[index];
    }

    public static String getRandomName(){
        return new Faker().name().firstName();
    }

    public static String getRandomLastName(){
        return new Faker().name().lastName();
    }

    public static String getRandomEmailAddress(){
        return new Faker().internet().emailAddress();
    }

    public static String getRandomCurrentAddress(){
        return new Faker().address().fullAddress();
    }
    public static String getRandomUserNumberWithoutMask(){
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomUserNumber() {
        Faker faker = new Faker();
        // Генерируем 9 случайных цифр и добавляем в начало 8
        return "8" + faker.number().numberBetween(100000000, 999999999);
    }

    public static String getRandomBirthDay() {
        Faker faker = new Faker();
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public static String getRandomBirthYear() {
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(1907, 2007));
    }

    public static String getRandomString(int len) {
        // String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
