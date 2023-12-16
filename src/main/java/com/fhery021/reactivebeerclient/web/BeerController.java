package com.fhery021.reactivebeerclient.web;


import com.fhery021.reactivebeerclient.client.BeerClient;
import com.fhery021.reactivebeerclient.model.BeerDto;
import com.fhery021.reactivebeerclient.model.BeerPagedList;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/list")
    public Mono<BeerPagedList> list(@RequestParam(required = false) Integer pageNumber,
                                    @RequestParam(required = false) Integer pageSize,
                                    @RequestParam(required = false) String beerName,
                                    @RequestParam(required = false) String beerStyle,
                                    @RequestParam(required = false) Boolean showInventoryOnhand) {
        return beerClient.listBeers(pageNumber, pageSize, beerName, beerStyle, showInventoryOnhand);
    }


}
