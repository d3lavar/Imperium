package imperium.engine.core.map.tmx

import imperium.engine.core.map.{GameMap, MapLoader}
import org.newdawn.slick.tiled.TiledMap

/**
 * Created by DelavaR on 21.08.2014.
 */
class TmxMapLoader extends MapLoader {
  override def loadMap(): TiledMap = {
    loadMap("/map/test.tmx")
  }

  override def loadMap(path: String): TiledMap = {
    new TiledMap(path)
  }

}
