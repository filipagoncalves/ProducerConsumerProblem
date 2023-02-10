public enum Dishes {
    PLATE_1("Pizza"),
    PLATE_2("Lasagna"),
    PLATE_3("Pasta"),
    PLATE_4("Cannelloni"),
    PLATE_5("Veggie Lasagna");

    private final String dish;

    Dishes (String dish) {
        this.dish = dish;
    }

    public String getDish() {
        return dish;
    }
}
