package TOL2.controller;

/**
 * Created by HuangTing on 2016/4/24.
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import TOL2.model.User;
import TOL2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class LoginController {

    @Autowired
    private User user;
    @Autowired
    private UserService userService;



    //-------------------登录--------------------------
    @RequestMapping("/main/login")
    public String login()throws Exception {
        return "/main/login";
    }


    @RequestMapping("/loginByTel.action")
    public String loginByTel(HttpServletRequest request, String telephone, String password, ModelMap modelMap)
            throws Exception {
        User user=null;
        if((user=userService.loginByTel(telephone,password))!=null){
            modelMap.addAttribute("user",user);
            //session.setAttribute("user",user);
            WebUtils.setSessionAttribute(request, "user", user);

            return "/user/personalInfo";
        }
        else{

            return "/main/login";
        }
    }





    // 退出
    @RequestMapping("/logout.action")
    public String logout(HttpSession session) throws Exception {

        // 清除session
        session.removeAttribute("user");
        session.invalidate();

        // 重定向到商品列表页面
        return "/main/index";
    }

}