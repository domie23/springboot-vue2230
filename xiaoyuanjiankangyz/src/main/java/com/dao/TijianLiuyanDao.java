package com.dao;

import com.entity.TijianLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianLiuyanView;

/**
 * 服务留言 Dao 接口
 *
 * @author 
 */
public interface TijianLiuyanDao extends BaseMapper<TijianLiuyanEntity> {

   List<TijianLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
