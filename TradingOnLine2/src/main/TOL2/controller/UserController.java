package TOL2.controller;

import TOL2.model.User;
import TOL2.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by HuangTing on 2016/4/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;




    //-------------------查询信息--------------------------
    /*
    * @RequestMapping("/queryUserById")
    public String  queryUserById(Model model,User user)throws Exception{
        if(user!=null)
            model.addAttribute("user",user);
        return "/user/personalInfo";
    }**/
    @RequestMapping("/queryPersonalInfo")
    public String queryPersonalInfo(HttpSession session,ModelMap modelMap)throws Exception{
        User user=(User)session.getAttribute("user");
        if(user!=null)
            modelMap.addAttribute("user",user);
        return "/user/personalInfo";
    }


    @RequestMapping(value = "/querySellerInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public String querySellerInfo(@RequestParam(value = "sellerId",required =true) Integer sellerId,
                                  ModelMap modelMap)throws Exception{
        User seller=userService.findUserById(sellerId);
        modelMap.addAttribute("seller",seller);
        return "/user/sellerInfo";
    }
    //-------------------注册--------------------------
    @RequestMapping("/register")
    public String register()throws Exception{
        return "/user/register";
    }
    @RequestMapping("/saveRegisterInfo.action")
    public String saveRegisterInfo(HttpSession session, User user, ModelMap modelMap)throws Exception{
        userService.insertUser(user);
        if(user!=null)
        {
            session.setAttribute("user",user);
            modelMap.addAttribute("user",user);
        }
        return "/user/personalInfo";
    }



    //-------------------更新完善信息
    @RequestMapping("/editPersonalInfo.action")
    public String editPersonalInfo(HttpSession session,ModelMap modelMap){
        User user=null;
        if((user=(User)session.getAttribute("user"))!=null)
            modelMap.addAttribute("user",user);
        return "/user/editPersonalInfo";
    }


    @RequestMapping("/UpdateUserInfo.action")
    public String UpdateUserInfo(HttpSession session,User nuser,ModelMap modelMap)throws Exception{
        Integer id=((User)session.getAttribute("user")).getId();
        if(id!=null)
            userService.updateUser(id,nuser);
        User user=userService.findUserById(id);
        session.setAttribute("user",user);
        modelMap.addAttribute("user",user);
        return "/user/personalInfo";
    }
    //public
}
