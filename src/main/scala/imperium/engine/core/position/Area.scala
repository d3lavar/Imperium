package imperium.engine.core.position

import org.newdawn.slick.geom.Point

/*
 * Created by DelavaR on 07.11.2014.
 */
object Area {
  def apply(point: Point, width: Int, height: Int) = new Area(point, width, height)
}

class Area(val point: Point, val width: Int, val height: Int) {

  if (point == null) throw new IllegalArgumentException("Point can only be a non-nil instance of Point")
  if (width < 0) throw new IllegalArgumentException("Width can only be a positive integer.")
  if (height < 0) throw new IllegalArgumentException("Height can only be a positive integer.")

  def includes(point: Point): Boolean = {
    point.getX >= this.point.getX && point.getX <= this.point.getX + width &&
      point.getY >= this.point.getY && point.getY <= this.point.getY + height
  }

}
