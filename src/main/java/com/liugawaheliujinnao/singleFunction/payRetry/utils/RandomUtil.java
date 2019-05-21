package com.liugawaheliujinnao.singleFunction.payRetry.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 生成时间随机订单号工具类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class RandomUtil {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");

    public static String getRandomStr(int length) throws NoSuchAlgorithmException {
        SecureRandom random;
        random = SecureRandom.getInstance("SHA1PRNG");
        int value = random.nextInt(9999);
        return String.format("%04d", value);
    }

    public static String createOrderId() throws NoSuchAlgorithmException {
        StringBuffer sb = new StringBuffer();
        return sb.append(sdf.format(new Date())).append(getRandomStr(4)).toString();
    }
}
