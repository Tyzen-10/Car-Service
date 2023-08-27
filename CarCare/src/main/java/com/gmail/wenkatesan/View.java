package com.gmail.wenkatesan;

public class View {
	private int id;
    private String reportContent;
    private String ownerName;

    public View(int id, String reportContent, String ownerName) {
        this.id = id;
        this.reportContent = reportContent;
        this.ownerName = ownerName;
    }

    public int getId() {
        return id;
    }

    public String getReportContent() {
        return reportContent;
    }

    public String getOwnerName() {
        return ownerName;
    }
}
