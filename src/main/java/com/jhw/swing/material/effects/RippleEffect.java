/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.effects;

import java.awt.Color;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RippleEffect {

    public RippleEffect getRippleEffect();

    public void setRippleEffect(RippleEffect ripple);

    public Color getRippleColor();

    public void setRippleColor(Color color);
}
