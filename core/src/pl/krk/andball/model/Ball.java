package pl.krk.andball.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import pl.krk.andball.AndBallGame;

public class Ball extends Sprite {

    public Body b2body;

    public Ball(World world) {
        super(new Texture("soccerBall.png"));

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(960 / AndBallGame.PPM, 540 / AndBallGame.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(25 / AndBallGame.PPM);

        fixtureDef.shape = circleShape;
        b2body.createFixture(fixtureDef).setUserData(this);
        b2body.setLinearDamping(0.4f);


        setBounds(0, 0, 50 / AndBallGame.PPM, 50 / AndBallGame.PPM);
    }

    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getWidth() / 2);
    }

    public void resetPosition() {
        b2body.setTransform(960 / AndBallGame.PPM, 540 / AndBallGame.PPM, b2body.getAngle());
    }
}
