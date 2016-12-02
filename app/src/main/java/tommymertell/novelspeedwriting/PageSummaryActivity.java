package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PageSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_summary);

        ImageView back_view = (ImageView) findViewById(R.id.about_back);

        back_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_link = new Intent(PageSummaryActivity.this, LandingPage.class);
                startActivity(back_link);
            }
        });
    }
}
