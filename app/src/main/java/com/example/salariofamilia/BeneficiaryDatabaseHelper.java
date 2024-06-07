package com.example.salariofamilia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BeneficiaryDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "beneficiarios.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "Beneficiarios";
    public static final String COLUMN_ID = "beneficiarioID";
    public static final String COLUMN_NOME = "nome";
    public static final String COLUMN_CPF = "cpf";
    public static final String COLUMN_DATA_NASCIMENTO = "dataNascimento";
    public static final String COLUMN_ENDERECO = "endereco";
    public static final String COLUMN_TELEFONE = "telefone";
    public static final String COLUMN_EMAIL = "email";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NOME + " TEXT NOT NULL, " +
                    COLUMN_CPF + " TEXT NOT NULL, " +
                    COLUMN_DATA_NASCIMENTO + " TEXT NOT NULL, " +
                    COLUMN_ENDERECO + " TEXT NOT NULL, " +
                    COLUMN_TELEFONE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT NOT NULL UNIQUE);";

    public BeneficiaryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
