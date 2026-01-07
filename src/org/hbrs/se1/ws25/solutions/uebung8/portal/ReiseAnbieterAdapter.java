package org.hbrs.se1.ws25.solutions.uebung8.portal;
import org.hbrs.se1.ws25.solutions.uebung8.reiseanbieter.*;

public class ReiseAnbieterAdapter implements HotelSucheInterface {
	
	private ReiseAnbieter system; // = new ... hier ausgelassen

	@Override
	public SuchErgebnis suche(SuchAuftrag auftrag) {
		QueryObject q = this.transformIN( auftrag );
		QueryResult r = system.executeQuery(q);
		SuchErgebnis r2 =  this.transformOUT( r );
		return r2;
	}
	
	private QueryObject transformIN( SuchAuftrag auftrag ) {
		// Transformation SuchAuftrag --> QueryObject
		return null;
	}
	
	private SuchErgebnis transformOUT( QueryResult result ) {
		// Transformation QueryResult --> SuchErgebnis
		return null;
	}



}
