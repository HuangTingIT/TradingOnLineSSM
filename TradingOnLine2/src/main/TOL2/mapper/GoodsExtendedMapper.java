package TOL2.mapper;

import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.GoodsQueryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/25.
 */
public interface GoodsExtendedMapper {
    public List<GoodsExtended> findGoodsListByName(GoodsQueryVO goodsQueryVO);
    public List<Goods> searchAllGoodsWithConditions(GoodsExtended goodsExtended);

    public Integer getGoodsCountWithCondition(GoodsExtended goodsExtended);
}
