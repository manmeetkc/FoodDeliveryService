import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class FoodDeliveryService {
    final Integer maxSlots = 7;
    public void processOrders(List<Order> orderList) {
        Double []freeUpTime = new Double[7];
        Integer currentSlot = 0;
        Integer availableSlots = maxSlots;
        for(Order order : orderList){
            Integer requiredSlots = 0;
            Double timeTaken = 0.0;
            for(MealType mealType : order.getMeals()){
                timeTaken = max(timeTaken,mealType.getCookingTime());
                requiredSlots += mealType.getCookingSlots();
            }
            timeTaken+= order.getDistance()*8;
            if(requiredSlots>maxSlots || timeTaken>150){
                System.out.println("Order " + order.getOrderId() +" is denied because the restaurant cannot accommodate it.");
                continue;
            } else{
                if(requiredSlots<=availableSlots){
                        System.out.println("Order "+ order.getOrderId()+" will get delivered in "+ timeTaken+" minutes.");
                        availableSlots -= requiredSlots;
                        while(requiredSlots>0){
                            freeUpTime[currentSlot] = timeTaken;
                            currentSlot++;
                            requiredSlots--;

                        }


                }else{
                    Arrays.sort(freeUpTime);

                    timeTaken+=freeUpTime[requiredSlots-1];
                    if(timeTaken>150){
                        System.out.println("Order " + order.getOrderId() +" is denied because the restaurant cannot accommodate it.");
                    }
                    else{
                        System.out.println("Order "+ order.getOrderId()+" will get delivered in "+ timeTaken+" minutes.");

                    }

                }

            }
        }


    }
}
