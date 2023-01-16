package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumCurrency {
    AZN(1),
    USD(2),
    RUB(3),
    EUR(4);

    private final Integer value;

    private static final Map<Integer, EnumCurrency> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumCurrency type : EnumCurrency.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumCurrency(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumCurrency getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
