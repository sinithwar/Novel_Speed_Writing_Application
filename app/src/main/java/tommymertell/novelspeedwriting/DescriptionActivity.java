package tommymertell.novelspeedwriting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ImageView back_view = (ImageView) findViewById(R.id.about_back);

        back_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back_link = new Intent(DescriptionActivity.this, LandingPage.class);
                startActivity(back_link);
            }
        });
    }

}
