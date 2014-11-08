package imperium.engine.core.map

import org.newdawn.slick.tiled.TiledMap

/*
 * Created by DelavaR on 21.08.2014.
 */
trait MapLoader {

  def loadMap(): TiledMap = loadMap("")
  def loadMap(path: String): TiledMap

}
