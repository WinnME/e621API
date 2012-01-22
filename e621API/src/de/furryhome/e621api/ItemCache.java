package de.furryhome.e621api;

import java.util.ArrayList;

import de.furryhome.e621api.Exceptions.e621apiObjectException;

class ItemCache<ObjectClass> {
	private ArrayList<ObjectClass> cachedList = new ArrayList<ObjectClass>();
	
	public final boolean isContentCached() {
		return !this.cachedList.isEmpty();
	}
	
	public final void clearContentCache() {
		this.cachedList.clear();
	}
	
	public final ObjectClass GetListItem() throws e621apiObjectException {
		if (!this.isContentCached()) {throw new e621apiObjectException("Content cache is empty!");}
		return this.cachedList.get(0);
	}
	
	public final ObjectClass GetListItem(int index) throws e621apiObjectException {
		if (index < 0) {throw new e621apiObjectException("Index may never be smaller than 0!");}
		if (!this.isContentCached()) {throw new e621apiObjectException("Content cache is empty!");}
        return this.cachedList.get(index);
	}
	
	protected final ArrayList<ObjectClass> GetPostObjectList() throws e621apiObjectException {
		return this.cachedList;
	}
}
