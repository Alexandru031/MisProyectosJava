/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionListener;

/**
 *
 * @author Eduardo Silvestre
 */
public class FPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FPrincipal
     */
    public FPrincipal() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taPantalla = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        miEixir = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miAfegirVehicle = new javax.swing.JMenuItem();
        miAfegirRepostage = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        miLlistatComplet = new javax.swing.JMenuItem();
        miLlistatEnRuta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        taPantalla.setColumns(20);
        taPantalla.setRows(5);
        jScrollPane1.setViewportView(taPantalla);

        jMenu1.setText("Accions");

        miEixir.setText("Eixir");
        jMenu1.add(miEixir);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Afegir");

        miAfegirVehicle.setText("Vehicle");
        miAfegirVehicle.setActionCommand("afegir vehicle");
        jMenu3.add(miAfegirVehicle);

        miAfegirRepostage.setText("Repostage");
        miAfegirRepostage.setActionCommand("afegir repostage");
        jMenu3.add(miAfegirRepostage);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Llistats");

        miLlistatComplet.setText("Complet");
        miLlistatComplet.setActionCommand("llistat complet");
        jMenu2.add(miLlistatComplet);

        miLlistatEnRuta.setText("En ruta");
        miLlistatEnRuta.setActionCommand("llistat en ruta");
        jMenu2.add(miLlistatEnRuta);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAfegirRepostage;
    private javax.swing.JMenuItem miAfegirVehicle;
    private javax.swing.JMenuItem miEixir;
    private javax.swing.JMenuItem miLlistatComplet;
    private javax.swing.JMenuItem miLlistatEnRuta;
    private javax.swing.JTextArea taPantalla;
    // End of variables declaration//GEN-END:variables

    /**
     * assigna l'oïdor als botons.
     *
     * @param oidor d'esdeveniments d'acció
     */
    public void setOidor(ActionListener oidor) {
        miAfegirVehicle.addActionListener(oidor);
        miAfegirRepostage.addActionListener(oidor);
        miEixir.addActionListener(oidor);
        miLlistatComplet.addActionListener(oidor);
        miLlistatEnRuta.addActionListener(oidor);
    }

    /**
     * mostra un text en pantalla. substitueix el text anterior
     *
     * @param text
     */
    public void mostra(String text) {
        taPantalla.setText(text);
    }
}
