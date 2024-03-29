package simpleAddr.interpret;

import simpleAdder.analysis.DepthFirstAdapter;
import simpleAdder.node.AProgram;

public class Interpreter extends DepthFirstAdapter {
	@Override
	public void caseAProgram(AProgram node) {
		 String lhs = node.getLeft().getText().trim();
	      String rhs = node.getRight().getText().trim();
	      int result = (new Integer(lhs)).intValue() + (new Integer(rhs)).intValue();
	      System.out.println(lhs + "+" + rhs + "=" + result); 
	}
}
