package imperium.engine.core.state

import imperium.engine.ui.control.AbstractControl
import imperium.engine.ui.control.menu.MenuControlFactory
import org.newdawn.slick._
import org.newdawn.slick.geom.Point
import org.newdawn.slick.state.StateBasedGame

/*
 * Created by DelavaR on 06.11.2014.
 */
object SimpleMenuState {
  val ID: Int = 1
}

class SimpleMenuState(val screenWidth: Int, val screenHeight: Int) extends BasicState {

  private var game: StateBasedGame = null

  /**
   * @see org.newdawn.slick.state.BasicGameState#getID()
   */
  override def getID: Int = SimpleMenuState.ID

  override def init(container: GameContainer, game: StateBasedGame) {
    this.game = game
    MenuControlFactory.createStartMenu().foreach(addControll(_))
  }

  override def update(container: GameContainer, game: StateBasedGame, delta: Int) {

  }

  override def render(container: GameContainer, game: StateBasedGame, g: Graphics) {
    g.drawImage(new Image("menu/Imperium_splash_1024_800.png"), 0, 0)
    getControls.foreach(_.render())
  }

  override def mouseMoved(oldx: Int, oldy: Int, newx: Int, newy: Int): Unit = {
    getControls.foreach { c: AbstractControl =>
      if (c.area.includes(new Point(newx, newy))) c.onHoverActivated() else c.onHoverDeactivated()
    }
  }

  override def mouseClicked(button: Int, x: Int, y: Int, clickCount: Int): Unit = {
    getControls.foreach { c: AbstractControl =>
      if (c.area.includes(new Point(x, y))) c.action(game)
    }
  }

}
