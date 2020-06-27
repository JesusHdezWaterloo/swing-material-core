package com.jhw.swing.models.input.panels;

import com.jhw.swing.util.interfaces.ModelablePanel;
import com.jhw.swing.material.components.container.panel._PanelTransparent;
import com.jhw.utils.interfaces.Update;
import java.awt.Component;
import java.awt.GridLayout;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T> Tipo de modelos que se va a trabajar.
 */
public abstract class ModelPanel<T> extends _PanelTransparent implements Update, ModelablePanel<T> {

    protected T model;

    public ModelPanel(T model) {
        initComponents();
        this.model = model;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    protected void setComponent(Component component) {
        this.setLayout(new GridLayout(1, 1));
        this.removeAll();
        this.setPreferredSize(component.getPreferredSize());
        this.setMinimumSize(getPreferredSize());
        this.add(component);
    }

    @Override
    public T getOldModel() {
        return model;
    }

    @Override
    public void setOldModel(T model) {
        this.model = model;
    }

    @Override
    public T onPostDeleteAction(T obj) {
        return obj;
    }

    @Override
    public T onPostCreateAction(T obj) {
        return obj;
    }

    @Override
    public void update() {
    }

}
