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
 * 体检预约
 *
 * @author 
 * @email
 */
@TableName("tijian_yuyue")
public class TijianYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public TijianYuyueEntity() {

	}

	public TijianYuyueEntity(T t) {
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
     * 预约编号
     */
    @ColumnInfo(comment="预约编号",type="varchar(200)")
    @TableField(value = "tijian_yuyue_uuid_number")

    private String tijianYuyueUuidNumber;


    /**
     * 体检服务
     */
    @ColumnInfo(comment="体检服务",type="int(11)")
    @TableField(value = "tijian_id")

    private Integer tijianId;


    /**
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "tijian_yuyue_time")

    private Date tijianYuyueTime;


    /**
     * 预约备注
     */
    @ColumnInfo(comment="预约备注",type="longtext")
    @TableField(value = "tijian_yuyue_text")

    private String tijianYuyueText;


    /**
     * 预约状态
     */
    @ColumnInfo(comment="预约状态",type="int(11)")
    @TableField(value = "tijian_yuyue_yesno_types")

    private Integer tijianYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "tijian_yuyue_yesno_text")

    private String tijianYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "tijian_yuyue_shenhe_time")

    private Date tijianYuyueShenheTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：预约编号
	 */
    public String getTijianYuyueUuidNumber() {
        return tijianYuyueUuidNumber;
    }
    /**
	 * 设置：预约编号
	 */

    public void setTijianYuyueUuidNumber(String tijianYuyueUuidNumber) {
        this.tijianYuyueUuidNumber = tijianYuyueUuidNumber;
    }
    /**
	 * 获取：体检服务
	 */
    public Integer getTijianId() {
        return tijianId;
    }
    /**
	 * 设置：体检服务
	 */

    public void setTijianId(Integer tijianId) {
        this.tijianId = tijianId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getTijianYuyueTime() {
        return tijianYuyueTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setTijianYuyueTime(Date tijianYuyueTime) {
        this.tijianYuyueTime = tijianYuyueTime;
    }
    /**
	 * 获取：预约备注
	 */
    public String getTijianYuyueText() {
        return tijianYuyueText;
    }
    /**
	 * 设置：预约备注
	 */

    public void setTijianYuyueText(String tijianYuyueText) {
        this.tijianYuyueText = tijianYuyueText;
    }
    /**
	 * 获取：预约状态
	 */
    public Integer getTijianYuyueYesnoTypes() {
        return tijianYuyueYesnoTypes;
    }
    /**
	 * 设置：预约状态
	 */

    public void setTijianYuyueYesnoTypes(Integer tijianYuyueYesnoTypes) {
        this.tijianYuyueYesnoTypes = tijianYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getTijianYuyueYesnoText() {
        return tijianYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setTijianYuyueYesnoText(String tijianYuyueYesnoText) {
        this.tijianYuyueYesnoText = tijianYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getTijianYuyueShenheTime() {
        return tijianYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setTijianYuyueShenheTime(Date tijianYuyueShenheTime) {
        this.tijianYuyueShenheTime = tijianYuyueShenheTime;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "TijianYuyue{" +
            ", id=" + id +
            ", tijianYuyueUuidNumber=" + tijianYuyueUuidNumber +
            ", tijianId=" + tijianId +
            ", yonghuId=" + yonghuId +
            ", tijianYuyueTime=" + DateUtil.convertString(tijianYuyueTime,"yyyy-MM-dd") +
            ", tijianYuyueText=" + tijianYuyueText +
            ", tijianYuyueYesnoTypes=" + tijianYuyueYesnoTypes +
            ", tijianYuyueYesnoText=" + tijianYuyueYesnoText +
            ", tijianYuyueShenheTime=" + DateUtil.convertString(tijianYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
