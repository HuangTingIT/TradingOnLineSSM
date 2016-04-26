package TOL2.controller;
import TOL2.model.Goods;
import TOL2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/23.
 */
@Controller//@Controller注解：采用注解的方式，可以明确地定义该类为处理请求的Controller类；
public class MainController {

    @Autowired
    GoodsService goodsService;
    //@RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；
    @RequestMapping(value = "/index", method = {RequestMethod.GET,RequestMethod.POST})
    public String index(ModelMap modelMap) {
        List<Goods> goodsList=goodsService.selectAllGoods();
        modelMap.addAttribute("goodsList",goodsList);
        return "/main/index";//return "index"：处理完该请求后返回的页面，此请求返回 index.jsp页面。
    }




}