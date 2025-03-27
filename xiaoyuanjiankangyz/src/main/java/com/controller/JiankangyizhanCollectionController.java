
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
 * 驿站收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankangyizhanCollection")
public class JiankangyizhanCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangyizhanCollectionController.class);

    private static final String TABLE_NAME = "jiankangyizhanCollection";

    @Autowired
    private JiankangyizhanCollectionService jiankangyizhanCollectionService;


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
    private JiankangyizhanLiuyanService jiankangyizhanLiuyanService;//驿站留言
    @Autowired
    private JiaoshiService jiaoshiService;//教师
    @Autowired
    private NewsService newsService;//校园健康资讯
    @Autowired
    private TijianService tijianService;//体检服务
    @Autowired
    private TijianCollectionService tijianCollectionService;//服务收藏
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
        PageUtils page = jiankangyizhanCollectionService.queryPage(params);

        //字典表数据转换
        List<JiankangyizhanCollectionView> list =(List<JiankangyizhanCollectionView>)page.getList();
        for(JiankangyizhanCollectionView c:list){
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
        JiankangyizhanCollectionEntity jiankangyizhanCollection = jiankangyizhanCollectionService.selectById(id);
        if(jiankangyizhanCollection !=null){
            //entity转view
            JiankangyizhanCollectionView view = new JiankangyizhanCollectionView();
            BeanUtils.copyProperties( jiankangyizhanCollection , view );//把实体数据重构到view中
            //级联表 健康驿站
            //级联表
            JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(jiankangyizhanCollection.getJiankangyizhanId());
            if(jiankangyizhan != null){
            BeanUtils.copyProperties( jiankangyizhan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiankangyizhanId(jiankangyizhan.getId());
            }
            //级联表 学生
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiankangyizhanCollection.getYonghuId());
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
    public R save(@RequestBody JiankangyizhanCollectionEntity jiankangyizhanCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankangyizhanCollection:{}",this.getClass().getName(),jiankangyizhanCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            jiankangyizhanCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiankangyizhanCollectionEntity> queryWrapper = new EntityWrapper<JiankangyizhanCollectionEntity>()
            .eq("jiankangyizhan_id", jiankangyizhanCollection.getJiankangyizhanId())
            .eq("yonghu_id", jiankangyizhanCollection.getYonghuId())
            .eq("jiankangyizhan_collection_types", jiankangyizhanCollection.getJiankangyizhanCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangyizhanCollectionEntity jiankangyizhanCollectionEntity = jiankangyizhanCollectionService.selectOne(queryWrapper);
        if(jiankangyizhanCollectionEntity==null){
            jiankangyizhanCollection.setInsertTime(new Date());
            jiankangyizhanCollection.setCreateTime(new Date());
            jiankangyizhanCollectionService.insert(jiankangyizhanCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangyizhanCollectionEntity jiankangyizhanCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiankangyizhanCollection:{}",this.getClass().getName(),jiankangyizhanCollection.toString());
        JiankangyizhanCollectionEntity oldJiankangyizhanCollectionEntity = jiankangyizhanCollectionService.selectById(jiankangyizhanCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            jiankangyizhanCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jiankangyizhanCollectionService.updateById(jiankangyizhanCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiankangyizhanCollectionEntity> oldJiankangyizhanCollectionList =jiankangyizhanCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jiankangyizhanCollectionService.deleteBatchIds(Arrays.asList(ids));

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
            List<JiankangyizhanCollectionEntity> jiankangyizhanCollectionList = new ArrayList<>();//上传的东西
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
                            JiankangyizhanCollectionEntity jiankangyizhanCollectionEntity = new JiankangyizhanCollectionEntity();
//                            jiankangyizhanCollectionEntity.setJiankangyizhanId(Integer.valueOf(data.get(0)));   //驿站 要改的
//                            jiankangyizhanCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            jiankangyizhanCollectionEntity.setJiankangyizhanCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            jiankangyizhanCollectionEntity.setInsertTime(date);//时间
//                            jiankangyizhanCollectionEntity.setCreateTime(date);//时间
                            jiankangyizhanCollectionList.add(jiankangyizhanCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiankangyizhanCollectionService.insertBatch(jiankangyizhanCollectionList);
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
        PageUtils page = jiankangyizhanCollectionService.queryPage(params);

        //字典表数据转换
        List<JiankangyizhanCollectionView> list =(List<JiankangyizhanCollectionView>)page.getList();
        for(JiankangyizhanCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangyizhanCollectionEntity jiankangyizhanCollection = jiankangyizhanCollectionService.selectById(id);
            if(jiankangyizhanCollection !=null){


                //entity转view
                JiankangyizhanCollectionView view = new JiankangyizhanCollectionView();
                BeanUtils.copyProperties( jiankangyizhanCollection , view );//把实体数据重构到view中

                //级联表
                    JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(jiankangyizhanCollection.getJiankangyizhanId());
                if(jiankangyizhan != null){
                    BeanUtils.copyProperties( jiankangyizhan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiankangyizhanId(jiankangyizhan.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiankangyizhanCollection.getYonghuId());
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
    public R add(@RequestBody JiankangyizhanCollectionEntity jiankangyizhanCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiankangyizhanCollection:{}",this.getClass().getName(),jiankangyizhanCollection.toString());
        Wrapper<JiankangyizhanCollectionEntity> queryWrapper = new EntityWrapper<JiankangyizhanCollectionEntity>()
            .eq("jiankangyizhan_id", jiankangyizhanCollection.getJiankangyizhanId())
            .eq("yonghu_id", jiankangyizhanCollection.getYonghuId())
            .eq("jiankangyizhan_collection_types", jiankangyizhanCollection.getJiankangyizhanCollectionTypes())
//            .notIn("jiankangyizhan_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangyizhanCollectionEntity jiankangyizhanCollectionEntity = jiankangyizhanCollectionService.selectOne(queryWrapper);
        if(jiankangyizhanCollectionEntity==null){
            jiankangyizhanCollection.setInsertTime(new Date());
            jiankangyizhanCollection.setCreateTime(new Date());
        jiankangyizhanCollectionService.insert(jiankangyizhanCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

