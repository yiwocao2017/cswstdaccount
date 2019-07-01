SET SQL_SAFE_UPDATES = 0;
delete from  tstd_account where system_code = 'CD-CCG000007';
delete from  tstd_bankcard where system_code = 'CD-CCG000007';
delete from  tstd_channel_bank;
delete from  tstd_company_channel where system_code = 'CD-CCG000007';
delete from  tstd_exchange_currency where system_code = 'CD-CCG000007';
delete from  tstd_jour where system_code = 'CD-CCG000007';
delete from  tsys_dict where system_code = 'CD-CCG000007';
delete from  tsys_config where system_code = 'CD-CCG000007';