SET autocommit = 0;

start transaction;








-- Replace from here

insert into cityinfo (id, zipcode, city) values (1, 1, "city1");
insert into cityinfo (id, zipcode, city) values (2, 2, "city2");
insert into cityinfo (id, zipcode, city) values (3, 3, "city3");
insert into hobby (id, `name`, description) values (1, "hobbyName1", "hobbyDescription1");
insert into hobby (id, `name`, description) values (2, "hobbyName2", "hobbyDescription2");
insert into hobby (id, `name`, description) values (3, "hobbyName3", "hobbyDescription3");
insert into address (id, street, additionalInfo, cityinfo_id) values (1, "street1", "additionalInfo1", 1);
insert into address (id, street, additionalInfo, cityinfo_id) values (2, "street2", "additionalInfo2", 2);
insert into address (id, street, additionalInfo, cityinfo_id) values (3, "street3", "additionalInfo3", 3);
insert into infoentity (dtype, email, address_id) values ("Person", "1@email.com", 1);
insert into infoentity (dtype, email, address_id) values ("Person", "2@email.com", 2);
insert into infoentity (dtype, email, address_id) values ("Person", "3@email.com", 3);
insert into person (firstname, lastname) values ("fn1", "ln1");
insert into person (firstname, lastname) values ("fn2", "ln2");
insert into person (firstname, lastname) values ("fn3", "ln3");
insert into person_hobby (hobbies_id, persons_id) values (1, 1);
insert into person_hobby (hobbies_id, persons_id) values (2, 2);
insert into person_hobby (hobbies_id, persons_id) values (3, 3);
insert into phone (id, phone, description, infoentity_id) values (1, 1, "phoneDescription1", 1);
insert into phone (id, phone, description, infoentity_id) values (2, 2, "phoneDescription2", 2);
insert into phone (id, phone, description, infoentity_id) values (3, 3, "phoneDescription3", 3);





-- Replace to here




commit;