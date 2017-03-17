package com.suixingpay.etl.Cams.core.target.domain;

import com.suixingpay.example.ChangeFlag;
import com.suixingpay.example.Enum.CreateEnum;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 个人用户信息表
 * @author huyou
 *
 */
@Entity
@Table(name="UMS.T_UMS_USR_PSN")
@DynamicUpdate(true)
public class UsrPsnPo{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="USR_PSN_ID")
	@ChangeFlag(systemCreate = CreateEnum.TYPE_UUID)
	private String usrPsnId;//UUID
	
	@Column(name="USR_ID")
    @ChangeFlag(alise = "USR_IN_NO")
	private String usrId;//用户号
	
	@Column(name="NM_CN")
    @ChangeFlag(alise = "NICK_NAME")
	private String nmCn;//用户姓名（中文）
	
	@Column(name="NM_EN")
	private String nmEn;//用户姓名(英文或者拼音)
	
	@Column(name="GENDAR")
	private String gendar; //性别(0:男,1:女)
	
	@Column(name="BRD_Y")
    @ChangeFlag(alise = "BIRTH_YEAR")
	private  String brdY; //出生日期（年）	
	
	@Column(name="BRD_M")
    @ChangeFlag(alise = "BIRTH_MONTH")
	private String brdM; //出生日期（月）
	
	@Column(name="BRD_D")
    @ChangeFlag(alise = "BIRTH_DAY")
	private  String brdD;//出生日期（日）

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public String getUsrPsnId() {
		return usrPsnId;
	}

	public void setUsrPsnId(String usrPsnId) {
		this.usrPsnId = usrPsnId;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getNmCn() {
		return nmCn;
	}

	public void setNmCn(String nmCn) {
		this.nmCn = nmCn;
	}

	public String getNmEn() {
		return nmEn;
	}

	public void setNmEn(String nmEn) {
		this.nmEn = nmEn;
	}

	public String getGendar() {
		return gendar;
	}

	public void setGendar(String gendar) {
		this.gendar = gendar;
	}

	public String getBrdY() {
		return brdY;
	}

	public void setBrdY(String brdY) {
		this.brdY = brdY;
	}

	public String getBrdM() {
		return brdM;
	}

	public void setBrdM(String brdM) {
		this.brdM = brdM;
	}

	public String getBrdD() {
		return brdD;
	}

	public void setBrdD(String brdD) {
		this.brdD = brdD;
	}
	
	

}
