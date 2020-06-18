package com.xiaomi.utils;

import com.xiaomi.entry.Goods;
import com.xiaomi.entry.GoodsType;
import com.xiaomi.service.GoodsShoppingService;
import com.xiaomi.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 辅助文件控制器
 */
@Controller
@RequestMapping("/u")
public class UtiilsController {

    @Autowired
    private GoodsShoppingService shoppingService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    @GetMapping("/search/{name}")
    @ResponseBody
    public ResponseMessage searchGoodsWithName(@PathVariable String name){

        List<Goods> goodsList = shoppingService.searchGoodsWithName(name);

        return goodsList.size() > 0 ? ResponseMessage.success().addObject("goodsList",goodsList)
                : ResponseMessage.error();
    }


    /**
     * 根据类型查看商品
     * @param level              类型级别 1  一级类型  2 二级类型
     * @param goodsTypeId       类型编号
     * @return              返回响应数据
     */
    @GetMapping("/search/{level}/{goodsTypeId}")
    @ResponseBody
    public ResponseMessage searchGoodsWithType(@PathVariable String level,
                                               @PathVariable String goodsTypeId){

        //根据编号查询类型
        GoodsType goodsType = goodsTypeService.findById(Integer.parseInt(goodsTypeId));
        List<Goods> goodsList = null;

        //判断类型级别
        if("1".equals(level)){
            goodsList = shoppingService.findGoodsWithToptype(goodsType);

        }else if("2".equals(level) ){

             goodsList = shoppingService.findGoodsWithType(goodsType);

        }


        return goodsList != null && goodsList .size()> 0
                ? ResponseMessage.success().addObject("goodsList",goodsList)
                : ResponseMessage.error();
    }

}
