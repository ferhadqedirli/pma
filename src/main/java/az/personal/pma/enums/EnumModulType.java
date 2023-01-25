package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumModulType {
    PURCHASE(1),
    SALE(2),
    STOCK(3),
    CASH(4);

    private final Integer value;

    private static final Map<Integer, EnumModulType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumModulType type : EnumModulType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumModulType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumModulType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
