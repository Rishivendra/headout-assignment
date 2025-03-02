# Globetrotter Challenge – The Ultimate Travel Guessing Game!

Globetrotter is a full-stack web application where users receive cryptic clues about famous travel destinations and must guess the correct destination. The game provides immediate feedback with fun facts and trivia, and it allows users to challenge friends by sharing their scores.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [API Endpoints](#api-endpoints)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## Overview

The Globetrotter Challenge is designed to be both fun and engaging. The application randomly selects a travel destination and displays one or two cryptic clues along with multiple-choice options. Users can register, play the game by making guesses, and update their scores accordingly. The "Challenge a Friend" feature allows users to invite friends and compare scores.

## Features

- **Dataset & AI Integration:**  
  - Use a starter dataset of destinations with clues, fun facts, and trivia.
  - Possibility to integrate AI or web scraping for dataset expansion to 100+ destinations.

- **Interactive Gameplay:**  
  - Displays a random clue and multiple-choice options for destinations.
  - Provides immediate feedback (correct/incorrect) with a fun fact and trivia.

- **User Score Tracking:**  
  - Updates the user’s score when a correct guess is made.
  - Displays the current score and integrates it into the challenge message.

- **Challenge a Friend:**  
  - Generates an invitation link with the current score.
  - Future enhancements may include dynamic image generation and referral tracking.

## Tech Stack

- **Backend:**  
  - Java (Spring Boot)
  - In-memory storage (using ArrayList and HashMap for demo purposes)
- **Build Tool:**  
  - Maven
- **Logging:**  
  - Lombok and Slf4j for logging and code simplification


## API Endpoints
Destination Endpoints
GET /headout/game/api/destination/random
Retrieves a random destination along with a clue and multiple-choice options.
**Response Example:**

{
  "clue": "This city is home to a famous tower that sparkles every night.",
  "destinationCity": "Paris",
  "options": ["Rome", "Paris", "London", "Berlin"],
  "country": "France"
}

POST /headout/game/api/destination/guess
Checks the user's guess and updates their score. 
**Request Body Example:**

{
  "destinationCity": "Paris",
  "guess": "Paris",
  "username": "john_doe"
}

**Response Example:**
{
  "result": "correct",
  "message": "🎉 Correct! Here's a fun fact:",
  "funFact": "The Eiffel Tower was supposed to be dismantled after 20 years...",
  "trivia": "Paris has only one stop sign in the entire city..."
}
User Endpoints
POST /headout/game/api/user/register
Registers a new user. Request Body Example:

{
  "username": "john_doe"
}
**Response Example:**

{
  "username": "john_doe",
  "score": 0
}

GET /headout/game/api/user/challenge
Generates a challenge invitation message for a friend. Query Parameter Example:
?username=john_doe

**Response Example:**
{
  "challengeMessage": "Hey, I'm playing the Globetrotter Challenge! My current score is 3. Can you beat me?",
  "inviteLink": "http://yourapp.com/play?ref=john_doe"
}

