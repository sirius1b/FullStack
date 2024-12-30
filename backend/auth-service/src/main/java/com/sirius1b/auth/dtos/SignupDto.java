package com.sirius1b.auth.dtos;


import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SignupDto {
    private String email;
    private String name;
    private String password;
}
