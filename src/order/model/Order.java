package order.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {
    private String dish;
    private Double price;
    private LocalDateTime time;

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("dish='").append(dish).append('\'');
        sb.append(", price=").append(price);
        sb.append(", time=").append(time);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Order order)) return false;
        return Objects.equals(dish, order.dish) && Objects.equals(price, order.price) && Objects.equals(time, order.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dish, price, time);
    }
}