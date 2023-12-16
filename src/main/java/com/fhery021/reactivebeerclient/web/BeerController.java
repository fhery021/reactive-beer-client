package com.fhery021.reactivebeerclient.web;


import com.fhery021.reactivebeerclient.client.BeerClient;
import com.fhery021.reactivebeerclient.model.BeerDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/beer")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BeerController {

    BeerClient beerClient;

    @GetMapping("/{id}")
    public Mono<BeerDto> getBeerById(@PathVariable String id) {
        return beerClient.getBeerById(UUID.fromString(id), false);
    }
}
