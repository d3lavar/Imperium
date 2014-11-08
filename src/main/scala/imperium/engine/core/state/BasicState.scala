package imperium.engine.core.state

import imperium.engine.ui.control.AbstractControl
import org.newdawn.slick.{Graphics, GameContainer}
import org.newdawn.slick.state.{StateBasedGame, BasicGameState}

import scala.collection.mutable

/*
 * Created by DelavaR on 08.11.2014.
 */
class BasicState extends BasicGameState {

  private val controls: mutable.MutableList[AbstractControl] = mutable.MutableList[AbstractControl]()

  override def getID: Int = {
    throw new NotImplementedError()
  }

  override def init(container: GameContainer, game: StateBasedGame): Unit = {
    throw new NotImplementedError()
  }

  override def update(container: GameContainer, game: StateBasedGame, delta: Int): Unit = {
    throw new NotImplementedError()
  }

  override def render(container: GameContainer, game: StateBasedGame, g: Graphics): Unit = {
    throw new NotImplementedError()
  }

  def addControll(control: AbstractControl): Unit = {
    controls.+=(control)
  }

  def getControls = controls
}
