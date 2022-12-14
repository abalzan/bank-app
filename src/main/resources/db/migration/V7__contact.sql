
CREATE TABLE `contact_messages` (
                                    `contact_id` varchar(50) NOT NULL,
                                    `contact_name` varchar(50) NOT NULL,
                                    `contact_email` varchar(100) NOT NULL,
                                    `subject` varchar(500) NOT NULL,
                                    `message` varchar(2000) NOT NULL,
                                    `created_date` date DEFAULT NULL,
                                    `updated_date` date DEFAULT NULL,
                                    PRIMARY KEY (`contact_id`)
);
