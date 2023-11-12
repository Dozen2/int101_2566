package work01;
public class Utilitor {
    public static String testString(String value){
        if(value == null){
            throw new NullPointerException("value cannot be null");
        }else if (value.isBlank()) {
            throw new IllegalArgumentException("This cannot be blank");
        }
        return value;
    }
    public static double testPositive(double value){
        if(value <=0){
            throw new IllegalArgumentException("this cannot be negative");
        }
        return value;
    }
    public static long computeIsbn10(long isbn10){
        if (isbn10 <=0) {
            throw new IllegalArgumentException("this cannot be negative");
        }
        int count = 0;
        long currentIsbn10 = isbn10;
        while (isbn10 != 0) {
            count++;
            isbn10 /= 10;
        }
        if (count != 9) {
            throw new IllegalArgumentException();
        }

        long result = 0;
        for (int i = 2; i <= 10; i++) {
            long digit = currentIsbn10 % 10;
            result += digit * i;
            currentIsbn10 /= 10;
        }
        if (result % 11 == 0 || result % 11 == 1) {
            return 0;
        }
        return 11 - (result % 11);
    }
    }
    
    

