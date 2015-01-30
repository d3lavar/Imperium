import imperium.engine.core.position.{AreaPositioner, Area}
import imperium.engine.ui.control.AbstractControl
import org.scalatest.{Matchers, FlatSpec}

/*
 * Created by DelavaR on 30.01.2015.
 */
class ControlSpec extends FlatSpec with Matchers {

  lazy val area = new Area(AreaPositioner(1, 1).topPoint, 1, 1)

  it should "be active or not" in {
    val control = new TestControl
    assert(!control.isActive)
    control.onHoverActivated()
    assert(control.isActive)
    control.onHoverDeactivated()
    assert(!control.isActive)
  }

  it should "have area" in {
    val control = new TestControl
    assert(control.area == area)
  }

  a [NotImplementedError] should be thrownBy {
    val control = new TestControl
    control.render()
  }


  class TestControl extends AbstractControl(area, (_) => Unit) {
    override def render(): Unit = ???
  }

}
