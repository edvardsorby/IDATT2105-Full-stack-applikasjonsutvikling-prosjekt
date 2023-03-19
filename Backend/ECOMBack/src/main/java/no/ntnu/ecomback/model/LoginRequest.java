package no.ntnu.ecomback.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
public class LoginRequest {
    private final String email;
    private final String password;


    @JsonCreator
    public LoginRequest(@JsonProperty("username") final String email, @JsonProperty("password") final String password) {
        this.email = email;
        this.password = password;
    }

    @JsonProperty("username")
    public String getEmail() {
        return email;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

}
