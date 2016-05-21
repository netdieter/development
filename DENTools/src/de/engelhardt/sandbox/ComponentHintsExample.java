/**
 * 
 */
package de.engelhardt.sandbox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.validation.Validatable;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.extras.IconFeedbackPanel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.util.PropertyValidationSupport;
import com.jgoodies.validation.util.ValidationUtils;
import com.jgoodies.validation.view.ValidationComponentUtils;
import com.jgoodies.validation.view.ValidationResultViewFactory;

/**
 * @author dieter
 *
 */
public class ComponentHintsExample extends JPanel {
	private Feed feed;
	private FeedPresentationModel feedPresentationModel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JComponent iconPanel;
	private ValidationResultModel validationModel;

	public ComponentHintsExample() {
		this.validationModel = new DefaultValidationResultModel();

		createFeed();
		this.feedPresentationModel = new FeedPresentationModel(this.feed);
		ValueModel nameModel = this.feedPresentationModel.getModel("name");

		DefaultFormBuilder formBuilder1 = new DefaultFormBuilder(new FormLayout("right:pref, 3dlu, p:g"));
		JTextField nameField1 = BasicComponentFactory.createTextField(nameModel, false);
		ValidationComponentUtils.setMandatory(nameField1, true);
		ValidationComponentUtils.setMessageKey(nameField1, "form.name_key");
		formBuilder1.append("Name:", nameField1);

		DefaultFormBuilder formBuilder2 = new DefaultFormBuilder(new FormLayout("right:pref, 3dlu, p:g"));
		JTextField nameField2 = BasicComponentFactory.createTextField(nameModel, false);
		ValidationComponentUtils.setMandatory(nameField2, true);
		ValidationComponentUtils.setMessageKey(nameField2, "form.name_key");
		formBuilder2.append("Name:", nameField2);

		DefaultFormBuilder formBuilder3 = new DefaultFormBuilder(new FormLayout("right:pref, 3dlu, p:g"));
		JTextField nameField3 = BasicComponentFactory.createTextField(nameModel, false);
		ValidationComponentUtils.setMandatory(nameField3, true);
		ValidationComponentUtils.setMessageKey(nameField3, "form.name_key");
		formBuilder3.append("Name:", nameField3);

		DefaultFormBuilder formBuilder4 = new DefaultFormBuilder(new FormLayout("right:pref, 4dlu, p:g"));
		JTextField nameField4 = BasicComponentFactory.createTextField(nameModel, false);
		ValidationComponentUtils.setMandatory(nameField4, true);
		ValidationComponentUtils.setMessageKey(nameField4, "form.name_key");
		formBuilder4.append("Name:", nameField4);
		// Padding for overlay icon
		formBuilder4.appendRow("5dlu");

		this.panel1 = formBuilder1.getPanel();
		this.panel2 = formBuilder2.getPanel();
		this.panel3 = formBuilder3.getPanel();
		this.iconPanel = new IconFeedbackPanel(this.validationModel, formBuilder4.getPanel());

		FormBuilder builder = FormBuilder.create().columns("p:g");

		builder.add(this.panel1);

		builder.add(this.panel2);

		builder.add(this.panel3);

		builder.add(this.iconPanel);

		builder.addLabel("Results");
		builder.add(ValidationResultViewFactory.createReportList(this.validationModel));

		add(builder.getPanel());

	}

	private void createFeed() {
		this.feed = new Feed();
		this.feed.setName("ClientJava.com");
		this.feed.setSiteUrl("http://www.clientjava.com/blog");
		this.feed.setFeedUrl("http://www.clientjava.com/blog/rss.xml");
	}

	public class FeedPresentationModel extends PresentationModel implements Validatable {
		private ValidationResultModel validationResultModel;

		public FeedPresentationModel(Object bean) {
			super(bean);
			this.validationResultModel = new DefaultValidationResultModel();
			initEventHandling();
		}

		public ValidationResultModel getValidationModel() {
			return this.validationResultModel;
		}

		public ValidationResult validate() {
			PropertyValidationSupport support = new PropertyValidationSupport(feed, "form");

			String name = (String) getModel("name").getValue();
			if (name.isEmpty()) {
				if (!"ClientJava.com".equals(name)) {
					support.addWarning("name_key", "is not ClientJava.com");
				}
				if (name.length() < 5) {
					support.addError("name_key", "must be more than 4 characters long.");
				}
			}

			return support.getResult();
		}

		private void initEventHandling() {
			PropertyChangeListener handler = new ValueUpdateHandler();
			addBeanPropertyChangeListener(handler);
			getBeanChannel().addValueChangeListener(handler);
		}

		public class ValueUpdateHandler implements PropertyChangeListener {
			public void propertyChange(PropertyChangeEvent evt) {
				updateComponents();
			}

			private void updateComponents() {
				ValidationResult result = validate();
				validationModel.setResult(result);

				ValidationComponentUtils.updateComponentTreeMandatoryAndBlankBackground(panel1);
				ValidationComponentUtils.updateComponentTreeMandatoryBackground(panel2);
				ValidationComponentUtils.updateComponentTreeMandatoryBorder(panel3);
				//ValidationComponentUtils.updateComponentTreeValidationBackground(panel1, result);
			}
		}
	}

	public static void main(String[] a) {
		JFrame f = new JFrame("Component Hints Example");
		f.setDefaultCloseOperation(2);
		f.add(new ComponentHintsExample());
		f.pack();
		f.setVisible(true);
	}
}
