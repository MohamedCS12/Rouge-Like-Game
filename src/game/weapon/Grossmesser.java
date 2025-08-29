package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.PickUpAction;
import edu.monash.fit2099.engine.items.PickUpWeaponAction;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AttackSurroundingsAction;

public class Grossmesser extends WeaponItem{

    /**
     * Constructor.
     *
     * @param name        name of the item
     * @param displayChar character to use for display when item is on the ground
     * @param damage      amount of damage this weapon does
     * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
     * @param hitRate     the probability/chance to hit the target.
     */
    public Grossmesser(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }
    public int getBuyWeaponPrice(){
        int buyPrice = 100;
        return buyPrice;}

    //attempt at the wide area attack ability by grossmesser
    public Action getSkill(Actor target, String direction){
        return new AttackSurroundingsAction(target);
    }
    /**
     * Create and return an action to pick this WeaponItem up.
     * If this WeaponItem is not portable, returns null.
     *
     * @return a new PickUpWeaponAction if this Item is portable, null otherwise.
     */
    @Override
    public PickUpAction getPickUpAction(Actor actor) {
        if (portable)
            return new PickUpWeaponAction(this);
        return null;
    }
}

