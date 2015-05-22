package br.com.alexandrealessi.gdx.fox.refactoring.animation;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ArrayMap;

/**
 * Created by alexandre on 20/05/15.
 */
public class AnimatedCharacter {

    private ArrayMap<String, Animation> animations;
    private float time;
    private Animation currentAnimation;

    public AnimatedCharacter(FileHandle file) {
    }

    public void update(float deltaTime) {

    }

    public TextureAtlas.AtlasRegion getCurrentFrame() {
        return null;
    }

    public Animation getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(Animation currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public void setPlaybackScale(float scale) {

    }

    public void stop() {

    }

    public void pause() {

    }

    public void play() {

    }

}
