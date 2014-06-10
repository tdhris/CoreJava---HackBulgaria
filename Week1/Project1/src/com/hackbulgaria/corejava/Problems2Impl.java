package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
        return Math.abs(number) % 2 == 1;
    }

    @Override
    public boolean isPrime(int n) {
        n = Math.abs(n);
        if (n == 1) {
            return false;
        }
        for (int divisor = 2; divisor <= Math.sqrt(n); divisor++) {
            if (n % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int min(int... array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        int sum = sumArray(array);
        return (int)(sum / array.length);
    }
    
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }
        return sum;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
        HashMap<Integer, Integer> primeFactors = new HashMap<Integer, Integer>();
        for (int i = 2; i <= upperBound; ++i) {
            HashMap<Integer, Integer> factorsOfI = getPrimeFactorization(i);
            for (Integer factor: factorsOfI.keySet()) {
                if (!primeFactors.containsKey(factor)) {
                    primeFactors.put(factor, factorsOfI.get(factor));
                }
                
                else {
                    if (primeFactors.get(factor) < factorsOfI.get(factor)) {
                        primeFactors.put(factor, factorsOfI.get(factor));
                    }
                }
            }
        }
        
        long smallestMultiple = 1;
        for (Integer factor: primeFactors.keySet()) {
            int power = (int)(primeFactors.get(factor));
            smallestMultiple *= Math.pow(factor, power);
        }
        return smallestMultiple;
    }
    
    HashMap<Integer, Integer> getPrimeFactorization(int n) {
        HashMap<Integer, Integer> factors = new HashMap<Integer, Integer>();
        for (Integer i = 2; i <= (Integer) n; i++) {
            if ((Integer) n % i == 0 && isPrime((int) i)) {
                Integer power = 0;
                Integer value = (Integer) n;
                while (value % i == 0) {
                    value /= i;
                    ++power;
                }
                factors.put(i, power);
            }
        }
        return factors;
    }

    @Override
    public long getLargestPalindrome(long N) {
        N = Math.abs(N);
        while (!this.isPalindrome((int)N) && N > 0) {
            N--;
        }
        long largestPalindrome = N;
        return largestPalindrome;
    }
    
    public ArrayList<Integer> getDigits( long n ) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int divisor = 1;
        if (n == 0) {
            digits.add(0);
        }
        while (n / divisor != 0) {
            int digit = (int)(n / divisor) % 10;
            divisor *= 10;
            digits.add(digit);
        }
        Collections.reverse(digits);
        return digits;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] histogram = new int[255];
        Arrays.fill(histogram, 0);
        for (int i = 0; i < image.length; ++i) {
            for(int j = 0; j < image.length; ++j) {
                int n = image[i][j];
                histogram[n] += 1;
            }
        }
        return histogram;
    }

    @Override
    public long doubleFac(int n) {
        int n_fac = singleFac(n);
        return singleFac(n_fac);
    }

    public static int singleFac(int n) {
        if (n == 0) {
            return 1;
        }

        return n * singleFac(n-1);
    }

    @Override
    public long kthFac(int k, int n) {
        for (int i = 1; i <= k; i++) {
            n = singleFac(n);
        }
        return n;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }

    @Override
    public long pow(int number, int power) {
        long result = 1;
        while (power != 0) {
            if (power % 2 == 1) {
                result *= number;
            }
            
            power /= 2;
            number *= number;
        }
        
        return result;
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0;
        for (int i = 0; i < a.length; i ++) {
            sum += a[i] * b[i];
        }
        return sum;
    }

    @Override
    public int maxSpan(int[] array) {
        int maxSpan = 1;
        String numbers = Arrays.toString(array).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
        for (int i = 0; i < numbers.length(); ++i) {
            char searchFor = numbers.charAt(i);
            int last = numbers.lastIndexOf(searchFor);
            int span = last - i + 1;
            if (span > maxSpan) {
                maxSpan = span;
            }
        }
        return maxSpan;
    }

    @Override
    public boolean canBalance(int[] array) {
        int middle = array.length/2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        if (array.length % 2 == 1) {
            right = Arrays.copyOfRange(right, 1, right.length);
        }
        return sumOfNumbers(left) == sumOfNumbers(right);
    }
    
    public int sumOfNumbers(int[] numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int[][] rescaled = new int[newHeight][newWidth];
        int heightRatio = original.length / newHeight;
        int widthRatio = original[0].length / newWidth;
        int x, y;
        for (int i = 0; i < newHeight; i++) {
            for (int j = 0; j < newWidth; j++) {
                x = i * widthRatio;
                y = j * heightRatio;
                rescaled[i][j] = original[x][y];
            }
        }
        return rescaled;
    }

    @Override
    public String reverseMe(String argument) {
        String reversed = "";
        for (int i = argument.length() - 1; i >= 0; i--) {
            reversed += argument.charAt(i);
        }
        return reversed;
    }

    @Override
    public String copyEveryChar(String input, int k) {
        String result = new String();
        for (int i = 0; i < input.length(); ++i) {
            String multipliedChar = "";
            char letter = input.charAt(i);
            for (int j = 0; j < k; ++j) {
                multipliedChar += letter;
            }
            result += multipliedChar;
        }
        return result;
    }

    @Override
    public String reverseEveryWord(String arg) {
        String[] words = arg.split("[^a-zA-Z]");
        String reversedWords = new String(arg);
        for (String word: words) {
            String reversedWord = reverseMe(word);
            reversedWords = reversedWords.replaceFirst(word, reversedWord);
        }
        return reversedWords;
    }

    @Override
    public boolean isPalindrome(String argument) {
        int size =  argument.length();
        for (int i = 0; i < size; ++i) {
            if (argument.charAt(i) != argument.charAt(size - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isPalindrome(int n) {
        ArrayList<Integer> digits = getDigits(n);
        int length = digits.size();
        for (int i = 0; i < length; ++i) {
            if (digits.get(i) != digits.get(length - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public int getPalindromeLength(String input) {
        char divisingChar = '*';
        int palindromeLength = 0;
        int start = input.indexOf(divisingChar);
        if (start == -1) {
            return palindromeLength;
        }
        
        int i = 1;
        while (start - i >= 0 && start + i < input.length() && input.charAt(start - i) == input.charAt(start + i)) {
            palindromeLength++;
            ++i;
        }
        
        return palindromeLength;
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        int count = 0;
        if (needle.length() > haystack.length()) {
            return count;
        }
        
        int start = haystack.indexOf(haystack);
        while(start != -1) {
            haystack = haystack.substring(start + needle.length());
            start = haystack.indexOf(needle);
            count++;
        }
        return count;
    }

    @Override
    public String decodeURL(String input) {
        return input.replace("%20", " ").replaceAll("%3A", ":").replace("%3D", "?").replace("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (String number: input.split("[^0-9-]+")) {
            if (!number.equals("")) {
                numbers.add(Integer.parseInt(number));
            }
        }
        
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        ArrayList<Character> lettersA = getLetters(A);
        ArrayList<Character> lettersB = getLetters(B);
        if (lettersA.size() != lettersB.size()) {
            return false;
        }
        Collections.sort(lettersA);
        Collections.sort(lettersB);
        for (int i = 0; i < lettersA.size(); i++) {
            if (lettersA.get(i) != lettersB.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static ArrayList<Character> getLetters(String text) {
        ArrayList<Character> letters = new ArrayList<Character>();
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isAlphabetic(symbol)) {
                letters.add(symbol);
            }
        }
        return letters;
    }

    @Override
    public boolean hasAnagramOf(String needle, String haystack) {
        if (areAnagrams(needle, haystack)) {
            return true;
        }
        
        int len = haystack.length();
        for (int i = 1; i < len; i++) {
            String cutEnd = haystack.substring(0, len - 1 - i);
            String cutFront = haystack.substring(i);
            
            if (areAnagrams(needle, cutEnd) || areAnagrams(needle, cutFront)) {
                return true;
            }
        }
        
        for (int i = 1; i < len / 2; i++) {
            String cutBoth = haystack.substring(i, len - 1 - i);
            if (areAnagrams(needle, cutBoth)) {
                return true;
            }
        }
        return false;
    }
}
