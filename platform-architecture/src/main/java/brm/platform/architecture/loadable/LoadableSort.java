package brm.platform.architecture.loadable;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Loadable sorting values.
 * @author Gregory
 */
@Documented
@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.ANNOTATION_TYPE)
public @interface LoadableSort {
  /**
   * A major value. This is used as the primary sort key for ordinal sorting operations.<p>
   * Defaults to {@link Byte#MAX_VALUE}.
   * @return A {@link Byte} value.
   * @see LoadableSort
   */
  public byte major() default Byte.MAX_VALUE;

  /**
   * A minor value. This is used as the secondary sort key for ordinal sorting operations.<p>
   * Defaults to {@link Byte#MAX_VALUE}.
   * @return A {@link Byte} value.
   * @see LoadableSort
   */
  public byte minor() default Byte.MAX_VALUE;
}
