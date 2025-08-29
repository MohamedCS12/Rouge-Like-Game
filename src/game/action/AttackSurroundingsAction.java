package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.WeaponItem;

import java.util.List;

/**
 * An Action to attack all surrounding Actors.
 */
public class AttackSurroundingsAction extends Action {

    private final Actor actor;

    /**
     * Constructor.
     *
     * @param actor the Actor performing the attack
     */
    public AttackSurroundingsAction(Actor actor) {
        this.actor = actor;
    }

    /**
     * Executes the action by attacking all surrounding actors.
     *
     * @param actor The actor performing the attack action.
     * @param map   The map the actor is on.
     * @return the result of the attack action for each target.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        List<Exit> exits = map.locationOf(actor).getExits();
        for (Exit exit : exits) {
            Location destination = exit.getDestination();
            if (!destination.containsAnActor())
                continue;
            Actor target = destination.getActor();
            if (target.isConscious()) {
                WeaponItem weapon = (WeaponItem) actor.getWeaponInventory();
                if (weapon != null) {
                    int damage = weapon.damage();
                    target.hurt(damage);
                }
            }
        }
        return menuDescription(actor);
    }

    /**
     * Describes the action of attacking all surrounding actors.
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks all surrounding actors";
    }
}
