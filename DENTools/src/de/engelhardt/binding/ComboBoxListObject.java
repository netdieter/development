/**
 * 
 */
package de.engelhardt.binding;

/**
 * @author dieter
 *
 */
public class ComboBoxListObject {
	private int id;
	private String value;

	public ComboBoxListObject(int id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}
