/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.swing.material.effects;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface ElevationEffect {

    public ElevationEffect getElevationEffect();

    public void setElevationEffect(ElevationEffect elevation);

    /**
     * Method to override to change the different elevations
     *
     * @return
     */
    public double getLevel();
}
