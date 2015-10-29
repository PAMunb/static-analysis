package br.unb.cic.sa.model;

/**
 * Represents a simple API for collecting and exporting data from the 
 * visitors. 
 * @author rbonifacio
 *
 */
public interface Data<T> {
	public void setProject(Project project);
	public void addValue(T value);
	public void export();
	public void clean();
}
