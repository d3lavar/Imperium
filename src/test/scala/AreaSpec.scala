import imperium.engine.core.position.Area
import org.newdawn.slick.geom.Point
import org.scalatest.{Matchers, FlatSpec}

/*
 * Created by DelavaR on 07.12.2014.
 */
class AreaSpec extends FlatSpec with Matchers {

  it should "not accept invalid coordinates/size" in {
    noException shouldBe thrownBy {
      Area(new Point(5, 7), 10, 15)
    }

    val topPoint = new Point(5, 7)
    a[IllegalArgumentException] should be thrownBy {
      Area(topPoint, -10, 15)
    }
    a[IllegalArgumentException] should be thrownBy {
      Area(topPoint, 10, -15)
    }
    a[IllegalArgumentException] should be thrownBy {
      Area(null, 10, 15)
    }

    val area = Area(topPoint, 10, 15)
    assert(area.point == topPoint)
    assert(area.width == 10)
    assert(area.height == 15)
  }

  it should "correctly shows included points" in {
    val topPoint = new Point(2, 2)
    val area = Area(topPoint, 10, 15)

    val included = List(new Point(2, 2),
                        new Point(2, 17),
                        new Point(12, 2),
                        new Point(12, 17),
                        new Point(5, 5),
                        new Point(3, 2),
                        new Point(10, 10))
    val excluded = List(new Point(1, 1),
                        new Point(1, 10),
                        new Point(10, 1),
                        new Point(13, 5),
                        new Point(5, 18))

    included.map { x => assert(area.includes(x)) }
    excluded.map { x => assert(!area.includes(x)) }
  }

}
