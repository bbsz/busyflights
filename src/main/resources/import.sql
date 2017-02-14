--
-- Sample dataset containing a number of Flights to cities across the world.
--

-- =================================================================================================
-- AUSTRALIA

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency)  values (1,1,'LDN', 'BRB', '2017-03-14 10:30:00', '2017-03-14 10:30:00', 250, 'EasyJet', 299, 29, 0, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'BRB', 'LDN', '2017-03-21 10:30:00', '2017-03-21 17:30:00', 250, 'EasyJet', 299, 29, 0, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency)  values (0,0,'LDN', 'BRB', '2017-03-14 10:30:00', '2017-03-14 17:30:00', 250, 'EasyJet', 99, 29, 0, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'BRB', 'LDN', '2017-03-21 10:30:00', '2017-03-21 17:30:00', 250, 'EasyJet', 99, 29, 0, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'LDN', 'MLB', '2017-03-17 12:30:00', '2017-03-17 21:30:00', 250, 'Thomson Airways', 99, 29, 50, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'MLB', 'LDN', '2017-03-25 12:30:00', '2017-03-25 21:30:00', 250, 'Thomson Airways', 99, 29, 50, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'LDN', 'MLB', '2017-03-17 12:30:00', '2017-03-17 21:30:00', 250, 'Thomson Airways', 199, 29, 50, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'MLB', 'LDN', '2017-03-25 12:30:00', '2017-03-25 21:30:00', 250, 'Thomson Airways', 199, 29, 50, 'GBP')


-- =================================================================================================
-- USA
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency)  values (1,1,'MNT', 'WSH', '2017-03-14 10:30:00', '2017-03-14 10:30:00', 250, 'EasyJet', 299, 29, 0, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'WSH', 'MNT', '2017-03-21 10:30:00', '2017-03-21 17:30:00', 250, 'EasyJet', 299, 29, 0, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency)  values (0,0,'MNT', 'WSH', '2017-03-14 10:30:00', '2017-03-14 17:30:00', 250, 'EasyJet', 99, 29, 0, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'WSH', 'MNT', '2017-03-21 10:30:00', '2017-03-21 17:30:00', 250, 'EasyJet', 99, 29, 0, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'NYC', 'MAI', '2017-03-17 12:30:00', '2017-03-17 21:30:00', 250, 'Thomson Airways', 999, 29, 40, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (0,0,'MAI', 'NYC', '2017-03-25 12:30:00', '2017-03-25 21:30:00', 250, 'Thomson Airways', 999, 29, 40, 'GBP')

insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'NYC', 'MAI', '2017-03-17 12:30:00', '2017-03-17 21:30:00', 250, 'Thomson Airways', 199, 29, 30, 'GBP')
insert into flight(provider, cabin_class, origin, destination,departure_date,arrival_date,passengers_count,air_line,base_price,tax,discount,currency) values (1,1,'MAI', 'NYC', '2017-03-25 12:30:00', '2017-03-25 21:30:00', 250, 'Thomson Airways', 199, 29, 30, 'GBP')

-