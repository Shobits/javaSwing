package org.example.service.Impl;

import org.example.dao.GoodsDao;
import org.example.dao.SaleDao;
import org.example.entity.Goods;
import org.example.entity.Sale;
import org.example.service.BuyGoodsService;

public class BuyGoodsServiceImpl implements BuyGoodsService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void addSale() {
    }

    public void addGoods() {
    }

    public void modifySale() {
    }

    public void modifyGoods() {
    }

    public void removeSale() {
    }

    public void removeGoods() {
    }

    public void querySale() {
    }

    public void findGoods() {
    }


    @Override
    public void buy(Integer goodsId, Integer nums) {
        System.out.println("=====buy方法的开始=====");
        //生成销售记录
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNum(nums);
        saleDao.insertSale(sale);

        //查询商品
        Goods goods = goodsDao.selectById(goodsId);
        if (goods == null) {
            throw new NullPointerException(goodsId + "，商品不存在");
        } else if (goods.getAmount() < nums) {
            throw new NullPointerException(goodsId + "，商品库存不足");
        }

        //更新库存
        Goods buyGoods = new Goods();
        buyGoods.setId(goodsId);
        buyGoods.setAmount(nums);
        goodsDao.updateGoods(buyGoods);

        System.out.println("=====buy方法的结束=====");
    }
}
