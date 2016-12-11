package tommymertell.novelspeedwriting;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Tommy on 12/11/2016.
 */
public class RSSFeedHandler {

    private String initialUrl = "http://www.huffingtonpost.com/news/authors/feed//";
    private XmlPullParserFactory xmlFactoryObj;
    public volatile boolean parsingComplete = true;
    private String huffington_entry = "entry";

    public void RSSFeedHandler(){

    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public String getHuffington_entry() {
        return huffington_entry;
    }

    public void parseAndStoreXML(XmlPullParser parser){
        int event;
        String text = null;
        try{
            event = parser.getEventType();
            // TODO: Refine XML PARSER
            int xml_count = 0;
            while(event != XmlPullParser.END_DOCUMENT){
                String name = parser.getName();

                switch(event) {
                    case XmlPullParser.START_TAG:
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        Log.v("Result", "" + text + "");
                        break;

                    default:
                        Log.v("Error", "Failed to load");
                        break;
                }
                if(xml_count == 20){
                    break;
                }
                xml_count++;
                event = parser.next();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getXML(){
        Thread xml_thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Initiate a connection with the url
                    URL xml_url = new URL(initialUrl);
                    HttpURLConnection xml_connection = (HttpURLConnection) xml_url.openConnection();
                    xml_connection.setReadTimeout(10000);
                    xml_connection.setConnectTimeout(15000);
                    xml_connection.setRequestMethod("GET");
                    xml_connection.setDoInput(true);
                    xml_connection.connect();

                    // Start pulling the data
                    InputStream stream = xml_connection.getInputStream();
                    xmlFactoryObj = XmlPullParserFactory.newInstance();
                    XmlPullParser parser = xmlFactoryObj.newPullParser();
                    parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    parser.setInput(stream, null);

                    parseAndStoreXML(parser);
                    stream.close();

                }catch (Exception e){

                }
            }
        });
        xml_thread.start();
    }


    }
