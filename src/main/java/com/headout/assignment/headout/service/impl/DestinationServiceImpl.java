package com.headout.assignment.headout.service.impl;

import com.headout.assignment.headout.model.DestinationModel;
import com.headout.assignment.headout.repository.DestinationRepository;
import com.headout.assignment.headout.request.GuessRequest;
import com.headout.assignment.headout.response.DestinationResponse;
import com.headout.assignment.headout.response.GuessResponse;
import com.headout.assignment.headout.service.IDestinationService;
import com.headout.assignment.headout.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class DestinationServiceImpl implements IDestinationService {

    private final DestinationRepository destinationRepository;
    private final IUserService userService;
    private final Random random = new Random();

    public DestinationServiceImpl(DestinationRepository destinationRepository, IUserService userService) {
        this.destinationRepository = destinationRepository;
        this.userService = userService;
    }

    @Override
    public DestinationResponse getRandomDestinationResponse() {
        DestinationModel correct = destinationRepository.getRandomDestination();
        List<String> options = destinationRepository.getRandomOptions(correct.getCity(), 3);
        options.add(correct.getCity());
        Collections.shuffle(options);

        String clue = correct.getClues().get(random.nextInt(correct.getClues().size()));
        DestinationResponse response = DestinationResponse.builder().clue(clue).destinationCity(correct.getCity()).options(options).country(correct.getCountry()).build();
        log.info("Response to getRandomDestinationResponse: {}", response);
        return response;
    }

    @Override
    public GuessResponse checkGuess(GuessRequest request) {
        DestinationModel destination = destinationRepository.findByCity(request.getDestinationCity());
        if (destination == null) {
            return new GuessResponse("error", "Destination not found.", "", "");
        }
        boolean isCorrect = destination.getCity().equalsIgnoreCase(request.getGuess());
        userService.updateUserScore(request.getUsername(), isCorrect);
        String result;
        String message;
        if (destination.getCity().equalsIgnoreCase(request.getGuess())) {
            result = "correct";
            message = "🎉 Correct! Here's a fun fact:";
        } else {
            result = "incorrect";
            message = "😢 Incorrect. But here's a fun fact:";
        }
        String funFact = destination.getFunFacts().get(random.nextInt(destination.getFunFacts().size()));
        String trivia = destination.getTrivia().get(random.nextInt(destination.getTrivia().size()));
        GuessResponse response = GuessResponse.builder().result(result).message(message).funFact(funFact).trivia(trivia).build();
        log.info("Response to checkGuess: {}, Request: {}", response, request);
        return response;
    }

}
