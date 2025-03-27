package com.entity.model;

import com.entity.JiankangyizhanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 健康驿站
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiankangyizhanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 驿站名称
     */
    private String jiankangyizhanName;


    /**
     * 驿站照片
     */
    private String jiankangyizhanPhoto;


    /**
     * 驿站地址
     */
    private String jiankangyizhanAddress;


    /**
     * 负责人
     */
    private String jiankangyizhanFzr;


    /**
     * 联系方式
     */
    private String jiankangyizhanPhone;


    /**
     * 驿站类型
     */
    private Integer jiankangyizhanTypes;


    /**
     * 驿站热度
     */
    private Integer jiankangyizhanClicknum;


    /**
     * 驿站介绍
     */
    private String jiankangyizhanContent;


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
	 * 获取：驿站名称
	 */
    public String getJiankangyizhanName() {
        return jiankangyizhanName;
    }


    /**
	 * 设置：驿站名称
	 */
    public void setJiankangyizhanName(String jiankangyizhanName) {
        this.jiankangyizhanName = jiankangyizhanName;
    }
    /**
	 * 获取：驿站照片
	 */
    public String getJiankangyizhanPhoto() {
        return jiankangyizhanPhoto;
    }


    /**
	 * 设置：驿站照片
	 */
    public void setJiankangyizhanPhoto(String jiankangyizhanPhoto) {
        this.jiankangyizhanPhoto = jiankangyizhanPhoto;
    }
    /**
	 * 获取：驿站地址
	 */
    public String getJiankangyizhanAddress() {
        return jiankangyizhanAddress;
    }


    /**
	 * 设置：驿站地址
	 */
    public void setJiankangyizhanAddress(String jiankangyizhanAddress) {
        this.jiankangyizhanAddress = jiankangyizhanAddress;
    }
    /**
	 * 获取：负责人
	 */
    public String getJiankangyizhanFzr() {
        return jiankangyizhanFzr;
    }


    /**
	 * 设置：负责人
	 */
    public void setJiankangyizhanFzr(String jiankangyizhanFzr) {
        this.jiankangyizhanFzr = jiankangyizhanFzr;
    }
    /**
	 * 获取：联系方式
	 */
    public String getJiankangyizhanPhone() {
        return jiankangyizhanPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setJiankangyizhanPhone(String jiankangyizhanPhone) {
        this.jiankangyizhanPhone = jiankangyizhanPhone;
    }
    /**
	 * 获取：驿站类型
	 */
    public Integer getJiankangyizhanTypes() {
        return jiankangyizhanTypes;
    }


    /**
	 * 设置：驿站类型
	 */
    public void setJiankangyizhanTypes(Integer jiankangyizhanTypes) {
        this.jiankangyizhanTypes = jiankangyizhanTypes;
    }
    /**
	 * 获取：驿站热度
	 */
    public Integer getJiankangyizhanClicknum() {
        return jiankangyizhanClicknum;
    }


    /**
	 * 设置：驿站热度
	 */
    public void setJiankangyizhanClicknum(Integer jiankangyizhanClicknum) {
        this.jiankangyizhanClicknum = jiankangyizhanClicknum;
    }
    /**
	 * 获取：驿站介绍
	 */
    public String getJiankangyizhanContent() {
        return jiankangyizhanContent;
    }


    /**
	 * 设置：驿站介绍
	 */
    public void setJiankangyizhanContent(String jiankangyizhanContent) {
        this.jiankangyizhanContent = jiankangyizhanContent;
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
