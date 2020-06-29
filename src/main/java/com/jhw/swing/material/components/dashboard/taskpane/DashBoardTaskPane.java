/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.dashboard.taskpane;

import com.jhw.swing.TEST.dash.CollapseMenuFormateer;
import com.jhw.swing.material.components.taskpane.CollapseMenu;
import com.jhw.swing.material.components.taskpane.TaskPaneContainer;
import com.jhw.swing.material.components.button._MaterialIconButtonTranspRect;
import com.jhw.swing.material.standars.MaterialIcons;
import com.jhw.swing.personalization.PersonalizationMaterial;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Jorge
 */
public class DashBoardTaskPane extends JPanel {

    private final CardLayout cards = new CardLayout();

    private boolean shrinked;

    private TaskPaneContainer task = new TaskPaneContainer();

    private CollapseMenuFormateer formateer;

    /**
     * Creates new form RootView
     */
    public DashBoardTaskPane() {
        initComponents();
        personalize();
        panelContent.setLayout(cards);
        jPanelMenu.add(task, BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContent = new javax.swing.JPanel();
        panelSideMenu = new javax.swing.JPanel();
        jPanelBackButton = new javax.swing.JPanel();
        jButtonBack = new javax.swing.JButton();
        jPanelShinkButton = new javax.swing.JPanel();
        jButtonShrink = new _MaterialIconButtonTranspRect(MaterialIcons.MENU.deriveIcon(36f));
        jPanelMenu = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        panelContent.setBackground(new java.awt.Color(255, 255, 255));
        panelContent.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.GroupLayout panelContentLayout = new javax.swing.GroupLayout(panelContent);
        panelContent.setLayout(panelContentLayout);
        panelContentLayout.setHorizontalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        panelContentLayout.setVerticalGroup(
            panelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        add(panelContent, java.awt.BorderLayout.CENTER);

        panelSideMenu.setBackground(new java.awt.Color(102, 102, 102));
        panelSideMenu.setLayout(new java.awt.BorderLayout());

        jPanelBackButton.setOpaque(false);

        jButtonBack.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBack.setMaximumSize(new java.awt.Dimension(40, 40));
        jButtonBack.setMinimumSize(new java.awt.Dimension(40, 40));
        jButtonBack.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanelBackButton.add(jButtonBack);

        panelSideMenu.add(jPanelBackButton, java.awt.BorderLayout.PAGE_START);

        jPanelShinkButton.setOpaque(false);
        jPanelShinkButton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButtonShrink.setMaximumSize(new java.awt.Dimension(60, 40));
        jButtonShrink.setMinimumSize(new java.awt.Dimension(60, 40));
        jButtonShrink.setPreferredSize(new java.awt.Dimension(60, 40));
        jButtonShrink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonShrinkActionPerformed(evt);
            }
        });
        jPanelShinkButton.add(jButtonShrink);

        panelSideMenu.add(jPanelShinkButton, java.awt.BorderLayout.PAGE_END);

        jPanelMenu.setBackground(new java.awt.Color(0, 0, 0));
        jPanelMenu.setLayout(new java.awt.BorderLayout());
        panelSideMenu.add(jPanelMenu, java.awt.BorderLayout.CENTER);

        add(panelSideMenu, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonShrinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonShrinkActionPerformed
        setShrinked(!shrinked);
    }//GEN-LAST:event_jButtonShrinkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonShrink;
    private javax.swing.JPanel jPanelBackButton;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelShinkButton;
    private javax.swing.JPanel panelContent;
    private javax.swing.JPanel panelSideMenu;
    // End of variables declaration//GEN-END:variables

    private void personalize() {
        panelSideMenu.setBackground(PersonalizationMaterial.getInstance().getColorPrincipal());
    }

    public CollapseMenuFormateer getFormateer() {
        return formateer;
    }

    public void setFormateer(CollapseMenuFormateer formateer) {
        this.formateer = formateer;
    }

    public void setShrinked(boolean shrink) {
        this.shrinked = shrink;
        this.task.setCollapsed(this.shrinked);
    }

    public void addCollapseMenu(CollapseMenu menu) {
        if (formateer != null) {
            formateer.format(menu);
        }
        this.task.addMenuItem(menu);
    }

    public void addComponent(CollapseMenu menu) {
        this.task.addMenuItem(menu);
    }

    public void addView(String name, Component compoment) {
        panelContent.add(name, compoment);
    }

    public void showView(String name) {
        cards.show(panelContent, name);
    }

}
