package game.environment;

import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;
import game.enemy.west.LoneWolf;

/**
 * A class representing a Gust of Wind environment that can spawn a LoneWolf actor.
 */
public class GustOfWind extends Environment {
    private Random random = new Random();

    /**
     * Constructor for the GustOfWind class.
     */
    public GustOfWind() {
        super('&');
    }

    /**
     * Performs the environment-specific actions during each tick.
     *
     * @param location the Location of the GustOfWind
     */
    @Override
    public void tick(Location location) {
        // There is a 33% chance of spawning a LoneWolf in the GustOfWind
        if (random.nextDouble() <= 0.33 && !location.containsAnActor()) {
            //req 5 Check if the location of the GustOfWind is in the west or east, and add the appropriate actor
            location.addActor(new LoneWolf());
        }
    }
}
