insert into CAR (ID, MODEL, DAY_RATE) values (CAR_SEQ.nextval, 'Toyota Yaris', 40);
insert into CAR (ID, MODEL, DAY_RATE) values (CAR_SEQ.nextval, 'Ford Focus', 50);
insert into CAR (ID, MODEL, DAY_RATE) values (CAR_SEQ.nextval, 'Fiat Pundo', 30);
insert into CAR (ID, MODEL, DAY_RATE) values (CAR_SEQ.nextval, 'Toyota Corolla', 50);
insert into CAR (ID, MODEL, DAY_RATE) values (CAR_SEQ.nextval, 'Audi A4', 60);

insert into CUSTOMER (ID, NAME, ADDRESS) values (CUSTOMER_SEQ.nextval, 'Mike Lamprakis', '14 Gilpin View');
insert into CUSTOMER (ID, NAME, ADDRESS) values (CUSTOMER_SEQ.nextval, 'Jim Johnson', '14 Wesley Road');
insert into CUSTOMER (ID, NAME, ADDRESS) values (CUSTOMER_SEQ.nextval, 'Anna Daughty', '16 High Street');
insert into CUSTOMER (ID, NAME, ADDRESS) values (CUSTOMER_SEQ.nextval, 'John Smith', '4 Arleton Road');
insert into CUSTOMER (ID, NAME, ADDRESS) values (CUSTOMER_SEQ.nextval, 'Amy Moore', '10 Moorland Road');

insert into RESERVATION (RESERVATION_ID, CUSTOMER_ID, CAR_ID, DATEFROM, DATETO, AMOUNT, DISCOUNT, DELAYEDDAYS, FINE) values (RESERVATION_SEQ.nextval, 1, 1, '10/03/2021', '13/03/2021', 100, '40%',  2, 200 );

insert into MANAGER (MANAGERID, USERNAME, PASSWORD) values (MANAGER_SEQ.nextval, 'Mike', 'mike123');