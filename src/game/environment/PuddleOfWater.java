package game.environment;

import edu.monash.fit2099.engine.positions.Location;

import java.util.Random;

/**
 * A class representing a Puddle of Water environment that can spawn a GiantCrab actor.
 */
public class PuddleOfWater extends Environment {
    private Random random = new Random();

    /**
     * Constructor for the PuddleOfWater class.
     */
    public PuddleOfWater() {
        super('~');
    }

    /**
     * Performs the environment-specific actions during each tick.
     *
     * @param location the Location of the PuddleOfWater
     */
    @Override
    public void tick(Location location) {
        // There is a 2% chance of spawning a GiantCrab in the PuddleOfWater
        if (random.nextDouble() <= 0.02 && !location.containsAnActor()) {
            // req 5 Check if the location of the PuddleOfWater is in the west or east, and add the appropriate actor
            //location.addActor(new Trader());
        }
    }
}