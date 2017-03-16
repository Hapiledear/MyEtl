/**
 * All rights Reserved, Designed By Suixingpay.
 *
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:11
 * @Copyright: ©2017 Suixingpay. All rights reserved.
 * 注意：本内容仅限于随行付支付有限公司内部传阅，禁止外泄以及用于其他的商业用途。
 */
package com.suixingpay.example.core.bap.domain;

import com.suixingpay.example.ChangeFlag;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * @Description: TODO
 * @author: yang_huang<yang_huang@suixingpay.com>
 * @date: 2017/3/15 15:11
 * @version: V1.0
 */
@Entity
@Table(name="bap_class")
public class BapTableClass {
    @Id
    @Column(name = "id")
    @ChangeFlag(systemCreate = "uuid")
    private Integer id;

    @Column(name = "className")
    @ChangeFlag(alise = "name")
    private String className;

    @Column(name = "defaultName")
    @ChangeFlag(defaultValue = "default")
    private String defaultName;


    @Transient
    @Column(name = "className")
    private String name;

    public BapTableClass() {
        super();
    }

    public BapTableClass(String className) {
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



}
