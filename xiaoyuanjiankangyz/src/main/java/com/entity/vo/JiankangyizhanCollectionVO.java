package com.entity.vo;

import com.entity.JiankangyizhanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 驿站收藏
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangyizhan_collection")
public class JiankangyizhanCollectionVO implements Serializable {
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
     * 学生
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 类型
     */

    @TableField(value = "jiankangyizhan_collection_types")
    private Integer jiankangyizhanCollectionTypes;


    /**
     * 收藏时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 photoShow
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
	 * 设置：类型
	 */
    public Integer getJiankangyizhanCollectionTypes() {
        return jiankangyizhanCollectionTypes;
    }


    /**
	 * 获取：类型
	 */

    public void setJiankangyizhanCollectionTypes(Integer jiankangyizhanCollectionTypes) {
        this.jiankangyizhanCollectionTypes = jiankangyizhanCollectionTypes;
    }
    /**
	 * 设置：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：收藏时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
