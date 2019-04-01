package ro.pub.cs.systems.eim.practicaltest01var10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PracticalTest01Var10SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_second);
        // intent from parent
        Intent intentFromParent = getIntent();
        Bundle data = intentFromParent.getExtras();
        // process information from data ...
        String d = data.getString("ro.pub.cs.systems.eim.eim.someKey").trim();

        String[] parts = d.split("\\+");
        int sum  = 0;

        for(int i = 0; i < parts.length; i++) {
            sum += Integer.parseInt(parts[i].trim());
        }

        // intent to parent
        Intent intentToParent = new Intent();
        intentToParent.putExtra("ro.pub.cs.systems.eim.lab04.anotherKey", sum);
        setResult(RESULT_OK, intentToParent);
        finish();
    }
}
