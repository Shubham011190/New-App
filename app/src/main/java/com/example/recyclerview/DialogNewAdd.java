package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import static android.support.v4.content.ContextCompat.getSystemService;

public class DialogNewAdd extends DialogFragment {
    private DialogNewAddListener listener;
    Database db;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_new_add,null);

        final AutoCompleteTextView nameAdd = dialogView.findViewById(R.id.nameAdd);
        final EditText idAdd= dialogView.findViewById(R.id.idAdd);
        final EditText dateAdd= dialogView.findViewById(R.id.dateAdd);
        final EditText debitAdd= dialogView.findViewById(R.id.debitAdd);
        final EditText creditAdd= dialogView.findViewById(R.id.creditAdd);
        Button btnOK= dialogView.findViewById(R.id.btnOK);
        Button btnCancel = dialogView.findViewById(R.id.btnCancel);
        db = new Database(getContext());

        builder.setView(dialogView).setMessage("Add a New info.");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Data newData = new Data();
                newData.setName(nameAdd.getText().toString());
                newData.setID(idAdd.getText().toString());
                newData.setDate(dateAdd.getText().toString());
                newData.setDebitAmt(Double.valueOf(debitAdd.getText().toString()));
                newData.setCreditAmt(Double.valueOf(creditAdd.getText().toString()));
                newData.setBalanceAmt(newData.getDebitAmt()-newData.getCreditAmt());

                listener.apply(newData);
                dismiss();
            }
        });
        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (DialogNewAddListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "Need to implement DialogNewAddListener");
        }
    }

    public interface DialogNewAddListener {
        void apply(Data data);
    }
    public void loadData(){
        Cursor mData = db.getAllData();
        while(mData.moveToNext()){
            String name = mData.getString(mData.getColumnIndex("col1"));
            String id = mData.getString(mData.getColumnIndex("col2"));
            String date = mData.getString(mData.getColumnIndex("col3"));

        }
    }


}
