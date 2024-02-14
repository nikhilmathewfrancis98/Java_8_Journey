package Com.Java8_FunctionalProgramming.SupplierFunctionalInterface;

import java.util.function.Supplier;

public class SupplierExtending implements Supplier<SupplierFunctional> {
private Object thisOject;

    public SupplierExtending(Object thisOject) {
        this.thisOject = thisOject;
    }





    @Override
    public SupplierFunctional get() {
        return (SupplierFunctional) this.thisOject;
    }
}
