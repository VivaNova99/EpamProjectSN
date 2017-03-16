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


//import lombok.Value;
//
//@Value
//public class AccessLevel {
//
//    private int id;
////    id INT PRIMARY KEY,
//    private String description;
////    description VARCHAR(20) NOT NULL
//}
