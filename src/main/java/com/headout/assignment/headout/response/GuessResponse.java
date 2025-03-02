package com.headout.assignment.headout.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class GuessResponse {
    private String result;
    private String message;
    private String funFact;
    private String trivia;

}
