package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.email;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.BillsCommonRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.points.request.PointsRequest;

/**
 * @Description: 第三方邮件 API
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class EmailApi {

    public static void sendBillsErrorMail(BillsCommonRequest request, String responseDesc) {
        String subject = "获取票券失败通知";
        String[] to = new String[5]; // 获取票券失败通知收件人列表
        sendEmail(subject, request, responseDesc, to);
    }

    public static void sendPointsErrorMail(PointsRequest request, String responseDesc) {
        String subject = "扣除点数失败通知";
        String[] to = new String[10]; // 扣除点数失败通知收件人列表
        sendEmail(subject, request, responseDesc, to);
    }

    private static void sendEmail(String subject, Object request, String responseDesc, String[] to) {
        String content = "本次调用参数是 " + request.toString() + "，发生的错误是 " + responseDesc;
        // 发送邮件
    }
}
