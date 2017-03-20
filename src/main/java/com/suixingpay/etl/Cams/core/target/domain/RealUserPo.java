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
 * Description: 用户实名信息表 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author yanghuang
 * Created on: 2017-03-20 09:51:34
 */
@Entity
@Table(name = "ums.T_UMS_REAL_USR")
public class RealUserPo{
	// REAL_USR_ID
	@Id
	@Column(name = "REAL_USR_ID")
    @ChangeFlag(alise = "USR_IN_NO")
	private	String	realUsrId;
	// 用户号
	@Column(name = "USR_ID")
	@ChangeFlag(alise = "USR_IN_NO")
	private	String	usrId;
	// 身份证号
	@Column(name = "ID_NO")
    @ChangeFlag(alise = "ENC_ID_CARD_NO",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET)
	private	String	idNo;
	// 显示身份证件号
	@Column(name = "ID_NO_DIS")
    @ChangeFlag(alise = "DISP_ID_CARD_NO")
	private	String	idNoDis;
	// 加密身份证件号
	@Column(name = "ID_NO_ENC")
    @ChangeFlag(alise = "ENC_ID_CARD_NO",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET,
            tagertEncryptType = EncryptorEnum.TYPE_UMS)
	private	String	idNoEnc;
	// 真实姓名
	@Column(name = "ID_NAME")
    @ChangeFlag(alise = "ENC_REAL_NAME",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET)
	private	String	idName;
	// 显示证件姓名
	@Column(name = "ID_NAME_DIS")
    @ChangeFlag(alise = "DISP_REAL_NAME")
	private	String	idNameDis;
	// 加密证件姓名
	@Column(name = "ID_NAME_ENC")
    @ChangeFlag(alise = "ENC_REAL_NAME",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET,
            tagertEncryptType = EncryptorEnum.TYPE_UMS)
	private	String	idNameEnc;
	// 身份证件生效日期
	@Column(name = "ID_EFF_DT")
	private	String	idEffDt;
	// 身份证件失效日期
	@Column(name = "ID_EXP_DT")
	private	String	idExpDt;
	// 正面照路径
	@Column(name = "ID_FRONT_PATH")
	private	String	idFrontPath;
	// 背面照路径
	@Column(name = "ID_BACK_PATH")
	private	String	idBackPath;
	// 手持照路径
	@Column(name = "ID_HOLDING_PATH")
	private	String	idHoldingPath;
	// 营业执照注册号
	@Column(name = "LIC_REG_NO")
	private	String	licRegNo;
	// 营业执照注册名称
	@Column(name = "LIC_REG_NM")
	private	String	licRegNm;
	// 营业执照上的姓名
	@Column(name = "LIC_NAME")
	private	String	licName;
	// 营业执照照片路径
	@Column(name = "LIC_PATH")
	private	String	licPath;
	// 签名照路径
	@Column(name = "SIGN_PATH")
	private	String	signPath;
	// 门店照路径
	@Column(name = "STORE_PATH")
	private	String	storePath;
	// 认证状态(00:通过，01:待审核，02:拒绝，03：失效)
	@Column(name = "AUTH_STS")
    @ChangeFlag(alise = "AUTH_STATE",switcSTS = "0-02;1-00;2-01%03")
	private	String	authSts;
	// 创建日期
	@Column(name = "CTE_DT")
    @ChangeFlag(mergerDate = "CREATE_DATE@CREATE_TIME")
	private	java.util.Date	cteDt;
	// 更新日期
	@Column(name = "UTE_DT")
	private	java.util.Date	uteDt;
	// 认证次数
	@Column(name = "AUTH_TIMES")
    @ChangeFlag(ToInteger = true)
	private	Integer	authTimes;
	// 身份证认证次数
	@Column(name = "ID_TIMES")
    @ChangeFlag(ToInteger = true)
    private	Integer	idTimes;
	// 身份证成功认证次数
	@Column(name = "ID_SUCC_TIMES")
    @ChangeFlag(ToInteger = true)
	private	Integer	idSuccTimes;
	// 银行卡认证次数
	@Column(name = "BNK_TIMES")
    @ChangeFlag(ToInteger = true)
	private	Integer	bnkTimes;
	// 银行卡成功认证次数
	@Column(name = "BNK_SUCC_TIMES")
    @ChangeFlag(ToInteger = true)
	private	Integer	bnkSuccTimes;
	// 营业执照认证次数
	@Column(name = "LIC_TIMES")
    @ChangeFlag(defaultValue = "0",ToInteger = true)
	private	Integer	licTimes;
	// 营业执照成功认证次数
	@Column(name = "LIC_SUCC_TIMES")
    @ChangeFlag(defaultValue = "0",ToInteger = true)
	private	Integer	licSuccTimes;

	@Override public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public void setRealUsrId(String realUsrId) {
		this.realUsrId = realUsrId;
	}
	/**
	 * REAL_USR_ID
	 * @return
	 */
	public String getRealUsrId() {
		return realUsrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	/**
	 * 用户号
	 * @return
	 */
	public String getUsrId() {
		return usrId;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * 身份证号
	 * @return
	 */
	public String getIdNo() {
		return idNo;
	}

	public void setIdNoDis(String idNoDis) {
		this.idNoDis = idNoDis;
	}
	/**
	 * 显示身份证件号
	 * @return
	 */
	public String getIdNoDis() {
		return idNoDis;
	}

	public void setIdNoEnc(String idNoEnc) {
		this.idNoEnc = idNoEnc;
	}
	/**
	 * 加密身份证件号
	 * @return
	 */
	public String getIdNoEnc() {
		return idNoEnc;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}
	/**
	 * 真实姓名
	 * @return
	 */
	public String getIdName() {
		return idName;
	}

	public void setIdNameDis(String idNameDis) {
		this.idNameDis = idNameDis;
	}
	/**
	 * 显示证件姓名
	 * @return
	 */
	public String getIdNameDis() {
		return idNameDis;
	}

	public void setIdNameEnc(String idNameEnc) {
		this.idNameEnc = idNameEnc;
	}
	/**
	 * 加密证件姓名
	 * @return
	 */
	public String getIdNameEnc() {
		return idNameEnc;
	}

	public void setIdEffDt(String idEffDt) {
		this.idEffDt = idEffDt;
	}
	/**
	 * 身份证件生效日期
	 * @return
	 */
	public String getIdEffDt() {
		return idEffDt;
	}

	public void setIdExpDt(String idExpDt) {
		this.idExpDt = idExpDt;
	}
	/**
	 * 身份证件失效日期
	 * @return
	 */
	public String getIdExpDt() {
		return idExpDt;
	}

	public void setIdFrontPath(String idFrontPath) {
		this.idFrontPath = idFrontPath;
	}
	/**
	 * 正面照路径
	 * @return
	 */
	public String getIdFrontPath() {
		return idFrontPath;
	}

	public void setIdBackPath(String idBackPath) {
		this.idBackPath = idBackPath;
	}
	/**
	 * 背面照路径
	 * @return
	 */
	public String getIdBackPath() {
		return idBackPath;
	}

	public void setIdHoldingPath(String idHoldingPath) {
		this.idHoldingPath = idHoldingPath;
	}
	/**
	 * 手持照路径
	 * @return
	 */
	public String getIdHoldingPath() {
		return idHoldingPath;
	}

	public void setLicRegNo(String licRegNo) {
		this.licRegNo = licRegNo;
	}
	/**
	 * 营业执照注册号
	 * @return
	 */
	public String getLicRegNo() {
		return licRegNo;
	}

	public void setLicRegNm(String licRegNm) {
		this.licRegNm = licRegNm;
	}
	/**
	 * 营业执照注册名称
	 * @return
	 */
	public String getLicRegNm() {
		return licRegNm;
	}

	public void setLicName(String licName) {
		this.licName = licName;
	}
	/**
	 * 营业执照上的姓名
	 * @return
	 */
	public String getLicName() {
		return licName;
	}

	public void setLicPath(String licPath) {
		this.licPath = licPath;
	}
	/**
	 * 营业执照照片路径
	 * @return
	 */
	public String getLicPath() {
		return licPath;
	}

	public void setSignPath(String signPath) {
		this.signPath = signPath;
	}
	/**
	 * 签名照路径
	 * @return
	 */
	public String getSignPath() {
		return signPath;
	}

	public void setStorePath(String storePath) {
		this.storePath = storePath;
	}
	/**
	 * 门店照路径
	 * @return
	 */
	public String getStorePath() {
		return storePath;
	}

	public void setAuthSts(String authSts) {
		this.authSts = authSts;
	}
	/**
	 * 认证状态(00:通过，01:待审核，02:拒绝，03：失效)
	 * @return
	 */
	public String getAuthSts() {
		return authSts;
	}

	public void setCteDt(java.util.Date cteDt) {
		this.cteDt = cteDt;
	}
	/**
	 * 创建日期
	 * @return
	 */
	public java.util.Date getCteDt() {
		return cteDt;
	}

	public void setUteDt(java.util.Date uteDt) {
		this.uteDt = uteDt;
	}
	/**
	 * 更新日期
	 * @return
	 */
	public java.util.Date getUteDt() {
		return uteDt;
	}

	public void setAuthTimes(Integer authTimes) {
		this.authTimes = authTimes;
	}
	/**
	 * 认证次数
	 * @return
	 */
	public Integer getAuthTimes() {
		return authTimes;
	}

	public void setIdTimes(Integer idTimes) {
		this.idTimes = idTimes;
	}
	/**
	 * 身份证认证次数
	 * @return
	 */
	public Integer getIdTimes() {
		return idTimes;
	}

	public void setIdSuccTimes(Integer idSuccTimes) {
		this.idSuccTimes = idSuccTimes;
	}
	/**
	 * 身份证成功认证次数
	 * @return
	 */
	public Integer getIdSuccTimes() {
		return idSuccTimes;
	}

	public void setBnkTimes(Integer bnkTimes) {
		this.bnkTimes = bnkTimes;
	}
	/**
	 * 银行卡认证次数
	 * @return
	 */
	public Integer getBnkTimes() {
		return bnkTimes;
	}

	public void setBnkSuccTimes(Integer bnkSuccTimes) {
		this.bnkSuccTimes = bnkSuccTimes;
	}
	/**
	 * 银行卡成功认证次数
	 * @return
	 */
	public Integer getBnkSuccTimes() {
		return bnkSuccTimes;
	}

	public void setLicTimes(Integer licTimes) {
		this.licTimes = licTimes;
	}
	/**
	 * 营业执照认证次数
	 * @return
	 */
	public Integer getLicTimes() {
		return licTimes;
	}

	public void setLicSuccTimes(Integer licSuccTimes) {
		this.licSuccTimes = licSuccTimes;
	}
	/**
	 * 营业执照成功认证次数
	 * @return
	 */
	public Integer getLicSuccTimes() {
		return licSuccTimes;
	}
}