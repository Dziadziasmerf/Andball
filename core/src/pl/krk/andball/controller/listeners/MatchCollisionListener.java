package pl.krk.andball.controller.listeners;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.*;
import pl.krk.andball.model.Ball;
import pl.krk.andball.model.Goal;
import pl.krk.andball.model.Player;

public class MatchCollisionListener implements ContactListener {

    @Override
    public void beginContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if (fixtureA.getUserData() instanceof Ball && fixtureB.getUserData() instanceof Player) {
            ((Player) fixtureB.getUserData()).setTouchingBall(true);

        } else if (fixtureB.getUserData() instanceof Ball && fixtureA.getUserData() instanceof Player) {
            ((Player) fixtureA.getUserData()).setTouchingBall(true);
        } else if (fixtureA.getUserData() instanceof Ball && fixtureB.getUserData() instanceof Goal) {
            ((Goal) fixtureB.getUserData()).setGoal(true);
            Gdx.app.debug("GOOOOOAL","");
        } else if (fixtureB.getUserData() instanceof Ball && fixtureA.getUserData() instanceof Goal) {
            ((Goal) fixtureA.getUserData()).setGoal(true);
            Gdx.app.debug("GOOOOOAL","");
        }
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fixtureA = contact.getFixtureA();
        Fixture fixtureB = contact.getFixtureB();

        if (fixtureA.getUserData() instanceof Ball && fixtureB.getUserData() instanceof Player) {
            ((Player) fixtureB.getUserData()).setTouchingBall(false);
        } else if (fixtureB.getUserData() instanceof Ball && fixtureA.getUserData() instanceof Player) {
            ((Player) fixtureA.getUserData()).setTouchingBall(false);
        }

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
