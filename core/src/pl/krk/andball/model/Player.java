package pl.krk.andball.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import pl.krk.andball.AndBallGame;

public class Player extends Sprite {

    public Body b2body;
    private boolean isTouchingBall = false;


    public Player(World world) {
        super(new Texture("player.png"));

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(500 / AndBallGame.PPM, 540 / AndBallGame.PPM);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.restitution = 0.1f;

        CircleShape circleShape = new CircleShape();
        circleShape.setRadius(40 / AndBallGame.PPM);

        fixtureDef.shape = circleShape;
        b2body.createFixture(fixtureDef).setUserData(this);
        b2body.setLinearDamping(1.25f);

        setBounds(0, 0, 80 / AndBallGame.PPM, 80 / AndBallGame.PPM);

    }

    public void update(float dt) {
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getWidth() / 2);
    }

    public void resetPosition() {
        b2body.setTransform(500 / AndBallGame.PPM, 540 / AndBallGame.PPM, b2body.getAngle());
    }

    public boolean isTouchingBall() {
        return isTouchingBall;
    }

    public void setTouchingBall(boolean touchingBall) {
        isTouchingBall = touchingBall;
    }

}

