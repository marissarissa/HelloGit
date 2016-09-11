package id.sch.smktelkom_mlg.tugas01.xirpl3017.tugas001;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    Button bOk;
    Spinner spAsal, spTujuan;
    /*  RadioButton rbPP,rbSatu; */
    RadioGroup rgBerangkat;
    CheckBox lansia, dewasa, anak;
    TextView tvHasil;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        bOk = (Button) findViewById(R.id.button);
        spAsal = (Spinner) findViewById(R.id.spinnerasal);
        spTujuan = (Spinner) findViewById(R.id.spinnertujuan);
        /* rbPP = (RadioButton) findViewById(R.id.radioButtonPP);
        rbSatu = (RadioButton) findViewById(R.id.radioButtonSatu); */
        rgBerangkat = (RadioGroup) findViewById(R.id.rgBerangkat);
        lansia = (CheckBox) findViewById(R.id.checkBoxLansia);
        dewasa = (CheckBox) findViewById(R.id.checkBoxDewasa);
        anak = (CheckBox) findViewById(R.id.checkBoxAnak);
        lansia.setOnCheckedChangeListener(this);
        dewasa.setOnCheckedChangeListener(this);
        anak.setOnCheckedChangeListener(this);

        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();
            }
        });
    }

    private void doClick() {
        String hasil = null;
        int startlen = hasil.length();
        if (lansia.isChecked()) hasil += lansia.getText() + "\n";
        if (dewasa.isChecked()) hasil += dewasa.getText() + "\n";
        if (anak.isChecked()) hasil += anak.getText() + "\n";
        if (hasil.length() == startlen) hasil += "tidak ada pilihan";

        if (rgBerangkat.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgBerangkat.getCheckedRadioButtonId());
            hasil = rb.getText().toString();

        /*if(rbPP.isChecked()) {
            hasil = rbPP.getText().toString();
        }
        else (rbSatu.isChecked()) {
            hasil = rbSatu.getText().toString();*/
        }


        tvHasil.setText("Nama Anda " + etNama + " pesawat asal " + spAsal + " dengan tujuan " + spTujuan);
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();


        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
    }
}
