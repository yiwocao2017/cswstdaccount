ALTER TABLE `tstd_jour` 
CHANGE COLUMN `real_name` `real_name` VARCHAR(64) CHARACTER SET 'utf8mb4' NULL DEFAULT NULL COMMENT '真实姓名' ;

ALTER TABLE `tstd_account` 
CHANGE COLUMN `real_name` `real_name` VARCHAR(64) CHARACTER SET 'utf8mb4' NULL DEFAULT NULL COMMENT '真实姓名',
ADD COLUMN `add_amount` BIGINT(32) NULL COMMENT '增加金额' AFTER `md5`,
ADD COLUMN `in_amount` BIGINT(32) NULL COMMENT '入金' AFTER `add_amount`,
ADD COLUMN `out_amount` BIGINT(32) NULL COMMENT '出金' AFTER `in_amount`;

ALTER TABLE `tstd_jour` 
ADD COLUMN `fee` BIGINT(32) NULL COMMENT '手续费' AFTER `remark`;
