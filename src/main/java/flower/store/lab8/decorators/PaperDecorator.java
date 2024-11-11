package flower.store.lab8.decorators;

import flower.store.lab8.model.Item;

public class PaperDecorator extends ItemDecorator{

    private final Item item;

    public PaperDecorator(Item item){
        this.item = item;
    }

    @Override
    public double getPrice(){
        return  13 + item.getPrice();
    }

}