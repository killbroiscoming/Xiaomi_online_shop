package com.xiaomi.service;

import com.xiaomi.dao.GoodsCartMapper;
import com.xiaomi.entry.Consumer;
import com.xiaomi.entry.Goods;
import com.xiaomi.entry.GoodsCart;
import com.xiaomi.entry.GoodsCartExample;
import javafx.scene.chart.PieChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 购物车相关业务处理类
 */
@Service
public class ShopCartService {

    @Autowired
    private GoodsCartMapper goodsCartMapper;

    /**
     *指定商品加入购物车
     * @param goods     要加入购物车的商品
     * @return              返回加入结果
     */
    public boolean addGoodsToShopCart(Consumer consumer,Goods goods){
        //判断商品在购物车是否存在
        List<GoodsCart> cartList = this.chkGoods(consumer,goods);
        if (cartList.size() > 0){

            //更新购买数量
           int count = cartList.get(0).getBuyCount() ;
            cartList.get(0).setBuyCount(count+1);

            //更新小计金额  =
            // （getSubtotal原来小计金额 ）getSubtotal() /count =单价  乘以当前购买数量
            double price = cartList.get(0).getSubtotal() / count * cartList.get(0).getBuyCount();
            cartList.get(0).setSubtotal(price);
        }else {
            //新增商品
            //Integer goodsId, Integer buyCount, Date addDate, Double subtotal, Integer consumerId
            GoodsCart goodsCart = new GoodsCart(goods.getId(),1,new Date(),goods.getPrice(),consumer.getId());
            goodsCartMapper.insert(goodsCart);
        }

        return true;
    }

    /**
     * 从购物车中删除指定的商品
     * @param goods     要删除的商品
     * @return                  返回删除结果
     */
    public boolean removeGoodsFromShopCart(Consumer consumer,Goods goods){
        //判断商品在购物车是否存在
        List<GoodsCart> cartList = this.chkGoods(consumer,goods);
        if(cartList.size() > 0){
            //商品存在，删除
            goodsCartMapper.deleteByPrimaryKey(cartList.get(0).getId());
            return true;
        }
        System.out.println("商品不存在");
        return false;
    }

    /**
     * 查询指定用户购物车中所有商品
     * @param consumer      指定用户
     * @return                      返回该用户的所有商品
     */
    public List<GoodsCart> findAllGoodsCartWithConsumer(Consumer consumer){
            GoodsCartExample gce = new GoodsCartExample();
        gce.createCriteria().andConsumerIdEqualTo(consumer.getId());

        return  goodsCartMapper.selectByExample(gce);
    }


    /**
     * 判断某个商品在购物车中是否存在
     * @param consumer      所属商品
     * @param goods                 商品对象
     * @return                  商品数据
     */
    private List<GoodsCart> chkGoods(Consumer consumer,Goods goods){
        GoodsCartExample gc = new GoodsCartExample();

        //查询指定的商品在当前用户的购物车中是否存在
        gc.createCriteria().andConsumerIdEqualTo(consumer.getId())
                .andGoodsIdEqualTo(goods.getId());
        //查询操作
        List<GoodsCart> cartList = goodsCartMapper.selectByExample(gc);

        return cartList;
    }

}
