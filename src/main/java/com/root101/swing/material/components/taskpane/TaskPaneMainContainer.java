/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.swing.material.components.taskpane;

import com.root101.swing.material.components.scrollpane.MaterialScrollFactory;
import com.root101.swing.material.components.scrollpane.MaterialScrollPane;
import com.root101.swing.ui.componentsui.panel.MaterialPanelUI;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.Border;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.JXTaskPaneContainer;
import org.jdesktop.swingx.VerticalLayout;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class TaskPaneMainContainer extends JXCollapsiblePane {

    private final JXTaskPaneContainer taskPane = new JXTaskPaneContainer();
    private final MaterialScrollPane scrollPane = MaterialScrollFactory.buildPane();

    public TaskPaneMainContainer() {
        initComponents();
    }

    private void initComponents() {
        //sobreescribir el ui para que coja los colores
        taskPane.setUI(new MaterialPanelUI());

        //direction del collapse
        setDirection(JXCollapsiblePane.Direction.LEFT);

        //layout
        this.setLayout(new BorderLayout());

        //add el scroll
        this.add(scrollPane, BorderLayout.CENTER);

        //add el task pane al scroll
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setViewportView(taskPane);

        //retoques a la visual, quitados gap y border
        setComponentsGap(0);
        setInternalBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        //quita el border al scroll pane
        scrollPane.setBorder(null);
    }

    public void clear() {
        taskPane.removeAll();
    }

    public void setTaskPaneBackground(Color color) {
        this.taskPane.setBackground(color);
        this.scrollPane.getMaterialVerticalScrollBar().setBackgroundThumb(color);
    }

    public void setComponentsGap(int gap) {
        if (taskPane.getLayout() != null && taskPane.getLayout() instanceof VerticalLayout) {
            ((VerticalLayout) taskPane.getLayout()).setGap(gap);
        }
    }

    public void setInternalBorder(Border border) {
        taskPane.setBorder(border);
    }

    public void addItem(CollapseMenu menu) {
        this.taskPane.add(menu);
    }

}
