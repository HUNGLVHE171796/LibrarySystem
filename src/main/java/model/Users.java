package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    private int UserID;
    private String FullName;
    private String LastName;
    private String Email;
    private String Password;
    private String PhoneNumber;
    private String Address;
    private Date DateOfBirth;
    private String Status;
    private Date CreateAt;
    private int RoleId;
}
