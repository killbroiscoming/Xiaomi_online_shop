package com.xiaomi.service;

import com.xiaomi.dao.GoodsTypeMapper;
import com.xiaomi.entry.GoodsType;
import com.xiaomi.entry.GoodsTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品类型，业务处理类
 */
@Service
public class GoodsTypeService {

    @Autowired
    private GoodsTypeMapper goodsTypeMapper;

    /**
     * 查询一级商品类型
     * @return  返回所有的一级商品类型
     */
    public List<GoodsType> findTopLevel(){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidIsNull();//为空说明是一级类型
        return goodsTypeMapper.selectByExample(gte);
    }

    /**
     * 根据一级类型，查询所有所属二级类型
     * @return
     */
    public  List<GoodsType> findSecondLevel(GoodsType top){
        GoodsTypeExample gte = new GoodsTypeExample();
        gte.createCriteria().andPidEqualTo(top.getId());
        return goodsTypeMapper.selectByExample(gte);
    }

    /**
     * 根据指定编号查询一个类型
     * @param goodsTypeId           主键
     * @return                                  商品类型
     */
    public GoodsType findById(Integer goodsTypeId) {
        return goodsTypeMapper.selectByPrimaryKey(goodsTypeId);
    }
}
