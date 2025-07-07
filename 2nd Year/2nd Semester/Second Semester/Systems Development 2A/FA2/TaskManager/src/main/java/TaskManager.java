import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TaskManager {
    private JFrame frame;
    private final ArrayList<String> tasks;
    private JTextField taskNameField;
    private JTextField taskIndexField;
    private JButton insertButton;
    private JButton removeButton;
    private JButton viewButton;

    public TaskManager() {
        tasks = new ArrayList<>();
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        

        
        panel.add(new JLabel("Task:"));
        taskNameField = new JTextField();
        panel.add(taskNameField);

        
        panel.add(new JLabel("Task Number:"));
        taskIndexField = new JTextField();
        panel.add(taskIndexField);

        
        insertButton = new JButton("Add");
        panel.add(insertButton);

        
        removeButton = new JButton("Delete");
        panel.add(removeButton);

        frame.add(panel, BorderLayout.NORTH);

        
        viewButton = new JButton("View Tasks");
        frame.add(viewButton, BorderLayout.SOUTH);

        
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String taskName = taskNameField.getText();
                if (!taskName.isEmpty()) {
                    tasks.add(taskName);
                    taskNameField.setText(""); // Clear input field
                    JOptionPane.showMessageDialog(frame, "Task added");
                } else {
                    JOptionPane.showMessageDialog(frame, "Enter a task name.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int taskIndex = Integer.parseInt(taskIndexField.getText());
                    if (taskIndex >= 0 && taskIndex < tasks.size()) {
                        tasks.remove(taskIndex);
                        taskIndexField.setText("");
                        JOptionPane.showMessageDialog(frame, "Task deletd");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid task number.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter a valid task number.");
                }
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tasks.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No tasks to show.");
                } else {
                    StringBuilder taskList = new StringBuilder("Tasks:\n");
                    for (int i = 0; i < tasks.size(); i++) {
                        taskList.append(i).append(": ").append(tasks.get(i)).append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, taskList.toString());
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TaskManager();
            }
        });
    }
}