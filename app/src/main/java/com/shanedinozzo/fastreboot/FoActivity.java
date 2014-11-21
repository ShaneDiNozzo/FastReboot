package com.shanedinozzo.fastreboot;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import java.io.IOException;

public class FoActivity extends ActionBarActivity {

    static Process rebootRecovery, rebootNormal, rebootDownload, rebootFastboot;
    static String message, title, rebootType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fo);
    } //onCreate

    @SuppressWarnings("UnusedParameters")
    public String _normalReboot(View view) {

        message = "Are you sure you want to reboot the device?\nAll unsaved data will be lost!";
        title = "REBOOT";
        rebootType = "normal";

        _alertDialog(message, title);

        return rebootType;
    } //_normalReboot

    @SuppressWarnings("UnusedParameters")
    public String _recoveryReboot(View view) {

        message = "Are you sure you want to reboot the device into recovery mode?\n" +
                "All unsaved data will be lost!";
        title = "REBOOT INTO RECOVERY";
        rebootType = "recovery";

        _alertDialog(message, title);

        return rebootType;
    } //_recoveryReboot

    @SuppressWarnings("UnusedParameters")
    public String  _fastbootReboot(View view) {

        message = "Are you sure you want to reboot the device into" +
                " bootloader (fastboot) mode?\nAll unsaved data will be lost!";
        title = "REBOOT INTO BOOTLOADER";
        rebootType = "fastboot";

        _alertDialog(message, title);

        return rebootType;
    } //_fastbootReboot

    @SuppressWarnings("UnusedParameters")
    public String _downloadReboot(View view) {

        message = "Are you sure you want to reboot the device into download mode?\n" +
                "All unsaved data will be lost!\n\n" +
                "WARNING:\nThis function can be used only on Samsung phones!";
        title = "REBOOT INTO DOWNLOAD";
        rebootType = "download";

        _alertDialog(message, title);

        return rebootType;
    } //_downloadReboot

    public void _alertDialog(String message, String title) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                _rebooter(rebootType);
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-NOTHING-*-*-*-*-*-*-*-*-*-*-*-*-
            } //onClick
        }); //DialogInterface.OnClickListener
        builder.create().show();
    } //_alertDialog

    public void _rebooter(String rebootType) {

        switch (rebootType) {
            case "normal":
                try {
                    rebootNormal = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot"});
                } catch (IOException e) {
                    //
                } //try

                break;
            case "recovery":
                try {
                    rebootRecovery = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot",
                            "recovery"});
                } catch (IOException e) {
                    //
                } //try

                break;
            case "bootloader":
                try {
                    rebootFastboot = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot",
                            "bootloader"});
                } catch (IOException e) {
                    //
                } //try

                break;
            case "download":
                try {
                    rebootDownload = Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot",
                            "download"});
                } catch (IOException e) {
                    //
                } //try

                break;
        } //switch rebootType
    } //_rebooter
} //FoActivity class
