package com.entity.vo;

import com.entity.JiankangtianbaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 每日健康填报
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiankangtianbao")
public class JiankangtianbaoVO implements Serializable {
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
     * 填报标题
     */

    @TableField(value = "jiankangtianbao_name")
    private String jiankangtianbaoName;


    /**
     * 当前体温
     */

    @TableField(value = "jiankangtianbao_tiwen")
    private Double jiankangtianbaoTiwen;


    /**
     * 填报详情
     */

    @TableField(value = "jiankangtianbao_text")
    private String jiankangtianbaoText;


    /**
     * 填报时间
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
	 * 设置：填报标题
	 */
    public String getJiankangtianbaoName() {
        return jiankangtianbaoName;
    }


    /**
	 * 获取：填报标题
	 */

    public void setJiankangtianbaoName(String jiankangtianbaoName) {
        this.jiankangtianbaoName = jiankangtianbaoName;
    }
    /**
	 * 设置：当前体温
	 */
    public Double getJiankangtianbaoTiwen() {
        return jiankangtianbaoTiwen;
    }


    /**
	 * 获取：当前体温
	 */

    public void setJiankangtianbaoTiwen(Double jiankangtianbaoTiwen) {
        this.jiankangtianbaoTiwen = jiankangtianbaoTiwen;
    }
    /**
	 * 设置：填报详情
	 */
    public String getJiankangtianbaoText() {
        return jiankangtianbaoText;
    }


    /**
	 * 获取：填报详情
	 */

    public void setJiankangtianbaoText(String jiankangtianbaoText) {
        this.jiankangtianbaoText = jiankangtianbaoText;
    }
    /**
	 * 设置：填报时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：填报时间
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
