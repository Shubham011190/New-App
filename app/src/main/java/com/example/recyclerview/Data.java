package com.example.recyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private String name;
    private String date;
    private String ID;
    private Double debitAmt;
    private Double creditAmt;
    private Double balanceAmt;


    protected Data(Parcel in) {
        name = in.readString();
        date = in.readString();
        ID = in.readString();
        if (in.readByte() == 0) {
            debitAmt = null;
        } else {
            debitAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            creditAmt = null;
        } else {
            creditAmt = in.readDouble();
        }
        if (in.readByte() == 0) {
            balanceAmt = null;
        } else {
            balanceAmt = in.readDouble();
        }
    }

    public static final Creator<Data> CREATOR = new Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };

    public Data() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getDebitAmt() {
        return debitAmt;
    }

    public void setDebitAmt(Double debitAmt) {
        this.debitAmt = debitAmt;
    }

    public Double getCreditAmt() {
        return creditAmt;
    }

    public void setCreditAmt(Double creditAmt) {
        this.creditAmt = creditAmt;
    }

    public Double getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(Double balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(ID);
        if (debitAmt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(debitAmt);
        }
        if (creditAmt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(creditAmt);
        }
        if (balanceAmt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(balanceAmt);
        }
    }
}
