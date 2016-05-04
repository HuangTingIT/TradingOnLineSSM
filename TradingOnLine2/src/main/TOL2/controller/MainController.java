package TOL2.controller;
import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.Page;
import TOL2.service.GoodsService;
import TOL2.service.PageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HuangTing on 2016/4/23.
 */
@Controller//@Controller注解：采用注解的方式，可以明确地定义该类为处理请求的Controller类；
public class MainController {
    private static final Logger logger = Logger.getLogger(MainController.class);
    @Autowired
    GoodsService goodsService;
    @Autowired
    PageService pageService;
    @Autowired
    GoodsExtended goodsExtended;
    @ModelAttribute("categorys")
    public Map<String, String> getItemTypes() {
        Map<String, String> itemTypes = new HashMap<String, String>();
        itemTypes.put("101", "电子");
        itemTypes.put("102", "饰品");

        return itemTypes;
    }

    //@RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；
    @RequestMapping(value = "/index", method = {RequestMethod.GET,RequestMethod.POST})
    public String index(HttpServletRequest request,ModelMap modelMap) {
        //此处的productService是注入的IProductService接口的对象
        this.pageService.showAllGoodsByPage(request, modelMap);
        modelMap.addAttribute("goodsExtended",goodsExtended);
        return "/main/index";//return "index"：处理完该请求后返回的页面，此请求返回 index.jsp页面。
    }
    @RequestMapping(value = "/searchFromAllWithConditions", method = {RequestMethod.GET,RequestMethod.POST})
    public String searchFromAllWithConditions(HttpServletRequest request,GoodsExtended goodsExtended,ModelMap modelMap){
        pageService.searchAllGoodsWithConditions(request,goodsExtended,modelMap);
        return "/main/index";
    }



}