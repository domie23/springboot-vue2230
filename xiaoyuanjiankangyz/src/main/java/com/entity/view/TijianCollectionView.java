package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.TijianCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 服务收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("tijian_collection")
public class TijianCollectionView extends TijianCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String tijianCollectionValue;

	//级联表 体检服务
							/**
		* 体检服务名称
		*/

		@ColumnInfo(comment="体检服务名称",type="varchar(200)")
		private String tijianName;
		/**
		* 体检服务照片
		*/

		@ColumnInfo(comment="体检服务照片",type="varchar(200)")
		private String tijianPhoto;
		/**
		* 体检服务类型
		*/
		@ColumnInfo(comment="体检服务类型",type="int(11)")
		private Integer tijianTypes;
			/**
			* 体检服务类型的值
			*/
			@ColumnInfo(comment="体检服务类型的字典表值",type="varchar(200)")
			private String tijianValue;
		/**
		* 体检费用
		*/
		@ColumnInfo(comment="体检费用",type="decimal(10,2)")
		private Double tijianPrice;
		/**
		* 体检服务热度
		*/

		@ColumnInfo(comment="体检服务热度",type="int(11)")
		private Integer tijianClicknum;
		/**
		* 体检服务介绍
		*/

		@ColumnInfo(comment="体检服务介绍",type="longtext")
		private String tijianContent;
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



	public TijianCollectionView() {

	}

	public TijianCollectionView(TijianCollectionEntity tijianCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, tijianCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getTijianCollectionValue() {
		return tijianCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setTijianCollectionValue(String tijianCollectionValue) {
		this.tijianCollectionValue = tijianCollectionValue;
	}


	//级联表的get和set 体检服务

		/**
		* 获取： 体检服务名称
		*/
		public String getTijianName() {
			return tijianName;
		}
		/**
		* 设置： 体检服务名称
		*/
		public void setTijianName(String tijianName) {
			this.tijianName = tijianName;
		}

		/**
		* 获取： 体检服务照片
		*/
		public String getTijianPhoto() {
			return tijianPhoto;
		}
		/**
		* 设置： 体检服务照片
		*/
		public void setTijianPhoto(String tijianPhoto) {
			this.tijianPhoto = tijianPhoto;
		}
		/**
		* 获取： 体检服务类型
		*/
		public Integer getTijianTypes() {
			return tijianTypes;
		}
		/**
		* 设置： 体检服务类型
		*/
		public void setTijianTypes(Integer tijianTypes) {
			this.tijianTypes = tijianTypes;
		}


			/**
			* 获取： 体检服务类型的值
			*/
			public String getTijianValue() {
				return tijianValue;
			}
			/**
			* 设置： 体检服务类型的值
			*/
			public void setTijianValue(String tijianValue) {
				this.tijianValue = tijianValue;
			}

		/**
		* 获取： 体检费用
		*/
		public Double getTijianPrice() {
			return tijianPrice;
		}
		/**
		* 设置： 体检费用
		*/
		public void setTijianPrice(Double tijianPrice) {
			this.tijianPrice = tijianPrice;
		}

		/**
		* 获取： 体检服务热度
		*/
		public Integer getTijianClicknum() {
			return tijianClicknum;
		}
		/**
		* 设置： 体检服务热度
		*/
		public void setTijianClicknum(Integer tijianClicknum) {
			this.tijianClicknum = tijianClicknum;
		}

		/**
		* 获取： 体检服务介绍
		*/
		public String getTijianContent() {
			return tijianContent;
		}
		/**
		* 设置： 体检服务介绍
		*/
		public void setTijianContent(String tijianContent) {
			this.tijianContent = tijianContent;
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
		return "TijianCollectionView{" +
			", tijianCollectionValue=" + tijianCollectionValue +
			", tijianName=" + tijianName +
			", tijianPhoto=" + tijianPhoto +
			", tijianPrice=" + tijianPrice +
			", tijianClicknum=" + tijianClicknum +
			", tijianContent=" + tijianContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			"} " + super.toString();
	}
}
