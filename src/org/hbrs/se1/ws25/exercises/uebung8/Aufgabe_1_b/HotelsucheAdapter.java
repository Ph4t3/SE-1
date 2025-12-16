package org.hbrs.se1.ws25.exercises.uebung8.Aufgabe_1_b;

import java.sql.ResultSet;

public class HotelsucheAdapter implements  HotelSuche{
    private LegacyReiseAnbieter adaptee;
    public HotelsucheAdapter(LegacyReiseAnbieter adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public SuchErgebnis suche (SuchAuftrag auftrag){
    QueryObject query= mapToQueryObject(auftrag);
        ResultSet result = adaptee.suche(query);
    return mapToSuchErgebnis(result);
    }
    private QueryObject mapToQueryObject(SuchAuftrag auftrag){
        return new QueryObject();
    }
    private SuchErgebnis mapToSuchErgebnis(ResultSet result){
        return new SuchErgebnis();
    }
}
