package com.dao;

import com.entity.TijianCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianCollectionView;

/**
 * 服务收藏 Dao 接口
 *
 * @author 
 */
public interface TijianCollectionDao extends BaseMapper<TijianCollectionEntity> {

   List<TijianCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
