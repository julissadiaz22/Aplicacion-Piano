package sv.edu.itca.pianogrupo03;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pianoInstrumentos extends AppCompatActivity {
    private MediaPlayer sonidoBateria, sonidoClarinete, sonidoFlauta, sonidoGuitarra, sonidoSaxofon, sonidoTrompeta, sonidoViolin;
    Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_instrumentos);

        sonidoBateria = MediaPlayer.create(this, R.raw.bateria);
        sonidoClarinete= MediaPlayer.create(this, R.raw.clarinete);
        sonidoFlauta = MediaPlayer.create(this, R.raw.flauta);
        sonidoGuitarra= MediaPlayer.create(this, R.raw.guitarra);
        sonidoSaxofon = MediaPlayer.create(this, R.raw.saxofon);
        sonidoTrompeta= MediaPlayer.create(this, R.raw.trompeta);
        sonidoViolin = MediaPlayer.create(this, R.raw.violin);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("Menu", "Item seleccionado: " + item.getItemId());
        if (item.getItemId() == R.id.camPiano) {
            showPianoDialog();
            return true;
        } else if (item.getItemId() == R.id.sobreNosotros) {
            Intent intent = new Intent(pianoInstrumentos.this, acercade.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.salir) {
            new AlertDialog.Builder(this)
                    .setTitle("Salir")
                    .setMessage("¿Seguro que quieres salir?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finishAffinity();
                            System.exit(0);
                        }
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }


    private void showPianoDialog() {
        String[] pianoOptions={"Piano tradicional", "Piano infantil de la selva", "Piano de instrumentos musicales"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cambiar Tipo de Piano")
                .setItems(pianoOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which==0) {
                            Intent intent = new Intent(pianoInstrumentos.this, MainActivity.class);
                            startActivity(intent);
                        } else if (which==1) {
                            Intent intent = new Intent(pianoInstrumentos.this, pianoInfantil.class);
                            startActivity(intent);
                        } else if (which==2) {
                            Intent intent = new Intent(pianoInstrumentos.this, pianoInstrumentos.class);
                            startActivity(intent);
                        }
                    }
                });
        builder.create().show();
    }

    private void cambiarPiano(String tipoPiano) {
        System.out.println("piano seleccionado: "+ tipoPiano);
    }
    public void sonidoBateria(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Bateria", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoBateria == null) {
            sonidoBateria= MediaPlayer.create(this, R.raw.bateria);
        }

        if (!sonidoBateria.isPlaying()) {
            sonidoBateria.start();
        }
    }

    public void sonidoClarinete(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Clarinete", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoClarinete == null) {
            sonidoClarinete = MediaPlayer.create(this, R.raw.clarinete);
        }

        if (!sonidoClarinete.isPlaying()) {
            sonidoClarinete.start();
        }


    }

    public void sonidoFlauta(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Flauta", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoFlauta == null) {
            sonidoFlauta = MediaPlayer.create(this, R.raw.flauta);
        }

        if (!sonidoFlauta.isPlaying()) {
            sonidoFlauta.start();
        }
    }

    public void sonidoGuitarra(View view) {
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Guitarra", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoGuitarra == null) {
            sonidoGuitarra = MediaPlayer.create(this, R.raw.guitarra);
        }

        if (!sonidoGuitarra.isPlaying()) {
            sonidoGuitarra.start();
        }
    }


    public void sonidoSaxofon(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Saxofon", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoSaxofon == null) {
            sonidoSaxofon = MediaPlayer.create(this, R.raw.saxofon);
        }

        if (!sonidoSaxofon.isPlaying()) {
            sonidoSaxofon.start();
        }
    }

    public void sonidoTrompeta(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Trompeta", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoTrompeta == null) {
            sonidoTrompeta = MediaPlayer.create(this, R.raw.trompeta);
        }

        if (!sonidoTrompeta.isPlaying()) {
            sonidoTrompeta.start();
        }
    }

    public void sonidoViolin(View view){
        detenerSonidos();

        if (currentToast != null) {
            currentToast.cancel();
        }
        currentToast = Toast.makeText(this, "Sonido Violin", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(() -> currentToast.cancel(), 700);

        if (sonidoViolin == null) {
            sonidoViolin= MediaPlayer.create(this, R.raw.violin);
        }

        if (!sonidoViolin.isPlaying()) {
            sonidoViolin.start();
        }
    }

    private void detenerSonidos() {
        if (sonidoBateria != null && sonidoBateria.isPlaying()) {
            sonidoBateria.stop();
            sonidoBateria.release();
            sonidoBateria= null;

        }
        if (sonidoClarinete != null && sonidoClarinete.isPlaying()) {
            sonidoClarinete.stop();
            sonidoClarinete.release();
            sonidoClarinete = null;
        }

        if (sonidoFlauta != null) {
            sonidoFlauta.stop();
            sonidoFlauta.release();
            sonidoFlauta = null;
        }
        if (sonidoGuitarra!= null) {
            sonidoGuitarra.stop();
            sonidoGuitarra.release();
            sonidoGuitarra = null;
        }
        if (sonidoSaxofon != null) {
            sonidoSaxofon.stop();
            sonidoSaxofon.release();
            sonidoSaxofon = null;
        }
        if (sonidoTrompeta != null) {
            sonidoTrompeta.stop();
            sonidoTrompeta.release();
            sonidoTrompeta = null;
        }
        if (sonidoViolin != null) {
            sonidoViolin.stop();
            sonidoViolin.release();
            sonidoViolin = null;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (sonidoBateria != null && sonidoBateria.isPlaying()){
            sonidoBateria.stop();
            sonidoBateria.release();
            sonidoBateria=null;
        }

        if (sonidoClarinete != null && sonidoClarinete.isPlaying()){
            sonidoClarinete.stop();
            sonidoClarinete.release();
            sonidoClarinete=null;
        }

        if (sonidoFlauta != null && sonidoFlauta.isPlaying()){
            sonidoFlauta.stop();
            sonidoFlauta.release();
            sonidoFlauta=null;
        }

        if (sonidoGuitarra != null && sonidoGuitarra.isPlaying()){
            sonidoGuitarra.stop();
            sonidoGuitarra.release();
            sonidoGuitarra=null;
        }

        if (sonidoSaxofon != null && sonidoSaxofon.isPlaying()){
            sonidoSaxofon.stop();
            sonidoSaxofon.release();
            sonidoSaxofon=null;
        }

        if (sonidoTrompeta != null && sonidoTrompeta.isPlaying()){
            sonidoTrompeta.stop();
            sonidoTrompeta.release();
            sonidoTrompeta=null;
        }

        if (sonidoViolin != null && sonidoViolin.isPlaying()){
            sonidoViolin.stop();
            sonidoViolin.release();
            sonidoViolin=null;
        }
    }

}