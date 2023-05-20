package com.example.nutri.dto;

import com.example.nutri.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String userId;
    private String email;
    private String phoneNo;
    private String address;

    public UserDto(JSONObject itemJson) {
        this.name = itemJson.getString("name");
        this.userId = itemJson.getString("userId");
        this.email = itemJson.getString("email");
        this.phoneNo = itemJson.getString("phoneNo");
        this.address = itemJson.getString("address");
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .userId(userId)
                .email(email)
                .phoneNo(phoneNo)
                .address(address)
                .build();
    }
}
