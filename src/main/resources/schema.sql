CREATE TABLE QUOTE (
  id INT PRIMARY KEY,
  author VARCHAR(255),
  quote VARCHAR(255)
);

CREATE TABLE DEFINITION (
  id INT PRIMARY KEY,
  word VARCHAR(255),
  definition VARCHAR(255)
);

CREATE TABLE ANSWER (
  id INT PRIMARY KEY,
  question VARCHAR(255),
  answer VARCHAR(255)
);
