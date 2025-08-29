package game.behavior;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.action.AttackAction;

public class AttackBehaviour implements Behaviour{

    private final Actor target;

    /**
     * Constructor.
     *
     * @param subject the Actor to follow
     */
    public AttackBehaviour(Actor subject) {
        this.target = subject;
    }

    @Override
    public Action getAction(Actor actor, GameMap map) {
        if (!map.contains(target) || !map.contains(actor))
            return null;

        // get the location of the actor and target
        Location here = map.locationOf(actor);
        Location there = map.locationOf(target);

        int differenceX = here.x() - there.x();
        int differenceY = here.y() - there.y();

        String direction=null;
        if (differenceX > 0 && differenceY == 0) {
            direction = "west";
        } else if (differenceX < 0 && differenceY == 0) {
            direction = "east";
        } else if (differenceX == 0 && differenceY > 0) {
            direction = "north";
        } else if (differenceX == 0 && differenceY < 0) {
            direction = "south";
        } else if (differenceX > 0 && differenceY > 0) {
            direction = "northwest";
          //differenceY < 0 is removed as it is always true
        } else if (differenceX > 0) {
            direction = "southwest";
        } else if (differenceX < 0 && differenceY > 0) {
            direction = "northeast";
            //differenceY < 0 is removed as it is always true
        } else if (differenceX < 0) {
            direction = "southeast";
        }
            if (distance(here, there) == 1) {
                return new AttackAction(target,direction);
            }
            return null;
    }
    private int distance(Location a, Location b) {
        return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
    }
}
