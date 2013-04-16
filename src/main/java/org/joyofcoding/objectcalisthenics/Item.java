package org.joyofcoding.objectcalisthenics;

public class Item {
	private String name;
	private int sellIn;
	private int quality;

	public Item(String name, int sellIn, int quality) {
		this.name = name;
		this.quality = quality;
		this.sellIn = sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public String getName() {
		return name;
	}

	public int getSellIn() {
		return sellIn;
	}

	public int getQuality() {
		return quality;
	}
	
	public boolean compareName(String name){
		return this.name.equals(name);
	}
	
	public void increaseQuality(){
		this.quality++;
	}
	
	public void decreaseQuality(){
		this.quality--;
	}
	
	public void resetQuality(){
		this.quality = 0;
	}
	
	public boolean isLessQualityThan(int quality){
		return this.quality < quality;
	}
	
	public boolean isMoreQualityThan(int quality){
		return this.quality > quality;
	}
	
	public boolean isLessSellInThan(int sellIn){
		return this.sellIn < sellIn;
	}
	
	public void decreaseSellIn(){
		this.sellIn--;
	}
}
