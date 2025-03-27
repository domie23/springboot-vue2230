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
 * 体检服务
 *
 * @author 
 * @email
 */
@TableName("tijian")
public class TijianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianEntity() {

	}

	public TijianEntity(T t) {
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
     * 驿站
     */
    @ColumnInfo(comment="驿站",type="int(11)")
    @TableField(value = "jiankangyizhan_id")

    private Integer jiankangyizhanId;


    /**
     * 体检服务名称
     */
    @ColumnInfo(comment="体检服务名称",type="varchar(200)")
    @TableField(value = "tijian_name")

    private String tijianName;


    /**
     * 体检服务照片
     */
    @ColumnInfo(comment="体检服务照片",type="varchar(200)")
    @TableField(value = "tijian_photo")

    private String tijianPhoto;


    /**
     * 体检服务类型
     */
    @ColumnInfo(comment="体检服务类型",type="int(11)")
    @TableField(value = "tijian_types")

    private Integer tijianTypes;


    /**
     * 体检费用
     */
    @ColumnInfo(comment="体检费用",type="decimal(10,2)")
    @TableField(value = "tijian_price")

    private Double tijianPrice;


    /**
     * 体检服务热度
     */
    @ColumnInfo(comment="体检服务热度",type="int(11)")
    @TableField(value = "tijian_clicknum")

    private Integer tijianClicknum;


    /**
     * 体检服务介绍
     */
    @ColumnInfo(comment="体检服务介绍",type="longtext")
    @TableField(value = "tijian_content")

    private String tijianContent;


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
	 * 获取：驿站
	 */
    public Integer getJiankangyizhanId() {
        return jiankangyizhanId;
    }
    /**
	 * 设置：驿站
	 */

    public void setJiankangyizhanId(Integer jiankangyizhanId) {
        this.jiankangyizhanId = jiankangyizhanId;
    }
    /**
	 * 获取：体检服务名称
	 */
    public String getTijianName() {
        return tijianName;
    }
    /**
	 * 设置：体检服务名称
	 */

    public void setTijianName(String tijianName) {
        this.tijianName = tijianName;
    }
    /**
	 * 获取：体检服务照片
	 */
    public String getTijianPhoto() {
        return tijianPhoto;
    }
    /**
	 * 设置：体检服务照片
	 */

    public void setTijianPhoto(String tijianPhoto) {
        this.tijianPhoto = tijianPhoto;
    }
    /**
	 * 获取：体检服务类型
	 */
    public Integer getTijianTypes() {
        return tijianTypes;
    }
    /**
	 * 设置：体检服务类型
	 */

    public void setTijianTypes(Integer tijianTypes) {
        this.tijianTypes = tijianTypes;
    }
    /**
	 * 获取：体检费用
	 */
    public Double getTijianPrice() {
        return tijianPrice;
    }
    /**
	 * 设置：体检费用
	 */

    public void setTijianPrice(Double tijianPrice) {
        this.tijianPrice = tijianPrice;
    }
    /**
	 * 获取：体检服务热度
	 */
    public Integer getTijianClicknum() {
        return tijianClicknum;
    }
    /**
	 * 设置：体检服务热度
	 */

    public void setTijianClicknum(Integer tijianClicknum) {
        this.tijianClicknum = tijianClicknum;
    }
    /**
	 * 获取：体检服务介绍
	 */
    public String getTijianContent() {
        return tijianContent;
    }
    /**
	 * 设置：体检服务介绍
	 */

    public void setTijianContent(String tijianContent) {
        this.tijianContent = tijianContent;
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
        return "Tijian{" +
            ", id=" + id +
            ", jiankangyizhanId=" + jiankangyizhanId +
            ", tijianName=" + tijianName +
            ", tijianPhoto=" + tijianPhoto +
            ", tijianTypes=" + tijianTypes +
            ", tijianPrice=" + tijianPrice +
            ", tijianClicknum=" + tijianClicknum +
            ", tijianContent=" + tijianContent +
            ", dataDelete=" + dataDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
