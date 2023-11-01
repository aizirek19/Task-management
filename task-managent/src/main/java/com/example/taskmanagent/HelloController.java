package com.example.taskmanagent;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.Date;

public class HelloController {
    @FXML
    private ListView<Task> taskListView;
    @FXML
    private RadioButton homeworkRadioButton;
    @FXML
    private RadioButton meetingRadioButton;
    @FXML
    private RadioButton shoppingRadioButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private ComboBox<Priority> priorityComboBox;

    @FXML
    public void initialize() {
        // Initialize the ComboBox with priority values
        priorityComboBox.getItems().setAll(Priority.values());

        // Initialize the ListView with an empty observable list
        taskListView.setItems(FXCollections.observableArrayList());
    }

    @FXML
    public void addTask() {
        Task task;

        if (homeworkRadioButton.isSelected()) {
            task = new HomeworkTask();
        } else if (meetingRadioButton.isSelected()) {
            task = new MeetingTask();
            ((MeetingTask) task).setMeetingTime(new Date()); // Set the meeting time for the meeting task
        } else if (shoppingRadioButton.isSelected()) {
            task = new ShoppingTask();
            ((ShoppingTask) task).setShoppingPlace("Supermarket"); // Set the shopping place for the shopping task
        } else {
            // No task type selected
            return;
        }

        task.setTask(nameTextField.getText(), descriptionTextField.getText());
        task.setPriority(priorityComboBox.getValue());

        taskListView.getItems().add(task);

        // Clear the input fields after adding the task
        nameTextField.clear();
        descriptionTextField.clear();
        priorityComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    public void markTaskComplete() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            selectedTask.markAsComplete();
            taskListView.refresh();
        }
    }

    @FXML
    public void removeTask() {
        Task selectedTask = taskListView.getSelectionModel().getSelectedItem();

        if (selectedTask != null) {
            taskListView.getItems().remove(selectedTask);
        }
    }
}
