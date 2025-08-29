package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.Consumable;

/**
 * Action that allows an actor to consume a consumable item.
 */
public class ConsumeAction extends Action implements Consumable {
    private final Item item;

    public ConsumeAction(Item item) {
        this.item = item;
    }

    @Override
    public String execute(Actor actor, GameMap map) {

        // Remove the item from the actor's inventory
        actor.removeItemFromInventory(item);
        return menuDescription(actor);
    }

    @Override
    public String menuDescription(Actor actor) {
        return item + " has been consumed";
    }
}
