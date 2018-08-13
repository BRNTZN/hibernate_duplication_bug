CREATE TABLE PARENT (
    ID BIGINT PRIMARY KEY,
    NAME VARCHAR(255)
);

CREATE TABLE CHILD (
    ID BIGINT PRIMARY KEY,
    PARENT_ID BIGINT,
    NAME VARCHAR(255)
);

CREATE TABLE GRAND_CHILD (
    ID BIGINT PRIMARY KEY,
    CHILD_ID BIGINT,
    NAME VARCHAR(255)
);