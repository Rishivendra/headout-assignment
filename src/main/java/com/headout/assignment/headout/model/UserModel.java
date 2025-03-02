package com.headout.assignment.headout.model;

import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserModel {
    private String username;
    private int score;

    public UserModel(String username) {
        this.username = username;
        this.score = 0;
    }

    public void incrementScore() {
        this.score++;
    }
}
