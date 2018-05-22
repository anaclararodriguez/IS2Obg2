/*
 * Created on Dec 8, 2009
 *
 */
package traveller.com.wolfram.alpha.visitor;

import traveller.com.wolfram.alpha.WAAssumption;
import traveller.com.wolfram.alpha.WAExamplePage;
import traveller.com.wolfram.alpha.WAFutureTopic;
import traveller.com.wolfram.alpha.WAImage;
import traveller.com.wolfram.alpha.WAInfo;
import traveller.com.wolfram.alpha.WALink;
import traveller.com.wolfram.alpha.WAPlainText;
import traveller.com.wolfram.alpha.WAPod;
import traveller.com.wolfram.alpha.WAPodState;
import traveller.com.wolfram.alpha.WAQueryResult;
import traveller.com.wolfram.alpha.WAReinterpretWarning;
import traveller.com.wolfram.alpha.WARelatedExample;
import traveller.com.wolfram.alpha.WARelatedLink;
import traveller.com.wolfram.alpha.WASound;
import traveller.com.wolfram.alpha.WASourceInfo;
import traveller.com.wolfram.alpha.WASubpod;
import traveller.com.wolfram.alpha.WAUnits;
import traveller.com.wolfram.alpha.WAWarning;


public interface Visitor {
    
    void visit(WAQueryResult obj); 
    void visit(WAPod obj); 
    void visit(WASubpod obj); 
    void visit(WAAssumption obj); 
    void visit(WAWarning obj); 
    void visit(WAInfo obj); 
    void visit(WAPodState obj); 
    void visit(WARelatedLink obj); 
    void visit(WARelatedExample obj); 
    void visit(WASourceInfo obj); 
    void visit(WAFutureTopic obj); 
    void visit(WAExamplePage obj); 
    void visit(WALink obj); 
    void visit(WAReinterpretWarning obj); 
    void visit(WAUnits obj); 
    
    // Content types
    void visit(WAPlainText obj); 
    void visit(WAImage obj); 
    void visit(WASound obj); 

}
