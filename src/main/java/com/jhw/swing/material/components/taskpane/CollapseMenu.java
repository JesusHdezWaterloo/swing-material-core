/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.taskpane;

import com.jhw.swing.material.components.button._MaterialButtonTransparent;
import com.jhw.swing.material.components.button._MaterialButtonIconTranspRect;
import com.jhw.swing.material.components.container.panel._MaterialPanel;
import com.jhw.swing.material.components.dashboard.taskpane.DashBoardTaskPane;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.personalization.PersonalizationMaterial;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author Jorge
 */
//TODO: fondo personalizable
//TODO: 
public class CollapseMenu extends JPanel {

    public static final String PROP_COLLAPSE = "Collapse";

    private Icon iconoCategoria;
    private String nombreCategoria;

    private ArrayList<TaskButton> buttons = new ArrayList<>();
    private DashBoardTaskPane parent;

    private Color selected = MaterialColors.WHITE;
    private Color deselected = MaterialColors.RED_900;

    public CollapseMenu(Icon iconoCategoria, String nombreCategoria, DashBoardTaskPane parent) {
        initComponents();
        this.iconoCategoria = iconoCategoria;
        this.nombreCategoria = nombreCategoria;
        configurateUI();
        this.parent = parent;
        this.parent.addCollapseMenu(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSubActions = new JXTaskPaneContainer() {
            @Override
            public void updateUI() {
                //vacio para que no coja el ui del padre
            }
        };
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanelFixed = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonIcono = new _MaterialButtonIconTranspRect();
        jButtonNombre = new _MaterialButtonTransparent("");
        jPanelCollapsible = new org.jdesktop.swingx.JXCollapsiblePane();

        jPanelSubActions.setBackground(new java.awt.Color(204, 0, 204));
        jPanelSubActions.setOpaque(false);
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(14);
        jPanelSubActions.setLayout(verticalLayout1);

        setBackground(new java.awt.Color(255, 255, 0));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.BorderLayout());

        jPanelFixed.setBackground(new java.awt.Color(0, 153, 153));
        jPanelFixed.setMaximumSize(null);
        jPanelFixed.setMinimumSize(null);
        jPanelFixed.setPreferredSize(null);
        jPanelFixed.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel1.setText("#");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setMaximumSize(new java.awt.Dimension(15, 18));
        jLabel1.setMinimumSize(new java.awt.Dimension(15, 18));
        jLabel1.setPreferredSize(new java.awt.Dimension(15, 18));
        jPanelFixed.add(jLabel1, java.awt.BorderLayout.LINE_END);

        jButtonIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonIcono.setMaximumSize(new java.awt.Dimension(80, 80));
        jButtonIcono.setMinimumSize(new java.awt.Dimension(60, 60));
        jButtonIcono.setPreferredSize(new java.awt.Dimension(60, 60));
        jPanelFixed.add(jButtonIcono, java.awt.BorderLayout.LINE_START);

        jButtonNombre.setFont(new java.awt.Font(".SF NS Text", 0, 18)); // NOI18N
        jButtonNombre.setText("<Nombre>");
        jButtonNombre.setBorderPainted(false);
        jPanelFixed.add(jButtonNombre, java.awt.BorderLayout.CENTER);

        add(jPanelFixed, java.awt.BorderLayout.PAGE_START);

        jPanelCollapsible.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCollapsible.setDirection(org.jdesktop.swingx.JXCollapsiblePane.Direction.DOWN);
        add(jPanelCollapsible, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIcono;
    private javax.swing.JButton jButtonNombre;
    private javax.swing.JLabel jLabel1;
    private org.jdesktop.swingx.JXCollapsiblePane jPanelCollapsible;
    private javax.swing.JPanel jPanelFixed;
    private org.jdesktop.swingx.JXTaskPaneContainer jPanelSubActions;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables

    public void shrink() {
        onMouseCLicked(null);
    }

    public Color getSelected() {
        return selected;
    }

    public void setSelected(Color selected) {
        this.selected = selected;
    }

    public Color getDeselected() {
        return deselected;
    }

    public void setDeselected(Color deselected) {
        this.deselected = deselected;
    }

    public void selected(boolean select) {
        if (select) {
            setMainButtonBackground(selected);
        } else {
            setMainButtonBackground(deselected);
        }
    }

    public void addMenuItem(Action action) {
        //Add button
        TaskButton button = new TaskButton(action, this);
        if (parent.getFormateer() != null) {
            parent.getFormateer().formatButton(button);
        }

        buttons.add(button);
        jPanelSubActions.add(button);

        //update label cantidad
        jLabel1.setText("" + jPanelSubActions.getComponentCount());

        //add the popup
        JMenuItem item = jPopupMenu1.add(action);//add to the menu
        item.addActionListener(new ActionListener() {//activate the selected in case of click
            @Override
            public void actionPerformed(ActionEvent e) {
                childSelected();
            }
        });
    }

    public void childSelected() {
        parent.deselectAll();
        setMainButtonBackground(selected);
    }

    public void deselectAll() {
        setMainButtonBackground(deselected);
        for (TaskButton button : buttons) {
            button.deselect();
        }
    }

    private void setMainButtonBackground(Color color) {
        jPanelFixed.setBackground(color);
        setCollapsablePanelBackground(color);
    }

    public void setCollapsablePanelBackground(Color color) {
        jPanelCollapsible.getContentPane().setBackground(color);
    }

    public void setButtonNameFont(Font font) {
        jButtonNombre.setFont(font);
        Font internal = font.deriveFont(Font.PLAIN).deriveFont(font.getSize2D() * 0.8f);
        setButtonsInternalFont(internal);
        jLabel1.setFont(internal);

    }

    public void setButtonsInternalFont(Font font) {
        for (TaskButton button : buttons) {
            button.setFont(font);
        }
    }

    public void setButtonNameHorizontalAlignment(int align) {
        jButtonNombre.setHorizontalAlignment(align);
    }

    public void setPanelCollapsibleGaps(int top, int left, int bottom, int right) {
        jPanelCollapsible.setBorder(javax.swing.BorderFactory.createEmptyBorder(top, left, bottom, right));
    }

    public JPanel getjPanelFixed() {
        return jPanelFixed;
    }

    public void setHeight(int h) {//el # ese es el max
        jPanelFixed.setPreferredSize(new java.awt.Dimension(300, h));
        jButtonIcono.setPreferredSize(new java.awt.Dimension(h, h));
    }

    public int getComponentsHight() {
        return (int) jButtonIcono.getPreferredSize().getHeight();
    }

    public void setComponentsGap(int gap) {
        ((VerticalLayout) jPanelSubActions.getLayout()).setGap(gap);
    }

    protected void configurateUI() {
        jPanelCollapsible.setLayout(new BorderLayout());
        jPanelCollapsible.add(jPanelSubActions, BorderLayout.CENTER);

        setComponentsGap(0);

        jButtonIcono.setIcon(iconoCategoria);

        jButtonNombre.setText(nombreCategoria);

        jPanelCollapsible.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            if (evt.getPropertyName().equals("collapse")) {
                setOpaque(!jPanelCollapsible.isCollapsed());
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if (isShinked()) {
                    jPanelCollapsible.setCollapsed(true);
                    jButtonIcono.setToolTipText(nombreCategoria);
                } else {
                    jButtonIcono.setToolTipText(null);
                }

            }

        });
        addListeners();
        setMainButtonBackground(deselected);
    }

    private boolean isShinked() {
        return getSize().width < jButtonIcono.getSize().width + 20;//TODO: personalizar tamanno del menu
    }

    private void createPopupPanel() {
        jPopupMenu1.show(this, jButtonIcono.getBounds().x + jButtonIcono.getWidth(), jButtonIcono.getBounds().y);
        //  Logger.getLogger(getClass().getName()).log(Level.WARNING, "En desarrollo");
    }

    private void onMouseCLicked(ActionEvent e) {
        if (isShinked()) {
            createPopupPanel();
        } else {
            jPanelCollapsible.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION).actionPerformed(null);
        }

    }

    public JButton getjButtonIcono() {
        return jButtonIcono;
    }

    public JButton getjButtonNombre() {
        return jButtonNombre;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JXCollapsiblePane getjPanelCollapsible() {
        return jPanelCollapsible;
    }

    protected void addListeners() {
        jButtonIcono.addActionListener((ActionEvent e) -> {
            onMouseCLicked(e);
        });
        jButtonNombre.addActionListener((ActionEvent e) -> {
            onMouseCLicked(e);
        });
    }

}
