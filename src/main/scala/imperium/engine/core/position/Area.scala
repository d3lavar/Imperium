package imperium.engine.core.position

import org.lwjgl.util.Point

/*
 * Created by DelavaR on 07.11.2014.
 */
class Area(val point: Point, val width: Int, val height: Int) {

  def includes(point: Point): Boolean = {
    point.getX >= this.point.getX && point.getX <= this.point.getX + width &&
    point.getY >= this.point.getY && point.getY <= this.point.getY + height
  }

}
