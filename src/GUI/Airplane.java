
package GUI;

import MyUtil.DataBaseConnection;
import MyUtil.RoundPanel;
import static java.lang.Character.isDigit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Airplane extends RoundPanel {

    public Airplane(String Operation) {
        initComponents();
        loadAirline();
        loadtable();
        setBtns(Operation);
    }

    private void setBtns(String operation){
        jLabel1.setText(operation+" Airline's");
        neww.setVisible(false);
        add.setVisible(false);
        update.setVisible(false);
        remove.setVisible(false);
        if(operation.equals("Add")){
            neww.setVisible(true);
            add.setVisible(true);
        } else if(operation.equals("Remove")){
            remove.setVisible(true);
        } else if(operation.equals("Update")){
            update.setVisible(true);
        }
    }
    
    private void loadtable(){
        table.removeAll();
        ResultSet rs = DataBaseConnection.getData("select a.reg_no,a.model,al.airline_name,a.capacity from airplane a natural join airline al");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }

    private void loadAirline(){
        airline.removeAllItems();
        airline.addItem("--- Select ---");
        try {
            ResultSet rs = DataBaseConnection.getData("SELECT airline_name FROM AIRLINE");
            while (rs.next()) {
                airline.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Airplane.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundPanel1 = new MyUtil.RoundPanel();
        roundPanel3 = new MyUtil.RoundPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        remove = new javax.swing.JButton();
        update = new javax.swing.JButton();
        add = new javax.swing.JButton();
        regno = new javax.swing.JTextField();
        model = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        capacity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        airline = new javax.swing.JComboBox<>();
        neww = new javax.swing.JButton();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel3.setBackground(new java.awt.Color(234, 234, 234));
        roundPanel3.setRoundBottomLeft(0);
        roundPanel3.setRoundBottomRight(0);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Airplane");

        javax.swing.GroupLayout roundPanel3Layout = new javax.swing.GroupLayout(roundPanel3);
        roundPanel3.setLayout(roundPanel3Layout);
        roundPanel3Layout.setHorizontalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );
        roundPanel3Layout.setVerticalGroup(
            roundPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        );

        table.setBackground(new java.awt.Color(249, 249, 249));
        table.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        table.setForeground(new java.awt.Color(51, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setFocusTraversalPolicyProvider(true);
        table.setOpaque(false);
        table.setRowHeight(24);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        remove.setBackground(new java.awt.Color(255, 76, 85));
        remove.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(14, 225, 53));
        update.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(17, 136, 255));
        add.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        regno.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        regno.setForeground(new java.awt.Color(51, 51, 51));
        regno.setMargin(new java.awt.Insets(2, 11, 2, 11));
        regno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regnoActionPerformed(evt);
            }
        });

        model.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        model.setForeground(new java.awt.Color(51, 51, 51));
        model.setMargin(new java.awt.Insets(2, 11, 2, 11));
        model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Reg No :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Model :");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Capacity :");

        capacity.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        capacity.setForeground(new java.awt.Color(51, 51, 51));
        capacity.setMargin(new java.awt.Insets(2, 11, 2, 11));
        capacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                capacityActionPerformed(evt);
            }
        });
        capacity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capacityKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Airline :");

        airline.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        airline.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        neww.setBackground(new java.awt.Color(153, 153, 153));
        neww.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        neww.setForeground(new java.awt.Color(255, 255, 255));
        neww.setText("New");
        neww.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(capacity, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(airline, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(regno)))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(neww, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(regno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(capacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(airline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remove)
                            .addComponent(neww, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(roundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        if (validatefirlds()) {
            try {
                ResultSet rs = DataBaseConnection.getData("select airline_id from airline where airline_name='"+airline.getSelectedItem().toString()+"'  ");
                String airline_id = "";
                if(rs.next()){
                    airline_id = rs.getString(1);
                }
                
                int up = DataBaseConnection.updateData("update airplane set model='"
                                + model.getText().trim()+"', airline_id='"+airline_id+"', capacity='"
                                        + capacity.getText()+"' where reg_no='"
                                                + regno.getText().trim()+"'");
                loadtable();
            } catch (SQLException ex) {
                Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void regnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regnoActionPerformed

    private void modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelActionPerformed

    private void capacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_capacityActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        if(validatefirlds()){
            try {
                String airline_id ="";
                ResultSet rs = DataBaseConnection.getData("select airline_id from airline where airline_name='"+airline.getSelectedItem().toString()+"'");
                if(rs.next()){
                    airline_id = rs.getString(1);
                }
                DataBaseConnection.insertData("INSERT INTO AIRPLANE (REG_NO, MODEL, AIRLINE_ID, capacity) VALUES ('"
                        + regno.getText().trim()+ "', '"
                        + model.getText().trim()+"', "
                        + airline_id+","
                                +capacity.getText().trim()+ " ) ");
                loadtable();
                regno.setEditable(true);
                regno.setText(null);
                model.setText(null);
                capacity.setText(null);
                airline.setSelectedIndex(0);
            } catch (SQLException ex) {
                Logger.getLogger(Airplane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void newwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newwActionPerformed
        // TODO add your handling code here:
        
        regno.setEditable(true);
       regno.setText(null);
       model.setText(null);
       capacity.setText(null);
       airline.setSelectedIndex(0);
    }//GEN-LAST:event_newwActionPerformed

    private void capacityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capacityKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if( !isDigit(c)){
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_capacityKeyTyped

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        boolean del = DataBaseConnection.deleteData("delete from airplane where reg_no="+regno.getText()+"");
        if(del){
            int opt = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete..?");
            if(opt !=0){
                try {
                    DataBaseConnection.cnn.rollback();
                } catch (SQLException ex) {
                    Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            loadtable();
        }
    }//GEN-LAST:event_removeActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        regno.setEditable(false);
        int r = table.getSelectedRow();
        regno.setText(table.getValueAt(r, 0) .toString());
        model.setText(table.getValueAt(r, 1) .toString());
        airline.setSelectedItem(table.getValueAt(r, 2) .toString());
        capacity.setText(table.getValueAt(r, 3) .toString());
    }//GEN-LAST:event_tableMouseClicked


    private boolean validatefirlds(){
        if(regno.getText().equals("")){
            regno.requestFocus();
            getToolkit().beep();
            return false;
        } else if(capacity.getText().equals(null)){
            capacity.requestFocus();
            getToolkit().beep();
            return false;
        }  else if(model.getText().equals(null)){
            model.requestFocus();
            getToolkit().beep();
            return false;
        }  else if(airline.getSelectedIndex() == 0){
            airline.requestFocus();
            getToolkit().beep();
            return false;
        }
        return true;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> airline;
    private javax.swing.JTextField capacity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField model;
    private javax.swing.JButton neww;
    private javax.swing.JTextField regno;
    private javax.swing.JButton remove;
    private MyUtil.RoundPanel roundPanel1;
    private MyUtil.RoundPanel roundPanel3;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
