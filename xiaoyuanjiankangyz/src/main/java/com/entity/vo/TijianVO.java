package com.entity.vo;

import com.entity.TijianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 体检服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("tijian")
public class TijianVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 驿站
     */

    @TableField(value = "jiankangyizhan_id")
    private Integer jiankangyizhanId;


    /**
     * 体检服务名称
     */

    @TableField(value = "tijian_name")
    private String tijianName;


    /**
     * 体检服务照片
     */

    @TableField(value = "tijian_photo")
    private String tijianPhoto;


    /**
     * 体检服务类型
     */

    @TableField(value = "tijian_types")
    private Integer tijianTypes;


    /**
     * 体检费用
     */

    @TableField(value = "tijian_price")
    private Double tijianPrice;


    /**
     * 体检服务热度
     */

    @TableField(value = "tijian_clicknum")
    private Integer tijianClicknum;


    /**
     * 体检服务介绍
     */

    @TableField(value = "tijian_content")
    private String tijianContent;


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
	 * 设置：驿站
	 */
    public Integer getJiankangyizhanId() {
        return jiankangyizhanId;
    }


    /**
	 * 获取：驿站
	 */

    public void setJiankangyizhanId(Integer jiankangyizhanId) {
        this.jiankangyizhanId = jiankangyizhanId;
    }
    /**
	 * 设置：体检服务名称
	 */
    public String getTijianName() {
        return tijianName;
    }


    /**
	 * 获取：体检服务名称
	 */

    public void setTijianName(String tijianName) {
        this.tijianName = tijianName;
    }
    /**
	 * 设置：体检服务照片
	 */
    public String getTijianPhoto() {
        return tijianPhoto;
    }


    /**
	 * 获取：体检服务照片
	 */

    public void setTijianPhoto(String tijianPhoto) {
        this.tijianPhoto = tijianPhoto;
    }
    /**
	 * 设置：体检服务类型
	 */
    public Integer getTijianTypes() {
        return tijianTypes;
    }


    /**
	 * 获取：体检服务类型
	 */

    public void setTijianTypes(Integer tijianTypes) {
        this.tijianTypes = tijianTypes;
    }
    /**
	 * 设置：体检费用
	 */
    public Double getTijianPrice() {
        return tijianPrice;
    }


    /**
	 * 获取：体检费用
	 */

    public void setTijianPrice(Double tijianPrice) {
        this.tijianPrice = tijianPrice;
    }
    /**
	 * 设置：体检服务热度
	 */
    public Integer getTijianClicknum() {
        return tijianClicknum;
    }


    /**
	 * 获取：体检服务热度
	 */

    public void setTijianClicknum(Integer tijianClicknum) {
        this.tijianClicknum = tijianClicknum;
    }
    /**
	 * 设置：体检服务介绍
	 */
    public String getTijianContent() {
        return tijianContent;
    }


    /**
	 * 获取：体检服务介绍
	 */

    public void setTijianContent(String tijianContent) {
        this.tijianContent = tijianContent;
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
