package imperium.engine.ui.control

import imperium.engine.core.position.Area
import org.newdawn.slick.state.StateBasedGame


/*
 * Created by DelavaR on 07.11.2014.
 */
abstract class AbstractControl(val area: Area, val action: (StateBasedGame) => Unit) {

  var isActive: Boolean = false

  def render()

  def onHoverActivated() = {
    isActive = true
  }

  def onHoverDeactivated() = {
    isActive = false
  }

}
