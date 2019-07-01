/*
-- Query: SELECT `account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code` FROM std_account.tstd_account where user_id = 'CD-CZH000001'
-- Date: 2016-12-29 15:08
*/
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('LA2016100000000000000','SYS_ACCOUNT','平台','P','0','CNY',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CLW000005');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('LA2016100000000000001','SYS_ACCOUNT','平台','P','0','XNB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CLW000005');

/*
-- Query: SELECT * FROM std_account.tstd_company_channel
LIMIT 0, 10000

-- Date: 2017-02-17 16:49
*/
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CLW000005','来来旺旺','35',NULL,'1432931902','zhejianglailaiwangwangGS87015038','wx69a5f10912c97d87','08de579b53cf0617854e6ec621daa870',NULL,NULL,NULL,NULL,'http://118.178.124.16:5902/xn-tour/wechat/callback',NULL,'微信公众号支付','CD-CLW000005');