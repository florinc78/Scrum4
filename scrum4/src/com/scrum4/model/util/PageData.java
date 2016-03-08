package com.scrum4.model.util;

import java.io.Serializable;

public class PageData implements Serializable {
	private static final long serialVersionUID = 1816577653651666954L;
	private SessionData sessionData;
    private int iDisplayStart; //primul rand din pagina
    private int iDisplayLength; //numar de randuri pe pagina
    private int iTotalRecords; //numar de itemuri in colectie
    private int iSortCol_0; //numarul coloanei dupa care se sorteaza
    private String sSortDir_0; //directia de sortare
    private int sEcho; //idenitificator request
    
    public SessionData getSessionData() {
		return sessionData;
	}
	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}
	public int getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public int getiTotalRecords() {
		return iTotalRecords;
	}
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}
	public int getiSortCol_0() {
		return iSortCol_0;
	}
	public void setiSortCol_0(int iSortCol_0) {
		this.iSortCol_0 = iSortCol_0;
	}
	public String getsSortDir_0() {
		return sSortDir_0;
	}
	public void setsSortDir_0(String sSortDir_0) {
		this.sSortDir_0 = sSortDir_0;
	}
	public int getsEcho() {
		return sEcho;
	}
	public void setsEcho(int sEcho) {
		this.sEcho = sEcho;
	}
	public int getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
}
