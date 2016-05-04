package TOL2.service.impl;

import TOL2.exception.UserException;
import TOL2.mapper.*;
import TOL2.model.User;
import TOL2.model.UserQueryVO;
import TOL2.other.CodeUtils;
import TOL2.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

/**
 * Created by HuangTing on 2016/4/24.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    public User findUserById(Integer id) throws Exception{
        User user = userMapper.selectByPrimaryKey(id);
        if(user==null){
            throw new UserException("没有此人!");
        }
        //中间对商品信息进行业务处理
        //....
        //返回ItemsCustom
        return user;
        /*
        * UserQueryVO userQueryVO = null;
        //将items的属性值拷贝到itemsCustom
        if(user!=null){
            userQueryVO = new UserQueryVO();
            BeanUtils.copyProperties(user, userQueryVO);
        }


        return userQueryVO;*/
    }

    public void updateUser(Integer id,User user)throws Exception{
        //添加业务校验，通常在service接口对关键参数进行校验
        //校验 id是否为空，如果为空抛出异常

        //更新商品信息使用updateByPrimaryKeyWithBLOBs根据id更新items表中所有字段，包括 大文本类型字段
        //updateByPrimaryKeyWithBLOBs要求必须转入id
        user.setId(id);
        userMapper.updateByPrimaryKeySelective(user);
        System.out.println("gengxin "+user);
    }
    public void insertUser(User user)throws Exception{
        String salt=CodeUtils.getSalt();
        String hashpass=CodeUtils.getHash(user.getPassword(),salt);
        user.setPassword(hashpass);
        Integer id=userMapper.insertUser(user);
        System.out.println("id:"+id);
        userMapper.insertSalt(id,salt);
    }
    public User loginByTel(String telephone,String password)throws Exception{
        User user=userMapper.findUserByTel(telephone);
        if(user!=null){
            String salt= userMapper.findSalt(user.getId());
            String hashpass= CodeUtils.getHash(user.getPassword(),salt);
            boolean flag=CodeUtils.verify(hashpass,user.getPassword(),salt);
            if(!flag){
                user=null;
                System.out.println("login succeed!");
            }

        }
        return user;
    }
}
