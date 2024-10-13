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
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Bateria", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);

        if (sonidoBateria!=null){
            if (sonidoBateria.isPlaying()){
                sonidoBateria.stop();
                sonidoBateria=MediaPlayer.create(this, R.raw.bateria);
            }else {
                sonidoBateria.start();
            }
        }else{
            detenerSonidos();

            sonidoBateria=MediaPlayer.create(this, R.raw.bateria);
            sonidoBateria.start();
        }
    }

    public void sonidoClarinete(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Clarinete", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoClarinete!=null){
            if (sonidoClarinete.isPlaying()){
                sonidoClarinete.stop();
                sonidoClarinete=MediaPlayer.create(this, R.raw.clarinete);
            }else {
                sonidoClarinete.start();
            }
        }else{
            detenerSonidos();

            sonidoClarinete=MediaPlayer.create(this, R.raw.clarinete);
            sonidoClarinete.start();
        }
    }

    public void sonidoFlauta(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Flauta", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoFlauta!=null){
            if (sonidoFlauta.isPlaying()){
                sonidoFlauta.stop();
                sonidoFlauta=MediaPlayer.create(this, R.raw.flauta);
            }else {
                sonidoFlauta.start();
            }
        }else{
            detenerSonidos();

            sonidoFlauta=MediaPlayer.create(this, R.raw.flauta);
            sonidoFlauta.start();
        }
    }

    public void sonidoGuitarra(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Guitarra", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoGuitarra!=null){
            if (sonidoGuitarra.isPlaying()){
                sonidoGuitarra.stop();
                sonidoGuitarra=MediaPlayer.create(this, R.raw.guitarra);
            }else {
                sonidoGuitarra.start();
            }
        }else{
            detenerSonidos();

            sonidoGuitarra.create(this, R.raw.guitarra);
            sonidoGuitarra.start();
        }
    }

    public void sonidoSaxofon(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Saxofon", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoSaxofon!=null){
            if (sonidoSaxofon.isPlaying()){
                sonidoSaxofon.stop();
                sonidoSaxofon=MediaPlayer.create(this, R.raw.saxofon);
            }else {
                sonidoSaxofon.start();
            }
        }else{
            detenerSonidos();

            sonidoSaxofon=MediaPlayer.create(this, R.raw.saxofon);
            sonidoSaxofon.start();
        }
    }

    public void sonidoTrompeta(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Trompeta", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);

        if (sonidoTrompeta!=null){
            if (sonidoTrompeta.isPlaying()){
                sonidoTrompeta.stop();
                sonidoTrompeta=MediaPlayer.create(this, R.raw.trompeta);
            }else {
                sonidoTrompeta.start();
            }
        }else{
            detenerSonidos();

            sonidoTrompeta=MediaPlayer.create(this, R.raw.trompeta);
            sonidoTrompeta.start();
        }
    }

    public void sonidoViolin(View view){
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Violin", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoViolin!=null){
            if (sonidoViolin.isPlaying()){
                sonidoViolin.stop();
                sonidoViolin=MediaPlayer.create(this, R.raw.violin);
            }else {
                sonidoViolin.start();
            }
        }else{
            detenerSonidos();

            sonidoViolin=MediaPlayer.create(this, R.raw.violin);
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