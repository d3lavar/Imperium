package imperium.engine.core.game

import imperium.engine.core.state.{GameMapState, SimpleMenuState}
import org.newdawn.slick._
import org.newdawn.slick.state.StateBasedGame
import org.newdawn.slick.state.transition.{FadeInTransition, FadeOutTransition}

class SimpleGame extends StateBasedGame("Title") {

  override def initStatesList(container: GameContainer): Unit = {
    this.addState(new SimpleMenuState(getContainer.getWidth, getContainer.getHeight))
    this.addState(GameMapState(getContainer.getWidth, getContainer.getHeight, Consts.MAP_PATH.getValue))
  }

  override def keyReleased(key: Int, c: Char) {
    getCurrentState keyReleased(key, c)
  }

  def enterMainMenu() {
    this.enterState(SimpleMenuState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black))
  }

  override def mouseMoved(oldx: Int, oldy: Int, newx: Int, newy: Int): Unit = {
    getCurrentState mouseMoved(oldx, oldy, newx, newy)
  }
}