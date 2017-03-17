SET autocommit = 0;

start transaction;








-- Replace from here




insert into CITYINFO (zipcode, city) values (1, "city1");
insert into CITYINFO (zipcode, city) values (2, "city2");
insert into CITYINFO (zipcode, city) values (3, "city3");
insert into HOBBY (`name`, description) values ("hobbyName1", "hobbyDescription1");
insert into HOBBY (`name`, description) values ("hobbyName2", "hobbyDescription2");
insert into HOBBY (`name`, description) values ("hobbyName3", "hobbyDescription3");
insert into ADDRESS (street, additionalInfo, CITYINFO_zipcode) values ("street1", "additionalInfo1", 1);
insert into ADDRESS (street, additionalInfo, CITYINFO_zipcode) values ("street2", "additionalInfo2", 2);
insert into ADDRESS (street, additionalInfo, CITYINFO_zipcode) values ("street3", "additionalInfo3", 3);
insert into INFOENTITY (dtype, email, address_id) values ("Person", "1@email.com", 1);
insert into INFOENTITY (dtype, email, address_id) values ("Person", "2@email.com", 2);
insert into INFOENTITY (dtype, email, address_id) values ("Person", "3@email.com", 3);
insert into PERSON (id, firstname, lastname) values (1, "fn1", "ln1");
insert into PERSON (id, firstname, lastname) values (2, "fn2", "ln2");
insert into PERSON (id, firstname, lastname) values (3, "fn3", "ln3");
insert into PERSON_HOBBY (hobbies_id, person_id) values (1, 1);
insert into PERSON_HOBBY (hobbies_id, person_id) values (2, 2);
insert into PERSON_HOBBY (hobbies_id, person_id) values (3, 3);
insert into PHONE (id, number, description, ie_id) values (1, 1, "phoneDescription1", 1);
insert into PHONE (id, number, description, ie_id) values (2, 2, "phoneDescription2", 2);
insert into PHONE (id, number, description, ie_id) values (3, 3, "phoneDescription3", 3);






-- Replace to here




commit;