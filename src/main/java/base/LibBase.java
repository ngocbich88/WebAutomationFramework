package base;
import org.apache.log4j.Logger;

public class LibBase {
	protected Logger log = Logger.getLogger(this.getClass());
	
	/**
	 * Constructor of LibBase to: initialize all necessary objects for package Libs
	 */
	public LibBase() {		
		
		log = Logger.getLogger(LibBase.class.getName());
	}

}
