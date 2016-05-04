package TOL2.model;

import java.math.BigDecimal;

/**
 * Created by HuangTing on 2016/4/25.
 */

public class GoodsExtended extends Goods {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Page page;
    private String order;
    public GoodsExtended() {
        super();
    }

    @Override
    public String toString() {
        return "GoodsExtended{" +
                "minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", page=" + page +
                ", order='" + order + '\'' +
                "} " + super.toString();
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
