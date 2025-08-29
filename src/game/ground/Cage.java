package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.enemy.Dog;

/**
 * A class that represents a cage in the game.
 * Created by: Mohamed Alaa
 */
public class Cage extends Ground {

    private static final double SPAWN_CHANCE = 0.37;

    /**
     * Constructor.
     */
    public Cage() {
        super('<');
    }

    /**
     * Spawns a dog with a 37% chance at each turn.
     *
     * @param location the location of the cage
     */
    @Override
    public void tick(Location location) {
        if (Math.random() <= SPAWN_CHANCE) {
            Actor dog = new Dog();
            location.addActor(dog);
        }
    }
}
