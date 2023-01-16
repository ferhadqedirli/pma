package az.personal.pma.enums;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EnumLangType {
    AZ(1),
    EN(2),
    RU(3);

    private final Integer value;

    private static final Map<Integer, EnumLangType> VALUES = new ConcurrentHashMap<>();

    static {
        for (EnumLangType type : EnumLangType.values()) {
            VALUES.put(type.value, type);
        }
    }

    EnumLangType(int enumValue) {
        this.value = enumValue;
    }

    public Integer getValue() {
        return value;
    }

    public static EnumLangType getEnum(Integer value) {
        if (value == null)
            return null;
        return VALUES.get(value);
    }
}
