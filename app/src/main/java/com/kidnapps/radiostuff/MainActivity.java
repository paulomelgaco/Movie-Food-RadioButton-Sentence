package com.kidnapps.radiostuff;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private RadioGroup grupo1;
    private RadioGroup grupo2;
    private RadioButton opcao1;
    private RadioButton opcao2;
    private Button botaoPlano;
    private TextView resultado;

    //Radio Buttons para habilitar ou desabilitar
    private RadioButton rd1;
    private RadioButton rd2;
    private RadioButton rd3;
    private RadioButton rd4;
    private RadioButton rd5;
    private RadioButton rd6;

    private String frag1 = "Então vamos assistir ";
    private String frag2 = " comendo ";
    private String frag3 = ", hehehehe";

    private ToggleButton toggle;
    private TextView textoExib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //RadioButtons para ativar
        rd1 = findViewById(R.id.opOne);
        rd2 = findViewById(R.id.opTwo);
        rd3 = findViewById(R.id.opThree);
        rd4 = findViewById(R.id.optOne);
        rd5 = findViewById(R.id.optTwo);
        rd6 = findViewById(R.id.optThree);

        grupo1 = findViewById(R.id.radioGroup);
        grupo2 =  findViewById(R.id.RadioGPTwo);
        botaoPlano = findViewById(R.id.botaoPlano);
        resultado = findViewById(R.id.resultPlano);

        toggle = findViewById(R.id.botaoToggle);
        textoExib = findViewById(R.id.textoExib);

        final boolean enable = true;


        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked){
                    textoExib.setText("Acordou");
                    rd1.setEnabled(true);
                    rd2.setEnabled(true);
                    rd3.setEnabled(true);
                    rd4.setEnabled(true);
                    rd5.setEnabled(true);
                    rd6.setEnabled(true);

                } else {
                    textoExib.setText("Dormiu");
                    rd1.setEnabled(false);
                    rd2.setEnabled(false);
                    rd3.setEnabled(false);
                    rd4.setEnabled(false);
                    rd5.setEnabled(false);
                    rd6.setEnabled(false);
                }
            }
        });


        botaoPlano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idEscolhido1 = grupo1.getCheckedRadioButtonId();
                int idEscolhido2 = grupo2.getCheckedRadioButtonId();

                if (idEscolhido1>0 && idEscolhido2 >0){
                    opcao1 = findViewById(idEscolhido1);
                    opcao2 = findViewById(idEscolhido2);
                    String opt1 = opcao1.getText().toString();
                    String opt2 = opcao2.getText().toString();

                    String concat = frag1 + opt1 + frag2 + opt2 + frag3;

                    resultado.setText(concat);
                } else {
                    Toast.makeText(MainActivity.this, "Escolhe as coisas ae hehehe", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
