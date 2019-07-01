package com.std.account.util;

import java.math.BigDecimal;

public class AmountUtil {
    public static Long mul(Long amount, double rate) {
        BigDecimal a = new BigDecimal(Double.toString(amount));
        BigDecimal b = new BigDecimal(Double.toString(rate));
        return a.multiply(b).longValue();
    }

    public static Long mulJinFen(Long amount, double rate) {
        BigDecimal a = new BigDecimal(Double.toString(amount));
        BigDecimal b = new BigDecimal(Double.toString(rate));
        return rmbJinFen(a.multiply(b).doubleValue());
    }

    public static Long rmbJinFen(Double amount) {
        // 保留到分
        return Double.valueOf(Math.ceil(amount / 10) * 10).longValue();
    }

    public static void main(String[] args) {
        System.out.println(mulJinFen(1000L, 0.980990909d));
    }
}
