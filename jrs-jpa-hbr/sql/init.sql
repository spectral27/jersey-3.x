CREATE TABLE sector(
    id VARCHAR(16),
    name VARCHAR(64),
    PRIMARY KEY(id)
);

CREATE TABLE record(
    id VARCHAR(16),
    name VARCHAR(64),
    sector_id VARCHAR(16),
    PRIMARY KEY(id)
);

INSERT INTO sector VALUES ('78e3dbb7792d4cc9', 'SEC001');

INSERT INTO record VALUES ('455e58a20f9a4d30', 'REC001', '78e3dbb7792d4cc9');
INSERT INTO record VALUES ('87b49decaeed42c2', 'REC002', '78e3dbb7792d4cc9');
