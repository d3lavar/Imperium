import org.lwjgl.opengl.{DisplayMode, Display}
import org.newdawn.slick.SlickException
import org.newdawn.slick.tiled.TiledMap
import org.scalatest._

/**
 * Created by waynesayonara on 11.11.14.
 */
trait UISpec {
    //TODO: Init GL Context in a headless way and only once
    Display.setDisplayMode(new DisplayMode(1, 1))
    Display.create()
}