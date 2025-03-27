package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ZiceyichangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 自测异常信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("ziceyichang")
public class ZiceyichangView extends ZiceyichangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 隔离状态的值
	*/
	@ColumnInfo(comment="隔离状态的字典表值",type="varchar(200)")
	private String ziceyichangValue;

	//级联表 健康驿站
		/**
		* 驿站名称
		*/

		@ColumnInfo(comment="驿站名称",type="varchar(200)")
		private String jiankangyizhanName;
		/**
		* 驿站照片
		*/

		@ColumnInfo(comment="驿站照片",type="varchar(200)")
		private String jiankangyizhanPhoto;
		/**
		* 驿站地址
		*/

		@ColumnInfo(comment="驿站地址",type="varchar(200)")
		private String jiankangyizhanAddress;
		/**
		* 负责人
		*/

		@ColumnInfo(comment="负责人",type="varchar(200)")
		private String jiankangyizhanFzr;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String jiankangyizhanPhone;
		/**
		* 驿站类型
		*/
		@ColumnInfo(comment="驿站类型",type="int(11)")
		private Integer jiankangyizhanTypes;
			/**
			* 驿站类型的值
			*/
			@ColumnInfo(comment="驿站类型的字典表值",type="varchar(200)")
			private String jiankangyizhanValue;
		/**
		* 驿站热度
		*/

		@ColumnInfo(comment="驿站热度",type="int(11)")
		private Integer jiankangyizhanClicknum;
		/**
		* 驿站介绍
		*/

		@ColumnInfo(comment="驿站介绍",type="longtext")
		private String jiankangyizhanContent;



	public ZiceyichangView() {

	}

	public ZiceyichangView(ZiceyichangEntity ziceyichangEntity) {
		try {
			BeanUtils.copyProperties(this, ziceyichangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 隔离状态的值
	*/
	public String getZiceyichangValue() {
		return ziceyichangValue;
	}
	/**
	* 设置： 隔离状态的值
	*/
	public void setZiceyichangValue(String ziceyichangValue) {
		this.ziceyichangValue = ziceyichangValue;
	}


	//级联表的get和set 健康驿站

		/**
		* 获取： 驿站名称
		*/
		public String getJiankangyizhanName() {
			return jiankangyizhanName;
		}
		/**
		* 设置： 驿站名称
		*/
		public void setJiankangyizhanName(String jiankangyizhanName) {
			this.jiankangyizhanName = jiankangyizhanName;
		}

		/**
		* 获取： 驿站照片
		*/
		public String getJiankangyizhanPhoto() {
			return jiankangyizhanPhoto;
		}
		/**
		* 设置： 驿站照片
		*/
		public void setJiankangyizhanPhoto(String jiankangyizhanPhoto) {
			this.jiankangyizhanPhoto = jiankangyizhanPhoto;
		}

		/**
		* 获取： 驿站地址
		*/
		public String getJiankangyizhanAddress() {
			return jiankangyizhanAddress;
		}
		/**
		* 设置： 驿站地址
		*/
		public void setJiankangyizhanAddress(String jiankangyizhanAddress) {
			this.jiankangyizhanAddress = jiankangyizhanAddress;
		}

		/**
		* 获取： 负责人
		*/
		public String getJiankangyizhanFzr() {
			return jiankangyizhanFzr;
		}
		/**
		* 设置： 负责人
		*/
		public void setJiankangyizhanFzr(String jiankangyizhanFzr) {
			this.jiankangyizhanFzr = jiankangyizhanFzr;
		}

		/**
		* 获取： 联系方式
		*/
		public String getJiankangyizhanPhone() {
			return jiankangyizhanPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setJiankangyizhanPhone(String jiankangyizhanPhone) {
			this.jiankangyizhanPhone = jiankangyizhanPhone;
		}
		/**
		* 获取： 驿站类型
		*/
		public Integer getJiankangyizhanTypes() {
			return jiankangyizhanTypes;
		}
		/**
		* 设置： 驿站类型
		*/
		public void setJiankangyizhanTypes(Integer jiankangyizhanTypes) {
			this.jiankangyizhanTypes = jiankangyizhanTypes;
		}


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

		/**
		* 获取： 驿站热度
		*/
		public Integer getJiankangyizhanClicknum() {
			return jiankangyizhanClicknum;
		}
		/**
		* 设置： 驿站热度
		*/
		public void setJiankangyizhanClicknum(Integer jiankangyizhanClicknum) {
			this.jiankangyizhanClicknum = jiankangyizhanClicknum;
		}

		/**
		* 获取： 驿站介绍
		*/
		public String getJiankangyizhanContent() {
			return jiankangyizhanContent;
		}
		/**
		* 设置： 驿站介绍
		*/
		public void setJiankangyizhanContent(String jiankangyizhanContent) {
			this.jiankangyizhanContent = jiankangyizhanContent;
		}


	@Override
	public String toString() {
		return "ZiceyichangView{" +
			", ziceyichangValue=" + ziceyichangValue +
			", jiankangyizhanName=" + jiankangyizhanName +
			", jiankangyizhanPhoto=" + jiankangyizhanPhoto +
			", jiankangyizhanAddress=" + jiankangyizhanAddress +
			", jiankangyizhanFzr=" + jiankangyizhanFzr +
			", jiankangyizhanPhone=" + jiankangyizhanPhone +
			", jiankangyizhanClicknum=" + jiankangyizhanClicknum +
			", jiankangyizhanContent=" + jiankangyizhanContent +
			"} " + super.toString();
	}
}
