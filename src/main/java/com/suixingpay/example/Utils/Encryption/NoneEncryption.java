/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/17 11:14
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.Utils.Encryption;

import org.springframework.util.StringUtils;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/17 11:14
 * @version: V1.0
 */
public class NoneEncryption extends AbstractEncrypt {

    private static NoneEncryption instance;

    private NoneEncryption() {
    }

    public static NoneEncryption getInstance() {
        if (null == instance) {
            instance = new NoneEncryption();
        }
        return instance;
    }

    @Override public String encrypt(String encryField) {
        return encryField;
    }

    @Override public String encryptIgnoreCase(String encryField) {
        return encryField;
    }

    @Override public String decrypt(String decryField) {
        return decryField;
    }
}
