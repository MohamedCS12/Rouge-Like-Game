package game.enemy.west;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.action.AttackAction;
import game.Status;
import game.actor.Enemy;

/**
 * A hostile creature that carries around a weapon called Grossmesser.
 * It can become a "Pile of Bones" for three (3) turns if killed by other enemies or the player.
 * If the Pile of Bones is not hit within the three turns, the Heavy Skeletal Swordsman will be revived with full health.
 */
public class HeavySkeletalSwordsman extends Enemy {

    //??? private int pileOfBonesTurnsLeft = 0;

    public HeavySkeletalSwordsman() {

        super("Heavy Skeletal Swordsman", 'q', 153);
        addCapability(Status.FRIENDLY_TO_HEAVYSKELETALSWORDSMAN);
    }
    /**
     * The Heavy Skeletal Swordsman can be attacked by any actor that has the HOSTILE_TO_ENEMY capability
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return ActionList containing AttackAction if otherActor has HOSTILE_TO_ENEMY capability, else empty ActionList
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        } else if (!otherActor.hasCapability(Status.FRIENDLY_TO_HEAVYSKELETALSWORDSMAN)) {
        actions.add(new AttackAction(this, direction));
    }
        return actions;
    }

    //there is no intrinsic weapon for Heavy Skeletal Swordsman. It uses Grossmesser instead.
}
