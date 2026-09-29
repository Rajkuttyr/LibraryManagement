package com.Rocket.LibraryManagement.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data 
public class Lending {
    @Id 
    long LendingId;
    long userID;
    long bookId;
    Date issuedDate;
    Date returnDate;
    boolean returned;
    Date returnedOn;
}
