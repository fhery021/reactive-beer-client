package com.fhery021.reactivebeerclient.client;

import com.fhery021.reactivebeerclient.model.BeerDto;
import com.fhery021.reactivebeerclient.model.BeerPagedList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class BeerClientImpl implements BeerClient {
    @Override
    public Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand) {
        BeerDto beerDto = BeerDto.builder().beerName("kozel").beerStyle("Lager").price(BigDecimal.valueOf(50)).upc("upc").build();

        return Mono.just(beerDto);
    }

    @Override
    public Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName, String beerStyle, Boolean showInventoryOnhand) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> createBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> updateBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public Mono<ResponseEntity> deleteBeerById(UUID id) {
        return null;
    }

    @Override
    public Mono<BeerDto> getBeerByUPC(String upc) {
        return null;
    }
}
