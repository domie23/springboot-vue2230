package com.entity.vo;

import com.entity.JiankangyizhanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 健康驿站
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangyizhan")
public class JiankangyizhanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 驿站名称
     */

    @TableField(value = "jiankangyizhan_name")
    private String jiankangyizhanName;


    /**
     * 驿站照片
     */

    @TableField(value = "jiankangyizhan_photo")
    private String jiankangyizhanPhoto;


    /**
     * 驿站地址
     */

    @TableField(value = "jiankangyizhan_address")
    private String jiankangyizhanAddress;


    /**
     * 负责人
     */

    @TableField(value = "jiankangyizhan_fzr")
    private String jiankangyizhanFzr;


    /**
     * 联系方式
     */

    @TableField(value = "jiankangyizhan_phone")
    private String jiankangyizhanPhone;


    /**
     * 驿站类型
     */

    @TableField(value = "jiankangyizhan_types")
    private Integer jiankangyizhanTypes;


    /**
     * 驿站热度
     */

    @TableField(value = "jiankangyizhan_clicknum")
    private Integer jiankangyizhanClicknum;


    /**
     * 驿站介绍
     */

    @TableField(value = "jiankangyizhan_content")
    private String jiankangyizhanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "data_delete")
    private Integer dataDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：驿站名称
	 */
    public String getJiankangyizhanName() {
        return jiankangyizhanName;
    }


    /**
	 * 获取：驿站名称
	 */

    public void setJiankangyizhanName(String jiankangyizhanName) {
        this.jiankangyizhanName = jiankangyizhanName;
    }
    /**
	 * 设置：驿站照片
	 */
    public String getJiankangyizhanPhoto() {
        return jiankangyizhanPhoto;
    }


    /**
	 * 获取：驿站照片
	 */

    public void setJiankangyizhanPhoto(String jiankangyizhanPhoto) {
        this.jiankangyizhanPhoto = jiankangyizhanPhoto;
    }
    /**
	 * 设置：驿站地址
	 */
    public String getJiankangyizhanAddress() {
        return jiankangyizhanAddress;
    }


    /**
	 * 获取：驿站地址
	 */

    public void setJiankangyizhanAddress(String jiankangyizhanAddress) {
        this.jiankangyizhanAddress = jiankangyizhanAddress;
    }
    /**
	 * 设置：负责人
	 */
    public String getJiankangyizhanFzr() {
        return jiankangyizhanFzr;
    }


    /**
	 * 获取：负责人
	 */

    public void setJiankangyizhanFzr(String jiankangyizhanFzr) {
        this.jiankangyizhanFzr = jiankangyizhanFzr;
    }
    /**
	 * 设置：联系方式
	 */
    public String getJiankangyizhanPhone() {
        return jiankangyizhanPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setJiankangyizhanPhone(String jiankangyizhanPhone) {
        this.jiankangyizhanPhone = jiankangyizhanPhone;
    }
    /**
	 * 设置：驿站类型
	 */
    public Integer getJiankangyizhanTypes() {
        return jiankangyizhanTypes;
    }


    /**
	 * 获取：驿站类型
	 */

    public void setJiankangyizhanTypes(Integer jiankangyizhanTypes) {
        this.jiankangyizhanTypes = jiankangyizhanTypes;
    }
    /**
	 * 设置：驿站热度
	 */
    public Integer getJiankangyizhanClicknum() {
        return jiankangyizhanClicknum;
    }


    /**
	 * 获取：驿站热度
	 */

    public void setJiankangyizhanClicknum(Integer jiankangyizhanClicknum) {
        this.jiankangyizhanClicknum = jiankangyizhanClicknum;
    }
    /**
	 * 设置：驿站介绍
	 */
    public String getJiankangyizhanContent() {
        return jiankangyizhanContent;
    }


    /**
	 * 获取：驿站介绍
	 */

    public void setJiankangyizhanContent(String jiankangyizhanContent) {
        this.jiankangyizhanContent = jiankangyizhanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getDataDelete() {
        return dataDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setDataDelete(Integer dataDelete) {
        this.dataDelete = dataDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
