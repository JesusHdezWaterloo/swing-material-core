/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.components.popup;

import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.components.button._MaterialButton;
import com.jhw.swing.material.injection.Background_Force_Foreground;
import com.jhw.swing.material.injection.Foreground_Force_Icon;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialShadow;
import com.jhw.swing.util.MaterialDrawingUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Action;

/**
 * Boton cuadrado, no se puede poner en layouts que se expandan xq no hace bien
 * el resize.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class ButtonSqrt extends _MaterialButton {

    public static ButtonSqrt from() {
        return MaterialSwingInjector.getImplementation(ButtonSqrt.class);
    }

    public static ButtonSqrt from(Action a) {
        ButtonSqrt sqrt = MaterialSwingInjector.getImplementation(ButtonSqrt.class);
        sqrt.setAction(a);
        return sqrt;
    }

    public ButtonSqrt(Action act) {
        this();
        this.setAction(act);
    }

    public ButtonSqrt() {
        this.setBackground(MaterialColors.BLUEGREY_300);
        this.setBorderColor(MaterialColors.BLUEGREY_50);
        this.setBorderThickness(2);
        this.setType(Type.FLAT);
        this.setAccentColorFadeInto(MaterialColors.WHITE);
    }

    @Override
    public void setAction(Action a) {
        super.setAction(a);
        if (getIcon() != null) {
            int s = (int) (2.5f * Math.max(getIcon().getIconWidth(), getIcon().getIconHeight()));
            this.setPreferredSize(new Dimension(s, s));
        } else {
            this.setPreferredSize(new Dimension(75, 75));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = MaterialDrawingUtils.getAliasedGraphics(g);

        int offset_lr = (int) getBorderThickness();
        int offset_td = (int) getBorderThickness();

        //color de fondo
        if (isEnabled()) {
            g2.setColor(getColorFadeInto());
        } else {
            Color bg = getBackground();
            g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
        }
        int size = Math.min(getWidth(), getHeight());
        g2.fill(new RoundRectangle2D.Float(0, 0, size - offset_lr, size - offset_td, getBorderRadius() * 2, getBorderRadius() * 2));

        //borde
        paintBorder(this, g2, 0, 0, (int) (size - offset_lr + getBorderThickness()), (int) (size - offset_td + getBorderThickness()));

        //ripple
        if (this.isEnabled()) {//el ripple por debajo de las letras e iconos
            g2.setClip(new RoundRectangle2D.Float(0, 0, size - offset_lr, size - offset_td, Math.max(getBorderRadius() * 2 - 4, 0), Math.max(getBorderRadius() * 2 - 4, 0)));
            paintRipple(g2);
        }

        //icon
        if (this.getIcon() != null) {
            int xIcon = (int) (size - getIcon().getIconWidth()) / 2 - offset_lr / 2;
            int yIcon = (int) (size / 2 - getIcon().getIconHeight() + 3);
            this.getIcon().paintIcon(this, g2, xIcon, yIcon);
        }

        FontMetrics metrics = g2.getFontMetrics(getFont());

        int xText = (int) (size - metrics.stringWidth(getText())) / 2 - offset_lr / 2;
        int yText = size / 2 + metrics.getAscent() + 3;

        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(this.getText(), xText, yText);

    }

}
