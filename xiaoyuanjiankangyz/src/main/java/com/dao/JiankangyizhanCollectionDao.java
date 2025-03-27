package com.dao;

import com.entity.JiankangyizhanCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiankangyizhanCollectionView;

/**
 * 驿站收藏 Dao 接口
 *
 * @author 
 */
public interface JiankangyizhanCollectionDao extends BaseMapper<JiankangyizhanCollectionEntity> {

   List<JiankangyizhanCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
