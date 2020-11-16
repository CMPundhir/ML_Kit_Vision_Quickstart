package com.google.mlkit.vision.demo.utils;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.mlkit.vision.demo.R;

import java.util.List;

public class CommonDialog {
    public static AlertDialog myDialog(Context context, String title, String msg, String pB,
                                       String nB) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            if (((Activity) context).isDestroyed() || ((Activity) context).isFinishing()) {
                return null;
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg);
        if (pB != null) {
            builder.setPositiveButton(pB, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }
        if (nB != null) {
            builder.setNegativeButton(nB, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        }
        AlertDialog dialog = builder.create();
        dialog.show();
        return dialog;
    }

    public static AlertDialog myDialog(Context context, String title, String msg) {
        return myDialog(context, title, msg, "Ok", null);
    }


    public static AlertDialog myDialog(Context context, String title, String msg, String pB,
                                       String nB, DialogInterface.OnClickListener pListener,
                                       DialogInterface.OnClickListener nListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg);
        if (pB != null) {
            builder.setPositiveButton(pB, pListener);
        }
        if (nB != null) {
            builder.setNegativeButton(nB, nListener);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog myDialog(Context context, String title, String msg, String pB,
                                       String nB, String nuB,
                                       DialogInterface.OnClickListener pListener,
                                       DialogInterface.OnClickListener nListener,
                                       DialogInterface.OnClickListener nuListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg);
        if (pB != null) {
            builder.setPositiveButton(pB, pListener);
        }
        if (nB != null) {
            builder.setNegativeButton(nB, nListener);
        }
        if (nuB != null) {
            builder.setNeutralButton(nuB, nuListener);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static AlertDialog myDialog(Context context, String title, String msg, String pB,
                                       String nB, DialogInterface.OnClickListener pListener,
                                       DialogInterface.OnClickListener nListener,
                                       DialogInterface.OnDismissListener dismissListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(msg);
        if (pB != null) {
            builder.setPositiveButton(pB, pListener);
        }
        if (nB != null) {
            builder.setNegativeButton(nB, nListener);
        }
        if (dismissListener != null) {
            builder.setOnDismissListener(dismissListener);
        }
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return alertDialog;
    }

    public static Dialog getCustomDialog(Context context, int layout) {
        Dialog dialog;
        dialog = new Dialog(context, android.R.style.Theme_Material_Light_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        dialog.setCancelable(true);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        return dialog;
    }

    public static Dialog showFormData(final Context context, List<String> textList, List<String> qrList){
        Dialog dialog = getCustomDialog(context, R.layout.dialog_form_data);
        RecyclerView recyclerView = dialog.findViewById(R.id.recyclerView);
        Button bCancel = dialog.findViewById(R.id.bCancel);
        Button bSubmit = dialog.findViewById(R.id.bSubmit);
        FormRecyclerAdapter adapter = new FormRecyclerAdapter(context, textList, qrList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).finish();
            }
        });

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity)context).finish();
            }
        });

        return dialog;
    }



}
