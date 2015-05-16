package brm.platform.architecture.enumtype;


/**
 * <h2>OperatorMode</h2>
 * The operator mode. This is used to specify how the platform architecture is being used; it contains instances for if
 * the editor or the engine is in control of operation.
 * @author Gregory
 */
public enum OperatorMode {
  /**
   * Default modality. This is an initial state that the platform architecture is initialized as beginning. Only editor
   * controls should set this, and only after a project is closed.
   * <p/>
   * This is marked as "developer-only", and has an {@code id} value of {@code -3}, although it should not be used in
   * most cases.
   * @see OperatorMode
   */
  abstractBasics(true, -3, "DEFAULT MODALITY", "[dev] An initial state the platform architecture is initialized as being."),
  /**
   * Editor-only mode. The data can be read and saved; the engine is not being used at this moment.
   * <p/>
   * This is marked as "developer-only", and has an {@code id} value of {@code -2}.
   * @see OperatorMode
   */
  editorDataOnly(true, -2, "Editor data only", "[dev] The editor is used to create and manipulate the game data."),
  /**
   * Editor-test mode. The data has been opened by the editor, and is also being tested by the engine, from a test-play
   * session.
   * <p/>
   * This is marked as "developer-only", and has an {@code id} value of {@code -1}.
   * @see OperatorMode
   */
  editorGameTest(true, -1, "Editor game test", "[dev] The editor uses the engine to perform a test-play session."),
  /**
   * Engine-play mode. The data has been opened in the engine only, and processing control may proceed as normal. Games
   * will perform as they should, as released to the public.
   * <p/>
   * @see OperatorMode
   */
  engineGamePlay(false, 0, "Engine game only", "The engine operates normally, loading data and running the game."),
  /**
   * Engine-test mode. The engine is run in standalone mode, but also allows minor configuring of some game data or its
   * game-states.
   * <p/>
   * @see OperatorMode
   */
  engineGameTest(false, 1, "Engine game test", "The engine may play with testing data in Standalone mode.");
  /**
   * Developer-only mode. This is for the developers who are creating, editing, and testing the game and its data. They
   * must have the editor AND the developer's secret encryption/decryption key &hellip; which any sane developer should
   * not give out freely, unless it is meant to be a "free" project.
   * @see OperatorMode
   */
  public final boolean devOnly;
  /**
   * The mode identifier. This is used in place of an ordinal numbering system, in order to specify the control mode on
   * the command-line. The end-user or game player will only be able to specify either a zero or one, as a command-line
   * parameter.
   * @see OperatorMode
   */
  public final int id;
  /**
   * The name or title.
   * @see OperatorMode
   */
  public final String name;
  /**
   * The descriptive note.
   * @see OperatorMode
   */
  public final String note;

  /**
   * A private constructor. This is not to be used elsewhere!!
   * @see OperatorMode
   */
  private OperatorMode(boolean b, int i, String s, String t) {
    devOnly = b;
    id = i;
    name = s;
    note = t;
  }

  /**
   * Get the operator mode. This takes an integer value, and returns a matching mode.
   * @return An {@link OperatorMode} instance.
   * @see OperatorMode
   */
  public static final OperatorMode fromId(int i) {
    switch(i) {
      case -2:
        return editorDataOnly;
      case -1:
        return editorGameTest;
      case 0:
      default:
        return engineGamePlay;
      case 1:
        return engineGameTest;
    }
  }
}
