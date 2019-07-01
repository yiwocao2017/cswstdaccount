package com.std.account.api.impl;

//802为橙账本系统。accountNumber全局唯一，跟userId一样
public class Readme {
    // --------000-149为基础接口，共150个接口
    // 000-009数字字典的增删改3个查；
    // 010-019银行卡的增删改3个查；
    // 020-029系统参数的改3个查；
    // 100-109为公司渠道的增删改3个查；
    // 110-119为渠道银行的增删改3个查；

    // --------150-199为辅助对接接口，共300个接口
    // 150-159为fuiou相关接口，共10个接口
    // 160-169为baofoo相关接口，共10个接口
    // 170-179为yeepay相关接口，共10个接口
    // 180-189为wechat相关接口，共10个接口
    // 190-199为alipay相关接口，共10个接口

    // --------400-999为账户模块对"界面"开放的接口

    // --------002xxx，账户模块对"业务biz"开放的接口
    // 002000-002099 账户本身信息维护接口
    // 002100-002199 资金变动-内部划转接口
    // 002500-002699 资金变动-外部支付接口
}