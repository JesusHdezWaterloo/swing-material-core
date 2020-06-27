package com.jhw.swing.material.components.labels.prepared;

import com.jhw.swing.material.components.labels._MaterialLabel;
import com.jhw.swing.personalization.PersonalizationMaterial;

/**
 * Label con foreground getColorMoneyNegative de la personalizacion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _labelNegativo extends _MaterialLabel {

    public _labelNegativo() {
        super();
        this.setForeground(PersonalizationMaterial.getInstance().getColorMoneyNegative());
    }

}
