package com.mydemo.saxparserimagedemo;

import java.util.ArrayList;
import java.util.Comparator;

public class SAXItems implements Comparator<SAXItems> {
	/** Variables */
	private String Product;
	private String Products;
	private String Products1;
	private String PriceSet;
	private String categoryId;
	private String id;
	private String title;
	private String description;
	private String manufacturer;
	private String url;
	private String relevancy;
	private String minPrice;
	private String maxPrice;
	private String stores;
	private ArrayList<Image> imgList = new ArrayList<Image>();
	
	public ArrayList<Image> getImgList() {
		return imgList;
	}

	public void setImgList(ArrayList<Image> imgList) {
		this.imgList=imgList;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getProducts() {
		return Products;
	}

	public void setProducts(String products) {
		Products = products;
	}

	public String getProducts1() {
		return Products1;
	}

	public void setProducts1(String products1) {
		Products1 = products1;
	}

	public String getPriceSet() {
		return PriceSet;
	}

	public void setPriceSet(String priceSet) {
		PriceSet = priceSet;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getRelevancy() {
		return relevancy;
	}

	public void setRelevancy(String relevancy) {
		this.relevancy = relevancy;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getStores() {
		return stores;
	}

	public void setStores(String stores) {
		this.stores = stores;
	}

	@Override
	public int compare(SAXItems object1, SAXItems object2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class Image {
	
		private String xSize;
		private String ySize;
		private String url;

		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getxSize() {
			return xSize;
		}

		public void setxSize(String xSize) {
			this.xSize = xSize;
		}

		public String getySize() {
			return ySize;
		}

		public void setySize(String ySize) {
			this.ySize = ySize;
		}

		

	}

}
