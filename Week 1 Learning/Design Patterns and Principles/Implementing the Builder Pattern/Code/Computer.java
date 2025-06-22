// Filename: BuilderPattern.java

// Step 2 & 4: Product Class with private constructor
public class Computer {
    private final String CPU;
    private final int RAM; // in GB
    private final int storage; // in GB
    private final boolean graphicsCardEnabled;
    private final String operatingSystem;

    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCardEnabled = builder.graphicsCardEnabled;
        this.operatingSystem = builder.operatingSystem;
    }

    public String getCPU() {
        return CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public int getStorage() {
        return storage;
    }

    public boolean hasGraphicsCard() {
        return graphicsCardEnabled;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + "GB, Storage=" + storage + "GB, GraphicsCard="
                + graphicsCardEnabled
                + ", OS=" + operatingSystem + "]";
    }

    // Step 3: Static nested Builder class
    public static class Builder {
        private String CPU;
        private int RAM;
        private int storage;
        private boolean graphicsCardEnabled;
        private String operatingSystem;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCardEnabled(boolean enabled) {
            this.graphicsCardEnabled = enabled;
            return this;
        }

        public Builder setOperatingSystem(String os) {
            this.operatingSystem = os;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// Step 5: Test Class
class BuilderPattern {
    public static void main(String[] args) {
        // Creating a high-end gaming computer
        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM(32)
                .setStorage(1000)
                .setGraphicsCardEnabled(true)
                .setOperatingSystem("Windows 11")
                .build();

        // Creating a basic office computer
        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM(8)
                .setStorage(256)
                .setGraphicsCardEnabled(false)
                .setOperatingSystem("Windows 10")
                .build();

        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Office PC: " + officePC);
    }
}