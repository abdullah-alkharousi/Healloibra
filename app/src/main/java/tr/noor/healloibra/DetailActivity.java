package tr.noor.healloibra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String COURSE_TITLE = "course_title";
    public static final String RESULT_CODE = "result_code";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);


        TextView tvcourses= (TextView)findViewById(R.id.tvcoursediscription);
        tvcourses.setText(getIntent().getStringExtra(MainActivity.COURSE_DESCRIBTION));

        TextView tvcourseTitle= (TextView)findViewById(R.id.tvcourseTitle);
        tvcourseTitle.setText(getIntent().getStringExtra(MainActivity.COURSE_TITLE));

        TextView tvcourseid= (TextView)findViewById(R.id.tvcourseid);
        tvcourseid.setText(String.valueOf((getIntent().getIntExtra(MainActivity.COURSE_ID,0))));

        TextView tvcourseCredit= (TextView)findViewById(R.id.tvcourseCredit);
        tvcourseCredit.setText(Double.toString(getIntent().getDoubleExtra(MainActivity.COURSE_CREDIT,0.0)));



        ImageView ivCourseIcon = (ImageView)findViewById(R.id.ivCourse_im);

        int resId = getResources().getIdentifier("image_" +getIntent().getIntExtra(MainActivity.COURSE_ID,0), "drawable", getPackageName());

        ivCourseIcon.setImageResource(resId);



    }


    public void back(View view) {
        getIntent().putExtra(COURSE_TITLE,getIntent().getStringExtra(MainActivity.COURSE_TITLE));

        setResult(RESULT_OK,getIntent());

        finish();





    }
}
