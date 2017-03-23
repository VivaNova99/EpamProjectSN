package model;

import java.util.Arrays;
import java.util.Optional;

public enum MessageStatus{
    UNREAD, STANDART, DELETED;

    public static Optional<MessageStatus> valueOf(int id) {
        return Arrays.stream(values())
                .filter(messageStatus -> messageStatus.ordinal() == id)
                .findAny();
    }
}

