package com.erfeck.principal;

import com.erfeck.gui.controllers.ControladorPrincipal;
import com.erfeck.gui.models.ModeloPrincipal;
import com.formdev.flatlaf.FlatLightLaf;

public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        //FlatDarkLaf.setup();
        ModeloPrincipal modeloPrincipal = new ModeloPrincipal();
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(modeloPrincipal);
    }
   
}