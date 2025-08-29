package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.Random;

public class DespawnAction extends Action{

    private Actor target;

    /**
     * Random number generator
     */
    private Random rand = new Random();

    public DespawnAction(Actor target) {
        this.target = target;
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        if (rand.nextDouble() <= 0.1) {
            //req 5 Check if the location of the GustOfWind is in the west or east, and add the appropriate actor
            map.removeActor(actor);
            return menuDescription(actor);
        }
        return null;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */

    @Override
    public String menuDescription(Actor actor) {
        return actor + "has been despawned from map";
    }
}