import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int reverse(int x) {
        String number = String.valueOf(x);
        int result = 0;
        boolean isNegative = false;
        //check if the number is negative
        if (number.charAt(0) == '-') {
            isNegative = true;
            number = number.substring(1);
        }
        //make the number a list
        List<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < number.length(); i++) {
            digits.add(Character.getNumericValue(number.charAt(i)));
        }
        Collections.reverse(digits);
        //make the elements in the list to an integer

        for (int i = 0; i < digits.size(); i++) {
            if (digits.get(i) != 0) {
                result += digits.get(i) * Math.pow(10, digits.size() - i - 1);
            }
        }

        if (isNegative) {
            result *= -1;
        }

        if (result >= Math.pow(2, 31) - 1 || result <= Math.pow(-2, 31)+1) {
            return 0;
        }
        return result;
    }
}
