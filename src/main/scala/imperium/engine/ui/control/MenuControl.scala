package imperium.engine.ui.control

import imperium.engine.core.position.Area
import imperium.engine.ui.model.DataModel

/*
 * Created by DelavaR on 07.11.2014.
 */
class MenuControl(override val area: Area, val dataModel: DataModel, override val action: () => Unit = () => Unit) extends AbstractControl(area, action) {

  override def render(): Unit = {
    val image = if (isActive) dataModel.imageActive else dataModel.imageNormal
    image.draw(area.point.getX, area.point.getY)
  }

}
