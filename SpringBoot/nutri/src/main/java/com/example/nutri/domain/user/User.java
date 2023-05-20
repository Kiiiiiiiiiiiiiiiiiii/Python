package com.example.nutri.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String userId;
    @Column
    private String email;
    @Column
    private String phoneNo;
    @Column
    private String address;

    @Builder
    public User(String name, String userId, String email, String phoneNo, String address) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
    }
}
