package com.headout.assignment.headout.model;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DestinationModel {
    private String city;
    private String country;
    private List<String> clues;
    private List<String> funFacts;
    private List<String> trivia;
}