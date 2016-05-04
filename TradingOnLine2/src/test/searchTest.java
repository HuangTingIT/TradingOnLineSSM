
import Base.BaseTest;
import TOL2.mapper.GoodsExtendedMapper;
import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.Page;
import TOL2.service.PageService;
import TOL2.service.UserService;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by HuangTing on 2016/5/1.
 */
@RunWith(JUnit4ClassRunner.class)
public class searchTest extends BaseTest {
    @Autowired
    UserService userService;
    @Autowired
    PageService pageService;
    @Autowired
    GoodsExtendedMapper goodsExtendedMapper;

    /*
    static{
        PropertyConfigurator.configure("classpath:TOL2/conf/log4j.properties");
    }
     */

    @Test
    public void findGoodsWithConditions()throws Exception
    {
        GoodsExtended goodsExtended=new GoodsExtended();
        goodsExtended.setOrder("orderByDefault");
        goodsExtended.setCategory("饰品");
        goodsExtended.setName("书包");
        goodsExtended.setMinPrice(new BigDecimal(10));
        goodsExtended.setMaxPrice(new BigDecimal(10000));
        System.out.println("+++++++++++++++++++");
        int totalCount = goodsExtendedMapper.getGoodsCountWithCondition(goodsExtended);
        System.out.println("+++++++++++++++++++"+totalCount);
        Page page=new Page(totalCount,1);
        goodsExtended.setPage(page);
        List<Goods> goodsList=new ArrayList<Goods>();
        goodsList=goodsExtendedMapper.searchAllGoodsWithConditions(goodsExtended);
        //System.out.println(goodsList);
    }
}
