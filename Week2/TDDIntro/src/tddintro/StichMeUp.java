package tddintro;

public class StichMeUp {
    public static String join(String glue, Object... objs) {
        String result = new String();
        for (Object obj: objs) {
            if (!result.equals("")) {
                result += glue;
            }
            result += obj.toString();
        }
        return result;
    }
}
