package com.suixingpay.etl.Cams.core.target.domain;


import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.Enum.CreateEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户产品绑定关系表
 * @author huyou
 *
 */
@Entity
@Table(name="UMS.T_UMS_USR_PROD_BIND")
public class UsrProdBindPo {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USR_PROD_ID")
    @ChangeFlag(systemCreate = CreateEnum.TYPE_UUID)
	public String usrProdId; //标识uuid
	
	@Column(name="USR_ID")
    @ChangeFlag(alise = "USR_IN_NO")
	public String usrId; //用户号
	
	@Column(name="PROD_CD")
    @ChangeFlag(defaultValue = "900")
	public String prodCd; //产品编号
	
	@Column(name="PROD_NM")
    @ChangeFlag(defaultValue = "钱包")
	public String prodNm; //产品名称
	
	@Column(name="IN_MNO")
    @ChangeFlag(alise = "USR_IN_NO")
	public String inMno; //用户身份号
	
	@Column(name="STS")
    @ChangeFlag(defaultValue = "00")
	public String sts; //状态(00:绑定 01：解绑)
	
	@Column(name="SYS_ID")
    @ChangeFlag(defaultValue = "CAMS")
	public String sysId; //来源系统ID
	
	@Column(name="CTE_DT")
    @ChangeFlag(mergerDate = "REG_DATE@REG_TIME")
	public Date cteDt; //创建时间
	
	@Column(name="UTE_DT")
    @ChangeFlag(mergerDate = "UPDATE_DATE@UPDATE_TIME")
	public Date uteDt; //修改时间
	
	@Column(name="CTE_OPR")
	public String cteOpr; //首次创建人编号	
	
	@Column(name="UTE_OPR")
	public String uteOpr; //修改人编号

	public String getUsrProdId() {
		return usrProdId;
	}

	public void setUsrProdId(String usrProdId) {
		this.usrProdId = usrProdId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getProdCd() {
		return prodCd;
	}

	public void setProdCd(String prodCd) {
		this.prodCd = prodCd;
	}

	public String getProdNm() {
		return prodNm;
	}

	public void setProdNm(String prodNm) {
		this.prodNm = prodNm;
	}

	public String getInMno() {
		return inMno;
	}

	public void setInMno(String inMno) {
		this.inMno = inMno;
	}

	public String getSts() {
		return sts;
	}

	public void setSts(String sts) {
		this.sts = sts;
	}

	public String getSysId() {
		return sysId;
	}

	public void setSysId(String sysId) {
		this.sysId = sysId;
	}

	public Date getCteDt() {
		return cteDt;
	}

	public void setCteDt(Date cteDt) {
		this.cteDt = cteDt;
	}

	public Date getUteDt() {
		return uteDt;
	}

	public void setUteDt(Date uteDt) {
		this.uteDt = uteDt;
	}

	public String getCteOpr() {
		return cteOpr;
	}

	public void setCteOpr(String cteOpr) {
		this.cteOpr = cteOpr;
	}

	public String getUteOpr() {
		return uteOpr;
	}

	public void setUteOpr(String uteOpr) {
		this.uteOpr = uteOpr;
	}

	@Override
	public String toString() {
		return "UsrProdBindPo [usrProdId=" + usrProdId + ", usrId=" + usrId
				+ ", prodCd=" + prodCd + ", prodNm=" + prodNm + ", inMno="
				+ inMno + ", sts=" + sts + ", sysId=" + sysId + ", cteDt="
				+ cteDt + ", uteDt=" + uteDt + ", cteOpr=" + cteOpr
				+ ", uteOpr=" + uteOpr + "]";
	}
	

}
