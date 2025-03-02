package com.headout.assignment.headout.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class UserResponse {
    private String username;
    private int score;
}
