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
 * 学生请假
 *
 * @author 
 * @email
 */
@TableName("yonghuqingjia")
public class YonghuqingjiaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YonghuqingjiaEntity() {

	}

	public YonghuqingjiaEntity(T t) {
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
     * 学生
     */
    @ColumnInfo(comment="学生",type="int(200)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 请假缘由
     */
    @ColumnInfo(comment="请假缘由",type="longtext")
    @TableField(value = "yonghuqingjia_text")

    private String yonghuqingjiaText;


    /**
     * 请假类型
     */
    @ColumnInfo(comment="请假类型",type="int(11)")
    @TableField(value = "yonghuqingjia_types")

    private Integer yonghuqingjiaTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="申请时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 请假时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="请假时间",type="timestamp")
    @TableField(value = "yonghuqingjia_time")

    private Date yonghuqingjiaTime;


    /**
     * 请假天数
     */
    @ColumnInfo(comment="请假天数",type="int(200)")
    @TableField(value = "yonghuqingjia_number")

    private Integer yonghuqingjiaNumber;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "yonghuqingjia_yesno_types")

    private Integer yonghuqingjiaYesnoTypes;


    /**
     * 处理意见
     */
    @ColumnInfo(comment="处理意见",type="longtext")
    @TableField(value = "yonghuqingjia_yesno_text")

    private String yonghuqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "yonghuqingjia_shenhe_time")

    private Date yonghuqingjiaShenheTime;


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
	 * 获取：请假缘由
	 */
    public String getYonghuqingjiaText() {
        return yonghuqingjiaText;
    }
    /**
	 * 设置：请假缘由
	 */

    public void setYonghuqingjiaText(String yonghuqingjiaText) {
        this.yonghuqingjiaText = yonghuqingjiaText;
    }
    /**
	 * 获取：请假类型
	 */
    public Integer getYonghuqingjiaTypes() {
        return yonghuqingjiaTypes;
    }
    /**
	 * 设置：请假类型
	 */

    public void setYonghuqingjiaTypes(Integer yonghuqingjiaTypes) {
        this.yonghuqingjiaTypes = yonghuqingjiaTypes;
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
	 * 获取：请假时间
	 */
    public Date getYonghuqingjiaTime() {
        return yonghuqingjiaTime;
    }
    /**
	 * 设置：请假时间
	 */

    public void setYonghuqingjiaTime(Date yonghuqingjiaTime) {
        this.yonghuqingjiaTime = yonghuqingjiaTime;
    }
    /**
	 * 获取：请假天数
	 */
    public Integer getYonghuqingjiaNumber() {
        return yonghuqingjiaNumber;
    }
    /**
	 * 设置：请假天数
	 */

    public void setYonghuqingjiaNumber(Integer yonghuqingjiaNumber) {
        this.yonghuqingjiaNumber = yonghuqingjiaNumber;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getYonghuqingjiaYesnoTypes() {
        return yonghuqingjiaYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setYonghuqingjiaYesnoTypes(Integer yonghuqingjiaYesnoTypes) {
        this.yonghuqingjiaYesnoTypes = yonghuqingjiaYesnoTypes;
    }
    /**
	 * 获取：处理意见
	 */
    public String getYonghuqingjiaYesnoText() {
        return yonghuqingjiaYesnoText;
    }
    /**
	 * 设置：处理意见
	 */

    public void setYonghuqingjiaYesnoText(String yonghuqingjiaYesnoText) {
        this.yonghuqingjiaYesnoText = yonghuqingjiaYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getYonghuqingjiaShenheTime() {
        return yonghuqingjiaShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setYonghuqingjiaShenheTime(Date yonghuqingjiaShenheTime) {
        this.yonghuqingjiaShenheTime = yonghuqingjiaShenheTime;
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
        return "Yonghuqingjia{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yonghuqingjiaText=" + yonghuqingjiaText +
            ", yonghuqingjiaTypes=" + yonghuqingjiaTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", yonghuqingjiaTime=" + DateUtil.convertString(yonghuqingjiaTime,"yyyy-MM-dd") +
            ", yonghuqingjiaNumber=" + yonghuqingjiaNumber +
            ", yonghuqingjiaYesnoTypes=" + yonghuqingjiaYesnoTypes +
            ", yonghuqingjiaYesnoText=" + yonghuqingjiaYesnoText +
            ", yonghuqingjiaShenheTime=" + DateUtil.convertString(yonghuqingjiaShenheTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
