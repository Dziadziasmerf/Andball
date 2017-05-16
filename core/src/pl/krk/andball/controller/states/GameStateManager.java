package pl.krk.andball.controller.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {

    private Stack<State> stateStack;

    public GameStateManager() {
        stateStack = new Stack<State>();
    }

    public void push(State state) {
        stateStack.push(state);
    }

    public void pop() {
        stateStack.pop();
    }

    public void set(State state) {
        stateStack.pop();
        stateStack.push(state);
    }

    public void update(float dt) {
        stateStack.peek().update(dt);
    }

    public void render(SpriteBatch spriteBatch) {
        stateStack.peek().render(spriteBatch);
    }
}
