package clone;

/**
 * Created by sarkarri on 2/5/17.
 */
public class Employee implements Cloneable {

    int id;
    String name;
    Department dept;


    public Employee(int id, String name, Department dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Employee e = (Employee) super.clone();
        e.setDept((Department) e.getDept().clone());
        return e;
    }
}
