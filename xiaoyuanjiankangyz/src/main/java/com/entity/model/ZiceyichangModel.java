package com.entity.model;

import com.entity.ZiceyichangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 自测异常信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZiceyichangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 驿站
     */
    private Integer jiankangyizhanId;


    /**
     * 标题
     */
    private String ziceyichangName;


    /**
     * 隔离人名称
     */
    private String ziceyichangMingc;


    /**
     * 体温
     */
    private Double ziceyichangTiwen;


    /**
     * 隔离状态
     */
    private Integer ziceyichangTypes;


    /**
     * 详情信息
     */
    private String ziceyichangText;


    /**
     * 记录时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
