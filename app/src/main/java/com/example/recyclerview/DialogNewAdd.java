package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class DialogNewAdd extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_new_add,null);

        final AutoCompleteTextView nameAdd = (AutoCompleteTextView)dialogView.findViewById(R.id.nameAdd);
        final EditText idAdd= (EditText)dialogView.findViewById(R.id.idAdd);
        final EditText dateAdd= (EditText)dialogView.findViewById(R.id.dateAdd);
        final EditText debitAdd= (EditText)dialogView.findViewById(R.id.debitAdd);
        final EditText creditAdd= (EditText)dialogView.findViewById(R.id.creditAdd);
        Button btnOK= (Button)dialogView.findViewById(R.id.btnOK);
        Button btnCancel = (Button)dialogView.findViewById(R.id.btnCancel);

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

//                MainActivity callingActivity =(MainActivity)getActivity();
//                callingActivity.createNewData(newData);
                dismiss();

            }
        });
        return builder.create();

    }

}
