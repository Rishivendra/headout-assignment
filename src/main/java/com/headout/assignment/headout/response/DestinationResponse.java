package com.headout.assignment.headout.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class DestinationResponse {
    private String clue;
    private String country;
    private String destinationCity;
    private List<String> options;
}
