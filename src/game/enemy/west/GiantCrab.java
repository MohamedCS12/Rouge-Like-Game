package game.enemy.west;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.action.AttackAction;
import game.action.DespawnAction;
import game.actor.Enemy;
import game.behavior.Behaviour;
import game.Status;
/**
 * A Giant Crab. It's big, it's tough, and slams other creatures.
 */
public class GiantCrab extends Enemy {

    public GiantCrab() {

        super("Giant Crab", 'C', 407);
        addCapability(Status.FRIENDLY_TO_GIANTCRAB);
    }

    /**
     * The GiantCrab can be attacked by any actor that has the HOSTILE_TO_ENEMY capability.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return an ActionList containing an AttackAction if the otherActor has HOSTILE_TO_ENEMY capability, or an empty
     * ActionList otherwise.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        } else if (!otherActor.hasCapability(Status.FRIENDLY_TO_GIANTCRAB)) {
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }

    /**
     * Return the intrinsic weapon of the GiantCrab, which can inflict 20 damage per hit.
     *
     * @return an IntrinsicWeapon with 20 base damage and "claws" as its verb.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}
