package net.osgg.observer;

import java.util.*;

public class HeatIndexDisplay implements Observer, DisplayElement {
    private WeatherData weatherData;
    private double heatIndexC;

    public HeatIndexDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float T, float RH, float pressure) {
        
        // Convertir la temperatura de Celsius a Fahrenheit
        double T_F = T;

        // Coeficientes de la fórmula
        double c1 = 16.923;
        double c2 = 0.185212;
        double c3 = 5.37941;
        double c4 = -0.100254;
        double c5 = 0.00941695;
        double c6 = 0.00728898;
        double c7 = 0.000345372;
        double c8 = -0.000814971;
        double c9 = 0.0000102102;
        double c10 = -0.000038646;
        double c11 = 0.0000291583;
        double c12 = 0.00000142721;
        double c13 = 0.000000197483;
        double c14 = -0.0000000218429;
        double c15 = 0.000000000843296;
        double c16 = -0.0000000000481975;

        // Fórmula del índice de calor
        heatIndexC = c1 
                            + (c2 * T_F) 
                            + (c3 * RH) 
                            + (c4 * T_F * RH) 
                            + (c5 * T_F * T_F) 
                            + (c6 * RH * RH) 
                            + (c7 * T_F * T_F * RH) 
                            + (c8 * T_F * RH * RH) 
                            + (c9 * T_F * T_F * RH * RH) 
                            + (c10 * T_F * T_F * T_F) 
                            + (c11 * RH * RH * RH) 
                            + (c12 * T_F * T_F * T_F * RH) 
                            + (c13 * T_F * RH * RH * RH) 
                            + (c14 * T_F * T_F * T_F * RH * RH) 
                            + (c15 * T_F * T_F * RH * RH * RH) 
                            + (c16 * T_F * T_F * T_F * RH * RH * RH);



        display();
    }

    public void display() {
        System.out.print("Heat index is: " + heatIndexC + "\n");
    }
}
