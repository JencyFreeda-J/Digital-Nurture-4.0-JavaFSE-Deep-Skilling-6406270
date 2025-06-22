// Filename: ProxyPattern.java

// Step 2: Subject Interface
interface Image {
    void display();
}

// Step 3: Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Step 4: Proxy Class
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Step 5: Test Class
public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        System.out.println("--- First Call ---");
        image1.display();

        System.out.println("--- Second Call (Should use cache) ---");
        image1.display();

        System.out.println("--- Third Call ---");
        image2.display();
    }
}