package game.actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Status;
import game.behavior.WanderBehaviour;
import game.behavior.Behaviour;
import java.util.Map;
import java.util.TreeMap;

/**
 * An abstract class that represents an enemy in the game, inheriting from the Actor class.
 */
public abstract class Enemy extends Actor {
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor for the Enemies class.
     * @param name The name of the enemy.
     * @param displayChar The character that will be displayed on the terminal/console for this enemy.
     * @param hitPoints The enemy's starting hit points.
     */
    public Enemy(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(999, new WanderBehaviour());
        addCapability(Status.HOSTILE_TO_PLAYER);
    }

    public Map<Integer, Behaviour> getBehaviours() {
        return behaviours;
    }
    public void setBehaviours(Map<Integer, Behaviour> behaviours) {
        this.behaviours = behaviours;
    }

    /**
     * At each turn, select a valid action to perform.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn. Can do interesting things in conjunction with Action.getNextAction()
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : getBehaviours().values()) {
            Action action = behaviour.getAction(this, map);
            if(action != null)
                return action;
        }
        return new DoNothingAction();
    }
    /**
     * Returns a new collection of the Actions that the otherActor can do to the current Actor.
     *
     * @param otherActor the Actor that might be performing attack
     * @param direction  String representing the direction of the other Actor
     * @param map        current GameMap
     * @return A collection of Actions.
     */
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        return new ActionList();
    }

}
