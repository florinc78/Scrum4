package com.scrum4.model.util;

import java.util.List;

public class PagedItemsList {	
	
    public PagedItemsList() {
		super();
	}
    
    public PagedItemsList(PageData pageData) {
    	super();
    	this.setsEcho(pageData.getsEcho());
	}
    
    private int sEcho; //identificator request
    private int recordsTotal; //numar de itemuri in colectie
    private int recordsFiltered; //numar de itemuri in colectie
    private int draw;
    private List<? extends Object> aaData; //lista de date
    
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public List<? extends Object> getAaData() {
		return aaData;
	}
	public void setAaData(List<? extends Object> aaData) {
		this.aaData = aaData;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
}
