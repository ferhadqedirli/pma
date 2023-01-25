package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumDocumentType {

    //ALIS
    PURCHASE_OF_GOODS(1), //MALLARIN ALINMASI
    RETURN_OF_GOODS_TO_THE_SUPPLER(2), //MALLARIN TEDARUKCUYE QAYTARILMASI

    //SATIS
    RETURN_OF_GOODS_FROM_THE_BUYER(3), //MALLARIN ALICIDAN QAYTARILMASI
    SALE_OF_GOODS(4), //MALLARIN SATISI

    //KASSA
    CASH_RECEIPT_ORDER(5), //KASSA MEDAXIL ORDERI
    CASH_EXPENDITURE_ORDER(6), //KASSA MEXARIC ORDERI
    MOVEMENT_OF_FUNDS(7), //PUL VESAITLERININ YERDEYISMESI
    OTHER_INTERVENTION(8), //SAIR MEDAXIL
    OTHER_EXPENSES(9), //SAIR MEXARIC

    //ANBAR
    INTERVENTION_OF_GOODS(10), //MALLARIN MEDAXILI
    REMOVAL_OF_GOODS(11), //MALLARIN SILINMESI
    MOVEMENT_OF_GOODS(12), //MALLARIN YERDEYISMESI
    INVENTORY(13); //SAYIM, INVENTARIZASIYA

    private final Integer value;

    private static final Map<Integer, EnumDocumentType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumDocumentType type : EnumDocumentType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumDocumentType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumDocumentType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
