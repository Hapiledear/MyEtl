package com.suixingpay.example.core.uap.domain;

import com.suixingpay.turbo.framework.jpa.domain.BaseDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uap_class")
@DynamicUpdate
public class UapTClass implements BaseDomain {
	@Id
    private Integer id;
	
	@NotBlank(message="班级名字不能为空或者空串")
	@Length(min=2,max=10,message="名字必须由2~10个字组成")
	private String className;
	
	@Email(message="邮箱格式不正确")
	@Column(name="extra_abc")
	private String extra;
	
	
	public UapTClass() {
		super();
	}

	public UapTClass(String className) {
		super();
		this.className = className;
	}

    @Override public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	
	
}
