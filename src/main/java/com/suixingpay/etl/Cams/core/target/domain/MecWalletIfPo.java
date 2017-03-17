package com.suixingpay.etl.Cams.core.target.domain;


import com.suixingpay.sourceCode.ChangeFlag;
import com.suixingpay.sourceCode.Utils.Encryption.EncryptorEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: 钱包用户表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author huyou
 * Created on: 2017-02-22 11:29:52
 */
@Entity
@Table(name = "ums.T_UMS_MEC_WALLET_IF")
public class MecWalletIfPo {
	// UUID
	@Id
	@Column(name = "UUID")
	private	String	uuid;
	// 用户编号
	@Column(name = "USR_ID")
	@ChangeFlag(alise = "USR_IN_NO")
	private	String	usrId;
	// 商户编号
	@Column(name = "MNO")
    @ChangeFlag(alise = "USR_IN_NO")
	private	String	mno;
	// 内部商编
	@Column(name = "IN_MNO")
    @ChangeFlag(alise = "USR_IN_NO")
	private	String	inMno;
	// 昵称
	@Column(name = "NICK_NAME")
	private	String	nickName;
	// 打码注册手机号
	@Column(name = "REG_MOBILE")
	private	String	regMobile;
	// 加密手机号
	@Column(name = "ENC_REG_MOBILE")
    @ChangeFlag(sourceEncryptType = EncryptorEnum.TYPE_WALLET,tagertEncryptType = EncryptorEnum.TYPE_UMS)
	private	String	encRegMobile;
	// 注册邮箱
	@Column(name = "REG_EMAIL")
	private	String	regEmail;
	// 邮箱是否激活（0：未激活， 1：激活）
	@Column(name = "IS_EMAIL_ACTIVIE")
    @ChangeFlag(ToString = true)
	private	String	isEmailActivie;
	// 打码真实姓名
	@Column(name = "REAL_NAME")
	private	String	realName;
	// 加密真实姓名
	@Column(name = "ENC_REAL_NAME")
    @ChangeFlag(sourceEncryptType = EncryptorEnum.TYPE_WALLET,tagertEncryptType = EncryptorEnum.TYPE_UMS)
    private	String	encRealName;
	// 打码证件号码
	@Column(name = "ID_CARD_NO")
	private	String	idCardNo;
	// 加密证件号码
	@Column(name = "ENC_ID_CARD_NO")
    @ChangeFlag(sourceEncryptType = EncryptorEnum.TYPE_WALLET,tagertEncryptType = EncryptorEnum.TYPE_UMS)
    private	String	encIdCardNo;
	// 证件类型(01：身份证)
	@Column(name = "ID_CARD_TYPE")
	private	String	idCardType;
	// 性别(0:男；1：女)
	@Column(name = "GENDER")
	private	String	gender;
	// 出生年
	@Column(name = "BIRTH_YEAR")
	private	String	birthYear;
	// 出生月
	@Column(name = "BIRTH_MONTH")
	private	String	birthMonth;
	// 出生日
	@Column(name = "BIRTH_DAY")
	private	String	birthDay;
	// 实名认证状态
	@Column(name = "REAL_AUTH_STATE")
    @ChangeFlag(alise = "USTS")
	private	String	realAuthState;
	// 客户等级(01：一类；02：二类；03：三类)
	@Column(name = "CUST_LEVEL")
    @ChangeFlag(alise = "ULEVEL")
	private	String	custLevel;
	// 创建日期
	@Column(name = "DT_CTE")
	private	String	dtCte;
	// 创建时间
	@Column(name = "TM_CTE")
	private	String	tmCte;
	// 更新日期
	@Column(name = "DT_UTE")
	private	String	dtUte;
	// 更新时间
	@Column(name = "TM_UTE")
	private	String	tmUte;

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	/**
	 * UUID
	 * @return
	 */
	public String getUuid() {
		return uuid;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * 用户编号
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}
	/**
	 * 商户编号
	 * @return
	 */
	public String getMno() {
		return mno;
	}

	public void setInMno(String inMno) {
		this.inMno = inMno;
	}
	/**
	 * 内部商编
	 * @return
	 */
	public String getInMno() {
		return inMno;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 昵称
	 * @return
	 */
	public String getNickName() {
		return nickName;
	}

	public void setRegMobile(String regMobile) {
		this.regMobile = regMobile;
	}
	/**
	 * 打码注册手机号
	 * @return
	 */
	public String getRegMobile() {
		return regMobile;
	}

	public void setEncRegMobile(String encRegMobile) {
		this.encRegMobile = encRegMobile;
	}
	/**
	 * 加密手机号
	 * @return
	 */
	public String getEncRegMobile() {
		return encRegMobile;
	}

	public void setRegEmail(String regEmail) {
		this.regEmail = regEmail;
	}
	/**
	 * 注册邮箱
	 * @return
	 */
	public String getRegEmail() {
		return regEmail;
	}

	public void setIsEmailActivie(String isEmailActivie) {
		this.isEmailActivie = isEmailActivie;
	}
	/**
	 * 邮箱是否激活（0：未激活， 1：激活）
	 * @return
	 */
	public String getIsEmailActivie() {
		return isEmailActivie;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 打码真实姓名
	 * @return
	 */
	public String getRealName() {
		return realName;
	}

	public void setEncRealName(String encRealName) {
		this.encRealName = encRealName;
	}
	/**
	 * 加密真实姓名
	 * @return
	 */
	public String getEncRealName() {
		return encRealName;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	/**
	 * 打码证件号码
	 * @return
	 */
	public String getIdCardNo() {
		return idCardNo;
	}

	public void setEncIdCardNo(String encIdCardNo) {
		this.encIdCardNo = encIdCardNo;
	}
	/**
	 * 加密证件号码
	 * @return
	 */
	public String getEncIdCardNo() {
		return encIdCardNo;
	}

	public void setIdCardType(String idCardType) {
		this.idCardType = idCardType;
	}
	/**
	 * 证件类型(01：身份证)
	 * @return
	 */
	public String getIdCardType() {
		return idCardType;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 性别(0:男；1：女)
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	/**
	 * 出生年
	 * @return
	 */
	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}
	/**
	 * 出生月
	 * @return
	 */
	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * 出生日
	 * @return
	 */
	public String getBirthDay() {
		return birthDay;
	}

	public void setRealAuthState(String realAuthState) {
		this.realAuthState = realAuthState;
	}
	/**
	 * 实名认证状态
	 * @return
	 */
	public String getRealAuthState() {
		return realAuthState;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	/**
	 * 客户等级(01：一类；02：二类；03：三类)
	 * @return
	 */
	public String getCustLevel() {
		return custLevel;
	}

	public void setDtCte(String dtCte) {
		this.dtCte = dtCte;
	}
	/**
	 * 创建日期
	 * @return
	 */
	public String getDtCte() {
		return dtCte;
	}

	public void setTmCte(String tmCte) {
		this.tmCte = tmCte;
	}
	/**
	 * 创建时间
	 * @return
	 */
	public String getTmCte() {
		return tmCte;
	}

	public void setDtUte(String dtUte) {
		this.dtUte = dtUte;
	}
	/**
	 * 更新日期
	 * @return
	 */
	public String getDtUte() {
		return dtUte;
	}

	public void setTmUte(String tmUte) {
		this.tmUte = tmUte;
	}
	/**
	 * 更新时间
	 * @return
	 */
	public String getTmUte() {
		return tmUte;
	}
}