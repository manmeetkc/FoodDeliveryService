import lombok.Data;

import java.util.List;

@Data
public class Order {
    String orderId;
    List<MealType> meals;
    Double distance;
}
