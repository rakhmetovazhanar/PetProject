create table hotel {
    id bigserial primary key,
    name varchar not null,
    city varchar not null,
    rooms
};

create table room {
    id bigserial primary key,
    roomNumber varchar not null,
    capacity varchar not null,
    hotel_id bigserial references hotel(id)
};