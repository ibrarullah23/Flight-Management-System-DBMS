
package GUI;

import MyUtil.DataBaseConnection;
import MyUtil.RoundPanel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Airline extends RoundPanel {

    public Airline( String operation) {
        initComponents();
        loadCountry();
        loadtable();
        setBtns(operation);
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
        ResultSet rs = DataBaseConnection.getData("select a.airline_id, a.airline_name, c.city_name, c.country from airline a join city c on airline_city = city_id ");
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    private void loadCountry(){
        
        country.removeAllItems();
        city.removeAllItems();
        country.addItem("--- Select ---");
        city.addItem("--- Select ---");
        
        try {
            ResultSet rs;
            if(country.getSelectedIndex() == 0){
                rs = DataBaseConnection.getData("select distinct(country) from city");
                while(rs.next()){
                    country.addItem(rs.getString(1));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void loadcity(){
        
        city.removeAllItems();
        city.addItem("--- Select ---");
        
        String countrystr = "" + country.getSelectedItem();
        try {
            ResultSet rs = DataBaseConnection.getData("select distinct(city_name) from city where country= '"+countrystr+"' ");
            while(rs.next()){
                city.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
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
        id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        country = new javax.swing.JComboBox<>();
        name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        city = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        neww = new javax.swing.JButton();

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));

        roundPanel3.setBackground(new java.awt.Color(234, 234, 234));
        roundPanel3.setRoundBottomLeft(0);
        roundPanel3.setRoundBottomRight(0);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Airline");

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
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(new java.awt.Color(51, 51, 51));
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

        id.setEditable(false);
        id.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        id.setForeground(new java.awt.Color(51, 51, 51));
        id.setMargin(new java.awt.Insets(2, 11, 2, 11));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ID :");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Country :");

        country.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        country.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(51, 51, 51));
        name.setMargin(new java.awt.Insets(2, 11, 2, 11));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Name :");

        city.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("City :");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundPanel1Layout.createSequentialGroup()
                        .addComponent(neww, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(city, 0, 167, Short.MAX_VALUE)
                            .addComponent(country, 0, 167, Short.MAX_VALUE)
                            .addComponent(id))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addComponent(roundPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addGroup(roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(remove)
                            .addComponent(neww, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(28, Short.MAX_VALUE))
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
                ResultSet rs = DataBaseConnection.getData("select city_id from city where city_name='"+city.getSelectedItem().toString()+"' and country='"+country.getSelectedItem().toString()+"' ");
                String countrystr = "";
                if(rs.next()){
                    countrystr = rs.getString(1);
                }
                
                int up = DataBaseConnection.updateData("update airline set airline_name='"
                        + name.getText().trim()+"', airline_city='"
                                + countrystr +"' where airline_id='"
                                        + id.getText()+ "'");
                loadtable();
            } catch (SQLException ex) {
                Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_updateActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        if (validatefirlds()) {
            try {
                ResultSet rs = DataBaseConnection.getData("select city_id from city where city_name='"+city.getSelectedItem().toString()+"' and country='"+country.getSelectedItem().toString()+"' ");
                String countrystr = "";
                if(rs.next()){
                    countrystr = rs.getString(1);
                }
                int ins = DataBaseConnection.insertData("INSERT INTO AIRLINE (AIRLINE_ID, AIRLINE_NAME, AIRLINE_CITY) VALUES (seq_airline.nextval,'"
                        + name.getText().trim()+"','"
                        + countrystr+"')");
                if(ins == 1){
                    JOptionPane.showMessageDialog(this, "New Airline added...");
                    loadtable();
                } else {
                    JOptionPane.showMessageDialog(this, "!..New Airline added..!");                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Airline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addActionPerformed

    private void newwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newwActionPerformed
        // TODO add your handling code here:
        id.setText("(Auto)");
    }//GEN-LAST:event_newwActionPerformed

    private void countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryActionPerformed
        // TODO add your handling code here:
            loadcity();
    }//GEN-LAST:event_countryActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        int r = table.getSelectedRow();
        id.setText(table.getValueAt(r, 0) .toString());
        name.setText(table.getValueAt(r, 1) .toString());
        country.setSelectedItem(table.getValueAt(r, 3) .toString());
        city.setSelectedItem(table.getValueAt(r, 2) .toString());
    }//GEN-LAST:event_tableMouseClicked

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        // TODO add your handling code here:
        boolean del = DataBaseConnection.deleteData("delete from airline where airline_id="+id.getText()+"");
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

    
    private boolean validatefirlds(){
        if(name.getText().equals(null)){
            name.requestFocus();
            getToolkit().beep();
            return false;
        } else if(country.getSelectedIndex() == 0){
            country.requestFocus();
            getToolkit().beep();
            return false;
        } else if(city.getSelectedIndex() == 0){
            city.requestFocus();
            getToolkit().beep();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JComboBox<String> city;
    private javax.swing.JComboBox<String> country;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton neww;
    private javax.swing.JButton remove;
    private MyUtil.RoundPanel roundPanel1;
    private MyUtil.RoundPanel roundPanel3;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
