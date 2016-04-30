/**
 * 
 */
package de.engelhardt.binding;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.jgoodies.binding.beans.Model;

/**
 * @author dieter
 *
 */
public class TestBean extends Model{
	private static final long serialVersionUID = 1L;

	private Integer id = -1;
	private String value;
	private ComboBoxListObject cbobj;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		Object oldValue = this.id;
		this.id = id;
		firePropertyChange("id", oldValue, id);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		Object oldValue = this.value;
		this.value = value;
		firePropertyChange("value", oldValue, value);
	}

	public ComboBoxListObject getCbobj() {
		return cbobj;
	}

	public void setCbobj(ComboBoxListObject cbobj) {
		Object oldValue = this.cbobj;
		this.cbobj = cbobj;
		firePropertyChange("cbobj", oldValue, cbobj);
	}
}
