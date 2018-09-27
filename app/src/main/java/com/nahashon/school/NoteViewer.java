package com.nahashon.school;

import android.content.Intent;
import android.support.design.internal.NavigationMenu;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.github.yavski.fabspeeddial.FabSpeedDial;
import io.github.yavski.fabspeeddial.SimpleMenuListenerAdapter;

public class NoteViewer extends AppCompatActivity {
    FabSpeedDial speedDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_viewer);

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
}
