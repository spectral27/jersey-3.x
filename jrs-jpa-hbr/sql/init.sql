create table sector(
    id varchar(16),
    name varchar(64),
    primary key(id)
);

create table record(
    id varchar(16),
    name varchar(64),
    sector_id varchar(16),
    primary key(id)
);

insert into sector values ('78e3dbb7792d4cc9', 'SEC001');

insert into record values ('455e58a20f9a4d30', 'REC001', '78e3dbb7792d4cc9');
insert into record values ('87b49decaeed42c2', 'REC002', '78e3dbb7792d4cc9');
