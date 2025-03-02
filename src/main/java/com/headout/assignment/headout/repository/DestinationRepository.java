package com.headout.assignment.headout.repository;

import com.headout.assignment.headout.model.DestinationModel;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class DestinationRepository {
    private final List<DestinationModel> destinations = new ArrayList<>();
    private final Random random = new Random();

    @PostConstruct
    public void init() {
        destinations.add(new DestinationModel("Paris", "France", List.of("This city is home to a famous tower that sparkles every night.", "Known as the 'City of Love' and a hub for fashion and art."), List.of("The Eiffel Tower was supposed to be dismantled after 20 years but was saved because it was useful for radio transmissions!", "Paris has only one stop sign in the entire city—most intersections rely on priority-to-the-right rules."), List.of("This city is famous for its croissants and macarons. Bon appétit!", "Paris was originally a Roman city called Lutetia.")));

        destinations.add(new DestinationModel("Tokyo", "Japan", List.of("This city has the busiest pedestrian crossing in the world.", "You can visit an entire district dedicated to anime, manga, and gaming."), List.of("Tokyo was originally a small fishing village called Edo before becoming the bustling capital it is today!", "More than 14 million people live in Tokyo, making it one of the most populous cities in the world."), List.of("The city has over 160,000 restaurants, more than any other city in the world.", "Tokyo’s subway system is so efficient that train delays of just a few minutes come with formal apologies.")));

        destinations.add(new DestinationModel("New York", "USA", List.of("Home to a green statue gifted by France in the 1800s.", "Nicknamed 'The Big Apple' and known for its Broadway theaters."), List.of("The Statue of Liberty was originally a copper color before oxidizing to its iconic green patina.", "Times Square was once called Longacre Square before being renamed in 1904."), List.of("New York City has 468 subway stations, making it one of the most complex transit systems in the world.", "The Empire State Building has its own zip code: 10118.")));

        destinations.add(new DestinationModel("London", "United Kingdom", List.of("This city is famous for its iconic clock tower and red double-decker buses.", "Home to a historic palace and an ancient river."), List.of("Big Ben is not the clock itself, but the bell inside the clock tower.", "London’s Underground is the oldest metro system in the world."), List.of("London has more than 170 museums, including the British Museum which is free to visit.", "The city’s street signs are famous for their distinctive red color and white lettering.")));

        destinations.add(new DestinationModel("Sydney", "Australia", List.of("This city is famous for its stunning harbour and opera house.", "Known for its beautiful beaches and vibrant cultural scene."), List.of("Sydney's Opera House took 15 years to build and was completed in 1973.", "The harbour is one of the largest natural harbours in the world."), List.of("Sydney is home to the world's largest ferris wheel, the Sydney Eye.", "The city has hosted the Olympic Games and remains a major sports hub.")));
    }


    public DestinationModel getRandomDestination() {
        return destinations.get(random.nextInt(destinations.size()));
    }

    public DestinationModel findByCity(String city) {
        return destinations.stream().filter(dest -> dest.getCity().equalsIgnoreCase(city)).findFirst().orElse(null);
    }

    public List<String> getRandomOptions(String excludeCity, int numberOfOptions) {
        List<String> options = destinations.stream().map(DestinationModel::getCity).filter(city -> !city.equalsIgnoreCase(excludeCity)).collect(Collectors.toList());
        Collections.shuffle(options);
        return options.stream().limit(numberOfOptions).collect(Collectors.toList());
    }
}
