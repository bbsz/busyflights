package com.travix.flightsearch.controller;

import com.travix.flightsearch.controller.dto.CrazyAirFlightDto;
import com.travix.flightsearch.controller.dto.FlightsSearchRequest;
import com.travix.flightsearch.domain.Flight;
import com.travix.flightsearch.service.SearchCriteria;
import com.travix.flightsearch.service.CrazyAirSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@RestController
@RequestMapping("busyFlights/")
public class FlightsSearchController {

    private CrazyAirSearchService crazyAirSearch;

    @Autowired
    public FlightsSearchController(CrazyAirSearchService crazyAirSearch) {
        this.crazyAirSearch = crazyAirSearch;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CrazyAirFlightDto> search(@Valid @RequestBody FlightsSearchRequest request) {
        SearchCriteria criteria = toSearchCriteria(request);
        List<Flight> flights = crazyAirSearch.getFlights(criteria);
        List<CrazyAirFlightDto> dtos = toSearchResponse(flights);
        return dtos;
    }

    private SearchCriteria toSearchCriteria(FlightsSearchRequest request) {
        SearchCriteria criteria = new SearchCriteria();
        criteria.setDepartureDate(request.getDepartureDate());
        criteria.setReturnDate(request.getReturnDate());
        criteria.setDestination(request.getDestination());
        criteria.setOrigin(request.getOrigin());
        criteria.setPassengersCount(request.getPassengersCount());

        return criteria;
    }

    private List<CrazyAirFlightDto> toSearchResponse(List<Flight> flights) {
        Function<Flight, CrazyAirFlightDto> responseMapper = flight -> {
            CrazyAirFlightDto response = new CrazyAirFlightDto(flight);
            return response;
        };

        return flights.stream().map(responseMapper).collect(Collectors.toList());
    }
}
