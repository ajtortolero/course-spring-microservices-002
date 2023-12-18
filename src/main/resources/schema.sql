CREATE TABLE IF NOT EXISTS
producto(
    serial INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR2(120),
    marca VARCHAR2(80),
    precio NUMERIC(10,2) DEFAULT 0,
    PRIMARY KEY (serial));
