/*
-- Query: SELECT `type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code` FROM std_account.tsys_config where system_code = 'CD-CZH000001'
LIMIT 0, 10000

-- Date: 2017-04-05 11:05
*/
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','CNY2GXZ','1','',now(),'1人民币兑换贡献值比例','CD-CZH000001','CD-CZH000001');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','CNY2FRB','1','',now(),'1人民币兑换分润比例','CD-CZH000001','CD-CZH000001');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','HBB2GXZ','2','',now(),'1红包币兑换贡献值比例','CD-CZH000001','CD-CZH000001');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','HBYJ2GXZ','3','',now(),'1红包业绩兑换贡献值比例','CD-CZH000001','CD-CZH000001');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('2','EXCTIMES','6','',now(),'币种兑换每个月申请次数','CD-CZH000001','CD-CZH000001');

/*
-- Query: select `type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code` from tsys_dict
LIMIT 0, 10000

-- Date: 2017-04-01 19:22
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'bankcard_status','银行卡状态','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','bankcard_status','0','弃用','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','bankcard_status','1','启用','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'currency','货币','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','CNY','人民币','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','FRB','分润','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','GXJL','贡献值','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','QBB','钱包币','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','GWB','购物币','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','HBB','红包币','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','HBYJ','红包业绩','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'account_type','账户类型','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','C','C端用户','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','B','B端用户','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','PA','合伙人用户','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','P','平台用户','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'account_status','账户状态','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','0','正常','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','1','程序锁定','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','2','人工锁定','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'jour_status','流水状态','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','0','刚生成待回调','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','1','已回调通过待对账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','2','回调不通过','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','3','已对账且账已平','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','4','账不平待调账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','5','已调账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','9','无需对账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','6','待审批','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','7','审批通过','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','8','审批不通过','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'channel_type','渠道类型','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','01','线下_橙账本','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','0','内部账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','9','调账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','10','轧账','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','1','币种兑换','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','30','支付宝APP支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','35','微信公众号支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','36','微信APP支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','40','网银代付','admin',now(),'','CD-CZH000001');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'exchange_currency','币种兑换申请','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','exchange_currency','0','待支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','exchange_currency','1','已支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','exchange_currency','2','已取消','admin',now(),'','CD-CZH000001');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'biz_type','业务类型','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','11','充值','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-11','取现','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','19','蓝补','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-19','红冲','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-30','购物','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','30','购物退款','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','32','确认收货，商户收钱','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-40','购买折扣券','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-ZH1','正汇O2O支付','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-ZH2','正汇分红权分红','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-50','购买汇赚宝','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','51','购买汇赚宝分成','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','52','汇赚宝摇一摇奖励','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','53','汇赚宝主人摇一摇分成','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','54','推荐人摇一摇分成','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','60','发一发得红包','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','61','领取红包','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-70','参与小目标','admin',now(),'','CD-CZH000001');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','71','小目标中奖','admin',now(),'','CD-CZH000001');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','200','币种兑换','admin',now(),'','CD-CZH000001');
/*
-- Query: SELECT * FROM std_account.tstd_account where user_id = 'CD-CZH000001'
-- Date: 2016-12-29 15:08
*/
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000000','SYS_USER_ZHPAY','平台','P','0','CNY',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000001','SYS_USER_ZHPAY','平台','P','0','FRB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000002','SYS_USER_ZHPAY','平台','P','0','GXJL',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000003','SYS_USER_ZHPAY','平台','P','0','QBB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000004','SYS_USER_ZHPAY','平台','P','0','GWB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000005','SYS_USER_ZHPAY','平台','P','0','HBB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2016100000000000006','SYS_USER_ZHPAY','平台','P','0','HBYJ',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');

INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2017100000000000001','USER_POOL_ZHPAY','消费者资金池','P','0','FRB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2017100000000000002','STORE_POOL_ZHPAY','店家资金池','P','0','FRB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`create_datetime`,`last_order`,`system_code`) VALUES ('A2017100000000000003','PLAT_POOL_ZHPAY','平台资金池','P','0','FRB',0,0,'b99e0407fedc3d160f73fec8d1fa9a0c',now(),NULL,'CD-CZH000001');

/*
-- Query: SELECT `company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code` FROM std_account.tstd_company_channel where company_code = 'CD-CZH000001'
LIMIT 0, 10000

-- Date: 2017-04-04 20:18
*/
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CZH000001','正汇钱包','36','1','1360736402','r2jgDFSdiikklwlllejlwjio3242342n','wx9324d86fb16e8af0',NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,'CD-CZH000001');
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CZH000001','正汇钱包','30','1','2088421285632542','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','2016062201540795',NULL,NULL,NULL,NULL,'',NULL,NULL,'CD-CZH000001');
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CZH000001','正汇钱包','50','1','zhqb','579901044610406',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'银企直连','CD-CZH000001');
/*
-- Query: SELECT bank_code,bank_name,channel_type,status,channel_bank,max_order,order_amount,day_amount,month_amount,remark FROM std_account.tstd_channel_bank
LIMIT 0, 50000

-- Date: 2017-01-15 20:50
*/
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('ICBC','中国工商银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('ABC','中国农业银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('CCB','中国建设银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('BOC','中国银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('BCM','中国交通银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('CIB','兴业银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('CITIC','中信银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('CEB','中国光大银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('PAB','平安银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('PSBC','中国邮政储蓄银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('SHB','上海银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('SPDB','浦东发展银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `tstd_channel_bank` (`bank_code`,`bank_name`,`channel_type`,`status`,`channel_bank`,`max_order`,`order_amount`,`day_amount`,`month_amount`,`remark`) VALUES ('CIB','兴业银行','40','1',NULL,NULL,NULL,NULL,NULL,NULL);
