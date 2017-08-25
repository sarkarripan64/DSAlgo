package designpatterns;

/**
 * Created by sarkarri on 2/7/17.
 */
public class User {
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public static class UserBuilder {
        //All final attributes
        private final String firstName; // required
        private final String lastName; // required
        private int age; // optional
        private String phone; // optional
        private String address; // optional

        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setphone(String phn) {
            this.phone = phn;
            return this;
        }

        public User build() {
            User u = new User(this);
            return u;
        }
    }

    public static void main(String[] args) {
        User u = new User.UserBuilder("ripan", "sarkar").setAge(31).setphone("1234").build();
    }
}
