/*
 * Created on Mar 1, 2010
 *
 */
package traveller.com.wolfram.alpha;

import traveller.com.wolfram.alpha.visitor.Visitable;


public interface WARelatedExample extends Visitable {

    String getInput();
    String getDescription();
    String getCategory();
    WAImage getCategoryThumb();
    String getCategoryPage();   
    
}
