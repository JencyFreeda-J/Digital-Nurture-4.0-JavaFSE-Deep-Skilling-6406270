// Exercise 5: Task Management System using Singly Linked List

// Step 1: Understanding Linked Lists
// Singly Linked List: Nodes point to the next node. Efficient insertion/deletion at beginning.
// Doubly Linked List: Nodes have next and previous pointers. More flexible but uses more memory.

class Task {
    String taskId;
    String taskName;
    String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "TaskID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {
    private Node head;

    public TaskManagement() {
        this.head = null;
    }

    // Add task at end
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Search task by ID
    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equalsIgnoreCase(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse and display tasks
    public void displayTasks() {
        Node temp = head;
        if (temp == null) {
            System.out.println("No tasks to display.");
            return;
        }
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete task by ID
    public boolean deleteTask(String taskId) {
        if (head == null)
            return false;

        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equalsIgnoreCase(taskId)) {
            current = current.next;
        }

        if (current.next == null)
            return false;

        current.next = current.next.next;
        return true;
    }

    public static void main(String[] args) {
        TaskManagement tm = new TaskManagement();

        // Add tasks
        tm.addTask(new Task("T001", "Design UI", "Pending"));
        tm.addTask(new Task("T002", "Develop Backend", "In Progress"));
        tm.addTask(new Task("T003", "Write Tests", "Pending"));

        // Display tasks
        System.out.println("--- All Tasks ---");
        tm.displayTasks();

        // Search for a task
        System.out.println("\n--- Search Task T002 ---");
        Task found = tm.searchTask("T002");
        System.out.println(found != null ? found : "Task not found");

        // Delete a task
        System.out.println("\n--- Delete Task T001 ---");
        boolean deleted = tm.deleteTask("T001");
        System.out.println(deleted ? "Task deleted successfully." : "Task not found.");

        // Display tasks after deletion
        System.out.println("\n--- Tasks After Deletion ---");
        tm.displayTasks();
    }
}