package br.unb.cic.sa.model;

/**
 * To Export data to CSV
 * 
 * When finish a single project need call export otherwise throw 
 * 	java.lang.OutOfMemoryError: GC overhead limit exceeded because has a wide size of data  
 * 
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CSVData<T> implements Data<T>{

	private Project project;
	private String fileName;
	private String outDir;
	private String[] head; 
	private List<T> data;

	public void setFileName(String file) {
		this.fileName = file;
	}
	
	public void setHead(String[] head) {
		this.head = head;
	}
	
	public void setOutDir(String dir) {
		this.outDir = dir;
	}
	

	@Override
	public void setProject(Project project) {
		this.project = project;
	}
		

	@Override
	public void addValue(T value) {
		if(data == null) {
			data = new ArrayList<>();
		}
		data.add(value);
	} 

	@Override
	public void clean() {
		if(data != null) {
			data.clear();
		}
	}
	
	@Override
	public int size() {
		return data == null ? 0 : data.size();
	}
	
	
	private File makeCsv(String[] head) throws IOException{
		
		File csv = new File(outDir + "/" + fileName  + ".csv");
		
		if(!csv.exists()){
			csv.createNewFile();
			FileWriter writer = new FileWriter(csv);
			
			StringBuffer str = new StringBuffer("");

			for(String s: head) {
				str.append(s);
				str.append(";");
			}
			writer.append(str);
			writer.append("\n");
			
			writer.flush();
		}
		
		return csv;
	}
	
	@Override
	public void export() {
		
		try (FileWriter writer = new FileWriter(this.makeCsv(head), true)){
		
			StringBuffer str = new StringBuffer("");

			if(data == null) {
				return;
			}
			
			for(T value : data) {
				str = new StringBuffer("");
				
				str.append(project.getTypeOfProject());
				str.append(";");
				str.append(project.getBefore());
				str.append(";");
				str.append(project.getProjectName());
				str.append(";");
				str.append(project.getProjectRevision());
				str.append(";");
//				str.append(project.getLoc());
//				str.append(";");
				
				//writer.append(str);
				//writer.append("\n");
					
				//reflection code... trying to understand this might lead to a huge headache!!!
				for(Field f: value.getClass().getDeclaredFields()){
										
					String fieldName = f.getName();
					String prefix = "get";
					
					if(f.getType().isPrimitive()&& f.getType().equals(Boolean.TYPE)) {
						prefix = "is";
					}
					
					String methodName = prefix + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
										
					try {
						Method m = value.getClass().getDeclaredMethod(methodName);						
						str.append(m.invoke(value));
						str.append(";");
					}catch(NoSuchMethodException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						throw new RuntimeException("Type " + value.getClass().getName() + " must have a method named " + methodName);
					}
				}
				writer.append(str.toString());
				writer.append("\n");
				
			}
			writer.flush();
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
