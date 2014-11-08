package imperium.engine.core.state

import org.newdawn.slick.state.transition.{FadeInTransition, FadeOutTransition}
import org.newdawn.slick.state.StateBasedGame
import org.newdawn.slick.tiled.TiledMap
import org.newdawn.slick.{Color, GameContainer, Graphics, Input}

/*
 * Created by DelavaR on 06.11.2014.
 */

object GameMapState {
  val ID: Int = 2

  def apply(screenWidth: Int, screenHeight: Int, mapPath: String) = new GameMapState(screenWidth, screenHeight, mapPath)
}

class GameMapState(val screenWidth: Int, val screenHeight: Int, val mapPath: String) extends BasicState {

  private var game: StateBasedGame = null
  private var map: TiledMap = null
  private var firstTileX: Int = 0
  private var firstTileY: Int = 0

  override def getID: Int = GameMapState.ID

  override def init(container: GameContainer, game: StateBasedGame) {
    this.game = game
    this.map = new TiledMap(mapPath)
  }

  override def update(container: GameContainer, game: StateBasedGame, delta: Int) {

  }

  override def render(container: GameContainer, game: StateBasedGame, g: Graphics) {
    map.render(0, 0, firstTileX, firstTileY, getScreenWidthInTiles, getScreenHeightInTiles)
  }

  /**
   * @see org.newdawn.slick.state.BasicGameState#keyReleased(int, char)
   */
  override def keyReleased(key: Int, c: Char) {
    key match {
      case Input.KEY_DOWN => if (firstTileY + getScreenHeightInTiles < map.getHeight) firstTileY += 1
      case Input.KEY_UP => if (firstTileY > 0) firstTileY -= 1
      case Input.KEY_RIGHT => if (firstTileX + getScreenWidthInTiles < map.getWidth) firstTileX += 1
      case Input.KEY_LEFT => if (firstTileX > 0) firstTileX -= 1
      case Input.KEY_ESCAPE => game.enterState(SimpleMenuState.ID, new FadeOutTransition(Color.black), new FadeInTransition(Color.black))
      case _ =>
    }
  }

  def getScreenWidthInTiles: Int = Math.ceil(screenWidth / map.getTileWidth).toInt
  def getScreenHeightInTiles: Int = Math.ceil(screenHeight / map.getTileHeight).toInt

}
