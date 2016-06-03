# static-analysis   
	This work is a project of final course to degree in Computation at University of Brazilian of two students Thiago G. Cavalcanti and Vinícius C. Almeida directed by Dr. Rodrigo Bonifácio de Almeida.  
	
	 The main feature of this project is a data mining to obsolete construction in softwares open-software developed in Java. 

## Run
	__Manually__  
		To execute this you need a input that is a csv file that contains 6 columns like the following example:  
		
		columns:  
			1. kindApplication (opitional)
			2. before/after - Generics (optional)
			3. Name Project
			4. Version Project
			5. Path
			6. Lines of Code
	  
		application;yes;ANT;1.9.6;.../apache-ant-1.9.6/;135741;  
	    
	**Automatically**
		Only execute the file *./run.sh* and answer a question in the script **Where is a path directory that contains the projects?**    
	
	
	**Directory of projects**
		To run automatically we need follow a pattern on directory that contains the projects will be analysed, the pattern of directory is illustrated here:       	  	
		
		|---- **Projects**   
		|        |--- *Ant*   
		|              |--- 1.9.6    		
		|        |--- *Cassandra*    
		|              |--- 2.2.1	    			
		|        |--- *Maven*		    
		|              |--- 3.3.3	     				
		|        |--- *Spring*		    
		|              |--- 4.2.1		    			
						
 		


## Dependency
  1. **Need instal CLOC Count lines of code:**      
  2. **Need Python**       
  3. **Maven**   
