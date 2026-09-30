package com.Rocket.LibraryManagement.Entity;
import java.util.Date;

import lombok.Getter;

@Getter 
public class UserLending {

    private long userId;
    private String userName;
    private long bookId;
    private String bookName;
    private Date issueDate;
    private Date returnDate;
    private Date returnedOn;
    private boolean returned;

    private UserLending(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.bookId = builder.bookId;
        this.bookName = builder.bookName;
        this.issueDate = builder.issueDate;
        this.returnDate = builder.returnDate;
        this.returnedOn = builder.returnedOn;
        this.returned = builder.returned;
    }

    public static class Builder {

        private long userId;
        private String userName;
        private long bookId;
        private String bookName;
        private Date issueDate;
        private Date returnDate;
        private Date returnedOn;
        private boolean returned;

        public Builder userId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder bookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder bookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public Builder issueDate(Date issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public Builder returnDate(Date returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder returnedOn(Date returnedOn) {
            this.returnedOn = returnedOn;
            return this;
        }

        public Builder returned(boolean returned) {
            this.returned = returned;
            return this;
        }

        public UserLending build() {
            return new UserLending(this);
        }
    }
}