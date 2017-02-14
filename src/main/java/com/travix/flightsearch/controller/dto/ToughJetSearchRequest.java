package com.travix.flightsearch.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sergej on 13.2.2017.
 */
public class ToughJetSearchRequest {

    @NotNull
    @Length(max = 3, min = 3, message = "Origin must be 3 letter IATA code")
    @JsonProperty(value = "from", required = true)
    private String origin;

    @NotNull
    @Length(max = 3, min = 3, message = "Destination must be 3 letter IATA code")
    @JsonProperty(value = "to", required = true)
    private String destination;

    @NotNull(message =  "numberOfAdults has not been specified.")
    @JsonProperty(value = "numberOfAdults", required = true)
    private Integer passengersCount;

    @NotNull
    @Range(min = 1, max = 31, message = "Invalid departure day specified.")
    @JsonProperty(value = "departureDay", required = true)
    private Integer departureDay;

    @NotNull
    @Range(min = 1, max = 12, message = "Invalid departure month specified.")
    @JsonProperty(value = "departureMonth", required = true)
    private Integer departureMonth;

    @NotNull
    @Range(min = 2017, max = 9999, message = "Invalid departure year specified.")
    @JsonProperty(value = "departureYear", required = true)
    private Integer departureYear;

    @NotNull
    @Range(min = 1, max = 31, message = "Invalid return day specified.")
    @JsonProperty(value = "returnDay", required = true)
    private Integer returnDay;

    @NotNull
    @Range(min = 1, max = 12, message = "Invalid return month specified.")
    @JsonProperty(value = "returnMonth", required = true)
    private Integer returnMonth;

    @NotNull
    @Range(min = 2017, max = 9999, message = "Invalid return year specified.")
    @JsonProperty(value = "returnYear", required = true)
    private Integer returnYear;

    @JsonIgnore
    private Date departureDate;

    @JsonIgnore
    private Date returnDate;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(Integer passengersCount) {
        this.passengersCount = passengersCount;
    }

    public Integer getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(Integer departureDay) {
        this.departureDay = departureDay;
    }

    public Integer getDepartureMonth() {
        return departureMonth;
    }

    public void setDepartureMonth(Integer departureMonth) {
        this.departureMonth = departureMonth;
    }

    public Integer getDepartureYear() {
        return departureYear;
    }

    public void setDepartureYear(Integer departureYear) {
        this.departureYear = departureYear;
    }

    public Integer getReturnDay() {
        return returnDay;
    }

    public void setReturnDay(Integer returnDay) {
        this.returnDay = returnDay;
    }

    public Integer getReturnMonth() {
        return returnMonth;
    }

    public void setReturnMonth(Integer returnMonth) {
        this.returnMonth = returnMonth;
    }

    public Integer getReturnYear() {
        return returnYear;
    }

    public void setReturnYear(Integer returnYear) {
        this.returnYear = returnYear;
    }

    public Date getDepartureDate() {
        return toDate(departureYear, departureMonth, departureDay);
    }

    public Date getReturnDate() {
        return toDate(returnYear, returnMonth, returnDay);
    }

    private Date toDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }
}
