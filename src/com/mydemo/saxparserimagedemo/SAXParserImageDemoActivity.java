package com.mydemo.saxparserimagedemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.mydemo.saxparserimagedemo.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class SAXParserImageDemoActivity extends Activity {
	
//	SAXItems getterSetterList = null;
	
    /** Called when the activity is first created. */
	List<SAXItems> listSaxItems;
	TextView txttitle, txtDecription ,txtCategoryID , txtProductID,txtImage,txtYSize;
	ImageView imageView;
	ImageLoader imageLoader;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.w("On Create", "Calling");
        imageLoader = new ImageLoader(this);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        layout.setVerticalScrollBarEnabled(true);
        
        ScrollView sv = new ScrollView(this);
        sv.addView(layout);
        /** Create a new textview array to display the results */
        
        try {

            /** Handling XML */
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            XMLReader xr = sp.getXMLReader();
            /** Send URL to parse XML Tags */
            URL sourceUrl = new URL("http://catalog.bizrate.com/services/catalog/v1/us/product?publisherId=50085&placementId=1&categoryId=1&keyword=ipod&productId=&productIdType=SZPID&merchantId=&minPrice=&maxPrice=&start=0&results=10&startOffers=0&resultsOffers=0&sort=relevancy_desc&brandId=&attFilter=&showAttributes=&showProductAttributes=&zipCode=&offersOnly=&biddedOnly=&minRelevancyScore=100&apiKey=58f536aa2fab110bbe0da501150bac1e");
            /** Create handler to handle XML Tags ( extends DefaultHandler ) */
            MySAXHandler myXMLHandler = new MySAXHandler();
            xr.setContentHandler(myXMLHandler);
            xr.parse(new InputSource(sourceUrl.openStream()));
            listSaxItems= myXMLHandler.getList();
            
            
            
        } catch (Exception e) {
            System.out.println("XML Pasing Excpetion = " + e);
        }
        for (int i = 0; i < listSaxItems.size(); i++) {
        	
        	txtCategoryID = new TextView(this);
        	txtCategoryID.setText("CategoryID :" + listSaxItems.get(i).getCategoryId());
        	Log.v("Get Category ID", ""+txtCategoryID.getText().toString());
        	txtCategoryID.setTextColor(Color.DKGRAY);
        	layout.addView(txtCategoryID);
        	
        	txtProductID = new TextView(this);
        	txtProductID.setText("Product ID :" + listSaxItems.get(i).getId());
        	txtProductID.setTextColor(Color.LTGRAY);
        	layout.addView(txtProductID);
        	
        	txttitle = new TextView(this);
        	txttitle.setText("Title : " +listSaxItems.get(i).getTitle());
        	txttitle.setTextColor(Color.GREEN);
        	layout.addView(txttitle);
        	
        	txtDecription = new TextView(this);
        	txtDecription.setText("Decription : " + listSaxItems.get(i).getDescription());
        	txtDecription.setTextColor(Color.RED);
        	layout.addView(txtDecription);
        	
        	txtImage = new TextView(this);
        	txtImage.setText("Image :" + listSaxItems.get(i).getImgList().get(0).getUrl());
        	layout.addView(txtImage);
        	try {
        		 imageView=new ImageView(this);
        		Drawable drawable = ImageOperations(this, listSaxItems.get(i).getImgList().get(1).getUrl());
        		imageView.setImageDrawable(drawable);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
        	layout.addView(imageView);

//        	imageView.setTag(listSaxItems.get(i).getImgList());
//        	imageLoader.DisplayImage(listSaxItems.get(i).getImgList().toString(), this, imageView);

        }
        setContentView(sv);
        
    }
    public Object fetch(String address) throws MalformedURLException,
    IOException {
        URL url = new URL(address);
        Object content = url.getContent();
        return content;
    } 
    private Drawable ImageOperations(Context ctx, String url) {
        try {
            InputStream is = (InputStream) this.fetch(url);
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
       }
    }
   
 }
        
