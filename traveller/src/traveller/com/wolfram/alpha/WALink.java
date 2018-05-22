/*
 * Created on Feb 8, 2010
 *
 */
package traveller.com.wolfram.alpha;

import traveller.com.wolfram.alpha.visitor.Visitable;


public interface WALink extends Visitable {

    String getURL();
    String getText();
    String getTitle();
}
