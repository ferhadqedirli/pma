package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumPriceType {
    PURCHASE(1), SALE(2);

    private final Integer value;

    private static final Map<Integer, EnumPriceType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumPriceType type : EnumPriceType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumPriceType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumPriceType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
