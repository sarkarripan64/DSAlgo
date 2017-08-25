package clone;

/**
 * Created by sarkarri on 2/5/17.
 */
public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Department dept = new Department(1,"HR");

        Employee e = new Employee(111,"Ripan",dept);

        Employee clone = (Employee) e.clone();

        System.out.println(clone.hashCode() == e.hashCode());

        clone.getDept().setDepName("Admin");

        System.out.println(e.getDept().getDepName());

    }
}
