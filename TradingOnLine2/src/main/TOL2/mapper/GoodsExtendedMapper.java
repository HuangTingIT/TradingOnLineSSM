package TOL2.mapper;

import TOL2.model.GoodsExtended;
import TOL2.model.GoodsQueryVO;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/25.
 */
public interface GoodsExtendedMapper {
    public List<GoodsExtended> findGoodsListByName(GoodsQueryVO goodsQueryVO);
}
