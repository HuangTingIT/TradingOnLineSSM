package TOL2.model;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/25.
 */
public class GoodsQueryVO extends Goods {
    private Goods goods;
    private UserExtended userExtended;
    private GoodsExtended goodsExtended;
    private List<GoodsExtended> goodsExtendedList;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public UserExtended getUserExtended() {
        return userExtended;
    }

    public void setUserExtended(UserExtended userExtended) {
        this.userExtended = userExtended;
    }

    public GoodsExtended getGoodsExtended() {
        return goodsExtended;
    }

    public void setGoodsExtended(GoodsExtended goodsExtended) {
        this.goodsExtended = goodsExtended;
    }

    public List<GoodsExtended> getGoodsExtendedList() {
        return goodsExtendedList;
    }

    public void setGoodsExtendedList(List<GoodsExtended> goodsExtendedList) {
        this.goodsExtendedList = goodsExtendedList;
    }

    @Override
    public String toString() {
        return "GoodsQueryVO{" +
                "goods=" + goods +
                ", userExtended=" + userExtended +
                ", goodsExtended=" + goodsExtended +
                ", goodsExtendedList=" + goodsExtendedList +
                '}';
    }
}
