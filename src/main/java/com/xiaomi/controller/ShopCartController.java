package com.xiaomi.controller;

import com.xiaomi.entry.Consumer;
import com.xiaomi.entry.GoodsCart;
import com.xiaomi.service.GoodsShoppingService;
import com.xiaomi.service.ShopCartService;
import com.xiaomi.utils.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 购物车业务操作 控制器 数据接口
 */
@Controller
@RequestMapping("/shopcart")
public class ShopCartController {

    @Autowired
    private ShopCartService shopCartService;
    @Autowired
    private GoodsShoppingService goodsShoppingService;

    @GetMapping("/add/{goodsId}")
    @ResponseBody
    public ResponseMessage addGoodsToCart(@PathVariable String goodsId, HttpSession session){
        //获取当前登录用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if(consumer == null ){
            return ResponseMessage.error();
        }
        //加入商品到购物车'
        shopCartService.addGoodsToShopCart(consumer,goodsShoppingService.findGoodsWithId(Integer.parseInt(goodsId)));

        return  ResponseMessage.success();
    }

@GetMapping("/remove/{goodsId}")
@ResponseBody
    public ResponseMessage removeGoodsFormCart(@PathVariable String goodsId,
                                               HttpSession session){
    //获取当前登录用户
    Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
    if(consumer == null ){
        return ResponseMessage.error();
    }
    shopCartService.removeGoodsFromShopCart(consumer,goodsShoppingService.findGoodsWithId(Integer.parseInt(goodsId)));
    return ResponseMessage.success();

    }

    @GetMapping("/chk")
    @ResponseBody
    public ResponseMessage findAllWithConsumer(HttpSession session){
        //获取当前登录用户
        Consumer consumer = (Consumer) session.getAttribute("loginConsumer");
        if(consumer == null ){
            return ResponseMessage.error();
        }
        List<GoodsCart> cartList = shopCartService.findAllGoodsCartWithConsumer(consumer);

        return ResponseMessage.success().addObject("cartList",cartList);
    }

}
