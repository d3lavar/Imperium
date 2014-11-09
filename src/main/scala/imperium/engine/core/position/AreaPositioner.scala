package imperium.engine.core.position

import org.newdawn.slick.geom.Point

/*
 * Created by DelavaR on 08.11.2014.
 */

case class AreaPositioner(canvasWidth: Int,
                          canvasHeight: Int,
                          areaWidth: Int = 0,
                          areaHeight: Int = 0,
                          topOffset: Int = 0,
                          bottomOffset: Int = 0,
                          leftOffset: Int = 0,
                          rightOffset: Int = 0,
                          verticalAlign: VerticalAlignment = VerticalAlignment.TOP,
                          horizontalAlign: HorizontalAlignment = HorizontalAlignment.LEFT) {

  def buildArea(): Area = Area(calculateTopPoint(), areaWidth, areaHeight)

  def buildTopPoint(): Point = calculateTopPoint()

  private def calculateTopPoint(): Point = {
    var topPointX = -1
    var topPointY = -1
    horizontalAlign match {
      case HorizontalAlignment.LEFT => topPointX = leftOffset
      case HorizontalAlignment.RIGHT => topPointX = canvasWidth - rightOffset - areaWidth
      case HorizontalAlignment.CENTER =>
        val availableWidth = canvasWidth - rightOffset - leftOffset
        val hCenteringOffset = (availableWidth / 2) - (areaWidth / 2)
        topPointX = leftOffset + hCenteringOffset
    }
    verticalAlign match {
      case VerticalAlignment.TOP => topPointY = topOffset
      case VerticalAlignment.BOTTOM => topPointY = canvasHeight - bottomOffset - areaHeight
      case VerticalAlignment.CENTER =>
        val availableHeight = canvasHeight - topOffset - bottomOffset
        val vCenteringOffset = (availableHeight / 2) - (areaHeight / 2)
        topPointY = topOffset + vCenteringOffset
    }

    new Point(topPointX, topPointY)
  }

}
