package org.hbrs.se1.ws25.demo.kapitel6.backdoor;


/**
 * Example for a back door in code (chapter 6, section 2):
 * Is there a back door given in this code?
 * 
 * @author saschaalda
 * 
 */

public class DocumentManager {
	
	public void checkAndSaveDocument( Document data ) {
		if ( checkDocument ( data ) == true ) {
			this.saveDocument(data);
		}
	}
	
	public void saveDocument( Document data ) {
		// Save to DB-Disk without check (should be ensured before!)
	}
	
	private boolean checkDocument( Document data ) {
		
		// Checks the consistency of the document
		// if good --> return true
		// if bad --> return false
		
		return false; // only to ensure correct compilation
	}

}
