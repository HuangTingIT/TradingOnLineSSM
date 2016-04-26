package TOL2.controller;

import TOL2.controller.validation.ValidateGroup1;
import TOL2.exception.GoodsException;
import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.GoodsQueryVO;
import TOL2.model.User;
import TOL2.service.GoodsService;
import TOL2.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.xa.XAException;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


/**
 * Created by HuangTing on 2016/4/25.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //-------------------商品类型-------------------
    @ModelAttribute("itemTypes")
    public Map<String, String> getItemTypes() {
        Map<String, String> itemTypes = new HashMap<String, String>();
        itemTypes.put("101", "电子");
        itemTypes.put("102", "饰品");

        return itemTypes;
    }

    //-------------------添加商品------------------
    @RequestMapping("/addGoods")
    public String addGoods() {
        return "/goods/addGoods";
    }

    @RequestMapping(value = "/saveAddedGoodsInfo",method= RequestMethod.POST)
    // 在需要校验的pojo前边添加@Validated，在需要校验的pojo后边添加BindingResult
    // bindingResult接收校验出错信息
    // 注意：@Validated和BindingResult bindingResult是配对出现，并且形参顺序是固定的（一前一后）。
    // value={ValidGroup1.class}指定使用ValidGroup1分组的 校验
    // @ModelAttribute可以指定pojo回显到页面在request中的key
    public String saveAddedGoodsInfo(HttpServletRequest request,
                                     ModelMap modelMap,
                                     @ModelAttribute("goods") @Validated(value = {ValidateGroup1.class}) Goods goods,
                                     BindingResult bindingResult,
                                     // @RequestParam MultipartFile[] goods_pics  **********************
                                     @RequestParam MultipartFile[] goods_pics)throws Exception{
        // 获取校验错误信息
        if (bindingResult.hasErrors()) {
            // 输出错误信息
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                // 输出错误信息
                System.out.println(objectError.getDefaultMessage());
            }
            // 将错误信息传到页面
            modelMap.addAttribute("allErrors", allErrors);
            //可以直接使用model将提交pojo回显到页面
            modelMap.addAttribute("goods", goods);
            // 出错重新到商品修改页面
            return "/goods/addGoods";
        }
        //userId得这样获取 这是发布商品的页面 读取过来的商品信息 并没有用户的
        Integer userId=((User)request.getSession().getAttribute("user")).getId();
        goods.setUserid(userId);
        goodsService.setGoodsPics(goods,goods_pics);
        // 调用service更新商品信息，页面需要将商品信息传到此方法
        Integer id=goodsService.insertGoods(goods,userId);

        String[] picsList=goodsService.getAGoodsPics(goods);
        modelMap.addAttribute("picsList",picsList);
        goods=goodsService.findGoodsById(id);
        modelMap.addAttribute("goods",goods);

        return "/goods/singleGoods";
    }


        /*
        * Integer userId = ((User) (request.getSession()).getAttribute("user")).getId();
        Integer id = goodsService.insertGoods(goods, userId);
        goods = goodsService.findGoodsById(id);
        modelMap.addAttribute("goods", goods);
        return "/goods/singleGoods";*/


    //--------------------修改商品信息------------------------
    @RequestMapping("/editGoodsInfo.action")
    public String editGoodsInfo(HttpServletRequest request,
                                @RequestParam(value = "id", required = true) Integer goods_id,
                                ModelMap modelMap) throws Exception {
        Goods goods = goodsService.findGoodsById(goods_id);
        //判断商品是否为空，根据id没有查询到商品，抛出异常，提示用户商品信息不存 在
        if (goods == null) {
            throw new GoodsException("修改的商品信息不存在!");
        }
        modelMap.addAttribute("goods", goods);
        String[] picsList=goodsService.getAGoodsPics(goods);
        modelMap.addAttribute("picsList",picsList);
        return "/goods/editGoodsInfo";
    }

    @RequestMapping(value = "/saveAlteredGoodsInfo.action")
    public String saveAlteredGoodsInfo(HttpServletRequest request,
                                       @RequestParam(value = "id", required = true) Integer goods_id,
                                       String[] picsSelected,
                                       Goods goods, ModelMap modelMap,
                                       @RequestParam MultipartFile[] goods_pics)throws Exception {
        //get到商品Id
        goods.setId(goods_id);
        //更新文本信息
        goodsService.updateGoods(goods);
        //刷新得到数据库当前该商品信息
        goods=goodsService.findGoodsById(goods_id);
        //删除用户选择的图片
        goodsService.deleteSelectedPics(goods,picsSelected);//这里更新了一次数据库

        goods = goodsService.findGoodsById(goods_id);
        //查看用户有没有新添加图片
        goodsService.setGoodsPics(goods,goods_pics);
        goodsService.updateGoods(goods);
        goods=goodsService.findGoodsById(goods.getId());
        modelMap.addAttribute("goods", goods);
        String[] picsList=goodsService.getAGoodsPics(goods);
        modelMap.addAttribute("picsList",picsList);

        return "/goods/singleGoods";
    }



    //----------------------删除商品-----------------------------------
    @RequestMapping("/deleteGoodsList.action")
    public String deleteGoodsList(Integer[] goods_id) throws Exception {
        goodsService.deleteGoodsListById(goods_id);
        return "/goods/goodsList";
    }


    //---------------------查看我的商品列表-----------------------------
    @RequestMapping("/queryMyGoodsByConditions")
    public String queryMyGoods(HttpSession session, ModelMap modelMap, GoodsQueryVO goodsQueryVO) {
        List<GoodsExtended> goodsList = goodsService.findGoodslistByName(goodsQueryVO);
        modelMap.addAttribute("goodsList", goodsList);
        return "/goods/goodsList";
    }

    @RequestMapping("/queryMyGoods")
    public String queryMyGoods(HttpSession session, ModelMap modelMap) {
        Integer userId = ((User) session.getAttribute("user")).getId();
        List<Goods> goodsList = goodsService.findGoodsByUser(userId);
        modelMap.addAttribute("goodsList", goodsList);
        return "/goods/goodsList";
    }



    //---------------------根据商品ID查看商品单个页面-----------------------
    @RequestMapping("/queryAGoodsByGoodsID")
    public String queryAGoodsByGoodsID(HttpServletRequest request,
                                       @RequestParam(value = "id", required = true) Integer goods_id,
                                       Goods goods, ModelMap modelMap) {
        System.out.println("request:" + goods_id);
        goods.setId(goods_id);
        System.out.println("queryAGoodsByGoodsID" + goods);
        goods = goodsService.findGoodsById(goods_id);
        modelMap.addAttribute("goods", goods);
        String[] picsList=goodsService.getAGoodsPics(goods);
        modelMap.addAttribute("picsList",picsList);
        return "/goods/singleGoods";
    }

}
