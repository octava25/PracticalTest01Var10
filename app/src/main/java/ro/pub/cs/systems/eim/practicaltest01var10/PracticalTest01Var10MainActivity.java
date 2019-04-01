package ro.pub.cs.systems.eim.practicaltest01var10;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var10MainActivity extends AppCompatActivity {

    EditText ed1;
    Button btnAdd;
    Button btnCompute;
    TextView tv1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btnAdd:
                    Log.d("DD", "AAA");
                    String t = ed1.getText().toString();
                    int n = Integer.parseInt(t);
                    if (tv1.getText().length() == 0) {
                        tv1.setText(t);
                    } else {
                        tv1.setText(tv1.getText().toString()+ " + " + t);
                    }
                    break;

                case R.id.btnCmp:
                    Log.d("DD", "AAA2");

                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var10SecondActivity.class);
                    intent.putExtra("ro.pub.cs.systems.eim.eim.someKey", tv1.getText().toString());
                    startActivityForResult(intent, 666);
                    break;

            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var10_main);

        ed1 = (EditText)findViewById(R.id.ed1);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnCompute = (Button)findViewById(R.id.btnCmp);
        tv1 = (TextView)findViewById(R.id.tv1);
        btnAdd.setOnClickListener(buttonClickListener);
        btnCompute.setOnClickListener(buttonClickListener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        switch (requestCode) {
            case 666:
                if (resultCode == Activity.RESULT_OK) {
                    Bundle data = intent.getExtras();
                    // process information from data ...
                    int r = data.getInt("ro.pub.cs.systems.eim.lab04.anotherKey");
                    Log.d("TAG2", "" + r);
                }
                break;

            // process other request codes
        }
    }
}
