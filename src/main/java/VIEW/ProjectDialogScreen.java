
package VIEW;

import CONTROLLER.PROJECTCONTROLLER;
import javax.swing.JOptionPane;
import MODEL.PROJECTS;


/**
 * Esta classe faz parte do pacote VIEW, onde temos as classes de interface gráfica.
 * Essa classe representa a tela para inserir projetos.
 * 
 * @author victo
 */
public class ProjectDialogScreen extends javax.swing.JDialog {
    
    
    /**
     * Instanciando a classe PROJECTCONTROLLER.
     */
    
    PROJECTCONTROLLER controller;
    
    public ProjectDialogScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       
        /**Criação do objeto controller 
         */
        controller = new PROJECTCONTROLLER();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPaneltoolbar = new javax.swing.JPanel();
        jLabeltoolbartitle = new javax.swing.JLabel();
        jLabeltoolbarsave = new javax.swing.JLabel();
        jPanelproject = new javax.swing.JPanel();
        jLabelname = new javax.swing.JLabel();
        jTextFieldname = new javax.swing.JTextField();
        jLabeldescription = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreadescription = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPaneltoolbar.setBackground(new java.awt.Color(0, 153, 102));

        jLabeltoolbartitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabeltoolbartitle.setForeground(java.awt.Color.white);
        jLabeltoolbartitle.setText("PROJETO");

        jLabeltoolbarsave.setForeground(java.awt.Color.white);
        jLabeltoolbarsave.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltoolbarsave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabeltoolbarsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabeltoolbarsaveMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPaneltoolbarLayout = new javax.swing.GroupLayout(jPaneltoolbar);
        jPaneltoolbar.setLayout(jPaneltoolbarLayout);
        jPaneltoolbarLayout.setHorizontalGroup(
            jPaneltoolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneltoolbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabeltoolbartitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeltoolbarsave, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPaneltoolbarLayout.setVerticalGroup(
            jPaneltoolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabeltoolbartitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabeltoolbarsave, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jPanelproject.setBackground(java.awt.Color.white);

        jLabelname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelname.setText("Nome");

        jTextFieldname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldname.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldnameActionPerformed(evt);
            }
        });

        jLabeldescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeldescription.setText("Descrição");

        jTextAreadescription.setColumns(20);
        jTextAreadescription.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextAreadescription.setRows(5);
        jTextAreadescription.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(jTextAreadescription);

        javax.swing.GroupLayout jPanelprojectLayout = new javax.swing.GroupLayout(jPanelproject);
        jPanelproject.setLayout(jPanelprojectLayout);
        jPanelprojectLayout.setHorizontalGroup(
            jPanelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelprojectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(jLabelname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabeldescription, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelprojectLayout.setVerticalGroup(
            jPanelprojectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelprojectLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelname)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabeldescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPaneltoolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelproject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPaneltoolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldnameActionPerformed
        
    }//GEN-LAST:event_jTextFieldnameActionPerformed

    /**
     * Criação do evento para quando clicar no icone + adicionar os dados inseridos 
     * nessa janela
     * @param evt 
     */
    private void jLabeltoolbarsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabeltoolbarsaveMouseClicked
       
       
        try {
            /**
            Se o campo NOME não for preenchido, mostrar a mensagem ao usuário.
            */
            if (jTextFieldname.getText().equals("")){
                 JOptionPane.showMessageDialog(rootPane, "O projeto não foi salvo, pois o campo nome não foi preenchido");
            
          
             /**
              * Aqui vamos pegar as informações inseridas nos campos, e usar o método 
              * SAVE para salvar esses dados.
              */
            }else{
                  PROJECTS project = new PROJECTS();
             project.setNAME(jTextFieldname.getText());
             project.setDESCRIPTION(jTextAreadescription.getText());  
             controller.Save(project);
             JOptionPane.showMessageDialog(rootPane, "Projeto salvo com sucesso");
            
             /**
             Este comando é usado para fechar a janela após clicar no icone +
             */
             this.dispose();
           
            }
            /**
             * execessão caso ocorra algum erro 
             */
        } catch (Exception e) {
           JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
           
    }//GEN-LAST:event_jLabeltoolbarsaveMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectDialogScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProjectDialogScreen dialog = new ProjectDialogScreen(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabeldescription;
    private javax.swing.JLabel jLabelname;
    private javax.swing.JLabel jLabeltoolbarsave;
    private javax.swing.JLabel jLabeltoolbartitle;
    private javax.swing.JPanel jPanelproject;
    private javax.swing.JPanel jPaneltoolbar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreadescription;
    private javax.swing.JTextField jTextFieldname;
    // End of variables declaration//GEN-END:variables

 
}
