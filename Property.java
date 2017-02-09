package com.example.zillowapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable{

	@Override
	public String toString() {
		return "Property [propType=" + propType + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", yearBuilt="
				+ yearBuilt + ", lotSize=" + lotSize + ", finishedArea="
				+ finishedArea + ", bathRooms=" + bathRooms + ", bedRooms="
				+ bedRooms + ", taxAssessYear=" + taxAssessYear
				+ ", taxAssess=" + taxAssess + ", lastSoldPrice="
				+ lastSoldPrice + ", lastSoldDate=" + lastSoldDate
				+ ", zestAmount=" + zestAmount + ", zestUpdateDate="
				+ zestUpdateDate + ", overChange=" + overChange
				+ ", overChangeImg=" + overChangeImg + ", rentAmount="
				+ rentAmount + ", rentDate=" + rentDate + ", allPropChange="
				+ allPropChange + ", rentChange=" + rentChange
				+ ", rentChangeImg=" + rentChangeImg + ", allRentChange="
				+ allRentChange + "]";
	}

	public String getChart5yrs() {
		return chart5yrs;
	}
	public void setChart5yrs(String chart5yrs) {
		this.chart5yrs = chart5yrs;
	}
	public String getChart1yrs() {
		return chart1yrs;
	}
	public void setChart1yrs(String chart1yrs) {
		this.chart1yrs = chart1yrs;
	}
	public String getChart10yrs() {
		return chart10yrs;
	}
	public void setChart10yrs(String chart10yrs) {
		this.chart10yrs = chart10yrs;
	}

	private String propType;
	private String address;
	private String city;
	private String state;
	private int yearBuilt;
	private String lotSize;
	private String finishedArea;
	private int bathRooms;
	private int bedRooms;
	private int taxAssessYear;
	private String taxAssess;
	private String lastSoldPrice;
	private String lastSoldDate;
	private String zestAmount;
	private String zestUpdateDate;
	private String 	overChange;
	private String overChangeImg;
	private String rentAmount;
	private String rentDate;
	private String allPropChange;
	private String rentChange;
	private String rentChangeImg;
	private String allRentChange;
	private String chart5yrs;
	private String chart1yrs;
	private String chart10yrs;
	
	public String getPropType() {
		return propType;
	}
	public void setPropType(String propType) {
		this.propType = propType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getYearBuilt() {
		return yearBuilt;
	}
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	public String getLotSize() {
		return lotSize;
	}
	public void setLotSize(String lotSize) {
		this.lotSize = lotSize;
	}
	public String getFinishedArea() {
		return finishedArea;
	}
	public void setFinishedArea(String finishedArea) {
		this.finishedArea = finishedArea;
	}
	public int getBathRooms() {
		return bathRooms;
	}
	public void setBathRooms(int bathRooms) {
		this.bathRooms = bathRooms;
	}
	public int getBedRooms() {
		return bedRooms;
	}
	public void setBedRooms(int bedRooms) {
		this.bedRooms = bedRooms;
	}
	public int getTaxAssessYear() {
		return taxAssessYear;
	}
	public void setTaxAssessYear(int taxAssessYear) {
		this.taxAssessYear = taxAssessYear;
	}
	public String getTaxAssess() {
		return taxAssess;
	}
	public void setTaxAssess(String taxAssess) {
		this.taxAssess = taxAssess;
	}
	public String getLastSoldPrice() {
		return lastSoldPrice;
	}
	public void setLastSoldPrice(String lastSoldPrice) {
		this.lastSoldPrice = lastSoldPrice;
	}
	public String getLastSoldDate() {
		return lastSoldDate;
	}
	public void setLastSoldDate(String lastSoldDate) {
		this.lastSoldDate = lastSoldDate;
	}
	public String getZestAmount() {
		return zestAmount;
	}
	public void setZestAmount(String zestAmount) {
		this.zestAmount = zestAmount;
	}
	public String getZestUpdateDate() {
		return zestUpdateDate;
	}
	public void setZestUpdateDate(String zestUpdateDate) {
		this.zestUpdateDate = zestUpdateDate;
	}
	public String getOverChange() {
		return overChange;
	}
	public void setOverChange(String overChange) {
		this.overChange = overChange;
	}
	public String getOverChangeImg() {
		return overChangeImg;
	}
	public void setOverChangeImg(String overChangeImg) {
		this.overChangeImg = overChangeImg;
	}
	public String getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(String rentAmount) {
		this.rentAmount = rentAmount;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getAllPropChange() {
		return allPropChange;
	}
	public void setAllPropChange(String allPropChange) {
		this.allPropChange = allPropChange;
	}
	public String getRentChange() {
		return rentChange;
	}
	public void setRentChange(String rentChange) {
		this.rentChange = rentChange;
	}
	public String getRentChangeImg() {
		return rentChangeImg;
	}
	public void setRentChangeImg(String rentChangeImg) {
		this.rentChangeImg = rentChangeImg;
	}
	public String getAllRentChange() {
		return allRentChange;
	}
	public void setAllRentChange(String allRentChange) {
		this.allRentChange = allRentChange;
	}
	@Override
	public int describeContents() {
		return hashCode();
	}
	@Override
	public void writeToParcel(Parcel dest, int arg1) {
		dest.writeString(allPropChange);
		dest.writeString(address);
		dest.writeString(allRentChange);
		dest.writeInt(bathRooms);
		dest.writeInt(bedRooms);
		dest.writeString(city);
		dest.writeString(finishedArea);
		dest.writeString(lastSoldDate);
		dest.writeString(lastSoldPrice);
		dest.writeString(lotSize);
		dest.writeString(overChange);
		dest.writeString(overChangeImg);
		dest.writeString(propType);
		dest.writeString(rentAmount);
		dest.writeString(rentChange);
		dest.writeString(rentChangeImg);
		dest.writeString(rentDate);
		dest.writeString(state);
		dest.writeString(taxAssess);
		dest.writeInt(taxAssessYear);
		dest.writeInt(yearBuilt);
		dest.writeString(zestAmount);
		dest.writeString(zestUpdateDate);
		dest.writeString(chart1yrs);
		dest.writeString(chart5yrs);
		dest.writeString(chart10yrs);
		
	}
	public Property(Parcel p) {
		allPropChange=p.readString();
		address=p.readString();
		allRentChange=p.readString();
		bathRooms=p.readInt();
		bedRooms=p.readInt();
		city=p.readString();
		finishedArea=p.readString();
		lastSoldDate=p.readString();
		lastSoldPrice=p.readString();
		lotSize=p.readString();
		overChange=p.readString();
		overChangeImg=p.readString();
		propType=p.readString();
		rentAmount=p.readString();
		rentChange=p.readString();
		rentChangeImg=p.readString();
		rentDate=p.readString();
		state=p.readString();
		taxAssess=p.readString();
		taxAssessYear=p.readInt();
		yearBuilt=p.readInt();
		zestAmount=p.readString();
		zestUpdateDate=p.readString();
		chart1yrs=p.readString();
		chart5yrs=p.readString();
		chart10yrs=p.readString();
		
		 }
	
	public Property() {}
	 
	 // We need to add a Creator
	 public static final Parcelable.Creator<Property> CREATOR = new Parcelable.Creator<Property>() {
	 
	  @Override
	  public Property createFromParcel(Parcel parcel) {  
	   return new Property(parcel);
	  }
	  
	 
	 
	  @Override
	  public Property[] newArray(int size) {  
	   return new Property[size];
	  }
	 };	
}
