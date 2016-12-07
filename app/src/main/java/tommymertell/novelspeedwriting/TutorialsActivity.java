package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TutorialsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        // Setting up the textview's ids so that they can be used for onclick listeners
        TextView about_activity = (TextView) findViewById(R.id.about_title);
        TextView chapter_summaries_activity = (TextView) findViewById(R.id.chapter_summaries);
        TextView description_activity = (TextView) findViewById(R.id.description_page);
        TextView idea_activity = (TextView) findViewById(R.id.the_idea);
        TextView page_summary_activity = (TextView) findViewById(R.id.page_summary);
        TextView word_count_activity = (TextView) findViewById(R.id.word_count);

        //Setting Up Back Functionality
        ImageView back_link_image = (ImageView) findViewById(R.id.tools_back);

        back_link_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_link = new Intent(TutorialsActivity.this, LandingPage.class);
                startActivity(back_link);
            }
        });

        // Setting up the onclick listener's to provide a responsive menu
        about_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about_link = new Intent(TutorialsActivity.this, AboutActivity.class);
                startActivity(about_link);
            }
        });

        chapter_summaries_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ch_sum_link = new Intent(TutorialsActivity.this, ChapterSummariesActivity.class);
                startActivity(ch_sum_link);
            }
        });

        description_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent descrip_link = new Intent(TutorialsActivity.this, DescriptionActivity.class);
                startActivity(descrip_link);
            }
        });

        idea_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent idea_link = new Intent(TutorialsActivity.this, IdeaActivity.class);
                startActivity(idea_link);
            }
        });
        page_summary_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent page_sum_link = new Intent(TutorialsActivity.this, PageSummaryActivity.class);
                startActivity(page_sum_link);
            }
        });
        word_count_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent word_count_link = new Intent(TutorialsActivity.this, WordCountActivity.class);
                startActivity(word_count_link);
            }
        });
    }
}
