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
package com.root101.swing.material.components.popup;

import com.root101.swing.material.components.button._MaterialButton;
import com.root101.swing.material.injection.Background_Force_Foreground;
import com.root101.swing.material.injection.Foreground_Force_Icon;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.util.MaterialDrawingUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Action;
import static com.root101.swing.material.standards.Utils.HINT_OPACITY_MASK;
import com.root101.swing.util.Utils;

/**
 * Boton cuadrado, no se puede poner en layouts que se expandan xq no hace bien
 * el resize.
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Background_Force_Foreground
@Foreground_Force_Icon
public class ButtonSqrt extends _MaterialButton {

    public static ButtonSqrt from() {
        return MaterialSwingInjector.getImplementation(ButtonSqrt.class);
    }

    public static ButtonSqrt from(Action a) {
        ButtonSqrt sqrt = from();
        sqrt.setAction(a);
        sqrt.setToolTipText((String) a.getValue(Action.SHORT_DESCRIPTION));
        return sqrt;
    }

    /**
     * Use ButtonSqrt.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public ButtonSqrt(Action act) {
        this();
        this.setAction(act);
    }

    /**
     * Use ButtonSqrt.from() para proy y AOP
     *
     * @deprecated
     */
    @Deprecated
    public ButtonSqrt() {
        this.setBackground(MaterialColors.BLUEGREY_300);
        this.setBorderColor(MaterialColors.BLUEGREY_50);
        this.setBorderThickness(2);
        this.setType(Type.FLAT);
        this.setAccentColorFadeInto(MaterialColors.WHITE);
        this.setIconTextGap(3);
    }

    @Override
    public void setAction(Action a) {
        super.setAction(a);
        float prop = 2.5f;
        if (getText().isEmpty()) {//si no tiene texto pongo el icono mas pequeño para que se ajuste al icono
            prop = 1.75f;
        }
        if (getIcon() != null) {//si tiene icono lo ajusto
            int s = (int) (prop * Math.max(getIcon().getIconWidth(), getIcon().getIconHeight()));
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
            g2.setColor(Utils.applyAlphaMask(bg, HINT_OPACITY_MASK));
            //g2.setColor(new Color(bg.getRed() / 255f, bg.getGreen() / 255f, bg.getBlue() / 255f, 0.6f));
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

        if (getText().isEmpty()) {//solo icon, lo pongo en el medio
            //icon
            if (this.getIcon() != null) {
                int xIcon = (int) (size - getIcon().getIconWidth()) / 2 - offset_lr / 2;
                int yIcon = (int) (size - getIcon().getIconHeight()) / 2;
                this.getIcon().paintIcon(this, g2, xIcon, yIcon);
            }
        } else {
            //icon
            if (this.getIcon() != null) {
                int xIcon = (int) (size - getIcon().getIconWidth()) / 2 - offset_lr / 2;
                int yIcon = (int) (size / 2 - getIcon().getIconHeight() + getIconTextGap());
                this.getIcon().paintIcon(this, g2, xIcon, yIcon);
            }

            FontMetrics metrics = g2.getFontMetrics(getFont());

            int xText = (int) (size - metrics.stringWidth(getText())) / 2 - offset_lr / 2;
            int yText = size / 2 + metrics.getAscent() + getIconTextGap();

            g2.setColor(getForeground());
            g2.setFont(getFont());
            g2.drawString(this.getText(), xText, yText);
        }
    }

}
