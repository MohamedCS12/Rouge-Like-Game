package game.ground;

import edu.monash.fit2099.engine.positions.Ground;
import game.action.RestAction;
import edu.monash.fit2099.engine.actors.Actor;


/**
 * A class that represents the Site of Lost Grace in the game of Elden Ring.
 * Created by: Mohamed Alaa
 */
public class LostGrace extends Ground {

    /**
     *Constructor.
     */
     public LostGrace() {
         super('U');
     }

     /**
      * Allows an actor to rest on the Site of Lost Grace. Resting triggers a game reset.
      *
      * @param actor the actor resting on the ground
      * @return a RestAction to reset the game
      */
     public RestAction allowableAction(Actor actor) {
         return new RestAction();
     }
}
