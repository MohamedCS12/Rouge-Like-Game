package game.environment;
import edu.monash.fit2099.engine.positions.Location;
import java.util.Random;
import game.enemy.west.HeavySkeletalSwordsman;

/**
 * A class representing a Graveyard environment that can spawn a HeavySkeletalSwordsman actor.
 */
public class GraveYard extends Environment {
    private Random random = new Random();

    /**
     * Constructor for the Graveyard class.
     */
    public GraveYard() {
        super('n');
    }

    /**
     * Performs the environment-specific actions during each tick.
     *
     * @param location the Location of the Graveyard
     */
    @Override
    public void tick(Location location) {
        // There is a 27% chance of spawning a HeavySkeletalSwordsman in the Graveyard
        if (random.nextDouble() <= 0.27 && !location.containsAnActor()) {
            //req 5 need an if statement to check if the location of the graveyard is in the west or east
            location.addActor(new HeavySkeletalSwordsman());
        }
    }
}
