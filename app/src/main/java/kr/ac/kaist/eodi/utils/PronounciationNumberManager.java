package kr.ac.kaist.eodi.utils;

/**
 * Created by yearnning on 15. 5. 28..
 */
public class PronounciationNumberManager {


    private static String[] places_number = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

    public static String getPronounciationOfIntegerChar(char num) {
        if (num == '0') {
            return "영";
        } else if (num == '1') {
            return "일";
        } else if (num == '2') {
            return "이";
        } else if (num == '3') {
            return "삼";
        } else if (num == '4') {
            return "사";
        } else if (num == '5') {
            return "오";
        } else if (num == '6') {
            return "육";
        } else if (num == '7') {
            return "칠";
        } else if (num == '8') {
            return "팔";
        } else if (num == '9') {
            return "구";
        }

        return null;
    }

    public static String[] getPronounciationOfInteger(int num) {

        /**
         * Init
         */
        String[] words = new String[2];
        for (int i = 0; i < 2; i++) {
            words[i] = "";
        }

        /**
         *
         */
        int current_number_of_digit = 0;
        for (; num > 0; num = num / 10) {

            String place = getPlaceOfInteger(current_number_of_digit);
            int a = num % 10;
            words[0] += places_number[a] + place + words[0];
            words[1] += places_number[a] + words[1];

            current_number_of_digit++;
        }
        return words;
    }

    private static String[] places_remain = {"", "십", "백", "천"};
    private static String[] places_main = {"", "만", "억", "조", "경"};

    private static String getPlaceOfInteger(int number_of_digit) {
        return places_main[number_of_digit / 4] + places_remain[number_of_digit % 4];
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
