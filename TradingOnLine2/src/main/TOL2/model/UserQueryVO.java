package TOL2.model;

/**
 * Created by HuangTing on 2016/4/23.
 */
import java.util.List;
public class UserQueryVO {

    //传入多个id
    private List<Integer> ids;


    //在这里包装所需要的查询条件

    //用户查询条件
    private UserExtended userCustom;

    public UserExtended getUserExtended() {
        return userCustom;
    }

    public void setUserExtended(UserExtended userCustom) {
        this.userCustom = userCustom;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    //可以包装其它的查询条件，订单、商品
    //....


}
