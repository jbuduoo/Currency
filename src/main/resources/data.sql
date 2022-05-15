DROP TABLE IF EXISTS `currency`;
CREATE TABLE `currency` ( 
   `id` INT  AUTO_INCREMENT,
   `name` VARCHAR(50) NOT NULL, 
   `code` VARCHAR(50) NOT NULL,
   `rate` VARCHAR(50),
   PRIMARY KEY (`name`)
);



INSERT INTO currency (name, code) VALUES ('美元', 'USD');
INSERT INTO currency (name, code) VALUES ('港幣', 'HKD');
INSERT INTO currency (name, code) VALUES ('日圓', 'JPY');
INSERT INTO currency (name, code) VALUES ('元人民幣', 'CNY');
INSERT INTO currency (name, code) VALUES ('英镑', 'GBP');
INSERT INTO currency (name, code) VALUES ('歐元', 'EUR');



