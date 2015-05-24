package br.unb.cic.sa.infra;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TrysInfra{
   
	public TrysInfra(){
		
		try{
			
			File f = new File("br/unb/cic/sa/infra/TrysInfra.java");
			
			if(!f.exists())
				throw new FileNotFoundException("File note found");
			
		}catch(IOException e){
			
		}catch(Exception e){
			
		}
		
		
		try{
			
			File f = new File("br/unb/cic/sa/infra/TrysInfra.java");
			
			if(!f.exists())
				throw new FileNotFoundException("File note found");
			
		}catch(IOException e){
			
		}catch(Exception e){
			
		}
		
		
		
		try{
			
			File f = new File("br/unb/cic/sa/infra/TrysInfra.java");
			
			if(!f.exists())
				throw new FileNotFoundException("File note found");
			
		}catch(Exception e){
			
		}
		
	}
	
}
