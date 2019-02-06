package tr.noor.healloibra;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    public static final String COURSE_DESCRIBTION = "course_describtion";
    public static final String COURSE_TITLE = "course_title";
    public static final String COURSE_ID = "Course_id";
    public static final String COURSE_CREDIT = "Course_credit";
    public static final int REQUEST_CODE = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);


        final List<Course> courseList = DataProvider.getData();
        //ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this,android.R.layout.simple_list_item_1,courseList);

        ArrayAdapter<Course> adapter = new CourseArrayAdapter(this, 0, courseList);


        ListView listView = (ListView) findViewById(R.id.Lv_Courses);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Course course = courseList.get(i);
                //Toast.makeText(MainActivity.this, course.getTitale(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra(COURSE_TITLE, course.getTitale());

                intent.putExtra(COURSE_ID, course.getID());

                intent.putExtra(COURSE_CREDIT, course.getCrdit());

                intent.putExtra(COURSE_DESCRIBTION, course.getDescription());
               // startActivity(intent);

                startActivityForResult(intent, REQUEST_CODE);

            }
        });


    }


    private class CourseArrayAdapter extends ArrayAdapter<Course> {

        Context context;
        List<Course> courseList;

        public CourseArrayAdapter(@Nullable Context context, @LayoutRes int resource, @NonNull List<Course> objects) {
            super(context, resource, objects);
            this.context = context;
            this.courseList = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


            Course course = courseList.get(position);

            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.course_item_list, parent, false);

            TextView tvCourseTitle = (TextView) convertView.findViewById(R.id.textView2);

            tvCourseTitle.setText(course.getTitale());

            ImageView ivCourseIcon = (ImageView) convertView.findViewById(R.id.ivCourseitem);

            int resId =
                    getResources().getIdentifier("image_" + course.getID(), "drawable", getPackageName());

            ivCourseIcon.setImageResource(resId);

            return convertView;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK) {

            Toast.makeText(this,

                    "Thank you for registring with: "

                            + data.getStringExtra(DetailActivity.COURSE_TITLE),
                    Toast.LENGTH_SHORT).show();
        }
    }
}


