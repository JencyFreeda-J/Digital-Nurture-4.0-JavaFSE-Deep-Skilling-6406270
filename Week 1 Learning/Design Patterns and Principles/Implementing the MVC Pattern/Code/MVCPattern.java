// Filename: MVCPattern.java

// Step 2: Model Class
class Student {
    private String name;
    private String id;
    private double grade;

    public Student(String name, String id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

// Step 3: View Class
class StudentView {
    public void displayStudentDetails(String name, String id, double grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }
}

// Step 4: Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public String getStudentId() {
        return model.getId();
    }

    public void setStudentGrade(double grade) {
        model.setGrade(grade);
    }

    public double getStudentGrade() {
        return model.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test Class
public class MVCPattern {
    public static void main(String[] args) {
        Student model = new Student("John Doe", "S12345", 89.5);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println("\nUpdating student grade...\n");
        controller.setStudentGrade(92.0);

        controller.updateView();
    }
}
