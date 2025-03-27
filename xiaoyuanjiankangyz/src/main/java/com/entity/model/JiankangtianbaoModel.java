package com.entity.model;

import com.entity.JiankangtianbaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 每日健康填报
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangtianbaoModel implements Serializable {
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
     * 填报标题
     */
    private String jiankangtianbaoName;


    /**
     * 当前体温
     */
    private Double jiankangtianbaoTiwen;


    /**
     * 填报详情
     */
    private String jiankangtianbaoText;


    /**
     * 填报时间
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
