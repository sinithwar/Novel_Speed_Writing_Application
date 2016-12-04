package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        // Setting up the textview's ids so that they can be used for onclick listeners
        TextView about_activity = (TextView) findViewById(R.id.about_title);
        TextView chapter_summaries_activity = (TextView) findViewById(R.id.chapter_summaries);
        TextView description_activity = (TextView) findViewById(R.id.description_page);
        TextView idea_activity = (TextView) findViewById(R.id.the_idea);
        TextView page_summary_activity = (TextView) findViewById(R.id.page_summary);
        TextView word_count_activity = (TextView) findViewById(R.id.word_count);

        // Setting up the onclick listener's to provide a responsive menu
        about_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_link = new Intent(LandingPage.this, AboutActivity.class);
                startActivity(about_link);
            }
        });

        chapter_summaries_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ch_sum_link = new Intent(LandingPage.this, ChapterSummariesActivity.class);
                startActivity(ch_sum_link);
            }
        });

        description_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent descrip_link = new Intent(LandingPage.this, DescriptionActivity.class);
                startActivity(descrip_link);
            }
        });

        idea_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idea_link = new Intent(LandingPage.this, IdeaActivity.class);
                startActivity(idea_link);
            }
        });
        page_summary_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page_sum_link = new Intent(LandingPage.this, PageSummaryActivity.class);
                startActivity(page_sum_link);
            }
        });
        word_count_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent word_count_link = new Intent(LandingPage.this, WordCountActivity.class);
                startActivity(word_count_link);
            }
        });
    }
}
