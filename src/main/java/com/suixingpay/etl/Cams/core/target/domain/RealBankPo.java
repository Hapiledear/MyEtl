package com.suixingpay.etl.Cams.core.target.domain;

import com.suixingpay.sourceCode.ChangeFlag;
import com.suixingpay.sourceCode.Enum.CreateEnum;
import com.suixingpay.sourceCode.Utils.Encryption.EncryptorEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description: 用户实名银行卡 Po
 * Copyright: ©2017 suixingpay. All rights reserved.
 * @author yanghuang
 * Created on: 2017-03-20 09:48:58
 */
@Entity
@Table(name = "ums.T_UMS_REAL_BNK")
public class RealBankPo {
	// REAL_BNK_ID
	@Id
	@Column(name = "REAL_BNK_ID")
	@ChangeFlag(systemCreate = CreateEnum.TYPE_UUID)
	private	String	realBnkId;
	// REAL_USR_ID
	@Column(name = "REAL_USR_ID")
	@ChangeFlag(alise = "USR_IN_NO")
	private	String	realUsrId;
	// 用户号
	@Column(name = "USR_ID")
    @ChangeFlag(alise = "USR_IN_NO")
	private	String	usrId;
	// 银行卡号
	@Column(name = "BNK_ACC")
    @ChangeFlag(alise = "ENC_ACC_NO",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET)
	private	String	bnkAcc;
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

    //手机号
    @Column(name = "MBL_NO")
    @ChangeFlag(alise = "ENC_MOBILE_PHONE",
            sourceEncryptType = EncryptorEnum.TYPE_WALLET)
    private String mblNo;

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
    @ChangeFlag(mergerDate = "APPROVAL_DATE@APPROVAL_TIME")
	private	java.util.Date	uteDt;

	@Override public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

    public String getMblNo() {
        return mblNo;
    }

    public void setMblNo(String mblNo) {
        this.mblNo = mblNo;
    }

    public void setRealBnkId(String realBnkId) {
		this.realBnkId = realBnkId;
	}
	/**
	 * REAL_BNK_ID
	 * @return
	 */
	public String getRealBnkId() {
		return realBnkId;
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

	public void setBnkAcc(String bnkAcc) {
		this.bnkAcc = bnkAcc;
	}
	/**
	 * 银行卡号
	 * @return
	 */
	public String getBnkAcc() {
		return bnkAcc;
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
}