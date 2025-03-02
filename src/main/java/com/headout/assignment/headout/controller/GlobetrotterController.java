package com.headout.assignment.headout.controller;


import com.headout.assignment.headout.request.GuessRequest;
import com.headout.assignment.headout.request.UserRequest;
import com.headout.assignment.headout.response.ChallengeResponse;
import com.headout.assignment.headout.response.DestinationResponse;
import com.headout.assignment.headout.response.GuessResponse;
import com.headout.assignment.headout.response.UserResponse;
import com.headout.assignment.headout.service.IDestinationService;
import com.headout.assignment.headout.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("headout/game/api")
public class GlobetrotterController {

    private final IDestinationService destinationService;
    private final IUserService userService;

    public GlobetrotterController(IDestinationService destinationService, IUserService userService) {
        this.destinationService = destinationService;
        this.userService = userService;
    }

    @GetMapping("/destination/random")
    public ResponseEntity<DestinationResponse> getRandomDestination() {
        DestinationResponse response = destinationService.getRandomDestinationResponse();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/destination/guess")
    public ResponseEntity<GuessResponse> checkGuess(@RequestBody GuessRequest guessRequest) {
        GuessResponse response = destinationService.checkGuess(guessRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest request) {
        try {
            UserResponse response = userService.registerUser(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/user/challenge")
    public ResponseEntity<ChallengeResponse> challengeFriend(UserRequest request) {
        try {
            UserResponse userResponse = userService.getUser(request);
            ChallengeResponse response = new ChallengeResponse("Hey, I'm playing the Globetrotter Challenge! My current score is " + userResponse.getScore() + ". Can you beat me?", "http://yourapp.com/play?ref=" + request.getUsername());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
