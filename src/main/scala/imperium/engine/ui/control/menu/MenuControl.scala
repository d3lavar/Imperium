package imperium.engine.ui.control.menu

import imperium.engine.core.position.Area
import imperium.engine.ui.control.AbstractControl
import imperium.engine.ui.model.DataModel
import org.newdawn.slick.state.StateBasedGame

/*
 * Created by DelavaR on 07.11.2014.
 */
object MenuControl {
  def apply(area: Area, dataModel: DataModel, action: (StateBasedGame) => Unit) = new MenuControl(area, dataModel, action)
  def apply(area: Area, dataModel: DataModel) = new MenuControl(area, dataModel, (StateBasedGame) => Unit)
}

class MenuControl(override val area: Area, val dataModel: DataModel, override val action: (StateBasedGame) => Unit = (StateBasedGame) => Unit) extends AbstractControl(area, action) {

  override def render(): Unit = {
    val image = if (isActive) dataModel.imageActive else dataModel.imageNormal
    image.draw(area.point.getX, area.point.getY)
  }

}
