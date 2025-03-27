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
 * 每日健康填报
 *
 * @author 
 * @email
 */
@TableName("jiankangtianbao")
public class JiankangtianbaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiankangtianbaoEntity() {

	}

	public JiankangtianbaoEntity(T t) {
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
     * 填报标题
     */
    @ColumnInfo(comment="填报标题",type="varchar(200)")
    @TableField(value = "jiankangtianbao_name")

    private String jiankangtianbaoName;


    /**
     * 当前体温
     */
    @ColumnInfo(comment="当前体温",type="decimal(10,2)")
    @TableField(value = "jiankangtianbao_tiwen")

    private Double jiankangtianbaoTiwen;


    /**
     * 填报详情
     */
    @ColumnInfo(comment="填报详情",type="longtext")
    @TableField(value = "jiankangtianbao_text")

    private String jiankangtianbaoText;


    /**
     * 填报时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="填报时间",type="timestamp")
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
	 * 获取：填报标题
	 */
    public String getJiankangtianbaoName() {
        return jiankangtianbaoName;
    }
    /**
	 * 设置：填报标题
	 */

    public void setJiankangtianbaoName(String jiankangtianbaoName) {
        this.jiankangtianbaoName = jiankangtianbaoName;
    }
    /**
	 * 获取：当前体温
	 */
    public Double getJiankangtianbaoTiwen() {
        return jiankangtianbaoTiwen;
    }
    /**
	 * 设置：当前体温
	 */

    public void setJiankangtianbaoTiwen(Double jiankangtianbaoTiwen) {
        this.jiankangtianbaoTiwen = jiankangtianbaoTiwen;
    }
    /**
	 * 获取：填报详情
	 */
    public String getJiankangtianbaoText() {
        return jiankangtianbaoText;
    }
    /**
	 * 设置：填报详情
	 */

    public void setJiankangtianbaoText(String jiankangtianbaoText) {
        this.jiankangtianbaoText = jiankangtianbaoText;
    }
    /**
	 * 获取：填报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：填报时间
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
        return "Jiankangtianbao{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", jiankangtianbaoName=" + jiankangtianbaoName +
            ", jiankangtianbaoTiwen=" + jiankangtianbaoTiwen +
            ", jiankangtianbaoText=" + jiankangtianbaoText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
