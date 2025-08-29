package game.environment;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Abstract class representing an environment.
 * Inherits from the Ground class.
 */
public abstract class Environment extends Ground {

    public Environment(char displayChar) {
        super(displayChar);
    }

    /**
     * Override this method to implement environment-specific actions during the tick.
     *
     * @param location the Location of the environment
     */
    public abstract void tick(Location location);
}