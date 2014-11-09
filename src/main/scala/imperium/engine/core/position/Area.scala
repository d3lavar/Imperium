package imperium.engine.core.position

import org.newdawn.slick.geom.Point

/*
 * Created by DelavaR on 07.11.2014.
 */
object Area {
  def apply(point: Point, width: Int, height: Int) = new Area(point, width, height)
}

class Area(val point: Point, val width: Int, val height: Int) {

  def includes(point: Point): Boolean = {
    point.getX >= this.point.getX && point.getX <= this.point.getX + width &&
    point.getY >= this.point.getY && point.getY <= this.point.getY + height
  }

}
