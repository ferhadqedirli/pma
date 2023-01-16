package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumProductType {
    RAW_MATERIAL(1),
    SEMI_FINISHED(2),
    READY_PRODUCT(3),
    COMMERCIAL(4);

    private final Integer value;

    private static final Map<Integer, EnumProductType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumProductType type : EnumProductType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumProductType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumProductType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
