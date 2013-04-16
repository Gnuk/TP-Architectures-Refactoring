package org.joyofcoding.objectcalisthenics;

import java.util.ArrayList;
import java.util.List;

public class GildedRose {
    public static void main(String[] args) {
		GildedRose gildedRose = new GildedRose();
		Items items = new Items();
        gildedRose.updateQuality(items.make());
	}

    public List<Item> makeItems() {
        List<Item> items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
        return items;
    }

    public void updateQuality(List<Item> list) {
    	List<Item> items = list;
        for (int i = 0; i < items.size(); i++) {
    		treatItems(items.get(i));
    	}
    }
    
    public void treatItems(Item item){
    	
    	treatAgedBrieBackstage(item);

		if (!item.compareName("Sulfuras, Hand of Ragnaros")) {
			item.decreaseSellIn();
		}

		if (item.isLessSellInThan(0)) {
			treatNotAgedBrie(item);
		}
    }
    
    public void treatAgedBrieBackstage(Item item){
    	if(item.compareName("Aged Brie")
				|| item.compareName("Backstage passes to a TAFKAL80ETC concert")){
    		treatAgedBrieBackstageBadQuality(item);
    		return;
    	}
    	
    	positiveQuality(item);
    }
    
    public void treatAgedBrieBackstageBadQuality(Item item){
    	if (badQuality(item)) {
    		return;
    	}

		if (item.compareName("Backstage passes to a TAFKAL80ETC concert")) {
			treatBackstageOnly(item);
		}
    }
    
    public void treatBackstageOnly(Item item){
    	if (item.isLessSellInThan(11) && item.isLessQualityThan(50)) {
			item.increaseQuality();
		}

		if (item.isLessSellInThan(6) && item.isLessQualityThan(50)) {
			item.increaseQuality();
		}
    }
    
    public void treatNotAgedBrie(Item item){
    	if(item.compareName("Aged Brie")){
    		badQuality(item);
    		return;
    	}
    	
    	treatBackstage(item);
    }
    
    public static void treatBackstage(Item item){
    	if(item.compareName("Backstage passes to a TAFKAL80ETC concert")){
			item.resetQuality();
			return;
    	}
    	
    	positiveQuality(item);
    }
    
    public static void positiveQuality(Item item){
    	if (item.isMoreQualityThan(0)) {
			treatSulfuras(item);
		}
    }
    
    public static void treatSulfuras(Item item){
    	if(item.compareName("Sulfuras, Hand of Ragnaros")){
    		return;
    	}
    	
    	item.decreaseQuality();
    }

	public static boolean badQuality(Item item) {
		if (item.isLessQualityThan(50)) {
			item.increaseQuality();
			return false;
		}
		return true;
	}

}
