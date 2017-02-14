package com.travix.busyflights.service;

import com.travix.busyflights.domain.Flight;
import com.travix.busyflights.service.rest.dto.CrazyAirFlightDto;
import com.travix.busyflights.service.rest.dto.CrazyAirSearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sergej on 13.2.2017.
 */
@Service
public class FlightsSearchService {

    private static final String SUPPLIER_CRAZY_AIR = "CrazyAir";
    private static final String SUPPLIER_TOUGH_JET = "ToughJet";

    private RestTemplate restTemplate;
    private String crazyAirSearchUrl;
    private String toughJetSearchUrl;

    @Autowired
    public FlightsSearchService(RestTemplate restTemplate,
                                @Qualifier("crazyAirSearchUrl") String crazyAirSearchUrl,
                                @Qualifier("toughJetSearchUrl") String toughJetSearchUrl) {
        this.restTemplate = restTemplate;
        this.crazyAirSearchUrl = crazyAirSearchUrl;
        this.toughJetSearchUrl = toughJetSearchUrl;
    }

    public List<Flight> getFlights(SearchCriteria sc) {
        List<Flight> crazyAirFlights = getCrazyAirFlights(sc);
        List<Flight> flights = new ArrayList<>();
        flights.addAll(crazyAirFlights);
        return flights;
    }

    private List<Flight> getCrazyAirFlights(SearchCriteria sc) {
        CrazyAirSearchRequest request = toCrazyAirRequest(sc);
        List<CrazyAirFlightDto> dtos = restTemplate.postForObject(crazyAirSearchUrl, request, List.class);
        return dtos.stream().map(dto -> toFlight(dto)).collect(Collectors.toList());
    }

    private CrazyAirSearchRequest toCrazyAirRequest(SearchCriteria sc) {
        CrazyAirSearchRequest request = new CrazyAirSearchRequest();
        request.setOrigin(sc.getOrigin());
        request.setDestination(sc.getDestination());
        request.setDepartureDate(sc.getDepartureDate());
        request.setReturnDate(sc.getReturnDate());
        request.setNumberOfPassengers(sc.getNumberOfPassengers());

        return request;
    }

    private Flight toFlight(CrazyAirFlightDto dto) {
        Flight flight = new Flight();
        flight.setAirLine(dto.getAirLine());
        flight.setDepartureDate(dto.getDepartureDate());
        flight.setArrivalDate(dto.getArrivalDate());
        flight.setDepartureAirportCode(dto.getDepartureAirportCode());
        flight.setDestinationAirportCode(dto.getDestinationAirportCode());
        flight.setFare(dto.getPrice());
        flight.setSupplier(SUPPLIER_CRAZY_AIR);
        return flight;
    }


}
