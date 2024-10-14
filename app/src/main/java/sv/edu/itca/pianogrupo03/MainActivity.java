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

public class MainActivity extends AppCompatActivity {
    private MediaPlayer sonidoDo, sonidoRe, sonidoMi, sonidoFa, sonidoSol, sonidoLa, sonidoSi;
    Toast currentToast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        sonidoDo = MediaPlayer.create(this, R.raw.don);
        sonidoRe = MediaPlayer.create(this, R.raw.re);
        sonidoMi = MediaPlayer.create(this, R.raw.mi);
        sonidoFa = MediaPlayer.create(this, R.raw.fa);
        sonidoSol = MediaPlayer.create(this, R.raw.sol);
        sonidoLa = MediaPlayer.create(this, R.raw.la);
        sonidoSi = MediaPlayer.create(this, R.raw.si);

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
            Intent intent = new Intent(MainActivity.this, acercade.class);
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
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (which==1) {
                    Intent intent = new Intent(MainActivity.this, pianoInfantil.class);
                    startActivity(intent);
                } else if (which==2) {
                    Intent intent = new Intent(MainActivity.this, pianoInstrumentos.class);
                    startActivity(intent);
                }
            }
        });
        builder.create().show();
    }

    private void cambiarPiano(String tipoPiano) {
        System.out.println("piano seleccionado: "+ tipoPiano);
    }

    public void sonidoDo(View view){
        detenerSonidos();
         if (currentToast != null){
             currentToast.cancel();
         }
         currentToast=Toast.makeText(this, "Ha presionado DO", Toast.LENGTH_SHORT);
         currentToast.show();

         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 currentToast.cancel();
             }
         }, 500);

        if (sonidoDo!=null){
            if (sonidoDo.isPlaying()){
                sonidoDo.stop();
                sonidoDo=MediaPlayer.create(this, R.raw.don);
            }else {
                sonidoDo.start();
            }
        }else{
            detenerSonidos();

            sonidoDo=MediaPlayer.create(this, R.raw.don);
            sonidoDo.start();
        }
    }

    public void sonidoRe(View view){
        detenerSonidos();

        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado RE", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);
        if (sonidoRe!=null){
            if (sonidoRe.isPlaying()){
                sonidoRe.stop();
                sonidoRe=MediaPlayer.create(this, R.raw.re);
            }else {
                sonidoRe.start();
            }
        }else{
            detenerSonidos();

            sonidoRe=MediaPlayer.create(this, R.raw.re);
            sonidoRe.start();
        }
    }

    public void sonidoMi(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado MI", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);
        if (sonidoMi!=null){
            if (sonidoMi.isPlaying()){
                sonidoMi.stop();
                sonidoMi=MediaPlayer.create(this, R.raw.mi);
            }else {
                sonidoMi.start();
            }
        }else{
            detenerSonidos();

            sonidoMi=MediaPlayer.create(this, R.raw.mi);
            sonidoMi.start();
        }
    }

    public void sonidoFa(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado FA", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);

        if (sonidoFa!=null){
            if (sonidoFa.isPlaying()){
                sonidoFa.stop();
                sonidoFa=MediaPlayer.create(this, R.raw.fa);
            }else {
                sonidoFa.start();
            }
        }else{
            detenerSonidos();

            sonidoFa=MediaPlayer.create(this, R.raw.fa);
            sonidoFa.start();
        }
    }

    public void sonidoSol(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado SOL", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);

        if (sonidoSol!=null){
            if (sonidoSol.isPlaying()){
                sonidoSol.stop();
                sonidoSol=MediaPlayer.create(this, R.raw.sol);
            }else {
                sonidoSol.start();
            }
        }else{
            detenerSonidos();

            sonidoSol=MediaPlayer.create(this, R.raw.sol);
            sonidoSol.start();
        }
    }

    public void sonidoLa(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado LA", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);

        if (sonidoLa!=null){
            if (sonidoLa.isPlaying()){
                sonidoLa.stop();
                sonidoLa=MediaPlayer.create(this, R.raw.la);
            }else {
                sonidoLa.start();
            }
        }else{
            detenerSonidos();

            sonidoLa=MediaPlayer.create(this, R.raw.la);
            sonidoLa.start();
        }
    }

    public void sonidoSi(View view){
        detenerSonidos();
        if (currentToast != null){
            currentToast.cancel();
        }
        currentToast=Toast.makeText(this, "Ha presionado SI", Toast.LENGTH_SHORT);
        currentToast.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentToast.cancel();
            }
        }, 500);
        if (sonidoSi!=null){
            if (sonidoSi.isPlaying()){
                sonidoSi.stop();
                sonidoSi=MediaPlayer.create(this, R.raw.si);
            }else {
                sonidoSi.start();
            }
        }else{
            detenerSonidos();

            sonidoSi=MediaPlayer.create(this, R.raw.si);
            sonidoSi.start();
        }
    }

    private void detenerSonidos() {
        if (sonidoDo != null && sonidoDo.isPlaying()) {
            sonidoDo.stop();
            sonidoDo.release();
            sonidoDo= null;

        }
        if (sonidoRe != null && sonidoRe.isPlaying()) {
            sonidoRe.stop();
            sonidoRe.release();
            sonidoRe = null;
        }
        if (sonidoMi != null) {
            sonidoMi.stop();
            sonidoMi.release();
            sonidoMi = null;
        }
        if (sonidoFa != null) {
            sonidoFa.stop();
            sonidoFa.release();
            sonidoFa = null;
        }
        if (sonidoSol!= null) {
            sonidoSol.stop();
            sonidoSol.release();
            sonidoSol = null;
        }
        if (sonidoLa != null) {
            sonidoLa.stop();
            sonidoLa.release();
            sonidoLa = null;
        }
        if (sonidoSi != null) {
            sonidoSi.stop();
            sonidoSi.release();
            sonidoSi = null;
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if (sonidoDo != null && sonidoDo.isPlaying()){
            sonidoDo.stop();
            sonidoDo.release();
            sonidoDo=null;
        }

        if (sonidoRe != null && sonidoRe.isPlaying()){
            sonidoRe.stop();
            sonidoRe.release();
            sonidoRe=null;
        }

        if (sonidoMi != null && sonidoMi.isPlaying()){
            sonidoMi.stop();
            sonidoMi.release();
            sonidoMi=null;
        }

        if (sonidoFa != null && sonidoFa.isPlaying()){
            sonidoFa.stop();
            sonidoFa.release();
            sonidoFa=null;
        }

        if (sonidoSol != null && sonidoSol.isPlaying()){
            sonidoSol.stop();
            sonidoSol.release();
            sonidoSol=null;
        }

        if (sonidoLa != null && sonidoLa.isPlaying()){
            sonidoLa.stop();
            sonidoLa.release();
            sonidoLa=null;
        }

        if (sonidoSi != null && sonidoSi.isPlaying()){
            sonidoSi.stop();
            sonidoSi.release();
            sonidoSi=null;
        }
    }
}