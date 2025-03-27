package com.entity.vo;

import com.entity.TijianYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tijian_yuyue")
public class TijianYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 预约编号
     */

    @TableField(value = "tijian_yuyue_uuid_number")
    private String tijianYuyueUuidNumber;


    /**
     * 体检服务
     */

    @TableField(value = "tijian_id")
    private Integer tijianId;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tijian_yuyue_time")
    private Date tijianYuyueTime;


    /**
     * 预约备注
     */

    @TableField(value = "tijian_yuyue_text")
    private String tijianYuyueText;


    /**
     * 预约状态
     */

    @TableField(value = "tijian_yuyue_yesno_types")
    private Integer tijianYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "tijian_yuyue_yesno_text")
    private String tijianYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "tijian_yuyue_shenhe_time")
    private Date tijianYuyueShenheTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：预约编号
	 */
    public String getTijianYuyueUuidNumber() {
        return tijianYuyueUuidNumber;
    }


    /**
	 * 获取：预约编号
	 */

    public void setTijianYuyueUuidNumber(String tijianYuyueUuidNumber) {
        this.tijianYuyueUuidNumber = tijianYuyueUuidNumber;
    }
    /**
	 * 设置：体检服务
	 */
    public Integer getTijianId() {
        return tijianId;
    }


    /**
	 * 获取：体检服务
	 */

    public void setTijianId(Integer tijianId) {
        this.tijianId = tijianId;
    }
    /**
	 * 设置：学生
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：学生
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getTijianYuyueTime() {
        return tijianYuyueTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setTijianYuyueTime(Date tijianYuyueTime) {
        this.tijianYuyueTime = tijianYuyueTime;
    }
    /**
	 * 设置：预约备注
	 */
    public String getTijianYuyueText() {
        return tijianYuyueText;
    }


    /**
	 * 获取：预约备注
	 */

    public void setTijianYuyueText(String tijianYuyueText) {
        this.tijianYuyueText = tijianYuyueText;
    }
    /**
	 * 设置：预约状态
	 */
    public Integer getTijianYuyueYesnoTypes() {
        return tijianYuyueYesnoTypes;
    }


    /**
	 * 获取：预约状态
	 */

    public void setTijianYuyueYesnoTypes(Integer tijianYuyueYesnoTypes) {
        this.tijianYuyueYesnoTypes = tijianYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getTijianYuyueYesnoText() {
        return tijianYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setTijianYuyueYesnoText(String tijianYuyueYesnoText) {
        this.tijianYuyueYesnoText = tijianYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getTijianYuyueShenheTime() {
        return tijianYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setTijianYuyueShenheTime(Date tijianYuyueShenheTime) {
        this.tijianYuyueShenheTime = tijianYuyueShenheTime;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
