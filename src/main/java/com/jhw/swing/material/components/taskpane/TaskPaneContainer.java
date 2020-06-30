package com.jhw.swing.material.components.taskpane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPaneContainer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class TaskPaneContainer extends JXCollapsiblePane {

    private JXTaskPaneContainer taskPane = new JXTaskPaneContainer();

    public TaskPaneContainer() {
        setDirection(JXCollapsiblePane.Direction.LEFT);
        this.setLayout(new BorderLayout());
        this.add(taskPane, BorderLayout.CENTER);
    }

    public void addMenuItem(CollapseMenu menu) {
        this.taskPane.add(menu);
    }
}
