import org.lwjgl.opengl.{DisplayMode, Display}
import org.newdawn.slick.SlickException
import org.newdawn.slick.tiled.TiledMap
import org.scalatest._

/*
 * Created by DelavaR on 09.11.2014.
 */

class TiledMapSpec extends FlatSpec with Matchers with UISpec {

  val WRONG_PATH = "WRONG_PATH"
  val WRONG_FILE = "maps/invalid-map.tmx"
  val CORRECT_FILE = "maps/map.tmx"


  it should "throw RuntimeException if wrong path was passed to TiledMap constructor" in {
    a [RuntimeException] should be thrownBy {
      new TiledMap(WRONG_PATH)
    }
  }

  it should "throw SlickException file cannot be parsed" in {
    a [SlickException] should be thrownBy {
      new TiledMap(WRONG_FILE)
    }
  }

  noException should be thrownBy {
      new TiledMap(CORRECT_FILE)
  }
}
