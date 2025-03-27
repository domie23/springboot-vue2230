package com.dao;

import com.entity.TijianYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TijianYuyueView;

/**
 * 体检预约 Dao 接口
 *
 * @author 
 */
public interface TijianYuyueDao extends BaseMapper<TijianYuyueEntity> {

   List<TijianYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
