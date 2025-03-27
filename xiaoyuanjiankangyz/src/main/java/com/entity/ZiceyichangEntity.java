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
 * 自测异常信息
 *
 * @author 
 * @email
 */
@TableName("ziceyichang")
public class ZiceyichangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZiceyichangEntity() {

	}

	public ZiceyichangEntity(T t) {
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
     * 标题
     */
    @ColumnInfo(comment="标题",type="varchar(200)")
    @TableField(value = "ziceyichang_name")

    private String ziceyichangName;


    /**
     * 隔离人名称
     */
    @ColumnInfo(comment="隔离人名称",type="varchar(200)")
    @TableField(value = "ziceyichang_mingc")

    private String ziceyichangMingc;


    /**
     * 体温
     */
    @ColumnInfo(comment="体温",type="decimal(10,2)")
    @TableField(value = "ziceyichang_tiwen")

    private Double ziceyichangTiwen;


    /**
     * 隔离状态
     */
    @ColumnInfo(comment="隔离状态",type="int(11)")
    @TableField(value = "ziceyichang_types")

    private Integer ziceyichangTypes;


    /**
     * 详情信息
     */
    @ColumnInfo(comment="详情信息",type="longtext")
    @TableField(value = "ziceyichang_text")

    private String ziceyichangText;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="记录时间",type="timestamp")
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
	 * 获取：标题
	 */
    public String getZiceyichangName() {
        return ziceyichangName;
    }
    /**
	 * 设置：标题
	 */

    public void setZiceyichangName(String ziceyichangName) {
        this.ziceyichangName = ziceyichangName;
    }
    /**
	 * 获取：隔离人名称
	 */
    public String getZiceyichangMingc() {
        return ziceyichangMingc;
    }
    /**
	 * 设置：隔离人名称
	 */

    public void setZiceyichangMingc(String ziceyichangMingc) {
        this.ziceyichangMingc = ziceyichangMingc;
    }
    /**
	 * 获取：体温
	 */
    public Double getZiceyichangTiwen() {
        return ziceyichangTiwen;
    }
    /**
	 * 设置：体温
	 */

    public void setZiceyichangTiwen(Double ziceyichangTiwen) {
        this.ziceyichangTiwen = ziceyichangTiwen;
    }
    /**
	 * 获取：隔离状态
	 */
    public Integer getZiceyichangTypes() {
        return ziceyichangTypes;
    }
    /**
	 * 设置：隔离状态
	 */

    public void setZiceyichangTypes(Integer ziceyichangTypes) {
        this.ziceyichangTypes = ziceyichangTypes;
    }
    /**
	 * 获取：详情信息
	 */
    public String getZiceyichangText() {
        return ziceyichangText;
    }
    /**
	 * 设置：详情信息
	 */

    public void setZiceyichangText(String ziceyichangText) {
        this.ziceyichangText = ziceyichangText;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：记录时间
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
        return "Ziceyichang{" +
            ", id=" + id +
            ", jiankangyizhanId=" + jiankangyizhanId +
            ", ziceyichangName=" + ziceyichangName +
            ", ziceyichangMingc=" + ziceyichangMingc +
            ", ziceyichangTiwen=" + ziceyichangTiwen +
            ", ziceyichangTypes=" + ziceyichangTypes +
            ", ziceyichangText=" + ziceyichangText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
