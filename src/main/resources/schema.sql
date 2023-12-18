CREATE TABLE IF NOT EXISTS movie (
    id VARCHAR(80) NOT NULL,
    title VARCHAR(80),
    director VARCHAR(80),
    releaseYear INTEGER,
    genre VARCHAR(80),
    PRIMARY KEY (id)
 );

CREATE TABLE IF NOT EXISTS client (
    id VARCHAR(80) NOT NULL,
    name VARCHAR(80),
    lastName VARCHAR(80),
    email VARCHAR(80),
    PRIMARY KEY (id)
 );
