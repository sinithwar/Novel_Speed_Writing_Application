package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WordCountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_count);

        ImageView back_view = (ImageView) findViewById(R.id.about_back);

        back_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_link = new Intent(WordCountActivity.this, LandingPage.class);
                startActivity(back_link);
            }
        });
    }
}
