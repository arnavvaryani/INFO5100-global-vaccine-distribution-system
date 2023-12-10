/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Distributor;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Enterprise.ServiceEnterprise;
import Business.Network.Network;
import Business.Organization.DistributionOrganization;
import Business.Organization.Organization;
import Business.Organization.PurchaseInventory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.requestVaccine;
import Business.WorkQueue.vaccinate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nehadevarapalli
 */
public class NDistirbutionWorkAreaJPanel extends javax.swing.JPanel {
    
    private JPanel userProcessContainer;
    private DistributionOrganization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    private UserAccount userAccount;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    public int currEP;
    private boolean bool = false;
    private boolean bool2 = false;
    /**
     * Creates new form NDistirbutionWorkAreaJPanel
     */
    public NDistirbutionWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, DistributionOrganization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.userAccount = account;
        
        currEP = ((ServiceEnterprise) enterprise).getVaccineCount();
        txtvacCount.setEnabled(false);
        txtvacCount.setEditable(false);
        System.out.println(currEP);
        txtvacCount.setText(Integer.toString(currEP));
        lblVal.setText(account.getEmployee().getName());
        populateTable();
        populateCount();
        populateVaccineTable();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblVacCount = new javax.swing.JLabel();
        btnSchedule = new javax.swing.JButton();
        VaccinationjDateChooser = new com.toedter.calendar.JDateChooser();
        txtvacCount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReq = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVac = new javax.swing.JTable();
        separatorLine1 = new javax.swing.JSeparator();
        lblTitle = new javax.swing.JLabel();
        lblTxt = new javax.swing.JLabel();
        lblVal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1440, 848));
        setPreferredSize(new java.awt.Dimension(1440, 848));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVacCount.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblVacCount.setText("Vaccine Count:");
        add(lblVacCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        btnSchedule.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        btnSchedule.setText("Schedule");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });
        add(btnSchedule, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, -1, -1));

        VaccinationjDateChooser.setBackground(new java.awt.Color(220, 241, 251));
        add(VaccinationjDateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, -1, -1));

        txtvacCount.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        txtvacCount.setForeground(new java.awt.Color(255, 255, 255));
        txtvacCount.setBorder(null);
        add(txtvacCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 240, -1));

        tblReq.setForeground(new java.awt.Color(36, 47, 65));
        tblReq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sender", "Receiver", "Status", "Date"
            }
        ));
        jScrollPane1.setViewportView(tblReq);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 485, 180));

        tblVac.setForeground(new java.awt.Color(36, 47, 65));
        tblVac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Sender", "Receiver", "Quantity", "Status"
            }
        ));
        jScrollPane2.setViewportView(tblVac);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 520, 180));

        separatorLine1.setBackground(new java.awt.Color(0, 0, 0));
        separatorLine1.setForeground(new java.awt.Color(255, 255, 255));
        separatorLine1.setMinimumSize(new java.awt.Dimension(1, 12));
        separatorLine1.setPreferredSize(new java.awt.Dimension(1, 12));
        add(separatorLine1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 290, 220, 10));

        lblTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/gradient-big.jpg"))); // NOI18N
        add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 850));

        lblTxt.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblTxt.setText("Currently Logged in as:");
        add(lblTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, 30));

        lblVal.setBackground(new java.awt.Color(0, 0, 0));
        lblVal.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        lblVal.setText("<value>");
        add(lblVal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 230, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblReq.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this, "Please select a person's request to schedule");
            return;
        }
        Date d = new Date();
        System.out.println(d);
        if(VaccinationjDateChooser.getDate().before(d)){
            JOptionPane.showMessageDialog(this, "Please select a future date");
            return;
        }
        vaccinate req = (vaccinate)tblReq.getModel().getValueAt(selectedRow, 0);
        
        if(req.getStatus().equals("Approved")){
            JOptionPane.showMessageDialog(this, "Person is already scheduled a vaccination slot2");
            System.out.println("Person is already scheduled a vaccination slot");
            return;
        }
        try{
        if(VaccinationjDateChooser.getDate().toString().length()<1){
            JOptionPane.showMessageDialog(this, "Please choose a date to schedule vaccination");
            return;
        }
        }
        catch(NullPointerException e){
            System.out.println("Null exception caught");
            JOptionPane.showMessageDialog(this, "Please select a date");
            return;
        }
        
        
        if(!bool){
            JOptionPane.showMessageDialog(this, "You don't have any vaccine in stock please check with manufacturer to approve your order");
            return;
        }
        if(bool){
            JOptionPane.showMessageDialog(this, "Please order vaccines as your stock is getting over..");
            
        }
        
        req.setDate(VaccinationjDateChooser.getDate().toString());
        req.setDt(VaccinationjDateChooser.getDate());
        System.out.print(VaccinationjDateChooser.getDate().toString());
        req.setStatus("Approved");
        currEP-=1;
        ((ServiceEnterprise) enterprise).setVaccineCount(currEP);
        
        System.out.println(enterprise.getName());
        JOptionPane.showMessageDialog(this, "Vaccination Scheduled");
        Network cn = enterprise.getNetwork();
        for(WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()){
            if(wr instanceof requestVaccine){
                System.out.println("Reducing vaccine count");
                int p = ((requestVaccine) wr).getCount();
                p-=1;
                ((requestVaccine) wr).setCount(p);
                break;
            }
        }
//        for(Enterprise e : cn.getEnterpriseDirectory().getEnterpriseList()){
//            if(e.getEnterpriseType() == EnterpriseType.Service){
//                for(Organization o : e.getOrganizationDirectory().getOrganizationList()){
//                    for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
//                        if(u.getRole().toString().equals("Business.Role.PurchaseRole")){
//                            for(WorkRequest wr : u.getWorkQueue().getWorkRequestList()){
//                                int p = ((requestVaccine) wr).getQty();
//                                p -=1;
//                                ((requestVaccine) wr).setQty(p);
//                                break;
//                            }
//                        }
//                    }
//                }
//            }
//        }
        populateTable();
        try{
            populateVaccineTable();
        }catch(Exception e){
            System.out.println("Exception handled");
        }
        
//        populateCount();
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_btnScheduleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser VaccinationjDateChooser;
    private javax.swing.JButton btnSchedule;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTxt;
    private javax.swing.JLabel lblVacCount;
    private javax.swing.JLabel lblVal;
    private javax.swing.JSeparator separatorLine1;
    private javax.swing.JTable tblReq;
    private javax.swing.JTable tblVac;
    private javax.swing.JTextField txtvacCount;
    // End of variables declaration//GEN-END:variables
    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblReq.getModel();
        model.setRowCount(0);
        
        for(WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            if(wr instanceof vaccinate){
            row[0] = wr;
            row[1] = wr.getReceiver();
            row[2] = wr.getStatus();
            String Date = ((vaccinate) wr).getDate();
            row[3] = Date;
            model.addRow(row);
        }
        }
    }

    private void populateCount() {
        for(WorkRequest wr : userAccount.getWorkQueue().getWorkRequestList()){
            if(wr instanceof requestVaccine){
                int i = ((requestVaccine) wr).getCount();
                txtvacCount.setText(Integer.toString(i));
            }
        }
    }

    private void populateVaccineTable() {
        DefaultTableModel model = (DefaultTableModel) tblVac.getModel();
        model.setRowCount(0);
        UserAccount distributor = new UserAccount();
        try{
        for(WorkRequest rv:userAccount.getWorkQueue().getWorkRequestList()){
            System.out.println(enterprise.getName());
            Object row[] = new Object[4];
            if(rv instanceof requestVaccine){
                ArrayList<PurchaseInventory> inv = ((requestVaccine) rv).getInventoryPurchase();
        
            row[0] = rv;
            row[1] = rv.getReceiver().getUsername();
            row[2] = ((requestVaccine) rv).getCount();
            if(((requestVaccine) rv).getCount()<10){
                bool2 = true;
            }
//            if(inv!=null){
//            for(PurchaseInventory p : inv){
//                int c = ((requestVaccine) rv).getCount();
//                row[2] = p.getQty();
//                
//                if(rv.getStatus().equals("Approved")){
//                System.out.println(enterprise.getName());
//                for(Organization o : enterprise.getOrganizationDirectory().getOrganizationList()){
//                    for(UserAccount u : o.getUserAccountDirectory().getUserAccountList()){
//                        System.out.println(u.getRole().toString());
//                        if(u.getRole().toString().equals("Business.Role.DistributionRole")){
//                            ((requestVaccine) rv).setDistribution(u);
//                            distributor = u;
////                            System.out.println(o.getName());
////                            VaccineCount vc = new VaccineCount();
////                            vc.setVaccineName(rv.getReceiver().toString());
////                            vc.setCount(p.getQty());
////                            currEP += p.getQty();
//                            System.out.println(p.getQty());
//                            c+=p.getQty();
//                            System.out.println(c);
//                            
////                            DistributionOrganization org = ((DistributionOrganization) o).getVaccineDirectory().add(vc);
//                        }
//                    }
//                }
//            }
//                ((requestVaccine) rv).setCount(c);
//                distributor.getWorkQueue().getWorkRequestList().add(rv);
                
            
            
            row[3] = rv.getStatus();
            if(rv.getStatus().equals("Approved")){
                bool = true;
            }
            System.out.println(rv.getStatus());
            
//            row[2] = 
            model.addRow(row);
        }
        }
        }
        catch(NullPointerException e){
            System.out.println("No records found");
        }
    }
}