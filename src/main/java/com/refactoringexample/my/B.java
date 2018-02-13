package com.refactoringexample.my;
import org.apache.http.client.*;
import org.apache.http.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


public class B {

    public B() {
        //Access some external interface
    }

    public int getThis() {
        try {
            //this bit taken from a post by Martin Fowler: https://martinfowler.com/articles/modernMockingTools.html
            String url = "http://www.gocurrency.com/v2/dorate.php?inV=1&from=USD&to=EUR&Calculate=Convert";

            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(url);
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            StringBuffer result = new StringBuffer();
            if (entity != null) {
                InputStream instream = entity.getContent();
                InputStreamReader irs = new InputStreamReader(instream);
                BufferedReader br = new BufferedReader(irs);
                String l;
                while ((l = br.readLine()) != null) {
                    result.append(l);
                }
            }
            String theWholeThing = result.toString();
            int start = theWholeThing.lastIndexOf("<div id=\"converter_results\"><ul><li>");
            String substring = result.substring(start);
            int startOfInterestingStuff = substring.indexOf("<b>") + 3;
            int endOfIntererestingStuff = substring.indexOf("</b>",
                    startOfInterestingStuff);
            String interestingStuff = substring.substring(
                    startOfInterestingStuff, endOfIntererestingStuff);
            String[] parts = interestingStuff.split("=");
            String value = parts[1].trim().split(" ")[0];
            int bottom = value.length();
            return (int)bottom;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
