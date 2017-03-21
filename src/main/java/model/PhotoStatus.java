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

//import lombok.Value;
//
//@Value
//public class PhotoStatus {
//
//    private int id;
////    id INT PRIMARY KEY,
//    private String description;
////    description VARCHAR(20) NOT NULL
//}
