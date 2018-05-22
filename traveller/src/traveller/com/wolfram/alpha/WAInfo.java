/*
 * Created on Dec 9, 2009
 *
 */
package traveller.com.wolfram.alpha;

import traveller.com.wolfram.alpha.visitor.Visitable;


public interface WAInfo extends Visitable {

    String getText();
    Visitable[] getContents();

}
