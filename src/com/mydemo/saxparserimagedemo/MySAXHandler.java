package com.mydemo.saxparserimagedemo;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.mydemo.saxparserimagedemo.SAXItems.Image;

import android.util.Log;

public class MySAXHandler extends DefaultHandler {

	public List<SAXItems> listSaxItems;
	private Image image;
	public ArrayList<Image> imageList;
	String currentValue = null;
	private SAXItems saxItems;
	StringBuilder sbr = new StringBuilder();
	boolean currentElement = false;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		currentElement = true;
		if (localName.equals("ProductResponse")) {
			// saxItems = new SAXItems();
			// String attr = attributes.getValue("categoryId");
			// Log.v("CategoryID", ""+attr);
			// String attr1 = attributes.getValue("id");
			// Log.v("ID", ""+attr1);
			// saxItems.setCategoryId(attr);
			// saxItems.setId(attr1);
			// // listSaxItems.add(saxItems);

			listSaxItems = new ArrayList<SAXItems>();
		} else if (localName.equals("Products")) {
			// String xsize = attributes.getValue("xsize");
			// Log.d("XSize", ""+xsize);
			// String ysize = attributes.getValue("ysize");
			// Log.d("YSize", ""+ysize);

		} else if (localName.equalsIgnoreCase("Product")) {
			saxItems = new SAXItems();
			saxItems.setCategoryId(attributes.getValue("categoryId"));
			saxItems.setId(attributes.getValue("id"));

		} else if (localName.equalsIgnoreCase("Images")) {
			imageList = new ArrayList<SAXItems.Image>();

		} else if (localName.equalsIgnoreCase("Image")) {

			image = saxItems.new Image();
			image.setxSize(attributes.getValue("xsize"));
			image.setySize(attributes.getValue("ysize"));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// currentElement = false;

		if (localName.equalsIgnoreCase("Product")) {
			listSaxItems.add(saxItems);
		} else if (localName.equalsIgnoreCase("title")) {
			saxItems.setTitle(currentValue);

		} else if (localName.equalsIgnoreCase("description")) {
			saxItems.setDescription(currentValue);
		} else if (localName.equalsIgnoreCase("Image")) {
			image.setUrl(sbr.toString());
			imageList.add(image);
			currentElement = true;
			Log.v("List", "" + imageList.size());
		} else if (localName.equalsIgnoreCase("Images")) {
			saxItems.setImgList(imageList);
		}
		sbr.setLength(0);

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (currentElement && ch != null) {
			currentValue = new String(ch, start, length);
			currentElement = false;
		}
		sbr.append(ch, start, length);
		Log.v("url", "" + sbr.toString().trim());
	}

	public List<SAXItems> getList() {
		return listSaxItems;
	}
}
