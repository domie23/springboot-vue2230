package com.entity.model;

import com.entity.TijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 体检服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class TijianModel implements Serializable {
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
     * 体检服务名称
     */
    private String tijianName;


    /**
     * 体检服务照片
     */
    private String tijianPhoto;


    /**
     * 体检服务类型
     */
    private Integer tijianTypes;


    /**
     * 体检费用
     */
    private Double tijianPrice;


    /**
     * 体检服务热度
     */
    private Integer tijianClicknum;


    /**
     * 体检服务介绍
     */
    private String tijianContent;


    /**
     * 逻辑删除
     */
    private Integer dataDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
