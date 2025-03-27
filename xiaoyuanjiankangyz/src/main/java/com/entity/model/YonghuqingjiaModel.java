package com.entity.model;

import com.entity.YonghuqingjiaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学生请假
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YonghuqingjiaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 学生
     */
    private Integer yonghuId;


    /**
     * 请假缘由
     */
    private String yonghuqingjiaText;


    /**
     * 请假类型
     */
    private Integer yonghuqingjiaTypes;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 请假时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yonghuqingjiaTime;


    /**
     * 请假天数
     */
    private Integer yonghuqingjiaNumber;


    /**
     * 申请状态
     */
    private Integer yonghuqingjiaYesnoTypes;


    /**
     * 处理意见
     */
    private String yonghuqingjiaYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yonghuqingjiaShenheTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
