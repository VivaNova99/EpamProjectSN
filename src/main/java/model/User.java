package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class User {

    public static String FIRST_NAME_KEY = "firstName";

    public User(String firstName, String lastName){};

    private int id;
//    id INT AUTO_INCREMENT PRIMARY KEY,
    private String firstName;
//    first_name VARCHAR(50) NOT NULL,
    private String lastName;
//    last_name VARCHAR(50) NOT NULL,
    private LocalDate dateOfBirth;
//    date_of_birth DATE NOT NULL,
    private AccessLevel accessLevel;
//    private int accessLevelId;
//    access_level_id int NOT NULL,
    private String email;
//    email VARCHAR(100) NOT NULL,
    private String passwordHash ;
//    password VARCHAR(255) NOT NULL,
    private String profilePhoto;
//    profile_photo VARCHAR(100) NOT NULL,
    private String statusOnWall;
//    status_on_wall VARCHAR(100),
    private String city;
//    city VARCHAR(50),
//
//    FOREIGN KEY (access_level_id) REFERENCES AccessLevel(id),
//    UNIQUE (email)
}
