package TOL2.service;

import TOL2.model.User;

/**
 * Created by HuangTing on 2016/4/24.
 */
public interface UserService {
    public User findUserById(Integer id) throws Exception;
    public void updateUser(Integer id,User user)throws Exception;
    public void insertUser(User user)throws Exception;
    public User loginByTel(String telephone,String password)throws Exception;
}
