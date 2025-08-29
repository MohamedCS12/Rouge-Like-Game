package game.ground;

import edu.monash.fit2099.engine.actors.Actor;
import game.enemy.GodrickSoldier;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents a Barrack ground in the game.
 * Created by: Mohamed Alaa
 */
public class Barrack extends Ground {

    private static final double SPAWN_CHANCE = 0.45;

    /**
     * Constructor.
     */
    public Barrack() {
        super('B');
    }

    /**
     * Spawns a Godrick Soldier with a 45% chance at each turn.
     *
     * @param location the location of the Barrack ground
     */
    @Override
    public void tick(Location location) {
        if (Math.random() <= SPAWN_CHANCE) {
            Actor godrickSoldier = new GodrickSoldier();
            location.addActor(godrickSoldier);
        }
    }
}
