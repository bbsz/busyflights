package com.travix.flightsearch.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travix.flightsearch.domain.Flight;

import java.util.Calendar;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetFlightDto {

    @JsonProperty(value = "carrier", required = true)
    private String airLine;

    @JsonProperty(value = "basePrice", required = true)
    private double basePrice;

    @JsonProperty(value = "tax", required = true)
    private double tax;

    @JsonProperty(value = "price", required = true)
    private double discount;

    @JsonProperty(value = "departureAirportName", required = true)
    private String departureAirportCode;

    @JsonProperty(value = "arrivalAirportName", required = true)
    private String destinationAirportCode;

    @JsonProperty(value = "departureDay", required = true)
    private int departureDay;

    @JsonProperty(value = "departureMonth", required = true)
    private int departureMonth;

    @JsonProperty(value = "departureYear", required = true)
    private int departureYear;

    @JsonProperty(value = "returnDay", required = true)
    private int returnDay;

    @JsonProperty(value = "returnMonth", required = true)
    private int returnMonth;

    @JsonProperty(value = "returnYear", required = true)
    private int returnYear;


    public ToughJetFlightDto() {
    }

    public ToughJetFlightDto(Flight flight) {
        this.airLine = flight.getAirLine();
        this.basePrice = flight.getBasePrice();
        this.tax = flight.getTax();
        this.discount = flight.getDiscount();
        this.departureAirportCode = flight.getOrigin();
        this.destinationAirportCode = flight.getDestination();

        Calendar departure = Calendar.getInstance();
        departure.setTime(flight.getDepartureDate());
        this.setDepartureDay(departure.get(Calendar.DAY_OF_MONTH));
        this.setDepartureMonth(departure.get(Calendar.MONTH) + 1);
        this.setDepartureYear(departure.get(Calendar.YEAR));

        Calendar arrival = Calendar.getInstance();
        arrival.setTime(flight.getArrivalDate());
        this.setReturnDay(arrival.get(Calendar.DAY_OF_MONTH));
        this.setReturnMonth(arrival.get(Calendar.MONTH) + 1);
        this.setReturnYear(arrival.get(Calendar.YEAR));
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public int getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(int departureDay) {
        this.departureDay = departureDay;
    }

    public int getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(int departureMonth) {
        this.departureMonth = departureMonth;
    }

    public int getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(int departureYear) {
        this.departureYear = departureYear;
    }

    public int getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(int returnDay) {
        this.returnDay = returnDay;
    }

    public int getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(int returnMonth) {
        this.returnMonth = returnMonth;
    }

    public int getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(int returnYear) {
        this.returnYear = returnYear;
    }
}
