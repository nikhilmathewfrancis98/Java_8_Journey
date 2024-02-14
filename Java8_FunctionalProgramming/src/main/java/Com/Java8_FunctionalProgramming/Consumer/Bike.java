package Com.Java8_FunctionalProgramming.Consumer;

public class Bike {
    private String name;
    private String model;

    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bike)) return false;

        Bike bike = (Bike) o;

        if (!getName().equals(bike.getName())) return false;
        return getModel().equals(bike.getModel());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getModel().hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
