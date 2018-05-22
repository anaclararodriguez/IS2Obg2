/*
 * Created on Sep 19, 2010
 *
 */
package traveller.com.wolfram.alpha;

import traveller.com.wolfram.alpha.visitor.Visitable;


public interface WAFutureTopic extends Visitable {

    String getTopic();
    String getMessage();
}
