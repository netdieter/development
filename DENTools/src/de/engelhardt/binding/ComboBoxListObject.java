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

	@Override
	//TODO: Seltsam hier
	public boolean equals(Object obj) {
		if(obj instanceof  ComboBoxListObject){
			System.out.println(this.toString());
			if(this.getId() == ((ComboBoxListObject)obj).getId()){
				return true;
			} 
		}
		if(obj instanceof  Integer){
			if(this.getId() == (Integer)obj){
				return true;
			} 
		}
		return false;
	}
	
	

}
