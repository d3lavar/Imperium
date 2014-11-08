package imperium.engine.core.position

/*
 * Created by DelavaR on 08.11.2014.
 */

object AreaPositioner {

  def apply(canvasWidth: Int, canvasHeight: Int) = new AreaPositioner(canvasWidth, canvasHeight)

}

class AreaPositioner(val canvasWidth: Int, val canvasHeight: Int) {

  private var areaWidth: Int = _
  private var areaHeight: Int = _

  private var topOffset: Int = _
  private var bottomOffset: Int = _
  private var leftOffset: Int = _
  private var rightOffset: Int = _

  private var verticalAlign = VerticalAlignment.TOP
  private var horizontalAlign = HorizontalAlignment.LEFT

  /*def areaWidth(width: Int) = {
    width match {
      case width if width > 0 => areaWidth = width
      case _ => throw new IllegalArgumentException("Area width only accepts positive value.")
    }
  }

  def areaHeight(height: Int) = height match {
    case height if height > 0 => areaHeight = height
    case _ => throw new IllegalArgumentException("Area height only accepts positive value.")
  }*/

  /*  def areaHeight(height: Int) = height match {
    case height if height > 0 => areaHeight = height
    case _ => throw new IllegalArgumentException("Area height only accepts positive value.")
  }

    def areaHeight(height: Int) = height match {
    case height if height > 0 => areaHeight = height
    case _ => throw new IllegalArgumentException("Area height only accepts positive value.")
  }*/





}
