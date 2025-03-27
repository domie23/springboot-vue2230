package com.entity.vo;

import com.entity.YonghuqingjiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 学生请假
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yonghuqingjia")
public class YonghuqingjiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 请假缘由
     */

    @TableField(value = "yonghuqingjia_text")
    private String yonghuqingjiaText;


    /**
     * 请假类型
     */

    @TableField(value = "yonghuqingjia_types")
    private Integer yonghuqingjiaTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 请假时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yonghuqingjia_time")
    private Date yonghuqingjiaTime;


    /**
     * 请假天数
     */

    @TableField(value = "yonghuqingjia_number")
    private Integer yonghuqingjiaNumber;


    /**
     * 申请状态
     */

    @TableField(value = "yonghuqingjia_yesno_types")
    private Integer yonghuqingjiaYesnoTypes;


    /**
     * 处理意见
     */

    @TableField(value = "yonghuqingjia_yesno_text")
    private String yonghuqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yonghuqingjia_shenhe_time")
    private Date yonghuqingjiaShenheTime;


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
	 * 设置：请假缘由
	 */
    public String getYonghuqingjiaText() {
        return yonghuqingjiaText;
    }


    /**
	 * 获取：请假缘由
	 */

    public void setYonghuqingjiaText(String yonghuqingjiaText) {
        this.yonghuqingjiaText = yonghuqingjiaText;
    }
    /**
	 * 设置：请假类型
	 */
    public Integer getYonghuqingjiaTypes() {
        return yonghuqingjiaTypes;
    }


    /**
	 * 获取：请假类型
	 */

    public void setYonghuqingjiaTypes(Integer yonghuqingjiaTypes) {
        this.yonghuqingjiaTypes = yonghuqingjiaTypes;
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
	 * 设置：请假时间
	 */
    public Date getYonghuqingjiaTime() {
        return yonghuqingjiaTime;
    }


    /**
	 * 获取：请假时间
	 */

    public void setYonghuqingjiaTime(Date yonghuqingjiaTime) {
        this.yonghuqingjiaTime = yonghuqingjiaTime;
    }
    /**
	 * 设置：请假天数
	 */
    public Integer getYonghuqingjiaNumber() {
        return yonghuqingjiaNumber;
    }


    /**
	 * 获取：请假天数
	 */

    public void setYonghuqingjiaNumber(Integer yonghuqingjiaNumber) {
        this.yonghuqingjiaNumber = yonghuqingjiaNumber;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getYonghuqingjiaYesnoTypes() {
        return yonghuqingjiaYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setYonghuqingjiaYesnoTypes(Integer yonghuqingjiaYesnoTypes) {
        this.yonghuqingjiaYesnoTypes = yonghuqingjiaYesnoTypes;
    }
    /**
	 * 设置：处理意见
	 */
    public String getYonghuqingjiaYesnoText() {
        return yonghuqingjiaYesnoText;
    }


    /**
	 * 获取：处理意见
	 */

    public void setYonghuqingjiaYesnoText(String yonghuqingjiaYesnoText) {
        this.yonghuqingjiaYesnoText = yonghuqingjiaYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getYonghuqingjiaShenheTime() {
        return yonghuqingjiaShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setYonghuqingjiaShenheTime(Date yonghuqingjiaShenheTime) {
        this.yonghuqingjiaShenheTime = yonghuqingjiaShenheTime;
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
