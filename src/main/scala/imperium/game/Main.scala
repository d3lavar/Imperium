package imperium.game

import imperium.engine.core.game.SimpleGame
import org.newdawn.slick.AppGameContainer

/*
 * Created by DelavaR on 07.11.2014.
 */
object Main extends App {
  val GAME_LABEL = "Imperium"
  val VERSION = "v. 0.0.1"
  val WINDOW_HEIGHT = 1024
  val WINDOW_WIDTH = 800
  val FULLSCREEN = false
  val app = new AppGameContainer(new SimpleGame)

  app.setDisplayMode(WINDOW_HEIGHT, WINDOW_WIDTH, FULLSCREEN)
  app.start()
}
