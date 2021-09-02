import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderService {

    private List<Item> items;

    public int getOrderValue(List<String> names){
        int sum=0;
        for(String item:names){
            Optional<Item> item1=items.stream().filter(x->x.getName().equals(item)).findFirst();
            if(item1.isPresent())
            sum=sum+item1.get().getPrice();
            else
                throw new RuntimeException("Item not found");
        }
        return  sum;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
