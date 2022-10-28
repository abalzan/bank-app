use bank;

CREATE TABLE `accounts` (
                            `customer_id` int NOT NULL,
                            `account_number` BIGINT(15) NOT NULL,
                            `account_type` varchar(100) NOT NULL,
                            `branch_address` varchar(200) NOT NULL,
                            `created_date` date DEFAULT NULL,
                            `updated_date` date DEFAULT NULL,
                            PRIMARY KEY (`account_number`),
                            KEY `customer_id` (`customer_id`),
                            CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);

INSERT INTO `accounts` (`customer_id`, `account_number`, `account_type`, `branch_address`, `created_date`)
VALUES (1, 186576453434, 'Savings', '123 Main Street, New York', SYSDATE());
