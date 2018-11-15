package com.nahashon.school;

import android.content.Intent;
import android.net.Uri;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;

import java.io.File;
import java.net.URI;

import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;

public class NoteViewer extends AppCompatActivity {
    FabSpeedDial speedDial;
    PDFView pdfView;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_viewer);
        storage = FirebaseStorage.getInstance();
        String link=  getIntent().getStringExtra("link");
        final File file = new File("sam.pdf");
//        URI uri = new URI(link)
//        storage.getReferenceFromUrl(link).getFile(file).
//                addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                        load(file);
//                    }
//                });


       speedDial = findViewById(R.id.ask_teacher_fab);



       speedDial.setMenuListener(new FabSpeedDial.MenuListener() {
           @Override
           public boolean onPrepareMenu(NavigationMenu navigationMenu) {
               return true;
           }

           @Override
           public boolean onMenuItemSelected(MenuItem menuItem) {
               switch (menuItem.getItemId()){
                   case R.id.ask_teacher:
//                       Snackbar snackbar = Snackbar.make(findViewById(R.id.noteViewerConstrainedLayout),
//                               "Skip to the last page viewed", Snackbar.LENGTH_SHORT);
//                       snackbar.show();

                       startActivity(new Intent(getApplicationContext(),AskTeacher.class));
                       break;
               }
               return true;
           }

           @Override
           public void onMenuClosed() {

           }
       });
    }

    public void load(File file){
        pdfView = findViewById(R.id.pdfViewer);
        pdfView.fromFile(file).load();
    }
}
