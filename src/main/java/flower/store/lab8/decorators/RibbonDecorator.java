package flower.store.lab8.decorators;

import flower.store.lab8.model.Item;

public class RibbonDecorator extends ItemDecorator{

    private final Item item;

    public RibbonDecorator(Item item){
        this.item = item;
    }

    @Override
    public double getPrice(){
        return  40 + item.getPrice();
    }

}