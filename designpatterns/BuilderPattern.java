package designpatterns;

/**
 * Created by sarkarri on 5/16/17.
 */
public class BuilderPattern {
    Computer computer = new Computer.ComputerBuilder("4gb", "500gb").setBluetoothRequired(false).setGraphicsCardRequired(true).build();
}

class Computer {
    private String ram;
    private String hdd;
    private boolean isGraphicsCardRequired;
    private boolean isBluetoothRequired;

    private Computer(ComputerBuilder builder) {
        this.ram = builder.ram;
        this.hdd = builder.hdd;
        this.isBluetoothRequired = builder.isBluetoothRequired;
        this.isGraphicsCardRequired = builder.isGraphicsCardRequired;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public boolean isGraphicsCardRequired() {
        return isGraphicsCardRequired;
    }

    public boolean isBluetoothRequired() {
        return isBluetoothRequired;
    }

    public static class ComputerBuilder {
        private String ram;
        private String hdd;
        private boolean isGraphicsCardRequired;
        private boolean isBluetoothRequired;

        public ComputerBuilder(String ram, String hdd) {
            this.hdd = hdd;
            this.ram = ram;
        }

        public ComputerBuilder setGraphicsCardRequired(boolean graphicsCardRequired) {
            this.isGraphicsCardRequired = graphicsCardRequired;
            return this;
        }

        public ComputerBuilder setBluetoothRequired(boolean bluetoothRequired) {
            this.isBluetoothRequired = bluetoothRequired;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
