package imperium.engine.core.state

import imperium.engine.core.position.Area
import imperium.engine.ui.control.{AbstractControl, MenuControl}
import imperium.engine.ui.model.DataModel
import org.lwjgl.util.Point
import org.newdawn.slick._
import org.newdawn.slick.state.StateBasedGame
import org.newdawn.slick.state.transition.{FadeInTransition, FadeOutTransition}

import scala.collection.mutable

/*
 * Created by DelavaR on 06.11.2014.
 */
object SimpleMenuState {
  val ID: Int = 1
  val MENU_Y_MARGIN = 320
}

class SimpleMenuState(val screenWidth: Int, val screenHeight: Int) extends BasicState {

  private var game: StateBasedGame = null

  /**
   * @see org.newdawn.slick.state.BasicGameState#getID()
   */
  override def getID: Int = SimpleMenuState.ID

  override def init(container: GameContainer, game: StateBasedGame) {
    this.game = game

    val newGameImage = new Image("menu/new_game.png")
    val newGamePoint = new Point(screenWidth / 2 - newGameImage.getWidth / 2, SimpleMenuState.MENU_Y_MARGIN)
    val newGamePointModel = new DataModel(newGameImage, new Image("menu/new_game_selected.png"))
    val newGameControl = new MenuControl(new Area(newGamePoint, newGameImage.getWidth, newGameImage.getHeight), newGamePointModel,
      () => game.enterState(GameMapState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black)))
    val newGameAction = () => game.enterState(GameMapState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black))
    addControll(newGameControl)

    val loadGameImage = new Image("menu/load_game.png")
    val loadGamePoint = new Point(screenWidth / 2 - loadGameImage.getWidth / 2, SimpleMenuState.MENU_Y_MARGIN + 100)
    val loadGamePointModel = new DataModel(loadGameImage, new Image("menu/load_game_selected.png"))
    val loadGameControl = new MenuControl(new Area(loadGamePoint, loadGameImage.getWidth, loadGameImage.getHeight), loadGamePointModel)
    addControll(loadGameControl)

    val exitImage = new Image("menu/exit.png")
    val exitPoint = new Point(screenWidth / 2 - exitImage.getWidth / 2, SimpleMenuState.MENU_Y_MARGIN + 250)
    val exitPointModel = new DataModel(exitImage, new Image("menu/exit_selected.png"))
    val exitControl = new MenuControl(new Area(exitPoint, exitImage.getWidth, exitImage.getHeight), exitPointModel, () => System.exit(0))
    addControll(exitControl)
  }

  override def update(container: GameContainer, game: StateBasedGame, delta: Int) {

  }

  override def render(container: GameContainer, game: StateBasedGame, g: Graphics) {
    g.drawImage(new Image("menu/Imperium_splash_1024_800.png"), 0, 0)

    getControls.foreach { c: AbstractControl =>
      c.render()
    }
  }

  override def mouseMoved(oldx: Int, oldy: Int, newx: Int, newy: Int): Unit = {
    getControls.foreach { c: AbstractControl =>
      if (c.area.includes(new Point(newx, newy))) c.onHoverActivated() else c.onHoverDeactivated()
    }
  }

  override def mouseClicked(button: Int, x: Int, y: Int, clickCount: Int): Unit = {
    getControls.foreach { c: AbstractControl =>
      if (c.area.includes(new Point(x, y))) c.action()
    }
  }

  /**
   * @see org.newdawn.slick.state.BasicGameState#keyReleased(int, char)
   */
  /*override def keyReleased(key: Int, c: Char) {
    key match {
      case Input.KEY_DOWN =>
        selected += 1
        if (selected >= OPTIONS.length) selected = 0
      case Input.KEY_UP =>
        selected -= 1
        if (selected < 0) selected = OPTIONS.length - 1
      case Input.KEY_ENTER =>
        if (selected == 0) game.enterState(GameMapState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black))
      case _ =>
    }
  }

  lazy val menuRectWidth = OPTIONS.reduceLeft((x: String, y: String) => {
    val xWidth: Int = font.getWidth(x)
    val yWidth: Int = font.getWidth(y)
    if (yWidth > xWidth) y else x
  })*/

}
