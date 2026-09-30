package com.Rocket.LibraryManagement.Entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lending {

    @Id
    private long lendingId;

    private long userId;
    private long bookId;

    private Date issuedDate;
    private Date returnDate;

    private boolean returned;
    private Date returnedOn;
}