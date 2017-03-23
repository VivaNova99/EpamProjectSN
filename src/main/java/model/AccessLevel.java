package model;

import java.util.Arrays;
import java.util.Optional;

public enum AccessLevel{
    ADMIN, MODERATOR, STANDART_USER, DELETED_USER;

    public static Optional<AccessLevel> valueOf(int id) {
        return Arrays.stream(values())
                .filter(accessLevel -> accessLevel.ordinal() == id)
                .findAny();
    }
}
