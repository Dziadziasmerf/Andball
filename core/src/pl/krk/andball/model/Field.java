package pl.krk.andball.model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import pl.krk.andball.AndBallGame;

public class Field {

    private World world;
    public Field(World world) {
        this.world = world;
        createFieldBody();
    }

    private void createFieldBody() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(16/ AndBallGame.PPM,16/AndBallGame.PPM);
        bodyDef.type = BodyDef.BodyType.StaticBody;
        Body body = world.createBody(bodyDef);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.restitution = 0.5f;

        Vector2[] points = new Vector2[13];
        points[0] = new Vector2(20/AndBallGame.PPM, 20/AndBallGame.PPM);
        points[1] = new Vector2(20/AndBallGame.PPM, 475/AndBallGame.PPM);
        points[2] = new Vector2(0/AndBallGame.PPM, 475/AndBallGame.PPM);
        points[3] = new Vector2(0/AndBallGame.PPM, 620/AndBallGame.PPM);
        points[4] = new Vector2(20/AndBallGame.PPM, 620/AndBallGame.PPM);
        points[5] = new Vector2(20/AndBallGame.PPM, 1060/AndBallGame.PPM);
        points[6] = new Vector2(1900/AndBallGame.PPM, 1060/AndBallGame.PPM);
        points[7] = new Vector2(1900/AndBallGame.PPM, 620/AndBallGame.PPM);
        points[8] = new Vector2(1920/AndBallGame.PPM, 620/AndBallGame.PPM);
        points[9] = new Vector2(1920/AndBallGame.PPM, 475/AndBallGame.PPM);
        points[10] = new Vector2(1900/AndBallGame.PPM, 475/AndBallGame.PPM);
        points[11] = new Vector2(1900/AndBallGame.PPM, 20/AndBallGame.PPM);
        points[12] = new Vector2(20/AndBallGame.PPM,20/AndBallGame.PPM);

        ChainShape chainShape = new ChainShape();
        chainShape.createChain(points);

        fixtureDef.shape = chainShape;
        body.createFixture(fixtureDef);
    }

}
