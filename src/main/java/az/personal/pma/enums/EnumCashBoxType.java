package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumCashBoxType {
    SIMPLE(1);

    private final Integer value;

    private static final Map<Integer, EnumCashBoxType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumCashBoxType type : EnumCashBoxType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumCashBoxType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumCashBoxType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
