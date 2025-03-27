
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
 * 健康驿站
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiankangyizhan")
public class JiankangyizhanController {
    private static final Logger logger = LoggerFactory.getLogger(JiankangyizhanController.class);

    private static final String TABLE_NAME = "jiankangyizhan";

    @Autowired
    private JiankangyizhanService jiankangyizhanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//校园论坛
    @Autowired
    private JiankangtianbaoService jiankangtianbaoService;//每日健康填报
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
        params.put("dataDeleteStart",1);params.put("dataDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiankangyizhanService.queryPage(params);

        //字典表数据转换
        List<JiankangyizhanView> list =(List<JiankangyizhanView>)page.getList();
        for(JiankangyizhanView c:list){
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
        JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(id);
        if(jiankangyizhan !=null){
            //entity转view
            JiankangyizhanView view = new JiankangyizhanView();
            BeanUtils.copyProperties( jiankangyizhan , view );//把实体数据重构到view中
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
    public R save(@RequestBody JiankangyizhanEntity jiankangyizhan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiankangyizhan:{}",this.getClass().getName(),jiankangyizhan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiankangyizhanEntity> queryWrapper = new EntityWrapper<JiankangyizhanEntity>()
            .eq("jiankangyizhan_name", jiankangyizhan.getJiankangyizhanName())
            .eq("jiankangyizhan_address", jiankangyizhan.getJiankangyizhanAddress())
            .eq("jiankangyizhan_fzr", jiankangyizhan.getJiankangyizhanFzr())
            .eq("jiankangyizhan_phone", jiankangyizhan.getJiankangyizhanPhone())
            .eq("jiankangyizhan_types", jiankangyizhan.getJiankangyizhanTypes())
            .eq("data_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangyizhanEntity jiankangyizhanEntity = jiankangyizhanService.selectOne(queryWrapper);
        if(jiankangyizhanEntity==null){
            jiankangyizhan.setJiankangyizhanClicknum(1);
            jiankangyizhan.setDataDelete(1);
            jiankangyizhan.setInsertTime(new Date());
            jiankangyizhan.setCreateTime(new Date());
            jiankangyizhanService.insert(jiankangyizhan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiankangyizhanEntity jiankangyizhan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiankangyizhan:{}",this.getClass().getName(),jiankangyizhan.toString());
        JiankangyizhanEntity oldJiankangyizhanEntity = jiankangyizhanService.selectById(jiankangyizhan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jiankangyizhan.getJiankangyizhanPhoto()) || "null".equals(jiankangyizhan.getJiankangyizhanPhoto())){
                jiankangyizhan.setJiankangyizhanPhoto(null);
        }
        if("".equals(jiankangyizhan.getJiankangyizhanContent()) || "null".equals(jiankangyizhan.getJiankangyizhanContent())){
                jiankangyizhan.setJiankangyizhanContent(null);
        }

            jiankangyizhanService.updateById(jiankangyizhan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiankangyizhanEntity> oldJiankangyizhanList =jiankangyizhanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiankangyizhanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiankangyizhanEntity jiankangyizhanEntity = new JiankangyizhanEntity();
            jiankangyizhanEntity.setId(id);
            jiankangyizhanEntity.setDataDelete(2);
            list.add(jiankangyizhanEntity);
        }
        if(list != null && list.size() >0){
            jiankangyizhanService.updateBatchById(list);
        }

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
            List<JiankangyizhanEntity> jiankangyizhanList = new ArrayList<>();//上传的东西
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
                            JiankangyizhanEntity jiankangyizhanEntity = new JiankangyizhanEntity();
//                            jiankangyizhanEntity.setJiankangyizhanName(data.get(0));                    //驿站名称 要改的
//                            jiankangyizhanEntity.setJiankangyizhanPhoto("");//详情和图片
//                            jiankangyizhanEntity.setJiankangyizhanAddress(data.get(0));                    //驿站地址 要改的
//                            jiankangyizhanEntity.setJiankangyizhanFzr(data.get(0));                    //负责人 要改的
//                            jiankangyizhanEntity.setJiankangyizhanPhone(data.get(0));                    //联系方式 要改的
//                            jiankangyizhanEntity.setJiankangyizhanTypes(Integer.valueOf(data.get(0)));   //驿站类型 要改的
//                            jiankangyizhanEntity.setJiankangyizhanClicknum(Integer.valueOf(data.get(0)));   //驿站热度 要改的
//                            jiankangyizhanEntity.setJiankangyizhanContent("");//详情和图片
//                            jiankangyizhanEntity.setDataDelete(1);//逻辑删除字段
//                            jiankangyizhanEntity.setInsertTime(date);//时间
//                            jiankangyizhanEntity.setCreateTime(date);//时间
                            jiankangyizhanList.add(jiankangyizhanEntity);


                            //把要查询是否重复的字段放入map中
                                //联系方式
                                if(seachFields.containsKey("jiankangyizhanPhone")){
                                    List<String> jiankangyizhanPhone = seachFields.get("jiankangyizhanPhone");
                                    jiankangyizhanPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> jiankangyizhanPhone = new ArrayList<>();
                                    jiankangyizhanPhone.add(data.get(0));//要改的
                                    seachFields.put("jiankangyizhanPhone",jiankangyizhanPhone);
                                }
                        }

                        //查询是否重复
                         //联系方式
                        List<JiankangyizhanEntity> jiankangyizhanEntities_jiankangyizhanPhone = jiankangyizhanService.selectList(new EntityWrapper<JiankangyizhanEntity>().in("jiankangyizhan_phone", seachFields.get("jiankangyizhanPhone")).eq("data_delete", 1));
                        if(jiankangyizhanEntities_jiankangyizhanPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiankangyizhanEntity s:jiankangyizhanEntities_jiankangyizhanPhone){
                                repeatFields.add(s.getJiankangyizhanPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiankangyizhanService.insertBatch(jiankangyizhanList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<JiankangyizhanView> returnJiankangyizhanViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("jiankangyizhanYesnoTypes",2);
        PageUtils pageUtils = jiankangyizhanCollectionService.queryPage(params1);
        List<JiankangyizhanCollectionView> collectionViewsList =(List<JiankangyizhanCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JiankangyizhanCollectionView collectionView:collectionViewsList){
            Integer jiankangyizhanTypes = collectionView.getJiankangyizhanTypes();
            if(typeMap.containsKey(jiankangyizhanTypes)){
                typeMap.put(jiankangyizhanTypes,typeMap.get(jiankangyizhanTypes)+1);
            }else{
                typeMap.put(jiankangyizhanTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jiankangyizhanTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("jiankangyizhanYesnoTypes",2);
            PageUtils pageUtils1 = jiankangyizhanService.queryPage(params2);
            List<JiankangyizhanView> jiankangyizhanViewList =(List<JiankangyizhanView>)pageUtils1.getList();
            returnJiankangyizhanViewList.addAll(jiankangyizhanViewList);
            if(returnJiankangyizhanViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("jiankangyizhanYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jiankangyizhanService.queryPage(params);
        if(returnJiankangyizhanViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJiankangyizhanViewList.size();//要添加的数量
            List<JiankangyizhanView> jiankangyizhanViewList =(List<JiankangyizhanView>)page.getList();
            for(JiankangyizhanView jiankangyizhanView:jiankangyizhanViewList){
                Boolean addFlag = true;
                for(JiankangyizhanView returnJiankangyizhanView:returnJiankangyizhanViewList){
                    if(returnJiankangyizhanView.getId().intValue() ==jiankangyizhanView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJiankangyizhanViewList.add(jiankangyizhanView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJiankangyizhanViewList = returnJiankangyizhanViewList.subList(0, limit);
        }

        for(JiankangyizhanView c:returnJiankangyizhanViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJiankangyizhanViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiankangyizhanService.queryPage(params);

        //字典表数据转换
        List<JiankangyizhanView> list =(List<JiankangyizhanView>)page.getList();
        for(JiankangyizhanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(id);
            if(jiankangyizhan !=null){

                //点击数量加1
                jiankangyizhan.setJiankangyizhanClicknum(jiankangyizhan.getJiankangyizhanClicknum()+1);
                jiankangyizhanService.updateById(jiankangyizhan);

                //entity转view
                JiankangyizhanView view = new JiankangyizhanView();
                BeanUtils.copyProperties( jiankangyizhan , view );//把实体数据重构到view中

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
    public R add(@RequestBody JiankangyizhanEntity jiankangyizhan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiankangyizhan:{}",this.getClass().getName(),jiankangyizhan.toString());
        Wrapper<JiankangyizhanEntity> queryWrapper = new EntityWrapper<JiankangyizhanEntity>()
            .eq("jiankangyizhan_name", jiankangyizhan.getJiankangyizhanName())
            .eq("jiankangyizhan_address", jiankangyizhan.getJiankangyizhanAddress())
            .eq("jiankangyizhan_fzr", jiankangyizhan.getJiankangyizhanFzr())
            .eq("jiankangyizhan_phone", jiankangyizhan.getJiankangyizhanPhone())
            .eq("jiankangyizhan_types", jiankangyizhan.getJiankangyizhanTypes())
            .eq("jiankangyizhan_clicknum", jiankangyizhan.getJiankangyizhanClicknum())
            .eq("data_delete", jiankangyizhan.getDataDelete())
//            .notIn("jiankangyizhan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiankangyizhanEntity jiankangyizhanEntity = jiankangyizhanService.selectOne(queryWrapper);
        if(jiankangyizhanEntity==null){
            jiankangyizhan.setJiankangyizhanClicknum(1);
            jiankangyizhan.setDataDelete(1);
            jiankangyizhan.setInsertTime(new Date());
            jiankangyizhan.setCreateTime(new Date());
        jiankangyizhanService.insert(jiankangyizhan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

