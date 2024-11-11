package flower.store.lab8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.store.lab8.model.Flower;
import flower.store.lab8.model.FlowerBucket;
import flower.store.lab8.model.FlowerPack;
import flower.store.lab8.decorators.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

public class FlowerTest {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int MAX_PRICE = 100;
    private Flower flower;
    private Flower flowerSecond;
    private FlowerPack pack, packSecond;
    private FlowerBucket bucket;

    @BeforeEach
    public void init() {
        flower = new Flower();
        flowerSecond = new Flower();
    }

    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int priceSecond = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        flowerSecond.setPrice(priceSecond);
        Assertions.assertEquals(price, flower.getPrice());

        pack = new FlowerPack(flower, RANDOM_GENERATOR.nextInt(MAX_PRICE));
        Assertions.assertEquals(price*pack.getQuantity(), pack.getPrice());

        packSecond = new FlowerPack(
                flowerSecond,
                RANDOM_GENERATOR.nextInt(MAX_PRICE));

        Assertions.assertEquals(
                priceSecond*packSecond.getQuantity(),
                packSecond.getPrice());

        bucket = new FlowerBucket(pack, packSecond);
        Assertions.assertEquals(
                bucket.getPrice(),
                packSecond.getPrice()+pack.getPrice());
    }

    @Test
    public void testBasicItemPrice() {
        Flower item = new Flower("Rose", "Red", 100, true);
        assertEquals(100, item.getPrice(), 0.01);
    }

    @Test
    public void testRibbonDecorator() {
        ItemDecorator item = new RibbonDecorator(new Flower("Rose", "Red", 100, true));
        assertEquals(140, item.getPrice(), 0.01);
    }

    @Test
    public void testPaperDecorator() {
        ItemDecorator item = new PaperDecorator(new Flower("Rose", "Red", 100, true));
        assertEquals(113, item.getPrice(), 0.01);
    }

    @Test
    public void testMultipleDecorators() {
        ItemDecorator item = new RibbonDecorator(new PaperDecorator(new Flower("Rose", "Red", 100, true)));
        assertEquals(153, item.getPrice(), 0.01);
    }
}
