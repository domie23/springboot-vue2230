package com.dao;

import com.entity.JiankangyizhanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangyizhanView;

/**
 * 健康驿站 Dao 接口
 *
 * @author 
 */
public interface JiankangyizhanDao extends BaseMapper<JiankangyizhanEntity> {

   List<JiankangyizhanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
