/*
 * Created on Feb 24, 2010
 *
 */
package traveller.com.wolfram.alpha;

import traveller.com.wolfram.alpha.visitor.Visitable;


public interface WARelatedLink extends Visitable {
    
    String getURL();
    String getText();
    String getSource();
    String getExcerpt();
    WAImage getImage();

}
