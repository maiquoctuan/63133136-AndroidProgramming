import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "ExpenseDB";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "transactions";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "amount INTEGER," +
                "category TEXT," +
                "description TEXT," +
                "type TEXT," +
                "date TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addTransaction(Transaction t) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("amount", t.amount);
        values.put("category", t.category);
        values.put("description", t.description);
        values.put("type", t.type);
        values.put("date", t.date);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        while (cursor.moveToNext()) {
            Transaction t = new Transaction();
            t.id = cursor.getInt(0);
            t.amount = cursor.getInt(1);
            t.category = cursor.getString(2);
            t.description = cursor.getString(3);
            t.type = cursor.getString(4);
            t.date = cursor.getString(5);
            list.add(t);
        }

        cursor.close();
        return list;
    }
}
