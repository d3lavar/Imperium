import imperium.engine.core.position.{Area, AreaPositioner}
import imperium.engine.ui.control.AbstractControl
import org.scalatest.{FreeSpec, Matchers}

/*
 * Created by DelavaR on 30.01.2015.
 */
class ControlSpec extends FreeSpec with Matchers {

  lazy val area = new Area(AreaPositioner(1, 1).topPoint, 1, 1)

  "it can be active or not" in new Control {
    assert(!control.isActive)
    control.onHoverActivated()
    assert(control.isActive)
    control.onHoverDeactivated()
    assert(!control.isActive)
  }

  "it can have area" in new Control {
    control.area should be(area)
  }

  "should produce NotImplementedError when render called" in new Control {
    intercept[NotImplementedError] {
      control.render()
    }
  }

  class TestControl extends AbstractControl(area, (_) => Unit) {
    override def render(): Unit = ???
  }

  class Control {
    val control = new TestControl
  }

}
