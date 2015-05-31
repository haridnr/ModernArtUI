package com.example.hkr.modernartui;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView rec1 = (TextView)findViewById(R.id.rec1);
        final TextView rec2 = (TextView)findViewById(R.id.rec2);
        final TextView rec4 = (TextView)findViewById(R.id.rec4);
        final TextView rec5 = (TextView)findViewById(R.id.rec5);
        final TextView rec6 = (TextView)findViewById(R.id.rec6);

        SeekBar bar = (SeekBar)findViewById(R.id.gradient_bar);

        ColorDrawable cd1 = (ColorDrawable) rec1.getBackground();
        final int rec1_color = cd1.getColor();
        final int a1 = Color.alpha(rec1_color);
        final int r1 = Color.red(rec1_color);
        final int g1 = Color.green(rec1_color);
        final int b1 = Color.blue(rec1_color);

        ColorDrawable cd2 = (ColorDrawable) rec2.getBackground();
        final int rec2_color = cd2.getColor();
        final int a2 = Color.alpha(rec2_color);
        final int r2 = Color.red(rec2_color);
        final int g2 = Color.green(rec2_color);
        final int b2 = Color.blue(rec2_color);

        ColorDrawable cd4 = (ColorDrawable) rec4.getBackground();
        final int rec4_color = cd4.getColor();
        final int a4 = Color.alpha(rec4_color);
        final int r4 = Color.red(rec4_color);
        final int g4 = Color.green(rec4_color);
        final int b4 = Color.blue(rec4_color);

        ColorDrawable cd5 = (ColorDrawable) rec5.getBackground();
        final int rec5_color = cd5.getColor();
        final int a5 = Color.alpha(rec5_color);
        final int r5 = Color.red(rec5_color);
        final int g5 = Color.green(rec5_color);
        final int b5 = Color.blue(rec5_color);

        ColorDrawable cd6 = (ColorDrawable) rec6.getBackground();
        final int rec6_color = cd6.getColor();
        final int a6 = Color.alpha(rec6_color);
        final int r6 = Color.red(rec6_color);
        final int g6 = Color.green(rec6_color);
        final int b6 = Color.blue(rec6_color);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChanged = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){

                rec1.setBackgroundColor(Color.argb(a1, r1+progress, g1+progress, b1+progress));
                rec2.setBackgroundColor(Color.argb(a2, r2+progress, g2+progress, b2+progress));
                rec4.setBackgroundColor(Color.argb(a4, r4+progress, g4+progress, b4+progress));
                rec5.setBackgroundColor(Color.argb(a5, r5+progress, g5+progress, b5+progress));
                rec6.setBackgroundColor(Color.argb(a6, r6+progress, g6+progress, b6+progress));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public static class AlertDialogFragment extends DialogFragment {

        public static AlertDialogFragment newInstance() {
            return new AlertDialogFragment();
        }

        // Build AlertDialog using AlertDialog.Builder
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setMessage("Visit the MOMA website for more information")

                            // User cannot dismiss dialog by hitting back button
                    .setCancelable(false)
                            // Set up Yes Button
                    .setPositiveButton("Visit MOMA",
                            new DialogInterface.OnClickListener() {
                                public void onClick(
                                        final DialogInterface dialog, int id) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                                    startActivity(browserIntent);
                                }
                            })
                            // Set up No Button
                    .setNegativeButton("Not Now",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {

                                }
                            })
                    .create();
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.context_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        AlertDialogFragment mDialog = AlertDialogFragment.newInstance();

        // Show AlertDialogFragment
        mDialog.show(getFragmentManager(), "Alert");


        return super.onOptionsItemSelected(item);
    }
}
