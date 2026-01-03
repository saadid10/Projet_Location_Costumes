package com.example.costumerental.models;

import com.google.gson.annotations.SerializedName;

public class AuthResponse {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("role")
    private String role;

    @SerializedName("message")
    private String message;

    public String getAccessToken() {
        return accessToken;
    }

    public String getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}
