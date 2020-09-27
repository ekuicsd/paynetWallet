package com.paynet.wallet.dto;

import lombok.Data;

@Data
public class JwtAuthenticationResponse extends ApiResponse {
    private String token;

    public JwtAuthenticationResponse(boolean success, String message, String token) {
        super(success, message);
        this.token = token;
    }
}
