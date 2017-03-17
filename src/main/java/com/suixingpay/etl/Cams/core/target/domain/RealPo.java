package com.suixingpay.etl.Cams.core.target.domain;


import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.Enum.CreateEnum;
import com.suixingpay.example.Utils.Encryption.EncryptorEnum;
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
 * Created on: 2017-02-28 15:56:23
 */
@Entity
@Table(name = "ums.T_UMS_REAL")
public class RealPo{
	// REAL_ID
	@Id
	@Column(name = "REAL_ID")
	@ChangeFlag(systemCreate = CreateEnum.TYPE_UUID)
	private	String	realId;
	// 用户号
	@Column(name = "USR_ID")
    @ChangeFlag(alise = "USR_IN_NO")
	private	String	usrId;
	// 认证类型（02：2要素，03:3要素，04:4要素）
	@Column(name = "AUTH_TYPE")
    @ChangeFlag(alise = "AUTH_ELEMENT_TYPE")
	private	String	authType;
	
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
	// 显示银行卡账户
	@Column(name = "BNK_ACC_DIS")
    @ChangeFlag(alise = "DISP_ACC_NO")
	private	String	bnkAccDis;
	// 加密银行卡账户
	@Column(name = "BNK_ACC_ENC")
    @ChangeFlag(alise = "ENC_ACC_NO",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET,
            tagertEncryptType = EncryptorEnum.TYPE_UMS)
	private	String	bnkAccEnc;
	// 大行编号
	@Column(name = "BNK_CD")
	private	String	bnkCd;
	// 大行名称
	@Column(name = "BNK_NAME")
    @ChangeFlag(alise = "BNK_NM")
	private	String	bnkName;
	// 生效日期
	@Column(name = "BNK_EFF_DT")
	private	String	bnkEffDt;
	// 失效日期
	@Column(name = "BNK_EXP_DT")
	private	String	bnkExpDt;
	// 银行卡照路径
	@Column(name = "BNK_PATH")
	private	String	bnkPath;
	// 显示预留手机
	@Column(name = "MBL_NO_DIS")
    @ChangeFlag(alise = "DISP_MOBILE_PHONE")
	private	String	mblNoDis;
	// 加密预留手机
	@Column(name = "MBL_NO_ENC")
    @ChangeFlag(alise = "ENC_MOBILE_PHONE",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET,
            tagertEncryptType = EncryptorEnum.TYPE_UMS)
	private	String	mblNoEnc;
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
	// 认证状态(00:通过，01:待审核，02:拒绝，03：失效，04:审核中)
	@Column(name = "AUTH_STS")
    @ChangeFlag(alise = "AUTH_STATE",switcSTS = "0-02;1-00;2-01%03")
	private	String	authSts;
	// 拒绝原因
	@Column(name = "REJECT_REASON")
	private	String	rejectReason;
	// 申请日期
	@Column(name = "CTE_DT")
    @ChangeFlag(mergerDate = "CREATE_DATE@CREATE_TIME")
	private	java.util.Date	cteDt;
	// 更新日期
	@Column(name = "UTE_DT")
    @ChangeFlag(mergerDate = "APPROVAL_DATE@APPROVAL_TIME")
	private	java.util.Date	uteDt;

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public void setRealId(String realId) {
		this.realId = realId;
	}
	/**
	 * REAL_ID
	 * @return
	 */
	public String getRealId() {
		return realId;
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

	public void setAuthType(String authType) {
		this.authType = authType;
	}
	/**
	 * 认证类型（02：2要素，03:3要素，04:4要素）
	 * @return
	 */
	public String getAuthType() {
		return authType;
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

	public void setBnkAccDis(String bnkAccDis) {
		this.bnkAccDis = bnkAccDis;
	}
	/**
	 * 显示银行卡账户
	 * @return
	 */
	public String getBnkAccDis() {
		return bnkAccDis;
	}

	public void setBnkAccEnc(String bnkAccEnc) {
		this.bnkAccEnc = bnkAccEnc;
	}
	/**
	 * 加密银行卡账户
	 * @return
	 */
	public String getBnkAccEnc() {
		return bnkAccEnc;
	}

	public void setBnkCd(String bnkCd) {
		this.bnkCd = bnkCd;
	}
	/**
	 * 大行编号
	 * @return
	 */
	public String getBnkCd() {
		return bnkCd;
	}

	public void setBnkName(String bnkName) {
		this.bnkName = bnkName;
	}
	/**
	 * 大行名称
	 * @return
	 */
	public String getBnkName() {
		return bnkName;
	}

	public void setBnkEffDt(String bnkEffDt) {
		this.bnkEffDt = bnkEffDt;
	}
	/**
	 * 生效日期
	 * @return
	 */
	public String getBnkEffDt() {
		return bnkEffDt;
	}

	public void setBnkExpDt(String bnkExpDt) {
		this.bnkExpDt = bnkExpDt;
	}
	/**
	 * 失效日期
	 * @return
	 */
	public String getBnkExpDt() {
		return bnkExpDt;
	}

	public void setBnkPath(String bnkPath) {
		this.bnkPath = bnkPath;
	}
	/**
	 * 银行卡照路径
	 * @return
	 */
	public String getBnkPath() {
		return bnkPath;
	}

	public void setMblNoDis(String mblNoDis) {
		this.mblNoDis = mblNoDis;
	}
	/**
	 * 显示预留手机
	 * @return
	 */
	public String getMblNoDis() {
		return mblNoDis;
	}

	public void setMblNoEnc(String mblNoEnc) {
		this.mblNoEnc = mblNoEnc;
	}
	/**
	 * 加密预留手机
	 * @return
	 */
	public String getMblNoEnc() {
		return mblNoEnc;
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
	 * 认证状态(00:通过，01:待审核，02:拒绝，03：失效，04:审核中)
	 * @return
	 */
	public String getAuthSts() {
		return authSts;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
	/**
	 * 拒绝原因
	 * @return
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	public void setCteDt(java.util.Date cteDt) {
		this.cteDt = cteDt;
	}
	/**
	 * 申请日期
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
}