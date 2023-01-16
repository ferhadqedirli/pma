package az.personal.pma.util;

import java.math.BigDecimal;

public class MoneyToWord {

    public static String convert(Double amount) {
        StringBuilder str = new StringBuilder();
        BigDecimal azn = BigDecimal.valueOf(amount);
        String[] power = {"", " min", " milyon", " milyard", " trilyon"};
        String[] one = {"", " bir", " iki", " üç", " dörd", " beş", " altı", " yeddi", " səkkiz", " doqquz"};
        String[] decimal = {"", " on", " iyirmi", " otuz", " qirx", " əlli", " altmış", " yetmiş", " səksən", " doxsan"};
        String[] hundred =
                {"", " bir yüz", " iki yüz", " üç yüz", " dörd yüz", " beş yüz", " altı yüz", " yeddi yüz",
                        " səkkiz yüz",
                        " doqquz yüz"};
        String aznString = azn.toString();
        String whole = aznString.split("\\.")[0];
        String fractional = aznString.split("\\.")[1];
        if (fractional.length() > 2)
            fractional = fractional.substring(0, 2);
        int length = whole.length();
        int powerIndex = length / 3;
        int powerIndexQ = length % 3;
        int beginIndex = whole.length() - 3;
        int endIndex = whole.length();
        int i = 0;
        for (; i < powerIndex; i++) {
            int tmp = Integer.parseInt(whole.substring(beginIndex, endIndex));
            beginIndex -= 3;
            endIndex -= 3;
            int hundredIndex = tmp / 100;
            int decimalIndex = (tmp % 100) / 10;
            int oneIndex = (tmp % 100) % 10;
            if (hundredIndex + decimalIndex + oneIndex == 0) continue;
            str.insert(0, hundred[hundredIndex] + decimal[decimalIndex] + one[oneIndex] + power[i]);
        }

        if (powerIndexQ != 0) {
            int tmp = Integer.parseInt(whole.substring(0, powerIndexQ));
            int hundredIndex = tmp / 100;
            int decimalIndex = (tmp % 100) / 10;
            int oneIndex = (tmp % 100) % 10;
            str = new StringBuilder(hundred[hundredIndex] + decimal[decimalIndex] + one[oneIndex] + power[i] + str + " manat");
        } else {
            str.append(" manat");
        }
        int tmp = Integer.parseInt(fractional);
        int decimalIndex = (tmp % 100) / 10;
        int oneIndex = (tmp % 100) % 10;
        str.append(decimal[decimalIndex]).append(one[oneIndex]).append(" qəpik ");
        return str.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(convert(1623.56));
    }

}
