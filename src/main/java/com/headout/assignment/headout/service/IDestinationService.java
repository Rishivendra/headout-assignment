package com.headout.assignment.headout.service;

import com.headout.assignment.headout.model.DestinationModel;
import com.headout.assignment.headout.request.GuessRequest;
import com.headout.assignment.headout.response.DestinationResponse;
import com.headout.assignment.headout.response.GuessResponse;

import java.util.Map;

public interface IDestinationService {
    DestinationResponse getRandomDestinationResponse();

    GuessResponse checkGuess(GuessRequest request);
}
