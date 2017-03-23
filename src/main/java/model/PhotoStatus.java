package model;

import java.util.Arrays;
import java.util.Optional;

public enum PhotoStatus {
    PRIVATE, FOR_FRIENDS, PUBLIC;

    public static Optional<PhotoStatus> valueOf(int id) {
        return Arrays.stream(values())
                .filter(photoStatus -> photoStatus.ordinal() == id)
                .findAny();
    }
}

