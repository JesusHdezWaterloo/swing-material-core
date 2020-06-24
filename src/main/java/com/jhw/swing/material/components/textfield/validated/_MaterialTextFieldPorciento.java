package com.jhw.swing.material.components.textfield.validated;

import com.jhw.swing.material.components.textfield._MaterialTextField;
import com.jhw.swing.util.enums.TextTypeEnum;
import com.jhw.swing.util.validations.textfield.GreaterThatCeroValidation;
import com.jhw.swing.util.validations.textfield.NotEmptyValidation;
import com.jhw.swing.util.validations.textfield.RangeValidation;

/**
 *
 * @author Jesús Hernández Barrios (jhernandezb96@gmail.com)
 */
public class _MaterialTextFieldPorciento extends _MaterialTextField {

    public _MaterialTextFieldPorciento() {
        super();
        this.setType(TextTypeEnum.FLOAT);
        this.setExtra("%");
        addValidations();
    }

    @Override
    public void setHint(String label) {
        super.setHint(label);
        addValidations();
    }

    private void addValidations() {
        String initial = "El valor de " + getHint().toLowerCase() + "\n";
        this.addPreValidation(new NotEmptyValidation(NotEmptyValidation.WRONG_TEXT, initial + "no pueder estar en blanco."));
        this.addPostValidation(new RangeValidation(0f, 100f, GreaterThatCeroValidation.WRONG_TEXT, initial + "tiene que estar entre 0 y 100, incluyéndolos."));
    }
}