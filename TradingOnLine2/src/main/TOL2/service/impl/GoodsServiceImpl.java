package TOL2.service.impl;

import TOL2.mapper.GoodsExtendedMapper;
import TOL2.mapper.GoodsMapper;
import TOL2.model.Goods;
import TOL2.model.GoodsExtended;
import TOL2.model.GoodsQueryVO;
import TOL2.model.User;
import TOL2.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by HuangTing on 2016/4/25.
 */
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsExtendedMapper goodsExtendedMapper;

    public Integer insertGoods(Goods goods, Integer userId) {
        goods.setUserid(userId);
        return goodsMapper.insertSelective(goods);
    }

    public List<Goods> findGoodsByUser(Integer userId) {
        List<Goods> goodsList = goodsMapper.selectByUserId(userId);
        return goodsList;
    }

    public Goods findGoodsById(Integer id) {

        Goods goods = goodsMapper.selectByPrimaryKey(id);
        return goods;
    }

    public void deleteGoods(Goods goods) {
        goodsMapper.deleteByPrimaryKey(goods.getId());
    }

    public void updateGoods(Goods goods) {
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public List<GoodsExtended> findGoodslistByName(GoodsQueryVO goodsQueryVO) {
        return goodsExtendedMapper.findGoodsListByName(goodsQueryVO);
    }

    @Override
    public void deleteGoodsListById(Integer[] id) throws Exception {
        for (int i = 0; i < id.length; i++)
            goodsMapper.deleteByPrimaryKey(id[i]);
    }

    public String[] getAGoodsPics(Goods goods) {
        String pics = goods.getPictures();
        String[] picList = null;
        if (pics != null)
            picList = pics.split(";");
        return picList;
    }

    public void deleteSelectedPics(Goods goods, String[] pics) {
        if (pics != null) {
            if (goods.getPictures() != null) {
                StringBuffer buffer = new StringBuffer(goods.getPictures());
                String pic_path = "D:\\workplace\\IntelliJ IDEA\\TradingOnLine2\\src\\main\\webapp\\pics\\" + goods.getUserid() + "\\";
                for (int i = 0; i < pics.length; i++) {
                    int start = buffer.indexOf(pics[i]);
                    buffer.delete(start, start + pics[i].length() + 1);
                    File file = new File(pic_path + pics[i]);
                    if (file.exists())
                        file.delete();
                }
                goods.setPictures(buffer.toString());
                updateGoods(goods);
            }
        }
    }

    //传入参数goods和图片文件  如果goods之前有图片就合并 goods需要有userid
    public void setGoodsPics(Goods goods, MultipartFile[] goods_pics) throws Exception {
        String pics = "";
        for (MultipartFile goods_pic : goods_pics) {
            if (!goods_pic.isEmpty()) {
                //原始名称
                String originalFilename = goods_pic.getOriginalFilename();
                //上传图片
                System.out.println("name:" + originalFilename);
                if (goods_pic != null && originalFilename != null && originalFilename.length() > 0) {
                    //存储图片的物理路径
                    String pic_path = "D:\\workplace\\IntelliJ IDEA\\TradingOnLine2\\src\\main\\webapp\\pics\\" + goods.getUserid() + "\\";
                    System.out.println(pic_path);

                    //新的图片名称
                    //String newFileName =goods.getId().toString()+ UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                    String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
                    //新图片
                    File newFile = new File(pic_path + newFileName);
                    //将内存中的数据写入磁盘
                    goods_pic.transferTo(newFile);
                    pics = pics + newFileName + ";";
                }
            }
        }
        if (goods.getPictures() != null)
            pics = pics + goods.getPictures();
        goods.setPictures(pics);
    }


    public List<Goods> selectAllGoods(){
        return  goodsMapper.selectAllGoods();
    }

}
