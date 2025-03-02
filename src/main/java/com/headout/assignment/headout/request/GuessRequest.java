package com.headout.assignment.headout.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class GuessRequest {
    private String guess;
    private String destinationCity;
    private String username;

}
