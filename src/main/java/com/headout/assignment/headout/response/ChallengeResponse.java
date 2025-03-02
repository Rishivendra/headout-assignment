package com.headout.assignment.headout.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@SuperBuilder
public class ChallengeResponse {
    private String inviteMessage;
    private String inviteLink;
}
