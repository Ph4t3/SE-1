package org.hbrs.se1.ws25.demo.kapitel6.godobject;

import java.util.List;

/**
 * Beispiel eines God-Objects (chapter 6, section 2):
 * Ist dieses Interface ein God-Object?
 *
 * @author saschaalda
 * (Interface is maintained in Git by further persons: Steve Maier, Julia Kappes, Angie Mills)
 *
 */

public interface ReportDistributor {

	public List getWheatherPredictions(int x, int y, String a, double bb);

	public List getStockReports(int data, double c, double n, int nn);

	public List getHealthInsights(String data, String dd, String ff, String abc);

	public List getClimateStatistics(int data, int x);

	void addWheatherPredictions(List report);

	void addStockReports(List report);

	void addHealthInsights(List report);

	void addClimateStatistics(List listofStatistics);

}
