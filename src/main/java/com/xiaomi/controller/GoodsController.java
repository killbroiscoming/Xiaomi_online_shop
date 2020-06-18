package com.xiaomi.controller;


import com.xiaomi.entry.Goods;
import com.xiaomi.service.GoodsShoppingService;
import com.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsShoppingService goodsShoppingService;

    @GetMapping("/detail/{gid}")
    @ResponseBody
    public ResponseMessage findGoodsWithId(@PathVariable String gid){
        Goods goodsWithId = goodsShoppingService.findGoodsWithId(Integer.parseInt(gid));

        return ResponseMessage.success().addObject("goodsWithId",goodsWithId);
    }


}
