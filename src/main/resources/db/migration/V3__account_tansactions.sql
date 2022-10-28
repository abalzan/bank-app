

CREATE TABLE `account_transactions` (
                                        `transaction_id` varchar(200) NOT NULL,
                                        `account_number` BIGINT(15) NOT NULL,
                                        `customer_id` int NOT NULL,
                                        `transaction_date` date NOT NULL,
                                        `transaction_summary` varchar(200) NOT NULL,
                                        `transaction_type` varchar(100) NOT NULL,
                                        `transaction_amount` int NOT NULL,
                                        `closing_balance` int NOT NULL,
                                        `created_date` date DEFAULT NULL,
                                        `updated_date` date DEFAULT NULL,
                                        PRIMARY KEY (`transaction_id`),
                                        KEY `customer_id` (`customer_id`),
                                        KEY `account_number` (`account_number`),
                                        CONSTRAINT `accounts_ibfk_2` FOREIGN KEY (`account_number`) REFERENCES `accounts` (`account_number`) ON DELETE CASCADE,
                                        CONSTRAINT `acct_user_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE
);



INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-7, 'Coffee Shop', 'Withdrawal', 30,34500,SYSDATE()-7);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-6, 'Uber', 'Withdrawal', 100,34400,SYSDATE()-6);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-5, 'Self Deposit', 'Deposit', 500,34900,SYSDATE()-5);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-4, 'Ebay', 'Withdrawal', 600,34300,SYSDATE()-4);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-2, 'OnlineTransfer', 'Deposit', 700,35000,SYSDATE()-2);

INSERT INTO `account_transactions` (`transaction_id`, `account_number`, `customer_id`, transaction_date, `transaction_summary`, `transaction_type`, transaction_amount,
                                    `closing_balance`, `created_date`)  VALUES (UUID(), 186576453434, 1, SYSDATE()-1, 'Amazon.com', 'Withdrawal', 100,34900,SYSDATE()-1);

