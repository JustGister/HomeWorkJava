public class Phone implements Comparable<Phone> {
    private String company;
    private String model;
    private int price;
    
    public Phone(String company, String model, int price) {
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Phone other) {
        return Double.compare(this.price, other.price);
    }
}
