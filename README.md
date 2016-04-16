# static-analysis   
	This work is a project of final course to degree in Computation at University of Brazilian (Brazil). __
	The main feature of this project is a data mining to obsolete construction in softwares __open-software developed in Java.

	To execute this you need a input that is a csv file that contains 6 columns like the following example:
	
	columns:
		1 -> kindApplication (opitional)
		2 -> before/after - Generics (optional)
		3 -> Name Project
		4 -> Version Project
		5 -> Path
		6 -> Lines of Code

	application;yes;ANT;1.9.6;.../apache-ant-1.9.6/;135741;



	
## Run
	To run you need execute a jar (StaticAnalyser.jar) file existents in targert folder. __To generate a jar file run mvc clean & mvn package.
	
	After execute: java -jar target/StaticAnalyser.jar input.csv. Is necessary pass with args a csv file valid.

	Another form to simply run is execute a scripting: 
		./run.sh args
		
		args is a path directory that contains the projects.
	  	
		
 


## Dependency
  1. **Need instal CLOC Count lines of code:**   
###### Debian:   
         apt-get install cloc   
    
   
