package com.shanedinozzo.fastreboot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;

public class FoActivity extends ActionBarActivity {

    static Process rebootRecovery, rebootNormal, rebootDownload, rebootFastboot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo);
    } //onCreate

    public void _normalReboot(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reboot the device?\n" +
                "All unsaved data will be lost!");
        builder.setTitle("REBOOT");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    rebootNormal = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot"});
                } catch (IOException e) {
                    e.printStackTrace();
                } //try
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-NOTHING-*-*-*-*-*-*-*-*-*-*-*-*-
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_normalReboot

    public void _recoveryReboot(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reboot the device into recovery mode?\n" +
                "All unsaved data will be lost!");
        builder.setTitle("REBOOT INTO RECOVERY");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    rebootRecovery = Runtime.getRuntime().exec(new String[] {
                            "su", "-c", "reboot", "recovery"});
                } catch (IOException e) {
                    e.printStackTrace();
                } //try
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-NOTHING-*-*-*-*-*-*-*-*-*-*-*-*-
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_recoveryReboot

    public void _downloadReboot(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reboot the device into download mode?\n" +
                "All unsaved data will be lost!");
        builder.setTitle("REBOOT INTO DOWNLOAD");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    rebootDownload = Runtime.getRuntime().exec(new String[] {
                            "su", "-c", "reboot", "download"});
                } catch (IOException e) {
                    e.printStackTrace();
                } //try
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-NOTHING-*-*-*-*-*-*-*-*-*-*-*-*-
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_downloadReboot

    public void _fastbootReboot(View view) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to reboot the device into" +
                " bootloader (fastboot) mode?\nAll unsaved data will be lost!");
        builder.setTitle("REBOOT INTO BOOTLOADER");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                try {
                    rebootFastboot = Runtime.getRuntime().exec(new String[] {
                            "su", "-c", "reboot", "bootloader"});
                } catch (IOException e) {
                    e.printStackTrace();
                } //try
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-NOTHING-*-*-*-*-*-*-*-*-*-*-*-*-
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_fastbootReboot
} //FoActivity class
