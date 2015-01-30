import imperium.engine.core.position.{HorizontalAlignment, AreaPositioner, VerticalAlignment}
import org.scalatest.{FlatSpec, Matchers}

/*
 * Created by DelavaR on 07.12.2014.
 */
class AreaPositionerSpec extends FlatSpec with Matchers {

  it should "not be initialized with invalid canvas size" in {
    a [IllegalArgumentException] should be thrownBy {
      AreaPositioner(0, -1)
    }
    a [IllegalArgumentException] should be thrownBy {
      AreaPositioner(-1, 0)
    }
  }

  noException shouldBe thrownBy {
    AreaPositioner(1, 1)
    AreaPositioner(0, 0)
  }

  //TODO: AreaPositioner args cannot be reassigned, is it wrong?
  it should "aligns to top left by default" in {
    var positioner = AreaPositioner(10, 10)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.topPoint.getY == 0)

    positioner = AreaPositioner(10, 10, areaHeight = 3)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.area.height == 3)
    assert(positioner.area.width == 0)

    positioner = AreaPositioner(10, 10, areaHeight = 3, areaWidth = 3)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.area.height == 3)
    assert(positioner.area.width == 3)

    positioner = AreaPositioner(10, 10, areaHeight = 3, areaWidth = 3, bottomOffset = 1)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.area.height == 3)
    assert(positioner.area.width == 3)

    positioner = AreaPositioner(10, 10, areaHeight = 3, areaWidth = 3, bottomOffset = 1, rightOffset = 1)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.area.height == 3)
    assert(positioner.area.width == 3)
  }

  it should "be bottom aligned" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, verticalAlign = VerticalAlignment.BOTTOM)
    assert(positioner.topPoint.getY == 6)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 3)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, bottomOffset = 2, verticalAlign = VerticalAlignment.BOTTOM)
    assert(positioner.topPoint.getY == 4)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 3)
  }

  it should "be top aligned" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, topOffset = 2, verticalAlign = VerticalAlignment.TOP)
    assert(positioner.topPoint.getY == 2)
    assert(positioner.topPoint.getX == 0)
  }

  it should "be right aligned" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, horizontalAlign = HorizontalAlignment.RIGHT)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 7)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 3)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, rightOffset = 2, horizontalAlign = HorizontalAlignment.RIGHT)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 5)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 3)
  }

  it should "be left aligned" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 3, leftOffset = 2, horizontalAlign = HorizontalAlignment.LEFT)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 2)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 3)
  }

  it should "be vertical centered" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, topOffset = 2, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getY == 4)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, bottomOffset = 2, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getY == 2)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, bottomOffset = 2, topOffset = 2, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.topPoint.getX == 0)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)
  }

  it should "be horizontal centered" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, horizontalAlign = HorizontalAlignment.CENTER)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, leftOffset = 2, horizontalAlign = HorizontalAlignment.CENTER)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 4)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, rightOffset = 2, horizontalAlign = HorizontalAlignment.CENTER)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 2)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, leftOffset = 2, rightOffset = 2, horizontalAlign = HorizontalAlignment.CENTER)
    assert(positioner.topPoint.getY == 0)
    assert(positioner.topPoint.getX == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)
  }

  it should "be vertical & horizontal centered" in {
    var positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 3)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, leftOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 4)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, leftOffset = 2, topOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 4)
    assert(positioner.topPoint.getY == 4)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, rightOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 2)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, rightOffset = 2, topOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 2)
    assert(positioner.topPoint.getY == 4)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, rightOffset = 2, leftOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 3)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

    positioner = AreaPositioner(10, 10, areaHeight = 4, areaWidth = 4, topOffset = 2, bottomOffset = 2, horizontalAlign = HorizontalAlignment.CENTER, verticalAlign = VerticalAlignment.CENTER)
    assert(positioner.topPoint.getX == 3)
    assert(positioner.topPoint.getY == 3)
    assert(positioner.area.height == 4)
    assert(positioner.area.width == 4)

  }

}
