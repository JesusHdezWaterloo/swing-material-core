package com.jhw.swing.material.components.textarea;

import com.jhw.swing.material.components.textfield.CopyPastePopup;
import java.awt.Color;
import javax.swing.JTextArea;
import com.jhw.swing.util.Utils;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.swing.util.interfaces.BindableComponent;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextAreaCore extends JTextArea implements BindableComponent<String> {

    public _MaterialTextAreaCore() {
        this.setBackground(MaterialColors.WHITE);
        this.setFont(MaterialFontRoboto.REGULAR.deriveFont(16f));
        this.setLineWrap(true);
        this.setComponentPopupMenu(CopyPastePopup.INSTANCE);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        this.setForeground(Utils.getForegroundAccording(bg));
    }

    @Override
    public String getObject() {
        return getText();
    }

    @Override
    public void setObject(String object) {
        setText(object);
    }
}
