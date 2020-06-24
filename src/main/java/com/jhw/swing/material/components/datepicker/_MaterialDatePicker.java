/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.datepicker;

import com.jhw.swing.material.components.container.panels._PanelTransparent;
import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.utils.exceptions.ModelInputErrorException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import com.jhw.swing.personalization.PersonalizationMaterial;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.interfaces.Update;
import com.jhw.swing.util.interfaces.DateSelected;
import com.jhw.swing.material.standars.MaterialColors;
import com.jhw.swing.material.standars.MaterialFontRoboto;
import com.jhw.swing.util.validations.Validation;
import com.jhw.swing.util.validations.datepicker.DatePickerValidation;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialDatePicker extends _PanelTransparent implements DateSelected, Update {

    private String label;

    //default
    private Color foreground = MaterialColors.BLACK;

    //flags for wrong
    private boolean wrongFlag = false;
    private Color wrongColor = PersonalizationMaterial.getInstance().getColorWrong();
    private String wrongText = "Error en este campo";

    private final ArrayList<DatePickerValidation> preValidations = new ArrayList<>();
    private final ArrayList<DatePickerValidation> postValidations = new ArrayList<>();

    public _MaterialDatePicker() {
        this("Fecha");
    }

    public _MaterialDatePicker(String label) {
        initComponents();
        labelWrong.setFont(MaterialFontRoboto.MEDIUM.deriveFont(14f));
        setLabel(label);
        this.datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearWrong();
            }
        });
        clearWrong();
        personalize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datePicker = new com.jhw.swing.material.components.datepicker._JXDatePicker();
        labelWrong = new com.jhw.swing.material.components.labels._MaterialLabel();

        datePicker.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

        labelWrong.setText("Wrong");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelWrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(datePicker, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelWrong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.jhw.swing.material.components.datepicker._JXDatePicker datePicker;
    private com.jhw.swing.material.components.labels._MaterialLabel labelWrong;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
    }

    private void personalize() {
        setLabel(label);
    }

    public ArrayList<DatePickerValidation> getPostValidations() {
        return postValidations;
    }

    public void addPostValidation(DatePickerValidation val) {
        postValidations.remove(val);
        postValidations.add(val);
    }

    public ArrayList<DatePickerValidation> getPreValidations() {
        return preValidations;
    }

    public void addPreValidation(DatePickerValidation val) {
        preValidations.remove(val);
        preValidations.add(val);
    }

    @Override
    public Date getDateValidated() {
        runPreValidations();
        Date ans = datePicker.getDateValidated();
        runPostValidations();
        return ans;
    }

    @Override
    public void setDate(Date date) {
        datePicker.setDate(date);
    }

    @Override
    public Date getDate() {
        return datePicker.getDate();
    }

    public void wrong(String text) {
        setWrongText(text);
        wrong();
    }

    public void wrong() {
        wrongFlag = true;
        setForeground(wrongColor);
        this.datePicker.setForeground(getForeground());
        labelWrong.setText(wrongText);
        labelWrong.setForeground(wrongColor);
        setLabel(label);
    }

    public void clearWrong() {
        wrongFlag = false;
        setForeground(foreground);
        this.datePicker.setForeground(getForeground());
        labelWrong.setForeground(MaterialColors.TRANSPARENT);
        setLabel(label);
    }

    public Color getRealForeground() {
        return foreground;
    }

    public void setRealForeground(Color fg) {
        this.foreground = fg;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
        datePicker.setBorder(getRealBorder());
    }

    public boolean isWrongFlag() {
        return wrongFlag;
    }

    public void setWrongFlag(boolean wrongFlag) {
        this.wrongFlag = wrongFlag;
    }

    public Color getWrongColor() {
        return wrongColor;
    }

    public void setWrongColor(Color wrongColor) {
        this.wrongColor = wrongColor;
    }

    public _JXDatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(_JXDatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public _MaterialLabel getLabelWrong() {
        return labelWrong;
    }

    public void setLabelWrong(_MaterialLabel labelWrong) {
        this.labelWrong = labelWrong;
    }

    private TitledBorder getRealBorder() {
        Font font = datePicker.getFont().deriveFont(datePicker.getFont().getSize2D() * 0.8f);
        Color lineColor = !wrongFlag ? Utils.applyAlphaMask(getForeground(), _MaterialTextField.LINE_OPACITY_MASK) : getForeground();
        TitledBorder border = new TitledBorder(new LineBorder(lineColor), this.label, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, font, getForeground());
        return border;
    }

    private void runPostValidations() {
        for (Validation v : postValidations) {
            if (!v.validate(this)) {
                setWrongText(v.getWrongText());
                wrong();
                throw new ModelInputErrorException(v.getDetailedText());
            }
        }
    }

    private void runPreValidations() {
        for (Validation v : preValidations) {
            if (!v.validate(this)) {
                setWrongText(v.getWrongText());
                wrong();
                throw new ModelInputErrorException(v.getDetailedText());
            }
        }
    }

    /**
     * Get the wrong text. The worng text is the text to display with the
     * explanaition of the error.
     *
     * @return the wrong color
     */
    public String getWrongText() {
        return wrongText;
    }

    /**
     * Set the wrong text. The worng text is the text to display with the
     * explanaition of the error.
     *
     * @param wrongText the wrong text
     */
    public void setWrongText(String wrongText) {
        this.wrongText = wrongText;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.datePicker.setEnabled(enabled);
        super.setEnabled(enabled);
    }
}