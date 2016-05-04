package TOL2.service;

import TOL2.model.GoodsExtended;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HuangTing on 2016/4/27.
 */
public interface PageService {
    public void showAllGoodsByPage(HttpServletRequest request, ModelMap modelMap);
    public void showAllGoodsByPageAndUserId(HttpServletRequest request,Integer userId, ModelMap modelMap);
    public void searchAllGoodsWithConditions(HttpServletRequest request, GoodsExtended goodsExtended, ModelMap modelMap);
}
