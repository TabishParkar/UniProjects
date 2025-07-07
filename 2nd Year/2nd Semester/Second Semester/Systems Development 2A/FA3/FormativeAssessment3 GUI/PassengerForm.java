import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author tabis
 */
public class PassengerForm extends javax.swing.JFrame {

    public PassengerForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        txtFName = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtLName = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        txtDest = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        txtPhone = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        btnAddPassenger = new javax.swing.JButton();
        btnViewPassengers = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtFName.setText("First Name");

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        txtLName.setText("Last Name");

        jTextField2.setText("jTextField2");

        txtDest.setText("Destination");

        jTextField3.setText("jTextField3");

        txtPhone.setText("jLabel4");

        jTextField4.setText("jTextField4");

        btnAddPassenger.setText("Add Passenger");
        btnAddPassenger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPassengerActionPerformed(evt);
            }
        });

        btnViewPassengers.setText("View Passengers");
        btnViewPassengers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPassengersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtFName, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtLName, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 56,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtDest, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 154, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnAddPassenger, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewPassengers, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 73,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFName)
                                        .addComponent(txtLName)
                                        .addComponent(txtDest)
                                        .addComponent(txtPhone))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170,
                                        Short.MAX_VALUE)
                                .addComponent(btnViewPassengers)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddPassenger)
                                .addGap(56, 56, 56)));

        pack();
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnAddPassengerActionPerformed(java.awt.event.ActionEvent evt) {
        btnAddPassenger.addActionListener(e -> {
            String fname = txtFName.getText();
            String lname = txtLName.getText();
            String dest = txtDest.getText();
            String phone = txtPhone.getText();

            String sql = "INSERT INTO passenger_details (FName, LName, Dest, Phone) VALUES (?, ?, ?, ?)";
            try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, fname);
                pstmt.setString(2, lname);
                pstmt.setString(3, dest);
                pstmt.setString(4, phone);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Passenger added successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error adding passenger.");
            }
        });

    }

    private void btnViewPassengersActionPerformed(java.awt.event.ActionEvent evt) {
        btnViewPassengers.addActionListener(e -> {
            String sql = "SELECT * FROM passenger_details";
            StringBuilder result = new StringBuilder();
            try (Connection conn = connect();
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    result.append("Name: ").append(rs.getString("FName")).append(" ").append(rs.getString("LName"))
                            .append(", Destination: ").append(rs.getString("Dest"))
                            .append(", Phone: ").append(rs.getString("Phone")).append("\n");
                }
                txtAreaPassengers.setText(result.toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error retrieving passengers.");
            }
        });

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassengerForm.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PassengerForm().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnAddPassenger;
    private javax.swing.JButton btnViewPassengers;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel txtDest;
    private javax.swing.JLabel txtFName;
    private javax.swing.JLabel txtLName;
    private javax.swing.JLabel txtPhone;

    private Connection connect() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

private Connection connect() {
    Connection conn = null;
    try {
        String url = "jdbc:mysql://localhost:3306/fa3_assessment";
        String user = "your_username";
        String password = "your_password";
        conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conn;
}