package flower.store.lab8.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract  class Item {
    @Setter
    private String description;

    public abstract double getPrice();
}