package com.jhw.swing.material.components.combobox.combobox_editable;

import com.jhw.swing.material.components.labels._MaterialLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.JLabel;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.swing.UIManager;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FilterEditor<T> extends BasicComboBoxEditor {

    private JLabel filterLabel = new _MaterialLabel();
    private String text = "";
    boolean editing;
    private Function<T, String> displayTextFunction;
    private Consumer<Boolean> editingChangeListener;
    private Object selected;

    FilterEditor(Function<T, String> displayTextFunction,
            Consumer<Boolean> editingChangeListener) {
        this.displayTextFunction = displayTextFunction;
        this.editingChangeListener = editingChangeListener;
    }

    public void addChar(char c) {
        text += c;
        if (!editing) {
            enableEditingMode();
        }
    }

    public void removeCharAtEnd() {
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
            if (!editing) {
                enableEditingMode();
            }
        }
    }

    private void enableEditingMode() {
        editing = true;
        //filterLabel.setFont(filterLabel.getFont().deriveFont(Font.PLAIN));
        editingChangeListener.accept(true);
    }

    public void reset() {
        if (editing) {
            //filterLabel.setFont(UIManager.getFont("ComboBox.font"));
            //filterLabel.setForeground(UIManager.getColor("Label.foreground"));
            text = "";
            editing = false;
            editingChangeListener.accept(false);
        }
    }

    @Override
    public Component getEditorComponent() {
        return filterLabel;
    }

    public JLabel getFilterLabel() {
        return filterLabel;
    }

    @Override
    public void setItem(Object anObject) {
        if (editing) {
            filterLabel.setText(text);
        } else {
            T t = (T) anObject;
            filterLabel.setText(displayTextFunction.apply(t));
        }
        this.selected = anObject;
    }

    @Override
    public Object getItem() {
        return selected;
    }

    @Override
    public void selectAll() {
    }

    @Override
    public void addActionListener(ActionListener l) {
    }

    @Override
    public void removeActionListener(ActionListener l) {
    }

    public boolean isEditing() {
        return editing;
    }

    public String getText() {
        return text;
    }
}