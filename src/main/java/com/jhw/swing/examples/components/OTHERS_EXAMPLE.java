package com.jhw.swing.examples.components;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.jhw.swing.ui.MaterialLookAndFeel;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialIcons;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OTHERS_EXAMPLE extends javax.swing.JFrame {

    public OTHERS_EXAMPLE() {
        initComponents();

        _MaterialLabel2.setIcon(MaterialIcons.TEC_GITKRAKEN.deriveIcon(300f));
        this.setExtendedState(MAXIMIZED_BOTH);

        _PanelGradient1.setIcon(MaterialIcons.ADD.deriveIcon(MaterialColors.COSMO_PURPLE).deriveIcon(150f));
        _PanelGradient2.setIcon(MaterialIcons.TEC_JAVA.deriveIcon(MaterialColors.PINK_600).deriveIcon(150f));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//
    private void initComponents() {

        _MaterialLabel1 = new com.jhw.swing.material.components.labels._MaterialLabel();
        _MaterialLabel2 = new com.jhw.swing.material.components.labels._MaterialLabel();
        _labelNegativo1 = new com.jhw.swing.material.components.labels.prepared._labelNegativo();
        _labelPositive1 = new com.jhw.swing.material.components.labels.prepared._labelPositive();
        _MaterialFileChooserPanel1 = new com.jhw.swing.material.components.filechooser._MaterialFileChooserPanel();
        _MaterialComboBox1 = new com.jhw.swing.material.components.combobox._MaterialComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        _MaterialPasswordField1 = new com.jhw.swing.material.components.passwordfield._MaterialPasswordField();
        _MaterialProgressSpinner1 = new com.jhw.swing.material.components.progress._MaterialProgressSpinner();
        jPasswordField1 = new javax.swing.JPasswordField();
        _PanelGradient1 = new com.jhw.swing.material.components.container.panel._PanelGradient();
        _PanelGradient2 = new com.jhw.swing.material.components.container.panel._PanelGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _MaterialLabel1.setText("_MaterialLabel1");

        _MaterialLabel2.setForeground(new java.awt.Color(0, 0, 0));
        _MaterialLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        _MaterialLabel2.setText("SVG icon");
        _MaterialLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N

        _labelNegativo1.setText("_labelNegativo1");

        _labelPositive1.setText("_labelPositive1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        _MaterialPasswordField1.setHint("Include the wrong functionality");
        _MaterialPasswordField1.setLabel("password field");

        jPasswordField1.setText("jPasswordField1");

        _PanelGradient1.setToolTipText("TTF icon derivated");

        javax.swing.GroupLayout _PanelGradient1Layout = new javax.swing.GroupLayout(_PanelGradient1);
        _PanelGradient1.setLayout(_PanelGradient1Layout);
        _PanelGradient1Layout.setHorizontalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        _PanelGradient1Layout.setVerticalGroup(
            _PanelGradient1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        _PanelGradient2.setToolTipText("SVG icon derivated");

        javax.swing.GroupLayout _PanelGradient2Layout = new javax.swing.GroupLayout(_PanelGradient2);
        _PanelGradient2.setLayout(_PanelGradient2Layout);
        _PanelGradient2Layout.setHorizontalGroup(
            _PanelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        _PanelGradient2Layout.setVerticalGroup(
            _PanelGradient2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_MaterialLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_MaterialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_MaterialComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_MaterialPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_MaterialFileChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_labelNegativo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_labelPositive1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_PanelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(_PanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_MaterialProgressSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_MaterialLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_MaterialLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_labelNegativo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(_labelPositive1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(_MaterialFileChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_MaterialProgressSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(_PanelGradient1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_MaterialComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(_MaterialPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPasswordField1))))
                    .addComponent(_PanelGradient2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new MaterialLookAndFeel());

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OTHERS_EXAMPLE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//:variables
    private com.jhw.swing.material.components.combobox._MaterialComboBox _MaterialComboBox1;
    private com.jhw.swing.material.components.filechooser._MaterialFileChooserPanel _MaterialFileChooserPanel1;
    private com.jhw.swing.material.components.labels._MaterialLabel _MaterialLabel1;
    private com.jhw.swing.material.components.labels._MaterialLabel _MaterialLabel2;
    private com.jhw.swing.material.components.passwordfield._MaterialPasswordField _MaterialPasswordField1;
    private com.jhw.swing.material.components.progress._MaterialProgressSpinner _MaterialProgressSpinner1;
    private com.jhw.swing.material.components.container.panel._PanelGradient _PanelGradient1;
    private com.jhw.swing.material.components.container.panel._PanelGradient _PanelGradient2;
    private com.jhw.swing.material.components.labels.prepared._labelNegativo _labelNegativo1;
    private com.jhw.swing.material.components.labels.prepared._labelPositive _labelPositive1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration                   

}
