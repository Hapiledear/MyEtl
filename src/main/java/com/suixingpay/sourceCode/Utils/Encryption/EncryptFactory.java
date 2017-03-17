/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 11:26
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.sourceCode.Utils.Encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 加密机工厂
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/9 11:26
 * @version: V1.0
 */
public class EncryptFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptFactory.class);

    public static AbstractEncrypt getEncryption(EncryptorEnum encType) {
        switch (encType) {
            case TYPE_UMS:
                LOGGER.debug("获取ums加密机");
                return UmsEncryption.getInstance();
            case TYPE_WALLET:
               LOGGER.debug("获取钱包加密机");
                return WalletEncryption.getInstance();
            case TYPE_NONE:
                LOGGER.debug("无加密");
                return NoneEncryption.getInstance();
            default:
                LOGGER.debug("获取默认的加密机");
                return NoneEncryption.getInstance();
        }
    }
}
