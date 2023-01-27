package az.personal.pma.util;

public class General {
    public static String generateDocNo(Long number) {
        String docNo = "000000000000000";
        String strNumber = String.valueOf(number);
        int zeroLength = docNo.length() - strNumber.length();
        docNo = docNo.substring(0, zeroLength).concat(strNumber);
        return docNo;
    }
}
