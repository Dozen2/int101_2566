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
        int product = 2;
        long result = 0;
        while (isbn10 !=0) {
             result += (count % 10)* product;
             isbn10 /= 10;
             count++;
             product++;
        }
        if (count != 9){
            throw new  IllegalArgumentException();
        }
        System.out.println(result);
        long finalResult = result % 11;
        if (finalResult < 2) {
            return 0;
        }
        return 11 - finalResult;
    }
    
    
}
