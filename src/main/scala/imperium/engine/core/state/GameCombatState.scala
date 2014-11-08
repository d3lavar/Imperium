package imperium.engine.core.state

/*
 * Created by DelavaR on 08.11.2014.
 */
object GameCombatState {
  val ID: Int = 999
}

class GameCombatState extends BasicState {
  override def getID: Int = GameCombatState.ID
}


/*



                            ||============\\              ||=========================
                            ||             \\             ||                       ||
                            ||              \\            ||
                            ||               \\           ||
                            ||                \\          ||
                            ||                 \\         ||
                            ||                  \\        ||
                            ||                   \\       ||
                            ||                    \\      ||
                            ||                     \\     ||
                            ||                     //     ||
                            ||                    //      ||
                            ||                   //       ||========================||
                            ||                  //        ||
                            ||=================//         ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||
                            ||                            ||                          ||
                            ||                            ||============================


 */