public enum MealType {

    A(17,1),
    M(29,2);

    Integer cookingTime;
    Integer cookingSlots;

    MealType(Integer cookingTime, Integer cookingSlots) {
        this.cookingTime = cookingTime;
        this.cookingSlots = cookingSlots;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public Integer getCookingSlots() {
        return cookingSlots;
    }
}
