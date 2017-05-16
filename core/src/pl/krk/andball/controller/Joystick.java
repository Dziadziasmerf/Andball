package pl.krk.andball.controller;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Joystick extends Touchpad {

    public Joystick(float deadzoneRadius, TouchpadStyle style) {
        super(deadzoneRadius, style);
    }

    public static Joystick getJoystic() {
        Skin touchpadSkin = new Skin();
        touchpadSkin.add("touchKnob", new Texture("touchKnob.png"));
        TouchpadStyle touchpadStyle = new TouchpadStyle();
        touchpadStyle.knob = touchpadSkin.getDrawable("touchKnob");


        Pixmap background = new Pixmap(200, 200, Pixmap.Format.RGBA8888);
        background.setBlending(Pixmap.Blending.None);
        background.setColor(1, 1, 1, .6f);
        background.fillCircle(100, 100, 100);
        touchpadStyle.background = new TextureRegionDrawable(new TextureRegion(new Texture(background)));

        Joystick joystick = new Joystick(10, touchpadStyle);
        joystick.setBounds(15, 15, 200, 200);

        return joystick;
    }
}
