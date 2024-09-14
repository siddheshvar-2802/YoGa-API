package com.yoga.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int userId;
    private String userName;
    private String phoneNo;
    private String emailId;
    private String password;
}
