import imperium.engine.core.position.{Area, AreaPositioner}
import imperium.engine.ui.control.AbstractControl
import org.scalatest.{FreeSpec, Matchers}

/*
 * Created by DelavaR on 30.01.2015.
 */
class ControlSpec extends FreeSpec with Matchers {

  lazy val area = new Area(AreaPositioner(1, 1).topPoint, 1, 1)

  "it can be active or not" in new TestControl {
    isActive shouldBe false
    onHoverActivated()
    isActive shouldBe true
    onHoverDeactivated()
    isActive shouldBe false
  }

  "it can have area" in new TestControl {
    area should be(area)
  }

  "should produce NotImplementedError when render called" in new TestControl {
    intercept[NotImplementedError] {
      render()
    }
  }

  class TestControl extends AbstractControl(area, (_) => Unit) {
    override def render(): Unit = ???
  }

}
