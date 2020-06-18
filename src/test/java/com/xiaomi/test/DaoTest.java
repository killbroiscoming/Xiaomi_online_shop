package com.xiaomi.test;

import com.xiaomi.dao.ConsumerMapper;
import com.xiaomi.entry.Consumer;
import com.xiaomi.entry.ConsumerExample;
import com.xiaomi.entry.Goods;
import com.xiaomi.service.GoodsShoppingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DaoTest {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Test
    public void testConsumerInsert(){
        //创建consumer对象
        Consumer consumer = new Consumer("lisa","123456");
        //将consumer对象增加到数据库中
        consumerMapper.insertSelective(consumer);
        System.out.println("数据Insert执行完成");

    }

    @Test
    public void testConsumerSelectById(){
        Consumer consumer = consumerMapper.selectByPrimaryKey(1);
        System.out.println(consumer);
    }

    @Test
    public void testConsumerSelectByExample(){
        //创建一个查询条件【账号+密码】
        ConsumerExample ce = new ConsumerExample();
        ce.createCriteria().andUsernameEqualTo("lisa")
                .andPasswordEqualTo("123456");
        //查询数据
        List<Consumer> consumers = consumerMapper.selectByExample(ce);
        for (Consumer consumer : consumers) {
            System.out.println(consumer);
        }

    }

    @Autowired
    private GoodsShoppingService goodsShoppingService;

    @Test
    public void testSearchGoods(){

        List<Goods> goodsList = goodsShoppingService.searchGoodsWithName("小米");
        for (Goods goods: goodsList             ) {
            System.out.println(goods.getName());
        }
    }

}
