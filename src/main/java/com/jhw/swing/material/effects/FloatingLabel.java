package com.jhw.swing.material.effects;

import static com.jhw.swing.material.components.textfield._MaterialTextField.HINT_OPACITY_MASK;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextField;
import com.jhw.swing.material.components.textfield._MaterialTextField;
import org.jdesktop.core.animation.timing.Animator;
import org.jdesktop.core.animation.timing.interpolators.SplineInterpolator;
import com.jhw.swing.personalization.Inistanciables;
import com.jhw.swing.util.SafePropertySetter;
import com.jhw.swing.util.Utils;
import com.jhw.swing.util.enums.TextTypeEnum;

/**
 * A floating label of a text field.
 */
public class FloatingLabel {

    private final JTextField target;
    private Animator animator;
    private final SafePropertySetter.Property<Integer> y;
    private final SafePropertySetter.Property<Integer> x;
    private final SafePropertySetter.Property<Float> fontSize;
    private final SafePropertySetter.Property<Color> color;
    private Color accentColor;

    public FloatingLabel(JTextField target) {
        this.target = target;

        y = SafePropertySetter.animatableProperty(target, 0);//target.getSize().height / 2 + target.getFontMetrics(target.getFont()).getAscent() / 2);
        x = SafePropertySetter.animatableProperty(target, 0);//target.getSize().height / 2 + target.getFontMetrics(target.getFont()).getAscent() / 2);

        fontSize = SafePropertySetter.animatableProperty(target, target.getFont().getSize2D());

        color = SafePropertySetter.animatableProperty(target, Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));

        this.updateForeground();
    }

    public void updateForeground() {
        color.setValue(Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK));
    }

    public void update() {
        if (animator != null) {
            animator.stop();
        }
        Animator.Builder builder = new Animator.Builder(Inistanciables.getSwingTimerTimingSource())
                .setDuration(200, TimeUnit.MILLISECONDS)
                .setEndBehavior(Animator.EndBehavior.HOLD)
                .setInterpolator(new SplineInterpolator(0.4, 0, 0.2, 1));

        //Font size, si no hay letra es tamaño real, si está arriba es el 80% del tamaño(1 poquito mas chiquito)
        float targetFontSize = (target.isFocusOwner() || !target.getText().isEmpty()) ? target.getFont().getSize2D() * 0.8f : target.getFont().getSize2D();
        if (fontSize.getValue() != targetFontSize) {
            builder.addTarget(SafePropertySetter.getTarget(fontSize, fontSize.getValue(), targetFontSize));
        }

        //Y position
        int targetY = target.isFocusOwner() || !target.getText().isEmpty() ? getYPositionUP() : getYPositionDOWN();
        if (Math.abs(targetY - y.getValue()) > 0.1) {
            builder.addTarget(SafePropertySetter.getTarget(y, y.getValue(), targetY));
        }

        //X position
        if (target instanceof _MaterialTextField) {
            _MaterialTextField txtFld = (_MaterialTextField) target;
            int targetX = 0;
            if (txtFld.getType() == TextTypeEnum.MONEY && targetY == getYPositionDOWN()) {
                targetX = _MaterialTextField.MONEY_TRASLATION;
            }
            builder.addTarget(SafePropertySetter.getTarget(x, x.getValue(), targetX));
        }

        //color, varia entre el color de accent y el de Opacity_Mask
        Color targetColor;
        if (target.isFocusOwner()) {
            targetColor = accentColor;
        } else {
            targetColor = Utils.applyAlphaMask(target.getForeground(), HINT_OPACITY_MASK);
        }
        if (!targetColor.equals(color.getValue())) {
            builder.addTarget(SafePropertySetter.getTarget(color, color.getValue(), targetColor));
        }

        animator = builder.build();
        animator.start();
    }

    public void setAccentColor(Color accentColor) {
        this.accentColor = accentColor;
    }

    public Color getColor() {
        return color.getValue();
    }

    public Font getFont() {
        return target.getFont().deriveFont(fontSize.getValue());
    }

    public int getY() {
        return y.getValue();
    }

    public int getX() {
        return x.getValue();
    }

    public boolean isFloatingAbove() {
        return y.getValue() >= getYPositionUP();
    }

    private int getYPositionUP() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionUP = yMid - metrics.getAscent() / 2 - 7;//un poquito mas arriba del texto
        return yPositionUP;
    }

    private int getYPositionDOWN() {
        int size = target.getSize().height;
        if (size == 0) {
            size = target.getPreferredSize().height;
        }

        int yMid = size / 2;
        FontMetrics metrics = target.getFontMetrics(target.getFont());
        int yPositionDown = yMid + metrics.getAscent() / 2;//un poquito mas arriba del texto
        return yPositionDown;
    }
}