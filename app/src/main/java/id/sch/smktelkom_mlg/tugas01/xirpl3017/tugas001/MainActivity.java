package id.sch.smktelkom_mlg.tugas01.xirpl3017.tugas001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nama;
    TextView tvHasil;
    Spinner asal, tujuan;
    RadioGroup rgstatus;
    CheckBox lansia, dewasa, anak;
    Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nama = (EditText) findViewById(R.id.editTextNama);
        asal = (Spinner) findViewById(R.id.spinnerasal);
        tujuan = (Spinner) findViewById(R.id.spinnertujuan);
        lansia = (CheckBox) findViewById(R.id.checkBoxLansia);
        dewasa = (CheckBox) findViewById(R.id.checkBoxDewasa);
        anak = (CheckBox) findViewById(R.id.checkBoxAnak);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        String Umur = " untuk usia";
        if (lansia.isChecked()) Umur += " " + lansia.getText() + " ";
        if (anak.isChecked()) Umur += " " + anak.getText() + " ";
        if (dewasa.isChecked()) Umur += " " + dewasa.getText() + " ";
        /*RadioButton rb = (RadioButton) findViewById(rgstatus.getCheckedRadioButtonId());*/
        tvHasil.setText("Nama anda " + nama.getText().toString() + " dari " + asal + " menuju " + tujuan + " keberangkatan " /*+ rb.getText().toString()*/ + Umur);
    }
}
