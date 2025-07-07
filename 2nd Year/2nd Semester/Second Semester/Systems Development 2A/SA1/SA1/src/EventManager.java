import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventManager extends JFrame {
    
    private JTextField eventNameField, eventDateField, eventTimeField, descriptionField, organiserField;
    private JButton addEventButton, viewEventsButton, updateEventButton, deleteEventButton;

    public EventManager() {
        setTitle("Event Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        
        add(new JLabel("Event Name:"));
        eventNameField = new JTextField();
        add(eventNameField);

        add(new JLabel("Event Date (YYYY-MM-DD):"));
        eventDateField = new JTextField();
        add(eventDateField);

        add(new JLabel("Event Time (HH:MM:SS):"));
        eventTimeField = new JTextField();
        add(eventTimeField);

        add(new JLabel("Description:"));
        descriptionField = new JTextField();
        add(descriptionField);

        add(new JLabel("Organiser:"));
        organiserField = new JTextField();
        add(organiserField);

        // Buttons for CRUD operations
        addEventButton = new JButton("Add Event");
        add(addEventButton);
        viewEventsButton = new JButton("View Events");
        add(viewEventsButton);
        updateEventButton = new JButton("Update Event");
        add(updateEventButton);
        deleteEventButton = new JButton("Delete Event");
        add(deleteEventButton);

        // Action Listeners for Buttons
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });

        viewEventsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewEvents();
            }
        });

        updateEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEvent();
            }
        });

        deleteEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEvent();
            }
        });
    }

    // CRUD Methods

    // Create Event
    private void addEvent() {
        String eventName = eventNameField.getText();
        String eventDate = eventDateField.getText();
        String eventTime = eventTimeField.getText();
        String description = descriptionField.getText();
        String organiser = organiserField.getText();

        try (Connection connection = DataBaseConnection.getConnection()) {
            String sql = "INSERT INTO Events (event_name, event_date, event_time, description, organiser) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventName);
            statement.setString(2, eventDate);
            statement.setString(3, eventTime);
            statement.setString(4, description);
            statement.setString(5, organiser);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(this, "Event added.");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error with adding event: " + ex.getMessage());
        }
    }

    // Read Events
    private void viewEvents() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            String sql = "SELECT * FROM Events";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder events = new StringBuilder("Events:\n");
            while (resultSet.next()) {
                events.append("ID: ").append(resultSet.getInt("event_id"))
                      .append(", Name: ").append(resultSet.getString("event_name"))
                      .append(", Date: ").append(resultSet.getDate("event_date"))
                      .append(", Time: ").append(resultSet.getTime("event_time"))
                      .append(", Description: ").append(resultSet.getString("description"))
                      .append(", Organiser: ").append(resultSet.getString("organiser"))
                      .append("\n");
            }
            JOptionPane.showMessageDialog(this, events.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error receiving events: " + ex.getMessage());
        }
    }

    // Update Event
    private void updateEvent() {
        String eventName = eventNameField.getText();
        String newEventDate = eventDateField.getText();
        String newEventTime = eventTimeField.getText();

        try (Connection connection = DataBaseConnection.getConnection()) {
            String sql = "UPDATE Events SET event_date = ?, event_time = ? WHERE event_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newEventDate);
            statement.setString(2, newEventTime);
            statement.setString(3, eventName);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Event successfully updated!");
            } else {
                JOptionPane.showMessageDialog(this, "Event unavailable.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating the event: " + ex.getMessage());
        }
    }

    // Delete Event
    private void deleteEvent() {
        String eventName = eventNameField.getText();

        try (Connection connection = DataBaseConnection.getConnection()) {
            String sql = "DELETE FROM Events WHERE event_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, eventName);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Event successfully deleted!");
            } else {
                JOptionPane.showMessageDialog(this, "Event not found.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error removing event: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        EventManager ems = new EventManager();
        ems.setVisible(true);
    }
}