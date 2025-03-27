
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
 * 体检服务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/tijian")
public class TijianController {
    private static final Logger logger = LoggerFactory.getLogger(TijianController.class);

    private static final String TABLE_NAME = "tijian";

    @Autowired
    private TijianService tijianService;


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
        PageUtils page = tijianService.queryPage(params);

        //字典表数据转换
        List<TijianView> list =(List<TijianView>)page.getList();
        for(TijianView c:list){
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
        TijianEntity tijian = tijianService.selectById(id);
        if(tijian !=null){
            //entity转view
            TijianView view = new TijianView();
            BeanUtils.copyProperties( tijian , view );//把实体数据重构到view中
            //级联表 健康驿站
            //级联表
            JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(tijian.getJiankangyizhanId());
            if(jiankangyizhan != null){
            BeanUtils.copyProperties( jiankangyizhan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiankangyizhanId(jiankangyizhan.getId());
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
    public R save(@RequestBody TijianEntity tijian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .eq("jiankangyizhan_id", tijian.getJiankangyizhanId())
            .eq("tijian_name", tijian.getTijianName())
            .eq("tijian_types", tijian.getTijianTypes())
            .eq("data_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if(tijianEntity==null){
            tijian.setTijianClicknum(1);
            tijian.setDataDelete(1);
            tijian.setInsertTime(new Date());
            tijian.setCreateTime(new Date());
            tijianService.insert(tijian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TijianEntity tijian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());
        TijianEntity oldTijianEntity = tijianService.selectById(tijian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(tijian.getTijianPhoto()) || "null".equals(tijian.getTijianPhoto())){
                tijian.setTijianPhoto(null);
        }
        if("".equals(tijian.getTijianContent()) || "null".equals(tijian.getTijianContent())){
                tijian.setTijianContent(null);
        }

            tijianService.updateById(tijian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<TijianEntity> oldTijianList =tijianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<TijianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            TijianEntity tijianEntity = new TijianEntity();
            tijianEntity.setId(id);
            tijianEntity.setDataDelete(2);
            list.add(tijianEntity);
        }
        if(list != null && list.size() >0){
            tijianService.updateBatchById(list);
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
            List<TijianEntity> tijianList = new ArrayList<>();//上传的东西
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
                            TijianEntity tijianEntity = new TijianEntity();
//                            tijianEntity.setJiankangyizhanId(Integer.valueOf(data.get(0)));   //驿站 要改的
//                            tijianEntity.setTijianName(data.get(0));                    //体检服务名称 要改的
//                            tijianEntity.setTijianPhoto("");//详情和图片
//                            tijianEntity.setTijianTypes(Integer.valueOf(data.get(0)));   //体检服务类型 要改的
//                            tijianEntity.setTijianPrice(data.get(0));                    //体检费用 要改的
//                            tijianEntity.setTijianClicknum(Integer.valueOf(data.get(0)));   //体检服务热度 要改的
//                            tijianEntity.setTijianContent("");//详情和图片
//                            tijianEntity.setDataDelete(1);//逻辑删除字段
//                            tijianEntity.setInsertTime(date);//时间
//                            tijianEntity.setCreateTime(date);//时间
                            tijianList.add(tijianEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        tijianService.insertBatch(tijianList);
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
        List<TijianView> returnTijianViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("tijianYesnoTypes",2);
        PageUtils pageUtils = tijianCollectionService.queryPage(params1);
        List<TijianCollectionView> collectionViewsList =(List<TijianCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(TijianCollectionView collectionView:collectionViewsList){
            Integer tijianTypes = collectionView.getTijianTypes();
            if(typeMap.containsKey(tijianTypes)){
                typeMap.put(tijianTypes,typeMap.get(tijianTypes)+1);
            }else{
                typeMap.put(tijianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("tijianTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("tijianYesnoTypes",2);
            PageUtils pageUtils1 = tijianService.queryPage(params2);
            List<TijianView> tijianViewList =(List<TijianView>)pageUtils1.getList();
            returnTijianViewList.addAll(tijianViewList);
            if(returnTijianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("tijianYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = tijianService.queryPage(params);
        if(returnTijianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnTijianViewList.size();//要添加的数量
            List<TijianView> tijianViewList =(List<TijianView>)page.getList();
            for(TijianView tijianView:tijianViewList){
                Boolean addFlag = true;
                for(TijianView returnTijianView:returnTijianViewList){
                    if(returnTijianView.getId().intValue() ==tijianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnTijianViewList.add(tijianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnTijianViewList = returnTijianViewList.subList(0, limit);
        }

        for(TijianView c:returnTijianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnTijianViewList);
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
        PageUtils page = tijianService.queryPage(params);

        //字典表数据转换
        List<TijianView> list =(List<TijianView>)page.getList();
        for(TijianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TijianEntity tijian = tijianService.selectById(id);
            if(tijian !=null){

                //点击数量加1
                tijian.setTijianClicknum(tijian.getTijianClicknum()+1);
                tijianService.updateById(tijian);

                //entity转view
                TijianView view = new TijianView();
                BeanUtils.copyProperties( tijian , view );//把实体数据重构到view中

                //级联表
                    JiankangyizhanEntity jiankangyizhan = jiankangyizhanService.selectById(tijian.getJiankangyizhanId());
                if(jiankangyizhan != null){
                    BeanUtils.copyProperties( jiankangyizhan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiankangyizhanId(jiankangyizhan.getId());
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
    public R add(@RequestBody TijianEntity tijian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tijian:{}",this.getClass().getName(),tijian.toString());
        Wrapper<TijianEntity> queryWrapper = new EntityWrapper<TijianEntity>()
            .eq("jiankangyizhan_id", tijian.getJiankangyizhanId())
            .eq("tijian_name", tijian.getTijianName())
            .eq("tijian_types", tijian.getTijianTypes())
            .eq("tijian_clicknum", tijian.getTijianClicknum())
            .eq("data_delete", tijian.getDataDelete())
//            .notIn("tijian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TijianEntity tijianEntity = tijianService.selectOne(queryWrapper);
        if(tijianEntity==null){
            tijian.setTijianClicknum(1);
            tijian.setDataDelete(1);
            tijian.setInsertTime(new Date());
            tijian.setCreateTime(new Date());
        tijianService.insert(tijian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

