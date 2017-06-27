package com.example.raaj.acs;


/**
 * Created by Raaj on 1/28/2016.
 */
public class Color_Holder {
    String Color_Code;
    String hexadecimal_color;
    int hex_color;
    String rgb_color;

    Color_Holder(String name, String hexadecimal_color, int hex_color, String rgb_color) {
        this.Color_Code = name;
        this.hexadecimal_color = hexadecimal_color;
        this.hex_color = hex_color;
        this.rgb_color = rgb_color;
    }
}
