package com.Rocket.LibraryManagement.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("User")
public class User {
    @Id
    long userID;
    String Name;
    String address;
    long phoneNumber;
    Date Dob;
}
