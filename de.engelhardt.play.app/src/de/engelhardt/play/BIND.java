package de.engelhardt.play;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.e4.core.di.annotations.Optional;


//TODO Wie sieht eine Implementiereung dieser Annotation aus?
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BIND {
	String value() default "unknown";
	// Wie macht man das richtig Optiona?l
	@Optional String struct();
	
}
