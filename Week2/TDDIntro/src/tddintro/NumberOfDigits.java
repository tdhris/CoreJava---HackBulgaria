package tddintro;

public class NumberOfDigits {
    public static int getNumberOfDigits(int number) {
        int digitCount = 1;
        int diviser = 10;
        while ( number / diviser != 0) {
            digitCount++;
            diviser *= 10;
        }
        return digitCount;
    }
}
