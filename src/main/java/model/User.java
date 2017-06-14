package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Blob;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class User {

    public static String FIRST_NAME_KEY = "first_name";
    public static String ID_KEY = "user_id";
    public static String LOGIN_KEY = "email";

//    public static String ID_KEY = "j_id";
//    public static String LOGIN_KEY = "j_username";

    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private AccessLevel accessLevel;
    private String email;
    private String passwordHash;
    private Blob profilePhoto;
    private String statusOnWall;
    private String city;
//    UNIQUE (email)


    public User(int id, Blob profilePhoto, String firstName, String lastName){
        this.id = id;
        this.profilePhoto = profilePhoto;
        this.firstName = firstName;
        this.lastName = lastName;
    };

    public User(String firstName, String lastName, LocalDate dateOfBirth, AccessLevel accessLevel, String email, String passwordHash, String statusOnWall, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accessLevel = accessLevel;
        this.email = email;
        this.passwordHash = passwordHash;
        this.statusOnWall = statusOnWall;
        this.city = city;
    }

    //test for registration
    public User(String firstName, String lastName, String email, String passwordHash, String statusOnWall, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.statusOnWall = statusOnWall;
        this.city = city;
    }

    //test for registration
    public User(int id, String firstName, String lastName, String email, String passwordHash, String statusOnWall, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.statusOnWall = statusOnWall;
        this.city = city;
    }

    //test for registration
    public User(String firstName, String lastName, AccessLevel accessLevel, String email, String passwordHash, String statusOnWall, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accessLevel = accessLevel;
        this.email = email;
        this.passwordHash = passwordHash;
        this.statusOnWall = statusOnWall;
        this.city = city;
    }

    public User(int id, String firstName, String lastName, LocalDate dateOfBirth, AccessLevel accessLevel, String email, String passwordHash, String statusOnWall, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accessLevel = accessLevel;
        this.email = email;
        this.passwordHash = passwordHash;
        this.statusOnWall = statusOnWall;
        this.city = city;
    }

//
//    public User(String firstName, String lastName, AccessLevel accessLevel, String passwordHash, String statusOnWall, String city) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.accessLevel = accessLevel;
//        this.passwordHash = passwordHash;
//        this.statusOnWall = statusOnWall;
//        this.city = city;
//    }
//
//    public Blob getBlob() {
//        return null;
//    }


    public String getFirstNameAndLastName(){

        return firstName + " " + lastName;

    };

}
