package game.enemy;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.displays.Display;
import game.action.AttackAction;
import game.action.DespawnAction;
import game.actor.Enemy;
import game.Status;
import game.enemy.east.GiantDog;
import game.enemy.west.LoneWolf;
import game.utils.RandomNumberGenerator;

import java.util.Random;

/**
 * A hostile creature that represents a dog.
 */
public class Dog extends Enemy {

    private static final int HIT_POINTS = 104;
    private static final int DAMAGE = 101;
    private static final int ACCURACY = 93;
    private static final int RUNES_MIN = 52;
    private static final int RUNES_MAX = 1390;
    private static final double DESPAWN_CHANCE = 0.1;
    private final Random random = new Random();

    public Dog() {
        super("Dog", 'a', HIT_POINTS);
    }

    /**
     * The dog can be attacked by any actor that has the HOSTILE_TO_ENEMY capability,
     * except for Godrick soldiers. It will also attack Giant Dogs and Lone Wolves if they enter the castle.
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

        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY) && !otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        } else if (otherActor instanceof GiantDog || otherActor instanceof LoneWolf) {
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }

    /**
     * Generates a random number of runes between the specified range when defeated by the player.
     * This is Done using the RandomNumberGenerator class, getRandomInt method
     * @return the number of runes generated (integer)
     */
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(RUNES_MIN, RUNES_MAX);
    }

    /**
     * At each turn, there is a 10% chance of the dog being despawned (removed from the map),
     * unless it is following the player.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public DespawnAction playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        if (!hasCapability(Status.HOSTILE_TO_ENEMY) && random.nextDouble() <= DESPAWN_CHANCE) {
            return new DespawnAction(this);
        }
        return (DespawnAction) super.playTurn(actions, lastAction, map, display);
    }

    /**
     * Return the intrinsic weapon of the dog, which can inflict damage with a specific accuracy.
     *
     * @return an IntrinsicWeapon with the specified base damage, "bites" as its verb
     */
     @Override
     public IntrinsicWeapon getIntrinsicWeapon() {
         return new IntrinsicWeapon(DAMAGE, "bites", ACCURACY);
     }
}