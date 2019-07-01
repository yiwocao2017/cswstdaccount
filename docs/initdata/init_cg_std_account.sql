/*
-- Query: SELECT `type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code` FROM std_account.tsys_config where system_code = 'CD-CCG000007'
LIMIT 0, 10000

-- Date: 2017-04-05 23:32
*/
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','CNY2CGB','1.02','',now(),'1人民币兑换多少菜狗币','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('1','CGB2CGJF','5','',now(),'1菜狗币兑换多少积分','CD-CCG000007','CD-CCG000007');

INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('2','cuserQxbs','100','',now(),'C端取现金额倍数','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('2','cuserQxfl','0.02','',now(),'C端取现手续费率','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('2','cuserQxsx','1','',now(),'C端取现时效(单位：天)','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('3','buserQxbs','100','',now(),'B端取现金额倍数','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('3','buserQxfl','0.02','',now(),'B端取现手续费率','CD-CCG000007','CD-CCG000007');
INSERT INTO `tsys_config` (`type`,`ckey`,`cvalue`,`updater`,`update_datetime`,`remark`,`company_code`,`system_code`) VALUES ('3','buserQxsx','1','',now(),'B端取现时效(单位：天)','CD-CCG000007','CD-CCG000007');

/*
-- Query: SELECT `account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,0 `amount`,0 `frozen_amount`,`md5`,0 `add_amount`,0 `in_amount`,0 `out_amount`,`create_datetime`,'' `last_order`,`system_code` FROM std_account.tstd_account where user_id = 'SYS_USER_CAIGO'
LIMIT 0, 400

-- Date: 2017-04-20 10:34
*/
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`add_amount`,`in_amount`,`out_amount`,`create_datetime`,`last_order`,`system_code`) VALUES ('CGA2016100000000000000','SYS_USER_CAIGO','平台','P','0','CNY',0,0,'d3b907844e4c1c51573c6be663f57eaf',0,0,0,now(),'','CD-CCG000007');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`add_amount`,`in_amount`,`out_amount`,`create_datetime`,`last_order`,`system_code`) VALUES ('CGA2016100000000000001','SYS_USER_CAIGO','平台','P','0','CGJF',0,0,'9cd0c94334e9ad8889941cfb0b8ad1e3',0,0,0,now(),'','CD-CCG000007');
INSERT INTO `tstd_account` (`account_number`,`user_id`,`real_name`,`type`,`status`,`currency`,`amount`,`frozen_amount`,`md5`,`add_amount`,`in_amount`,`out_amount`,`create_datetime`,`last_order`,`system_code`) VALUES ('CGA2016100000000000002','SYS_USER_CAIGO','平台','P','0','CGB',0,0,'6a3ea19778f8e415f8371457636abf7a',0,0,0,now(),'','CD-CCG000007');

/*
-- Query: SELECT `company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code` FROM std_account.tstd_company_channel where company_code = 'CD-CCG000007'
LIMIT 0, 50000

-- Date: 2017-01-15 20:51
*/
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CCG000007','菜狗商城','35','1','1343848501','r2jgDFSdiikklwlllejlwjio3242342n','wx5b7c0f77fd657fee','10e1b1dccee7da4ae2efc1c500108a95',NULL,NULL,NULL,NULL,'',NULL,NULL,'CD-CCG000007');
INSERT INTO `tstd_company_channel` (`company_code`,`company_name`,`channel_type`,`status`,`channel_company`,`private_key1`,`private_key2`,`private_key3`,`private_key4`,`private_key5`,`page_url`,`error_url`,`back_url`,`fee`,`remark`,`system_code`) VALUES ('CD-CCG000007','菜狗商城','37','1','1343848501','r2jgDFSdiikklwlllejlwjio3242342n','wx5b7c0f77fd657fee','10e1b1dccee7da4ae2efc1c500108a95',NULL,NULL,NULL,NULL,'',NULL,NULL,'CD-CCG000007');

/*
-- Query: SELECT `type`,`parent_key`,`dkey`,`dvalue`,`updater`,now() as `update_datetime`,`remark`,`system_code` FROM std_account.tsys_dict where system_code ='CD-CCG000007'
LIMIT 0, 10000

-- Date: 2017-03-25 21:53
*/
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'bankcard_status','银行卡状态','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','bankcard_status','0','弃用','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','bankcard_status','1','启用','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'currency','货币','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','CNY','人民币','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','CGJF','积分','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','currency','CGB','菜狗币','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'account_type','账户类型','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','C','C端用户','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','B','B端用户','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','PA','加盟商','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_type','P','平台用户','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'account_status','账户状态','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','0','正常','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','1','程序锁定','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','account_status','2','人工锁定','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'jour_status','流水状态','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','0','刚生成待回调','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','1','已回调通过待对账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','2','回调不通过','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','3','已对账且账已平','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','4','账不平待调账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','5','已调账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','9','无需对账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','6','待审批','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','7','审批通过','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','jour_status','8','审批不通过','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'channel_type','渠道类型','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','01','线下_橙账本','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','0','内部账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','9','调账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','10','轧账','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','1','币种兑换','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','35','微信公众号支付','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','channel_type','37','微信扫码支付','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('0',NULL,'biz_type','业务类型','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','01','注册送积分','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','02','每天首次登录送积分','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','11','充值','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-11','取现','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','19','蓝补','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-19','红冲','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-30','购物','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','30','购物退款','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','32','确认收货','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-50','购买摇钱树','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','51','购买摇钱树分成','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','52','摇钱树摇一摇奖励','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','53','摇一摇分成','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','60','发一发得红包','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','61','领取红包','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-70','参与小目标','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','71','小目标中奖','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','90','O2O菜狗币支付','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','91','O2O菜狗币返点人民币','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','92','O2O人民币支付','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','93','O2O积分支付','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','94','菜狗充值专区用款','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','-94','菜狗充值专区退款','admin',now(),'','CD-CCG000007');

INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','200','币种兑换','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','201','同币种的划转','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','210','菜狗币售卖','admin',now(),'','CD-CCG000007');
INSERT INTO `tsys_dict` (`type`,`parent_key`,`dkey`,`dvalue`,`updater`,`update_datetime`,`remark`,`system_code`) VALUES ('1','biz_type','211','嗨币兑换菜狗币','admin',now(),'','CD-CCG000007');
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
