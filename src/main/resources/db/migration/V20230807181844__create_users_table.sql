CREATE TABLE users (
       id INT PRIMARY KEY AUTO_INCREMENT,
       username VARCHAR(255),
       firstName VARCHAR(255),
       lastName VARCHAR(255),
       country VARCHAR(255),
       city VARCHAR(255),
       createdBy VARCHAR(255),
       createdDate DATETIME,
       lastModifiedBy VARCHAR(255),
       lastModifiedDate DATETIME
);