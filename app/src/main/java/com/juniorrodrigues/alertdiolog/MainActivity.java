package com.juniorrodrigues.alertdiolog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirDialog(View view){
        //getApplicationContext() contesto global da aplicação, nesse caso preciso passar no builder somente o contexto da Activity "this";
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //conf, titulo e mensagem
        dialog.setTitle("Primeiro Alert Dialog!");
        dialog.setMessage("Faça sua escolha: ");

        //Opcional conf de Cancelamento
        // configurando com ofalse, o dialog n cancela clicando fora, sim ela fecha normalmente
        dialog.setCancelable(false);

        //Opcional definindo icone para o dialog
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //Conf de açoes sim e não
        //sim
        dialog.setPositiveButton("Escolha sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Positivo sempre, vamos conseguir!!", Toast.LENGTH_LONG).show();
            }
        });
            //no metodo sim, o contexto que puxamos é da mainActivity, não usamos o this direto pois assim ele pega da interface,
            // ja no nao, usamos o contexto global da aplicação, atravez do getApplicationContext()

        //nao
        dialog.setNegativeButton("Escolha não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Mesmo Negativo vamos chegar la, tudo pronto como sempre!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.create(); //cria a dialog com as confs acima
        dialog.show(); // mostra o dialog
    }
}
