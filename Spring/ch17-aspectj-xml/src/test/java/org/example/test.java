package org.example;

import org.example.service.BuyGoodsService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
    @Test
    public void test() {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        BuyGoodsService buyService = (BuyGoodsService) ctx.getBean("buyService");
        System.out.println("service == " + buyService.getClass().getName());

        buyService.buy(1001, 20);
    }

}
