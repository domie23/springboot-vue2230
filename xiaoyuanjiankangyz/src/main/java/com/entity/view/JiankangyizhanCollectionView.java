package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiankangyizhanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 驿站收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiankangyizhan_collection")
public class JiankangyizhanCollectionView extends JiankangyizhanCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String jiankangyizhanCollectionValue;

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
	//级联表 学生
		/**
		* 学生名称
		*/

		@ColumnInfo(comment="学生名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 学生手机号
		*/

		@ColumnInfo(comment="学生手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 学生身份证号
		*/

		@ColumnInfo(comment="学生身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 学生头像
		*/

		@ColumnInfo(comment="学生头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 学生邮箱
		*/

		@ColumnInfo(comment="学生邮箱",type="varchar(200)")
		private String yonghuEmail;



	public JiankangyizhanCollectionView() {

	}

	public JiankangyizhanCollectionView(JiankangyizhanCollectionEntity jiankangyizhanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiankangyizhanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getJiankangyizhanCollectionValue() {
		return jiankangyizhanCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setJiankangyizhanCollectionValue(String jiankangyizhanCollectionValue) {
		this.jiankangyizhanCollectionValue = jiankangyizhanCollectionValue;
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
	//级联表的get和set 学生

		/**
		* 获取： 学生名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 学生名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 学生手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 学生手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 学生身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 学生身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 学生头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 学生头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 学生邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 学生邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "JiankangyizhanCollectionView{" +
			", jiankangyizhanCollectionValue=" + jiankangyizhanCollectionValue +
			", jiankangyizhanName=" + jiankangyizhanName +
			", jiankangyizhanPhoto=" + jiankangyizhanPhoto +
			", jiankangyizhanAddress=" + jiankangyizhanAddress +
			", jiankangyizhanFzr=" + jiankangyizhanFzr +
			", jiankangyizhanPhone=" + jiankangyizhanPhone +
			", jiankangyizhanClicknum=" + jiankangyizhanClicknum +
			", jiankangyizhanContent=" + jiankangyizhanContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
