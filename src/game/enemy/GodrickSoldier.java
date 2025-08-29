package game.enemy;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.action.AttackAction;
import game.action.DespawnAction;
import game.actor.Enemy;
import game.enemy.east.GiantDog;
import game.enemy.west.LoneWolf;
import game.utils.RandomNumberGenerator;

import java.util.Random;

public class GodrickSoldier extends Enemy {

    private static final int HIT_POINTS = 198;
    private static final int RUNES_MIN = 38;
    private static final int RUNES_MAX = 70;
    private static final double DESPAWN_CHANCE = 0.1;

    private final Random random = new Random();

    public GodrickSoldier() {
        super("Godrick Soldier", 'p', HIT_POINTS);
    }

    /**
     * At each turn, there is a 10% chance of the Godrick soldier being despawned (removed from the map),
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
     * Generates a random number of runes between the specified range when defeated by the player.
     * This is done using the RandomNumberGenerator class, getRandomInt method.
     *
     * @return the number of runes generated (integer)
     */
    public int generateRunes() {
        return RandomNumberGenerator.getRandomInt(RUNES_MIN, RUNES_MAX);
    }

    /**
     * The Godrick soldier can attack Giant Dogs and Lone Wolves if they enter the castle.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return an ActionList containing an AttackAction if the otherActor is a GiantDog or LoneWolf, or an empty
     * ActionList otherwise.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();

        if (otherActor instanceof GiantDog || otherActor instanceof LoneWolf) {
            actions.add(new AttackAction(this, direction));
        }

        return actions;
    }
}
