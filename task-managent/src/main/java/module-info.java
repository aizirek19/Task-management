module com.example.taskmanagent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.taskmanagent to javafx.fxml;
    exports com.example.taskmanagent;
}