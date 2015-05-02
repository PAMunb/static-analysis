package br.unb.cic.sa.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;

import br.unb.cic.sa.statements.MDCollected;

// Class to check if there is any vargs[] with params in methods
public class VarArgsInMethod {

	public VarArgsInMethod() {

	}

	public void checkVarArgs(List<MDCollected> lmdCollected){
		
		Map<MethodDeclaration, CompilationUnit> methodsWithVarArgs = new HashMap<MethodDeclaration, CompilationUnit>();
		
		for(MDCollected md :  lmdCollected){
			CompilationUnit compilation = md.getCompilationUnit();
			for(MethodDeclaration m : md.getListMethodDeclaration()){
				
				System.out.println("MethodName:"+m.getName());
				System.out.println("Parameter:"+m.parameters().get(0));
				
				List<SingleVariableDeclaration> d = m.parameters();
				
				for(SingleVariableDeclaration x : d){
					System.out.print(x.toString()+" ");
				}
				
				if(m.isVarargs()){
					System.out.println("Method:"+m.getName()+" is varArgs.");
					methodsWithVarArgs.put(m, compilation);
				}
				
				
				System.out.println("\n");

			}
			
		}
		
	}
}
