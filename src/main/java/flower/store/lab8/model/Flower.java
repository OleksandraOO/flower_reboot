package flower.store.lab8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "flowers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flower extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String color;
    private double price;
    private boolean available;

    public Flower(String name, String color, double price, boolean available) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.available = available;
    }

    @Override
    public double getPrice(){
        return this.price;
    }

    public String getColor() {
        return color.toString();
    }

}