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

    public static String FIRST_NAME_KEY = "firstName";
    public static String ID_KEY = "j_id";
    public static String LOGIN_KEY = "j_username";

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
//
//    public Blob getBlob() {
//        return null;
//    }


    public String getFirstNameAndLastName(){

        return firstName + " " + lastName;

    };

}
