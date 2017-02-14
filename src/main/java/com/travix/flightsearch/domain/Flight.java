/*
 * Copyright 2012-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.travix.flightsearch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SearchProvider provider;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CabinClass cabinClass;

    @Column(nullable = false)
    private String origin;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date arrivalDate;

    @Column(nullable = false)
    private int passengersCount;

    @Column(nullable = false)
    private String airLine;

    @Column(nullable = false)
    private double basePrice;

    @Column(nullable = false)
    private double tax;

    @Column(nullable = false)
    private double discount;

    @Column(nullable = false)
    private String currency;

    public Flight() {
    }

    public SearchProvider getProvider() {
        return provider;
    }

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public String getAirLine() {
        return airLine;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getTax() {
        return tax;
    }

    public double getDiscount() {
        return discount;
    }

    public double getPrice() {
        return getBasePrice() + getTax() - getDiscount();
    }

    public void setProvider(SearchProvider provider) {
        this.provider = provider;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setPassengersCount(int passengersCount) {
        this.passengersCount = passengersCount;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
