import java.util.List;

public class Computer {
    private String name;
    private String origin;
    private int price;
    private List<String> types;
    private boolean critical;
    public Computer(String Name, String Origin, int Price,List<String> Type, boolean Critical)
    {
        this.name = Name;
        this.origin = Origin;
        this.price = Price;
        this.types = Type;
        this.critical = Critical;
    }
    public Computer(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }
    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", types=" + types +
                ", critical=" + critical +
                '}';
    }
}
