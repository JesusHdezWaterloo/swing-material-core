package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.enums.TextTypeEnum;
import com.jhw.swing.util.validations.textfield.GreaterThatCeroValidation;
import com.jhw.swing.util.validations.textfield.NotEmptyValidation;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldFloatPositive extends _MaterialTextField {

    public _MaterialTextFieldFloatPositive() {
        super();
        this.setType(TextTypeEnum.FLOAT);
        addValidations();
    }

    @Override
    public void setHint(String label) {
        super.setHint(label);
        addValidations();
    }

    private void addValidations() {
        String initial = "El valor de " + getHint().toLowerCase() + "\n";
//        this.addPreValidation(new NotEmptyValidation(NotEmptyValidation.WRONG_TEXT, initial + "no pueder estar en blanco."));//TODO: textField
//        this.addPostValidation(new GreaterThatCeroValidation(GreaterThatCeroValidation.WRONG_TEXT, initial + "tiene que ser mayor que cero."));//TODO: textField
    }
}
