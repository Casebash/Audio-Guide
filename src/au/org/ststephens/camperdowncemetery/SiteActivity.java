package au.org.ststephens.camperdowncemetery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

public class SiteActivity extends FragmentActivity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        MyApplication app=(MyApplication) getApplication();
        Site s=app.getSiteById(intent.getIntExtra("id", -1));
        setTitle(s.title);
        setContentView(R.layout.text);
        TextView v=(TextView) findViewById(R.id.textView1);
        v.setText(s.description);
    }
}
