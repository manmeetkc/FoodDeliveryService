import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;

public class Driver {
   final Integer maxSlots = 7;
    public static void main(String[] args) throws JsonProcessingException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ObjectMapper mapper = new ObjectMapper();
        List<Order> orderList = mapper.readValue(input,new TypeReference<List<Order>>(){});
        FoodDeliveryService foodDeliveryService = new FoodDeliveryService();
        foodDeliveryService.processOrders(orderList);

    }




}
