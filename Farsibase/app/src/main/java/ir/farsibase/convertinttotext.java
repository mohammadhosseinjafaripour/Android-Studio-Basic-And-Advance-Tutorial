package ir.farsibase;

/**
 * Created by jefferson on 9/17/2017.
 */

public class convertinttotext {


    private static final String[] lowNames = {
            "صفر", "یک", "دو", "سه", "چهار", "پنج", "شش", "هفت", "هشت", "نه", "ده",
            "یازده", "دوازده", "سیزده", "چهارده", "پانزده", "شانزده", "هفده", "هجده", "نوزده"};

    private static final String[] tensNames = {
            "بیست", "سی", "چهل", "پنجاه", "شصت", "هفتاد", "هشتاد", "نود"};

    private static final String[] bigNames = {
            "هزا", "میلیون", "بیلیون"};

    public static String convertNumberToWords(int n) {
        if (n < 0) {
            return "minus " + convertNumberToWords(-n);
        }
        if (n <= 999) {
            return convert999(n);
        }
        String s = null;
        int t = 0;
        while (n > 0) {
            if (n % 1000 != 0) {
                String s2 = convert999(n % 1000);
                if (t > 0) {
                    s2 = s2 + " " + bigNames[t - 1];
                }
                if (s == null) {
                    s = s2;
                } else {
                    s = s2 + ", " + s;
                }
            }
            n /= 1000;
            t++;
        }
        return s;
    }

    private static String convert999(int n) {
        String s1 = lowNames[n / 100] + " هزار";
        String s2 = convert99(n % 100);
        if (n <= 99) {
            return s2;
        } else if (n % 100 == 0) {
            return s1;
        } else {
            return s1 + " " + s2;
        }
    }

    private static String convert99(int n) {
        if (n < 20) {
            return lowNames[n];
        }
        String s = tensNames[n / 10 - 2];
        if (n % 10 == 0) {
            return s;
        }
        return s + " و " + lowNames[n % 10];
    }
}
