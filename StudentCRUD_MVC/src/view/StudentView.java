package view; // Package holding the View layer (Java Swing GUI forms)

// ============================================================================
// IMPORTS: Swing getters return these component types to the MVC Controller
// ============================================================================
import javax.swing.JButton;    // Swing button component for Add, Update, Delete, Clear
import javax.swing.JTable;     // Swing table component for displaying student records
import javax.swing.JTextField; // Swing text box component for user input fields

/**
 * StudentView Class (View Layer - NetBeans JFrame Form)
 * Built using Apache NetBeans Drag-and-Drop Palette (Matisse GUI Builder).
 * Contains zero business/database logic—exposes getters so the Controller can interact with components.
 */
public class StudentView extends javax.swing.JFrame {

    // ========================================================================
    // GROUP 1: Constructor
    // Initializes all Swing components dragged from the NetBeans Palette.
    // ========================================================================
    public StudentView() {
        initComponents();                  // NetBeans auto-generated method that builds the drag-and-drop layout
        setLocationRelativeTo(null);       // Center the window on the user's screen when launched
    }

    // ========================================================================
    // GROUP 2: NetBeans GUI Builder Generated Code (initComponents)
    // In Apache NetBeans, this section is managed automatically by the Design tab
    // whenever you drag and drop components from the Swing Palette.
    // ========================================================================
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        pnlForm = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblCourse = new javax.swing.JLabel();
        txtCourse = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        scrollPaneTable = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management System - MVC CRUD");

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Student Management System (MVC + MySQL)");

        pnlForm.setBorder(javax.swing.BorderFactory.createTitledBorder("Student Details"));

        lblId.setText("Student ID:");

        txtId.setEditable(false);
        txtId.setToolTipText("Auto-generated ID (Read-only)");

        lblName.setText("Full Name:");

        lblCourse.setText("Course:");

        lblEmail.setText("Email:");

        btnAdd.setText("Add");

        btnUpdate.setText("Update");

        btnDelete.setText("Delete");

        btnClear.setText("Clear");

        javax.swing.GroupLayout pnlFormLayout = new javax.swing.GroupLayout(pnlForm);
        pnlForm.setLayout(pnlFormLayout);
        pnlFormLayout.setHorizontalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblId)
                            .addComponent(lblName)
                            .addComponent(lblCourse)
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName)
                            .addComponent(txtCourse)
                            .addComponent(txtEmail)
                            .addComponent(txtId)))
                    .addGroup(pnlFormLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
        );
        pnlFormLayout.setVerticalGroup(
            pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFormLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCourse)
                    .addComponent(txtCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(pnlFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "Course", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTable.setViewportView(tblStudents);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPaneTable, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // ========================================================================
    // GROUP 3: Component Getter Methods for the MVC Controller
    // Allow StudentController to read text fields, attach button listeners,
    // and update the JTable without placing business logic inside the View.
    // ========================================================================
    public JTextField getTxtId() {
        return txtId; // Expose the ID text field to the Controller
    }

    public JTextField getTxtName() {
        return txtName; // Expose the Full Name text field to the Controller
    }

    public JTextField getTxtCourse() {
        return txtCourse; // Expose the Course text field to the Controller
    }

    public JTextField getTxtEmail() {
        return txtEmail; // Expose the Email text field to the Controller
    }

    public JButton getBtnAdd() {
        return btnAdd; // Expose the Add button so the Controller can attach an ActionListener
    }

    public JButton getBtnUpdate() {
        return btnUpdate; // Expose the Update button so the Controller can attach an ActionListener
    }

    public JButton getBtnDelete() {
        return btnDelete; // Expose the Delete button so the Controller can attach an ActionListener
    }

    public JButton getBtnClear() {
        return btnClear; // Expose the Clear button so the Controller can attach an ActionListener
    }

    public JTable getTblStudents() {
        return tblStudents; // Expose the JTable so the Controller can populate rows and detect clicks
    }

    // ========================================================================
    // GROUP 4: NetBeans Palette Variable Declarations
    // Automatically maintained by the NetBeans Form Editor when components are renamed.
    // ========================================================================
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblCourse;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtCourse;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
