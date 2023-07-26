import java.util.TreeMap;

public class Converter {

    private static final TreeMap<Integer, String> romanNumerals = new TreeMap<>();

    static {
        romanNumerals.put(1000, "M");
        romanNumerals.put(900, "CM");
        romanNumerals.put(500, "D");
        romanNumerals.put(400, "CD");
        romanNumerals.put(100, "C");
        romanNumerals.put(90, "XC");
        romanNumerals.put(50, "L");
        romanNumerals.put(40, "XL");
        romanNumerals.put(10, "X");
        romanNumerals.put(9, "IX");
        romanNumerals.put(5, "V");
        romanNumerals.put(4, "IV");
        romanNumerals.put(1, "I");
    }

    public static String convertToRoman(int number) {
        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Недопустимое значение для конвертации в римские числа!");
        }

        StringBuilder romanNumber = new StringBuilder();
        for (int value : romanNumerals.descendingKeySet()) {
            while (number >= value) {
                romanNumber.append(romanNumerals.get(value));
                number -= value;
            }
        }
        return romanNumber.toString();
    }
}