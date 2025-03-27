package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankangyizhanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 健康驿站
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiankangyizhan")
public class JiankangyizhanView extends JiankangyizhanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 驿站类型的值
	*/
	@ColumnInfo(comment="驿站类型的字典表值",type="varchar(200)")
	private String jiankangyizhanValue;




	public JiankangyizhanView() {

	}

	public JiankangyizhanView(JiankangyizhanEntity jiankangyizhanEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangyizhanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 驿站类型的值
	*/
	public String getJiankangyizhanValue() {
		return jiankangyizhanValue;
	}
	/**
	* 设置： 驿站类型的值
	*/
	public void setJiankangyizhanValue(String jiankangyizhanValue) {
		this.jiankangyizhanValue = jiankangyizhanValue;
	}




	@Override
	public String toString() {
		return "JiankangyizhanView{" +
			", jiankangyizhanValue=" + jiankangyizhanValue +
			"} " + super.toString();
	}
}
