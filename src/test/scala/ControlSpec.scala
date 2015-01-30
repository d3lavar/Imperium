import imperium.engine.core.position.{Area, AreaPositioner}
import imperium.engine.ui.control.AbstractControl
import org.scalatest.{FreeSpec, Matchers}

/*
 * Created by DelavaR on 30.01.2015.
 */
class ControlSpec extends FreeSpec with Matchers {

  lazy val area = new Area(AreaPositioner(1, 1).topPoint, 1, 1)

  "it can be active or not" in {
    val control = new TestControl
    assert(!control.isActive)
    control.onHoverActivated()
    assert(control.isActive)
    control.onHoverDeactivated()
    assert(!control.isActive)
  }

  "it can have area" in {
    val control = new TestControl
    assert(control.area == area)
  }

  "should produce NotImplementedError when render called" in {
    intercept[NotImplementedError] {
      val control = new TestControl
      control.render()
    }
  }

  class TestControl extends AbstractControl(area, (_) => Unit) {
    override def render(): Unit = ???
  }

}
