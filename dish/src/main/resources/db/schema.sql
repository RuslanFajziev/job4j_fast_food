create table Products (
    id serial primary key not null,
    name varchar(2000),
    quantity int not null
);

insert into Products(name, quantity)
VALUES ('Чипсы', 200), ('Рыба', 500),
       ('Молоко', 40), ('Яблоки', 300);