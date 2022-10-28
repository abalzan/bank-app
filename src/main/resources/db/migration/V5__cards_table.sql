
CREATE TABLE `cards` (
                         `card_id` int NOT NULL AUTO_INCREMENT,
                         `card_number` varchar(100) NOT NULL,
                         `customer_id` int NOT NULL,
                         `card_type` varchar(100) NOT NULL,
                         `total_limit` int NOT NULL,
                         `amount_used` int NOT NULL,
                         `available_amount` int NOT NULL,
                         `created_date` date DEFAULT NULL,
                         `updated_date` date DEFAULT NULL,
                         PRIMARY KEY (`card_id`),
                         KEY `customer_id` (`customer_id`),
                         CONSTRAINT `card_customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, SYSDATE());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, SYSDATE());

INSERT INTO `cards` (`card_number`, `customer_id`, `card_type`, `total_limit`, `amount_used`, `available_amount`, `created_date`)
VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, SYSDATE());
