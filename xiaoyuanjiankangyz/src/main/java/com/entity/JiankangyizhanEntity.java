package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 健康驿站
 *
 * @author 
 * @email
 */
@TableName("jiankangyizhan")
public class JiankangyizhanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangyizhanEntity() {

	}

	public JiankangyizhanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 驿站名称
     */
    @ColumnInfo(comment="驿站名称",type="varchar(200)")
    @TableField(value = "jiankangyizhan_name")

    private String jiankangyizhanName;


    /**
     * 驿站照片
     */
    @ColumnInfo(comment="驿站照片",type="varchar(200)")
    @TableField(value = "jiankangyizhan_photo")

    private String jiankangyizhanPhoto;


    /**
     * 驿站地址
     */
    @ColumnInfo(comment="驿站地址",type="varchar(200)")
    @TableField(value = "jiankangyizhan_address")

    private String jiankangyizhanAddress;


    /**
     * 负责人
     */
    @ColumnInfo(comment="负责人",type="varchar(200)")
    @TableField(value = "jiankangyizhan_fzr")

    private String jiankangyizhanFzr;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "jiankangyizhan_phone")

    private String jiankangyizhanPhone;


    /**
     * 驿站类型
     */
    @ColumnInfo(comment="驿站类型",type="int(11)")
    @TableField(value = "jiankangyizhan_types")

    private Integer jiankangyizhanTypes;


    /**
     * 驿站热度
     */
    @ColumnInfo(comment="驿站热度",type="int(11)")
    @TableField(value = "jiankangyizhan_clicknum")

    private Integer jiankangyizhanClicknum;


    /**
     * 驿站介绍
     */
    @ColumnInfo(comment="驿站介绍",type="longtext")
    @TableField(value = "jiankangyizhan_content")

    private String jiankangyizhanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "data_delete")

    private Integer dataDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：驿站名称
	 */
    public String getJiankangyizhanName() {
        return jiankangyizhanName;
    }
    /**
	 * 设置：驿站名称
	 */

    public void setJiankangyizhanName(String jiankangyizhanName) {
        this.jiankangyizhanName = jiankangyizhanName;
    }
    /**
	 * 获取：驿站照片
	 */
    public String getJiankangyizhanPhoto() {
        return jiankangyizhanPhoto;
    }
    /**
	 * 设置：驿站照片
	 */

    public void setJiankangyizhanPhoto(String jiankangyizhanPhoto) {
        this.jiankangyizhanPhoto = jiankangyizhanPhoto;
    }
    /**
	 * 获取：驿站地址
	 */
    public String getJiankangyizhanAddress() {
        return jiankangyizhanAddress;
    }
    /**
	 * 设置：驿站地址
	 */

    public void setJiankangyizhanAddress(String jiankangyizhanAddress) {
        this.jiankangyizhanAddress = jiankangyizhanAddress;
    }
    /**
	 * 获取：负责人
	 */
    public String getJiankangyizhanFzr() {
        return jiankangyizhanFzr;
    }
    /**
	 * 设置：负责人
	 */

    public void setJiankangyizhanFzr(String jiankangyizhanFzr) {
        this.jiankangyizhanFzr = jiankangyizhanFzr;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiankangyizhanPhone() {
        return jiankangyizhanPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setJiankangyizhanPhone(String jiankangyizhanPhone) {
        this.jiankangyizhanPhone = jiankangyizhanPhone;
    }
    /**
	 * 获取：驿站类型
	 */
    public Integer getJiankangyizhanTypes() {
        return jiankangyizhanTypes;
    }
    /**
	 * 设置：驿站类型
	 */

    public void setJiankangyizhanTypes(Integer jiankangyizhanTypes) {
        this.jiankangyizhanTypes = jiankangyizhanTypes;
    }
    /**
	 * 获取：驿站热度
	 */
    public Integer getJiankangyizhanClicknum() {
        return jiankangyizhanClicknum;
    }
    /**
	 * 设置：驿站热度
	 */

    public void setJiankangyizhanClicknum(Integer jiankangyizhanClicknum) {
        this.jiankangyizhanClicknum = jiankangyizhanClicknum;
    }
    /**
	 * 获取：驿站介绍
	 */
    public String getJiankangyizhanContent() {
        return jiankangyizhanContent;
    }
    /**
	 * 设置：驿站介绍
	 */

    public void setJiankangyizhanContent(String jiankangyizhanContent) {
        this.jiankangyizhanContent = jiankangyizhanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getDataDelete() {
        return dataDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiankangyizhan{" +
            ", id=" + id +
            ", jiankangyizhanName=" + jiankangyizhanName +
            ", jiankangyizhanPhoto=" + jiankangyizhanPhoto +
            ", jiankangyizhanAddress=" + jiankangyizhanAddress +
            ", jiankangyizhanFzr=" + jiankangyizhanFzr +
            ", jiankangyizhanPhone=" + jiankangyizhanPhone +
            ", jiankangyizhanTypes=" + jiankangyizhanTypes +
            ", jiankangyizhanClicknum=" + jiankangyizhanClicknum +
            ", jiankangyizhanContent=" + jiankangyizhanContent +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
