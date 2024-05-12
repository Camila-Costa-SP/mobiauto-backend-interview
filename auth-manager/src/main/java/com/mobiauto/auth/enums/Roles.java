package com.mobiauto.auth.enums;

import static com.mobiauto.auth.enums.ErrorType.ERROR_MESSAGE;
import static java.lang.String.format;
import static java.util.Arrays.stream;

public enum Roles {

    ADMIN, MANAGER, OWNER, ASSISTANT, SALES;

    public static Roles fromString(String roleStr) {
        return stream(Roles.values())
                .filter(role -> role.name().equalsIgnoreCase(roleStr))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(format(ERROR_MESSAGE.getMessage(), roleStr)));
    }
}