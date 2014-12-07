package imperium.engine.ui.control.menu

import imperium.engine.core.position.{HorizontalAlignment, AreaPositioner, Area}
import imperium.engine.core.state.GameMapState
import imperium.engine.ui.model.DataModel
import org.lwjgl.opengl.Display
import org.newdawn.slick.state.StateBasedGame
import org.newdawn.slick.{Color, Image}
import org.newdawn.slick.state.transition.{FadeInTransition, FadeOutTransition}

/*
 * Created by DelavaR on 09.11.2014.
 */
object MenuControlFactory {

  val MENU_ELEMENTS_X_MARGIN = 280
  val MENU_ELEMENTS_Y_MARGIN = 320
  val MENU_ELEMENTS_WIDTH = 464
  val MENU_ELEMENTS_HEIGHT = 95

  private val screenWidth: Int = Display.getWidth
  private val screenHeight: Int = Display.getHeight

  def createStartMenu(): Seq[MenuControl] = {
    Seq(createNewGameMenu(0), createLoadGameMenu(150), createExitGameMenu(300))
  }

  private def createNewGameMenu(offset: Int): MenuControl = {
    val image = new Image("menu/new_game.png")
    val imageActive = new Image("menu/new_game_selected.png")
    val area = createMenuElementArea(offset, image.getWidth, image.getHeight)
    val action = (game: StateBasedGame) => game.enterState(GameMapState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black))

    MenuControl(area, DataModel(imageActive, image), action)
  }

  private def createLoadGameMenu(offset: Int): MenuControl = {
    val image = new Image("menu/load_game.png")
    val imageActive = new Image("menu/load_game_selected.png")
    val area = createMenuElementArea(offset, image.getWidth, image.getHeight)

    MenuControl(area, DataModel(imageActive, image))
  }

  private def createExitGameMenu(offset: Int): MenuControl = {
    val image = new Image("menu/exit.png")
    val imageActive = new Image("menu/exit_selected.png")
    val area = createMenuElementArea(offset, image.getWidth, image.getHeight)
    val action = (game: StateBasedGame) => System.exit(0)

    MenuControl(area, DataModel(imageActive, image), action)
  }

  private def createMenuElementArea(offset: Int, imageWidth:Int, imageHeight: Int): Area = {
    val topPoint = AreaPositioner(canvasWidth = screenWidth,
                                  canvasHeight = screenHeight,
                                  areaWidth = imageWidth,
                                  areaHeight = imageHeight,
                                  topOffset = MENU_ELEMENTS_Y_MARGIN + offset,
                                  horizontalAlign = HorizontalAlignment.CENTER)
      .topPoint
    new Area(topPoint, MENU_ELEMENTS_WIDTH, MENU_ELEMENTS_HEIGHT)
  }

}
