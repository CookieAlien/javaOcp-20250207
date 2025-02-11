package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ShopOrder implements Serializable{
	private int id;
	private String username;
	private int ps5pro;
	private int ps5slim;
	private int nswitch;
	private int steamdeck;
	private int xboxcontroller;
	private int sum;
	private LocalDateTime lastModified;
	public ShopOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopOrder(String username, int ps5pro, int ps5slim, int nswitch, int steamdeck, int xboxcontroller) {
		super();
		this.username = username;
		this.ps5pro = ps5pro;
		this.ps5slim = ps5slim;
		this.nswitch = nswitch;
		this.steamdeck = steamdeck;
		this.xboxcontroller = xboxcontroller;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getPs5pro() {
		return ps5pro;
	}
	public void setPs5pro(int ps5pro) {
		this.ps5pro = ps5pro;
	}
	public int getPs5slim() {
		return ps5slim;
	}
	public void setPs5slim(int ps5slim) {
		this.ps5slim = ps5slim;
	}
	public int getNswitch() {
		return nswitch;
	}
	public void setNswitch(int nswitch) {
		this.nswitch = nswitch;
	}
	public int getSteamdeck() {
		return steamdeck;
	}
	public void setSteamdeck(int steamdeck) {
		this.steamdeck = steamdeck;
	}
	public int getXboxcontroller() {
		return xboxcontroller;
	}
	public void setXboxcontroller(int xboxcontroller) {
		this.xboxcontroller = xboxcontroller;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public LocalDateTime getLastModified() {
		return lastModified;
	}
	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}
	
}
