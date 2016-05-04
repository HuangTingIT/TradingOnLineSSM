package TOL2.mapper;

import TOL2.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by HuangTing on 2016/4/27.
 */
public interface PageMapper {
    List<Goods> selectAllGoodsByPage(@Param(value="startPos") Integer startPos,
                                     @Param(value="pageSize") Integer pageSize);
    List<Goods>selectAllGoodsByPageAndUserId(@Param(value="startPos") Integer startPos,
                                             @Param(value="pageSize") Integer pageSize,
                                             @Param(value="userId") Integer userId);
    int getAllGoodsCount();
    int getAllGoodsCountByUserId(Integer userId);
}
