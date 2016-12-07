package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import org.w3c.dom.Text;

public class LandingPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        LinearLayout tutorials = (LinearLayout) findViewById(R.id.tutorials);
        LinearLayout news = (LinearLayout) findViewById(R.id.news);

        tutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tutorials_link = new Intent(LandingPage.this, TutorialsActivity.class);
                startActivity(tutorials_link);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent news_link = new Intent(LandingPage.this, NewsActivity.class);
                startActivity(news_link);
            }
        });
    }
}
