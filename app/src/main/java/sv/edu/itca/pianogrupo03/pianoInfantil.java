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

public class pianoInfantil extends AppCompatActivity {
    private MediaPlayer sonidoMave, sonidomElefante, sonidomGrillo, sonidoMleon, sonidoMmono, sonidoMrana, sonidoMserpiente;
    Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_piano_infantil);

        sonidoMave = MediaPlayer.create(this, R.raw.ave);
        sonidomElefante = MediaPlayer.create(this, R.raw.elefante);
        sonidomGrillo = MediaPlayer.create(this, R.raw.grillo);
        sonidoMleon = MediaPlayer.create(this, R.raw.leon);
        sonidoMmono = MediaPlayer.create(this, R.raw.mono);
        sonidoMrana = MediaPlayer.create(this, R.raw.rana);
        sonidoMserpiente = MediaPlayer.create(this, R.raw.serpiente);

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
            Intent intent = new Intent(pianoInfantil.this, acercade.class);
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
                            Intent intent = new Intent(pianoInfantil.this, MainActivity.class);
                            startActivity(intent);
                        } else if (which==1) {
                            Intent intent = new Intent(pianoInfantil.this, pianoInfantil.class);
                            startActivity(intent);
                        } else if (which==2) {
                            Intent intent = new Intent(pianoInfantil.this, pianoInstrumentos.class);
                            startActivity(intent);
                        }
                    }
                });
        builder.create().show();
    }

    private void cambiarPiano(String tipoPiano) {
        System.out.println("piano seleccionado: "+ tipoPiano);
    }





    public void sonidoAve(View view) {
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast= Toast.makeText(this, "Sonido Ave", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoMave!=null){
            if (sonidoMave.isPlaying()){
                sonidoMave.stop();
                sonidoMave=MediaPlayer.create(this, R.raw.ave);
            }else {
                sonidoMave.start();
            }
        }else{
            detenerSonidos();

            sonidoMave=MediaPlayer.create(this, R.raw.ave);
            sonidoMave.start();
        }

    }


    public void sonidoElefante(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Elefante", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidomElefante!=null){
            if (sonidomElefante.isPlaying()){
                sonidomElefante.stop();
                sonidomElefante=MediaPlayer.create(this, R.raw.elefante);
            }else {
                sonidomElefante.start();
            }
        }else{
            detenerSonidos();

            sonidomElefante=MediaPlayer.create(this, R.raw.elefante);
            sonidomElefante.start();
        }
    }


    public void sonidoGrillo(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Grillo", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidomGrillo!=null){
            if (sonidomGrillo.isPlaying()){
                sonidomGrillo.stop();
                sonidomGrillo=MediaPlayer.create(this, R.raw.grillo);
            }else {
                sonidomGrillo.start();
            }
        }else {
            detenerSonidos();

            sonidomGrillo=MediaPlayer.create(this, R.raw.grillo);
            sonidomGrillo.start();
        }


    }

    public void sonidoLeon(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Leon", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoMleon!=null){
            if (sonidoMleon.isPlaying()){
                sonidoMleon.stop();
                sonidoMleon=MediaPlayer.create(this, R.raw.leon);
            }else {
                sonidoMleon.start();
            }
        }else {
            detenerSonidos();

            sonidoMleon=MediaPlayer.create(this, R.raw.leon);
            sonidoMleon.start();
        }
    }

    public void sonidoMono(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Mono", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoMmono!=null){
            if (sonidoMmono.isPlaying()){
                sonidoMmono.stop();
                sonidoMmono=MediaPlayer.create(this, R.raw.mono);
            }else {
                sonidoMmono.start();
            }
        }else {
            detenerSonidos();

            sonidoMmono=MediaPlayer.create(this, R.raw.mono);
            sonidoMmono.start();
        }
    }

    public void sonidoRana(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Rana", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoMrana!=null){
            if (sonidoMrana.isPlaying()){
                sonidoMrana.stop();
                sonidoMrana=MediaPlayer.create(this, R.raw.rana);
            }else {
                sonidoMrana.start();
            }
        }else {
            detenerSonidos();

            sonidoMrana=MediaPlayer.create(this, R.raw.rana);
            sonidoMrana.start();
        }
    }

    public void sonidoSerpiente(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "sonido Serpiente", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 700);
        if (sonidoMserpiente!=null){
            if (sonidoMserpiente.isPlaying()){
                sonidoMserpiente.stop();
                sonidoMserpiente=MediaPlayer.create(this, R.raw.serpiente);
            }else {
                sonidoMserpiente.start();
            }
        }else {
            detenerSonidos();

            sonidoMserpiente=MediaPlayer.create(this, R.raw.serpiente);
            sonidoMserpiente.start();
        }
    }

    private void detenerSonidos() {
        if (sonidoMave != null && sonidoMave.isPlaying()) {
            sonidoMave.stop();
            sonidoMave.release();
            sonidoMave = null;

        }
        if (sonidomElefante != null && sonidomElefante.isPlaying()) {
            sonidomElefante.stop();
            sonidomElefante.release();
            sonidomElefante = null;
        }
        if (sonidomGrillo != null) {
            sonidomGrillo.stop();
            sonidomGrillo.release();
            sonidomGrillo = null;
        }
        if (sonidoMleon != null) {
            sonidoMleon.stop();
            sonidoMleon.release();
            sonidoMleon = null;
        }
        if (sonidoMmono != null) {
            sonidoMmono.stop();
            sonidoMmono.release();
            sonidoMmono = null;
        }
        if (sonidoMrana != null) {
            sonidoMrana.stop();
            sonidoMrana.release();
            sonidoMrana = null;
        }
        if (sonidoMserpiente != null) {
            sonidoMserpiente.stop();
            sonidoMserpiente.release();
            sonidoMserpiente = null;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (sonidoMave != null && sonidoMave.isPlaying()){
            sonidoMave.stop();
            sonidoMave.release();
            sonidoMave=null;
        }

        if (sonidomElefante != null && sonidomElefante.isPlaying()){
            sonidomElefante.stop();
            sonidomElefante.release();
            sonidomElefante=null;
        }

        if (sonidomGrillo != null && sonidomGrillo.isPlaying()){
            sonidomGrillo.stop();
            sonidomGrillo.release();
            sonidomGrillo=null;
        }

        if (sonidoMleon != null && sonidoMleon.isPlaying()){
            sonidoMleon.stop();
            sonidoMleon.release();
            sonidoMleon=null;
        }

        if (sonidoMmono != null && sonidoMmono.isPlaying()){
            sonidoMmono.stop();
            sonidoMmono.release();
            sonidoMmono=null;
        }

        if (sonidoMrana != null && sonidoMrana.isPlaying()){
            sonidoMrana.stop();
            sonidoMrana.release();
            sonidoMrana=null;
        }

        if (sonidoMserpiente != null && sonidoMserpiente.isPlaying()){
            sonidoMserpiente.stop();
            sonidoMserpiente.release();
            sonidoMserpiente=null;
        }
    }


}