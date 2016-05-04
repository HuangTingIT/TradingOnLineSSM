package TOL2.controller;

import TOL2.model.User;
import TOL2.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by HuangTing on 2016/5/1.
 */
@Controller
public class PageController {
    @Autowired
    private PageService pageService;
    @RequestMapping(value = "/concretePage",method = {RequestMethod.GET,RequestMethod.POST})
    public String concretePage(HttpServletRequest request, ModelMap modelMap){
        this.pageService.showAllGoodsByPage(request,modelMap);
        return "/main/index";
    }

    @RequestMapping(value = "/concretePageWithConditions",method = {RequestMethod.GET,RequestMethod.POST})
    public String concretePageWithConditions(HttpServletRequest request, HttpSession session, ModelMap modelMap){
        Integer userId = ((User) session.getAttribute("user")).getId();
        pageService.showAllGoodsByPageAndUserId(request,userId,modelMap);
        return "/goods/goodsList";
    }
}
