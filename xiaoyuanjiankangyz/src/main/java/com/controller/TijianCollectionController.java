
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 服务收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijianCollection")
public class TijianCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(TijianCollectionController.class);

    private static final String TABLE_NAME = "tijianCollection";

    @Autowired
    private TijianCollectionService tijianCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//校园论坛
    @Autowired
    private JiankangtianbaoService jiankangtianbaoService;//每日健康填报
    @Autowired
    private JiankangyizhanService jiankangyizhanService;//健康驿站
    @Autowired
    private JiankangyizhanCollectionService jiankangyizhanCollectionService;//驿站收藏
    @Autowired
    private JiankangyizhanLiuyanService jiankangyizhanLiuyanService;//驿站留言
    @Autowired
    private JiaoshiService jiaoshiService;//教师
    @Autowired
    private NewsService newsService;//校园健康资讯
    @Autowired
    private TijianService tijianService;//体检服务
    @Autowired
    private TijianLiuyanService tijianLiuyanService;//服务留言
    @Autowired
    private TijianYuyueService tijianYuyueService;//体检预约
    @Autowired
    private YonghuService yonghuService;//学生
    @Autowired
    private YonghuqingjiaService yonghuqingjiaService;//学生请假
    @Autowired
    private ZiceyichangService ziceyichangService;//自测异常信息
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教师".equals(role))
            params.put("jiaoshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = tijianCollectionService.queryPage(params);

        //字典表数据转换
        List<TijianCollectionView> list =(List<TijianCollectionView>)page.getList();
        for(TijianCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TijianCollectionEntity tijianCollection = tijianCollectionService.selectById(id);
        if(tijianCollection !=null){
            //entity转view
            TijianCollectionView view = new TijianCollectionView();
            BeanUtils.copyProperties( tijianCollection , view );//把实体数据重构到view中
            //级联表 体检服务
            //级联表
            TijianEntity tijian = tijianService.selectById(tijianCollection.getTijianId());
            if(tijian != null){
            BeanUtils.copyProperties( tijian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setTijianId(tijian.getId());
            }
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(tijianCollection.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TijianCollectionEntity tijianCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijianCollection:{}",this.getClass().getName(),tijianCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            tijianCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<TijianCollectionEntity> queryWrapper = new EntityWrapper<TijianCollectionEntity>()
            .eq("tijian_id", tijianCollection.getTijianId())
            .eq("yonghu_id", tijianCollection.getYonghuId())
            .eq("tijian_collection_types", tijianCollection.getTijianCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianCollectionEntity tijianCollectionEntity = tijianCollectionService.selectOne(queryWrapper);
        if(tijianCollectionEntity==null){
            tijianCollection.setInsertTime(new Date());
            tijianCollection.setCreateTime(new Date());
            tijianCollectionService.insert(tijianCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianCollectionEntity tijianCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tijianCollection:{}",this.getClass().getName(),tijianCollection.toString());
        TijianCollectionEntity oldTijianCollectionEntity = tijianCollectionService.selectById(tijianCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            tijianCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            tijianCollectionService.updateById(tijianCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TijianCollectionEntity> oldTijianCollectionList =tijianCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        tijianCollectionService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<TijianCollectionEntity> tijianCollectionList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            TijianCollectionEntity tijianCollectionEntity = new TijianCollectionEntity();
//                            tijianCollectionEntity.setTijianId(Integer.valueOf(data.get(0)));   //体检服务 要改的
//                            tijianCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            tijianCollectionEntity.setTijianCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            tijianCollectionEntity.setInsertTime(date);//时间
//                            tijianCollectionEntity.setCreateTime(date);//时间
                            tijianCollectionList.add(tijianCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tijianCollectionService.insertBatch(tijianCollectionList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = tijianCollectionService.queryPage(params);

        //字典表数据转换
        List<TijianCollectionView> list =(List<TijianCollectionView>)page.getList();
        for(TijianCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TijianCollectionEntity tijianCollection = tijianCollectionService.selectById(id);
            if(tijianCollection !=null){


                //entity转view
                TijianCollectionView view = new TijianCollectionView();
                BeanUtils.copyProperties( tijianCollection , view );//把实体数据重构到view中

                //级联表
                    TijianEntity tijian = tijianService.selectById(tijianCollection.getTijianId());
                if(tijian != null){
                    BeanUtils.copyProperties( tijian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTijianId(tijian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(tijianCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TijianCollectionEntity tijianCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tijianCollection:{}",this.getClass().getName(),tijianCollection.toString());
        Wrapper<TijianCollectionEntity> queryWrapper = new EntityWrapper<TijianCollectionEntity>()
            .eq("tijian_id", tijianCollection.getTijianId())
            .eq("yonghu_id", tijianCollection.getYonghuId())
            .eq("tijian_collection_types", tijianCollection.getTijianCollectionTypes())
//            .notIn("tijian_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianCollectionEntity tijianCollectionEntity = tijianCollectionService.selectOne(queryWrapper);
        if(tijianCollectionEntity==null){
            tijianCollection.setInsertTime(new Date());
            tijianCollection.setCreateTime(new Date());
        tijianCollectionService.insert(tijianCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

