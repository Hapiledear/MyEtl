/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 21:01
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.sourceCode;

import com.suixingpay.sourceCode.Enum.CreateEnum;
import com.suixingpay.sourceCode.Utils.Encryption.EncryptorEnum;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 21:01
 * @version: V1.0
 */
@Target({METHOD, FIELD,TYPE})
@Retention(RUNTIME)
public @interface ChangeFlag {

    String PKFiled() default "";

    /**
     * 来源表的字段名，当字段名称不同时使用
     * 别名可与其他共存
     * @return
     */
    String alise() default "";

    /**
     * 固定值,制空请用'-'符号
     * @return
     */
    String defaultValue() default "";

    /**
     * 系统创建，一般是生成主键
     * @return
     */
    CreateEnum systemCreate() default CreateEnum.TYPE_NONE;

    /**
     * 按照原系统解密
     * 再按照本系统进行加密
     * sourceEncryptType 为空则不进入加解密程序
     * @return
     */
    EncryptorEnum sourceEncryptType() default EncryptorEnum.TYPE_NONE;
    EncryptorEnum tagertEncryptType() default EncryptorEnum.TYPE_NONE;
    /**
     * date合并 格式:cName1@cName2
     * cName1为日期
     * cName2为时间
     * @return Date格式的日期
     */
    String mergerDate() default "";

    /**
     * 转换状态标识，标识字段必须为varchar或char类型
     * 可以与 alise 共存
     * 格式 "源标识-现标识;源标识-现标识$默认现标识"
     * eg "01-00;00-01%00"
     * 源标识 01正常，00异常
     * 现标识 00正常，01异常
     * @return
     */
    String switcSTS() default "";

    boolean ToString() default false;

    boolean ToInteger() default false;

}
