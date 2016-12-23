/**
 * 
 */
package de.engelhardt.jdbc;

import javax.inject.Singleton;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.fx.core.log.Logger;
import org.eclipse.fx.core.log.LoggerCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author dieter
 *
 */
@Singleton
@Creatable
public class JdbcService {
	private static Logger logger = LoggerCreator.createLogger(JdbcService.class);

	private JdbcTemplate jdbc;

	public JdbcService(){
		jdbc = new JdbcTemplate();
		
		 ApplicationContext context = new ClassPathXmlApplicationContext("datasource.xml");
		 logger.debug("datasource.xml gelesen");
//	      StudentJDBCTemplate studentJDBCTemplate = 
//	      (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
	      	
	}
}
