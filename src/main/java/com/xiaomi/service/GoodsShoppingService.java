package com.xiaomi.service;

import com.xiaomi.dao.GoodsMapper;
import com.xiaomi.dao.GoodsTypeMapper;
import com.xiaomi.entry.Goods;
import com.xiaomi.entry.GoodsExample;
import com.xiaomi.entry.GoodsType;
import com.xiaomi.entry.GoodsTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品 业务处理类
 * 1、根据商品类型查询商品
 */
@Service
public class GoodsShoppingService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private  GoodsTypeService goodsTypeService;

    /**
     * 根据商品类型查询商品
     * @param goodsType     二级商品类型
     * @return             属于指定商品类型的所有商品
     */
    public List<Goods> findGoodsWithType(GoodsType goodsType){
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andGoodsTypeIdEqualTo(goodsType.getId());


        return goodsMapper.selectByExample(ge);

    }

    /**
     * 根据名称模糊搜索商品数据
     * @param name      商品名称
     * @return                  返回符合搜索条件的商品
     */
    public List<Goods> searchGoodsWithName(String name){
        //构建条件
        GoodsExample ge = new GoodsExample();
        ge.createCriteria().andNameLike("%"+name+"%");
        return goodsMapper.selectByExample(ge);
    }


    /**
     * 根据一级类型查询商品数据
     * @param goodsType     一级类型
     * @return      返回所有商品
     */
    public List<Goods> findGoodsWithToptype(GoodsType goodsType){
        //根据一级类型查询所有所属二级类型
        List<GoodsType> gt =goodsTypeService.findSecondLevel(goodsType);

        //查询所有二级类型下的所有商品
        List<Goods> goodsList = new ArrayList<Goods>();


        for (int i = 0 ; i < gt.size() ; i ++){

            List<Goods> goods = this.findGoodsWithType(gt.get(i));

            goodsList.addAll(goods);
        }

        return goodsList;
    }


    /**
     * 根据id查询商品     完善对应的GoodsMapper.xml查询
     * @param gid       商品编号
     * @return              返回查询到的商品
     */
    public Goods findGoodsWithId(Integer gid){


        return goodsMapper.selectByPrimaryKey(gid);

    }


}
