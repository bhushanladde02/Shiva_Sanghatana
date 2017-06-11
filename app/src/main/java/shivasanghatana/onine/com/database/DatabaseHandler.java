package shivasanghatana.onine.com.database;
 
import java.util.ArrayList;
import java.util.List;


 



import shivasanghatana.onine.com.pojo.DataShiva;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
 
public class DatabaseHandler extends SQLiteOpenHelper {
 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "lostDatabase";
 
    private static final String TABLE_REGISTER = "SHIVADB";   
    private static final String idvalue ="IDVALUE";
    private static final String datevalue  ="DATEVALUE";
    private static final String name ="NAME";
    private static final String title ="TITLE";
    private static final String details ="DETAILS";
    
 
 
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
    	String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_REGISTER + "("+idvalue+" INTEGER PRIMARY KEY,"+
    			datevalue+" TEXT,"+ name +" TEXT,"+title+" TEXT," +details +" TEXT)";
    	System.out.println("Final Table Creation Query ::::::::::::::::::::::"+CREATE_CONTACTS_TABLE);
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);
 
        // Create tables again
        onCreate(db);
    }
    
    
    public void truncatTable() {
    	SQLiteDatabase db = this.getWritableDatabase();
        // Drop older table if existed
        db.execSQL("delete from  " + TABLE_REGISTER);
        db.close();
        // Create tables again
       
    }
 
    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */
 
    
    public long add(DataShiva register) {
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println("I am inside insertion of data");
        ContentValues values = new ContentValues();
        values.put(idvalue ,new Integer(register.getId()));
        values.put(datevalue  ,register.getLastUpdatedDt() );
        values.put(name ,register.getPerson() );
        values.put(title ,register.getHeaderValue() );
        values.put(details ,register.getNewsDetails() );
        
        // Inserting Row
       long l= db.insert(TABLE_REGISTER, null, values);
        db.close();
        return l;// Closing database connection
    }

   public DataShiva get(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
 
        Cursor cursor = db.query(TABLE_REGISTER, new String[] {title,details,idvalue,datevalue,name}, idvalue + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
 
        DataShiva register = new DataShiva(cursor.getString(0),
        		cursor.getString(1),
        		cursor.getString(2),
        		"".toString(), 
        		cursor.getString(3), 
        		cursor.getString(4));
        
    /*    DataShiva(String headerValue, String newsDetails, String id, 		String authValue, String lastUpdatedDt, String person */       
        // return contact
        return register;
    }
   
 
    // Getting All Contacts
    public List<DataShiva> getAll() {
        List<DataShiva> registerList = new ArrayList<DataShiva>();
        // Select All Query
        String selectQuery = "SELECT "+idvalue+","+datevalue+","+name+","+title+","+details+" FROM " + TABLE_REGISTER ;//+" ORDER BY "+idvalue+" DESC" ;
 
       // Cursor c = scoreDb.query(DATABASE_TABLE, rank, null, null, null, null, yourColumn+" DESC");
        String str[]={idvalue,datevalue,name,title,details};
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        //Cursor cursor = db.query(TABLE_REGISTER,str, null, null, null, null, idvalue+" ASC");
 
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                DataShiva register = new DataShiva();
                register.setId(cursor.getString(0));
                register.setLastUpdatedDt(cursor.getString(1));
                register.setPerson(cursor.getString(2));
                register.setHeaderValue(cursor.getString(3));
                register.setNewsDetails(cursor.getString(4));
                
               /* System.out.println("***************cursor.getString(0)************" +cursor.getString(0));
                System.out.println("***************cursor.getString(1)************" +cursor.getString(1));
                
                System.out.println("***************cursor.getString(2)************" +cursor.getString(2));
                System.out.println("***************cursor.getString(3)************" +cursor.getString(3));
                System.out.println("***************cursor.getString(4)************" +cursor.getString(4));
                */
                // Adding contact to list
                registerList.add(register);
            } while (cursor.moveToNext());
        }
 
        // return contact list
        return registerList;
    }
 
    
   

    public int update(DataShiva register) {
        SQLiteDatabase db = this.getWritableDatabase();
 
        ContentValues values = new ContentValues();
        values.put(idvalue ,register.getId() );
        values.put(datevalue  ,register.getLastUpdatedDt() );
        values.put(name ,register.getPerson() );
        values.put(title ,register.getHeaderValue() );
        values.put(details ,register.getNewsDetails());
 
 
        // updating row
        return db.update(TABLE_REGISTER, values, idvalue + " = ?",
                new String[] { String.valueOf(register.getId()) });
    }
 
    public void delete(DataShiva contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_REGISTER, idvalue + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }
    
    public void deleteQuery(String[] delete) {
        SQLiteDatabase db = this.getWritableDatabase();
        String args = TextUtils.join(", ", delete);
        
        db.execSQL(String.format("DELETE FROM "+TABLE_REGISTER+" WHERE "+idvalue+" IN (%s);", args));
        db.close();
        
    }
 
    
    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_REGISTER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
     // return count
        int p= cursor.getCount();
        cursor.close();
        return p;
        
    }
}