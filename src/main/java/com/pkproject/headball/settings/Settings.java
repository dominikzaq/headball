package com.pkproject.headball.settings;

/*
 * nie wiem czy tu bedziemy cos dawac czy nie :)
 */
public class Settings {
    public static final int FRAMEHEIGHT = 600;
    public static final int FRAMEWIDTH = 1200;

    public static final int POSITIONPLAYER1X = SettingsFrame.GOALWIDTHRECTANGLE * 2 ;
    public static final int POSITIONPLAYER1Y =  FRAMEHEIGHT / 2;


    public static final int POSITIONPLAYER2X = FRAMEWIDTH - SettingsFrame.GOALWIDTHRECTANGLE * 2 ;
    public static final int POSITIONPLAYER2Y = FRAMEHEIGHT / 2;


    public static final int VECOLITYPLAYERX = 40;
    public static final int VECOLITYPLAYERY = 60;

    public static final int POSITIONBALLX = FRAMEWIDTH / 2;
    public static final int POSITIONBALLY = FRAMEHEIGHT / 2;

    public static final int VECOLITYBALLX = 20;
    public static final int VECOLITYBALLY = 20;


    public static final int HITPOWERBALL = 100;
}
