package com.pitipong.android.pigfarm.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.Button;

import com.pitipong.android.pigfarm.listener.IButtonEventListener;


/**
 * Created by pw on 17/08/2017.
 */

public class MessageBox {

    private static final String TAG = "MessageBox";
    private static MessageBox instance = null;
    private AlertDialog alertDialog;

    public static MessageBox getInstance() {
        if (instance == null) {
            instance = new MessageBox();
        }
        return instance;
    }

    public AlertDialog alertMessage(String message, Activity currentActivity) {
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
            builder.setMessage(message);
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            alertDialog = builder.create();
            alertDialog.show();
            return alertDialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AlertDialog alertMessageWithLaterButton(String message, Activity currentActivity, final IButtonEventListener listener) {
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
            builder.setMessage(message);
            builder.setCancelable(false);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    listener.onClickPositive();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onClickNegative();
                    dialog.dismiss();
                }
            });

            alertDialog = builder.create();
            alertDialog.show();

            // Disable TextAllCaps
            Button buttonPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            buttonPositive.setTransformationMethod(null);

            Button buttonNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            buttonNegative.setTransformationMethod(null);

            return alertDialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AlertDialog alertMessageWithCallback(String message,
                                                String positiveButtonName,
                                                String negativeButtonName,
                                                Activity currentActivity,
                                                final IButtonEventListener listener) {
        try {
            final AlertDialog.Builder builder = new AlertDialog.Builder(currentActivity);
            builder.setMessage(message);
            builder.setCancelable(false);
            builder.setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    listener.onClickPositive();
                }
            });
            builder.setNegativeButton(negativeButtonName , new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    listener.onClickNegative();
                    dialog.dismiss();
                }
            });

            alertDialog = builder.create();
            alertDialog.show();

            // Disable TextAllCaps
            Button buttonPositive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            buttonPositive.setTransformationMethod(null);

            Button buttonNegative = alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
            buttonNegative.setTransformationMethod(null);

            return alertDialog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
