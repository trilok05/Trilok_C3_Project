import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    public void init(){
        orderService=new OrderService();
        Item item1=new Item("ItemA",200);
        Item item2=new Item("ItemB",300);
        Item item3=new Item("ItemC",400);
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
// adding items
        orderService.setItems(items);
    }

    @Test
    public void test_expected_order_value_Without_exception(){
       Assertions.assertEquals(600,orderService.getOrderValue(Arrays.asList("ItemA","ItemC")));
    }

    @Test
    public void test_expected_order_value_With_exception(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            orderService.getOrderValue(Arrays.asList("ItemD"));
        });
    }
}