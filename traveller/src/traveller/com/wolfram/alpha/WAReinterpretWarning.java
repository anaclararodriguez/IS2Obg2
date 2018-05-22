/*
 * Created on Sep 19, 2010
 *
 */
package traveller.com.wolfram.alpha;


public interface WAReinterpretWarning extends WAWarning {

    String getNew();
    String[] getAlternatives();
}
