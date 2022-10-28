

CREATE TABLE `notice_details` (
                                  `notice_id` int NOT NULL AUTO_INCREMENT,
                                  `notice_summary` varchar(200) NOT NULL,
                                  `notice_details` varchar(500) NOT NULL,
                                  `notice_beg_date` date NOT NULL,
                                  `notica_end_date` date DEFAULT NULL,
                                  `created_date` date DEFAULT NULL,
                                  `updated_date` date DEFAULT NULL,
                                  PRIMARY KEY (`notice_id`)
);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);

INSERT INTO `notice_details` (`notice_summary`, `notice_details`, `notice_beg_date`, `notica_end_date`, `created_date`, `updated_date`)
VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
        SYSDATE() - INTERVAL 30 DAY, SYSDATE() + INTERVAL 30 DAY, SYSDATE(), null);
