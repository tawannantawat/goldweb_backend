package com.example.goldshop.service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class GoldPriceService {

    public GoldPrice getGoldPrice() throws Exception {
    Document doc = Jsoup.connect("https://www.goldtraders.or.th").get();

    String goldBarBuyStr = doc.select("#DetailPlace_uc_goldprices1_lblBLBuy").text().replace(",", "").trim();
    String goldBarSellStr = doc.select("#DetailPlace_uc_goldprices1_lblBLSell").text().replace(",", "").trim();
    String goldJewelryBuyStr = doc.select("#DetailPlace_uc_goldprices1_lblOMBuy").text().replace(",", "").trim();
    String goldJewelrySellStr = doc.select("#DetailPlace_uc_goldprices1_lblOMSell").text().replace(",", "").trim();

    System.out.println("🔍 goldBarBuyStr: " + goldBarBuyStr);
    System.out.println("🔍 goldBarSellStr: " + goldBarSellStr);
    System.out.println("🔍 goldJewelryBuyStr: " + goldJewelryBuyStr);
    System.out.println("🔍 goldJewelrySellStr: " + goldJewelrySellStr);

    double barBuy = Double.parseDouble(goldBarBuyStr);
    double barSell = Double.parseDouble(goldBarSellStr);
    double jewelryBuy = Double.parseDouble(goldJewelryBuyStr);
    double jewelrySell = Double.parseDouble(goldJewelrySellStr);

    System.out.println("📌 barBuy: " + barBuy);
    System.out.println("📌 barSell: " + barSell);
    System.out.println("📌 jewelryBuy: " + jewelryBuy);
    System.out.println("📌 jewelrySell: " + jewelrySell);

    return new GoldPrice(barBuy, barSell, jewelryBuy, jewelrySell);
}


    public static class GoldPrice {
        public double barBuy;
        public double barSell;
        public double jewelryBuy;
        public double jewelrySell;

        public GoldPrice(double barBuy, double barSell, double jewelryBuy, double jewelrySell) {
            this.barBuy = barBuy;
            this.barSell = barSell;
            this.jewelryBuy = jewelryBuy;
            this.jewelrySell = jewelrySell;
        }
    }
}