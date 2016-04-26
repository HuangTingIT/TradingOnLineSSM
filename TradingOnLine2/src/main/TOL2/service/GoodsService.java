package TOL2.service;

import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.GoodsQueryVO;
import TOL2.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/24.
 */
public interface GoodsService {
    public Integer insertGoods(Goods goods,Integer userid);
    public String[] getAGoodsPics(Goods goods);
    public List<Goods> findGoodsByUser(Integer userId);
    public List<GoodsExtended> findGoodslistByName(GoodsQueryVO goodsQueryVO);
    public Goods findGoodsById(Integer id);
    public void deleteGoods(Goods goods);
    public void deleteGoodsListById(Integer[] id)throws Exception;
    public void updateGoods(Goods goods);
    public void deleteSelectedPics(Goods goods,String[]pics);
    public void setGoodsPics(Goods goods, MultipartFile[]goods_pics)throws Exception;
    public List<Goods> selectAllGoods();
}
