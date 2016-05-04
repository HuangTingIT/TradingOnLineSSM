package TOL2.service.impl;

import TOL2.mapper.GoodsExtendedMapper;
import TOL2.mapper.PageMapper;
import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.Page;
import TOL2.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuangTing on 2016/4/27.
 */
public class PageServiceImpl implements PageService{
    @Autowired
    PageMapper pageMapper;
    @Autowired
    GoodsExtendedMapper goodsExtendedMapper;
    @Override
    public void showAllGoodsByPage(HttpServletRequest request, ModelMap modelMap){
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<Goods> goodsList = new ArrayList<Goods>();
        int totalCount = pageMapper.getAllGoodsCount();
        if (pageNow != null) {
            System.out.println("pageNow:"+pageNow);
            page = new Page(totalCount, Integer.parseInt(pageNow));
            goodsList = this.pageMapper.selectAllGoodsByPage(page.getStartPos(), page.getPageSize());
            System.out.println("GoodsList:"+goodsList.size());
        } else {
            System.out.println("pageNow:"+pageNow);
            page = new Page(totalCount, 1);
            goodsList = this.pageMapper.selectAllGoodsByPage(page.getStartPos(), page.getPageSize());
            System.out.println("GoodsList:"+goodsList.size());
        }

        modelMap.addAttribute("goodsList", goodsList);
        modelMap.addAttribute("page", page);
    }
    @Override
    public void showAllGoodsByPageAndUserId(HttpServletRequest request,Integer userId, ModelMap modelMap){
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<Goods> goodsList = new ArrayList<Goods>();
        int totalCount = pageMapper.getAllGoodsCount();
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            goodsList = this.pageMapper.selectAllGoodsByPageAndUserId(page.getStartPos(), page.getPageSize(),userId);
            System.out.println("GoodsList:"+goodsList.size());
        } else {
            page = new Page(totalCount, 1);
            goodsList = this.pageMapper.selectAllGoodsByPageAndUserId(page.getStartPos(), page.getPageSize(),userId);
        }

        modelMap.addAttribute("goodsList", goodsList);
        modelMap.addAttribute("page", page);
    }
    public void searchAllGoodsWithConditions(HttpServletRequest request, GoodsExtended goodsExtended,ModelMap modelMap){
        goodsExtended.setOrder(request.getParameter("order"));;
        String pageNow = request.getParameter("pageNow");
        Page page = null;
        List<Goods> goodsList = new ArrayList<Goods>();
        int totalCount = goodsExtendedMapper.getGoodsCountWithCondition(goodsExtended);
        if (pageNow != null) {
            page = new Page(totalCount, Integer.parseInt(pageNow));
            goodsExtended.setPage(page);

            goodsList=goodsExtendedMapper.searchAllGoodsWithConditions(goodsExtended);
            System.out.println("goodsList；"+goodsList);
        } else {
            page = new Page(totalCount, 1);
            goodsExtended.setPage(page);
            goodsList=goodsExtendedMapper.searchAllGoodsWithConditions(goodsExtended);
            System.out.println("goodsList；"+goodsList);
        }
        System.out.println(goodsExtended);
        modelMap.addAttribute("goodsList", goodsList);
        modelMap.addAttribute("page", page);
    }
}
