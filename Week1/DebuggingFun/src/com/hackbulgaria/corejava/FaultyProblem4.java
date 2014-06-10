package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(Integer e, Integer k) {
        return e.equals(k);
    }

    public static boolean areEqual(float a, float b) {
        final float precisionLevel = 0.0001f;
        return (a - b) < precisionLevel;
    }

    public static boolean haveEqualSubstrings(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        final int len = a.length();
        for (int i = 0; i < len; i++) {
            String substringA = a.substring(i, len);
            String substringB = b.substring(i, len);
            if (substringA.equals(substringB)){
                return true;
            }
        }
        return false;
    }
}
