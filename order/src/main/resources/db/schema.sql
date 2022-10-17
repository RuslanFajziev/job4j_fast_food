create table Orders (
    id serial primary key not null,
    status varchar(2000)
);

create table Products (
    id serial primary key not null,
    name varchar(2000),
    quantity int not null
);

create table Order_Product (
   order_id integer not null references Orders (id),
   product_set_id integer not null references Products (id),
   constraint order_product_pkey primary key (order_id, product_set_id)
);