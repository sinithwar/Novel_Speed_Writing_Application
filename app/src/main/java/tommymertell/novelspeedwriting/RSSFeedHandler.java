package tommymertell.novelspeedwriting;

import android.util.Log;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
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

    public void RSSFeedHandler() {

    }

    public String getInitialUrl() {
        return initialUrl;
    }

    public String getHuffington_entry() {
        return huffington_entry;
    }
    // As of right now, this program attempts to parse and serve the data to the system log via String
    public void parseAndStoreXML(XmlPullParser parser) throws XmlPullParserException, IOException{
        int event;
        String text = null;
        try {
            try {
                event = parser.getEventType();
                // TODO: Refine XML PARSER
                int xml_count = 0;
                while (event != XmlPullParser.END_DOCUMENT) {
                    String name = parser.getName();

                    while (event != XmlPullParser.END_DOCUMENT) {
                        if (xml_count == 20) {
                            break;
                        }
                        xml_count++;
                        if (event == XmlPullParser.START_DOCUMENT) {
                            System.out.println("Start document");
                        } else if (event == XmlPullParser.START_TAG) {
                            System.out.println("Start tag " + parser.getName() + parser.getText());
                        } else if (event == XmlPullParser.END_TAG) {
                            System.out.println("End tag " + parser.getName() + parser.getText());
                        } else if (event == XmlPullParser.TEXT) {
                            System.out.println("Text " + parser.getName() + parser.getText());
                        }
                        try {
                            event = parser.next();
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }


        } catch (Exception e) {

        }
    }

    public void getXML() {
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

                } catch (Exception e) {

                }
            }
        });
        xml_thread.start();
    }


}
