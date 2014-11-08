package imperium.engine.ui.control

import imperium.engine.core.position.Area


/*
 * Created by DelavaR on 07.11.2014.
 */
abstract class AbstractControl(val area: Area, val action: () => Unit) {

  var isActive: Boolean = false

  def render(): Unit = {
    throw new NotImplementedError()
  }

  def onHoverActivated() = {
    isActive = true
  }

  def onHoverDeactivated() = {
    isActive = false
  }



}
