package com.example.quiz3mon;

import android.content.Context;
import android.database.sqlite.*;
import android.database.*;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import com.example.quiz3mon.model.Result;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "QuizApp.db";
    public static final int DB_VERSION = 4;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (username TEXT PRIMARY KEY, password TEXT, role TEXT)");

        db.execSQL("CREATE TABLE IF NOT EXISTS Results (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "userId TEXT, " +
                "subject TEXT, " +
                "score INTEGER, " +
                "date TEXT)");

        db.execSQL("CREATE TABLE questions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "subject TEXT, " +
                "question TEXT, " +
                "optionA TEXT, " +
                "optionB TEXT, " +
                "optionC TEXT, " +
                "optionD TEXT, " +
                "answer TEXT" +
                ")");
        // Thêm 15 câu hỏi Tiếng Anh
        db.execSQL("INSERT INTO questions (subject, question, optionA, optionB, optionC, optionD, answer) VALUES " +
                "('English', 'What is the plural form of ''child''?', '''childs''', '''childrens''', '''children''', '''childen''', '''children''')," +
                "('English', 'Which word is an adjective?', '''run''', '''quickly''', '''happy''', '''cat''', '''happy''')," +
                "('English', 'Complete the sentence: I ___ a book yesterday.', '''read''', '''reads''', '''reading''', '''will read''', '''read''')," +
                "('English', 'What is the opposite of ''big''?', '''small''', '''tall''', '''fat''', '''thin''', '''small''')," +
                "('English', 'Choose the correct tense: She is ___ a letter.', '''write''', '''writes''', '''writing''', '''wrote''', '''writing''')," +
                "('English', 'What is the meaning of ''beneath''?', '''above''', '''beside''', '''below''', '''around''', '''below''')," +
                "('English', 'Identify the pronoun in the sentence: They are playing football.', '''are''', '''playing''', '''football''', '''They''', '''They''')," +
                "('English', 'What is the past participle of ''eat''?', '''ate''', '''eating''', '''eaten''', '''eats''', '''eaten''')," +
                "('English', 'Which of these is a vowel?', '''B''', '''C''', '''D''', '''E''', '''E''')," +
                "('English', 'What is the comparative form of ''good''?', '''gooder''', '''goodest''', '''better''', '''best''', '''better''')," +
                "('English', 'Complete the analogy: Cat is to meow as Dog is to ___', '''bark''', '''purr''', '''hiss''', '''roar''', '''bark''')," +
                "('English', 'What is the synonym of ''brave''?', '''afraid''', '''timid''', '''courageous''', '''weak''', '''courageous''')," +
                "('English', 'Choose the correct preposition: The book is ___ the table.', '''on''', '''in''', '''at''', '''under''', '''on''')," +
                "('English', 'What is the antonym of ''fast''?', '''quick''', '''rapid''', '''slow''', '''swift''', '''slow''')," +
                "('English', 'Identify the adverb in the sentence: He ran very quickly.', '''He''', '''ran''', '''very''', '''quickly''', '''quickly''')");

// Thêm 15 câu hỏi Tin học
        db.execSQL("INSERT INTO questions (subject, question, optionA, optionB, optionC, optionD, answer) VALUES " +
                "('Tin Học', 'Đâu là thiết bị đầu vào của máy tính?', '''Màn hình''', '''Máy in''', '''Loa''', '''Bàn phím''', '''Bàn phím''')," +
                "('Tin Học', 'RAM là viết tắt của từ gì?', '''Read Only Memory''', '''Random Access Memory''', '''Read Access Module''', '''Random Only Module''', '''Random Access Memory''')," +
                "('Tin Học', 'Hệ điều hành nào sau đây không phải của Microsoft?', '''Windows''', '''Linux''', '''MS-DOS''', '''Windows Server''', '''Linux''')," +
                "('Tin Học', 'Phần mềm nào dùng để soạn thảo văn bản?', '''Excel''', '''PowerPoint''', '''Word''', '''Access''', '''Word''')," +
                "('Tin Học', 'Internet là gì?', '''Một mạng lưới các máy tính trên toàn thế giới''', '''Một phần mềm duyệt web''', '''Một thiết bị phần cứng''', '''Một ngôn ngữ lập trình''', '''Một mạng lưới các máy tính trên toàn thế giới''')," +
                "('Tin Học', 'Đâu là một loại tệp hình ảnh?', '''.doc''', '''.exe''', '''.jpg''', '''.txt''', '''.jpg''')," +
                "('Tin Học', 'CPU có chức năng gì?', '''Hiển thị hình ảnh''', '''In ấn tài liệu''', '''Xử lý dữ liệu''', '''Lưu trữ thông tin''', '''Xử lý dữ liệu''')," +
                "('Tin Học', 'ROM có chức năng gì?', '''Lưu trữ dữ liệu tạm thời''', '''Lưu trữ dữ liệu chỉ đọc''', '''Xử lý dữ liệu''', '''Kết nối mạng''', '''Lưu trữ dữ liệu chỉ đọc''')," +
                "('Tin Học', 'Đơn vị đo lường dung lượng dữ liệu nhỏ nhất là gì?', '''Byte''', '''Kilobyte''', '''Megabyte''', '''Gigabyte''', '''Byte''')," +
                "('Tin Học', 'Thư điện tử còn được gọi là gì?', '''Tin nhắn văn bản''', '''Mạng xã hội''', '''Email''', '''Trình duyệt web''', '''Email''')," +
                "('Tin Học', 'HTTP là giao thức cho ứng dụng nào?', '''Truyền tệp tin''', '''Gửi thư điện tử''', '''Truy cập trang web''', '''Kết nối mạng''', '''Truy cập trang web''')," +
                "('Tin Học', 'URL là gì?', '''Địa chỉ của một trang web''', '''Tên của một trình duyệt''', '''Một loại virus máy tính''', '''Một ngôn ngữ lập trình''', '''Địa chỉ của một trang web''')," +
                "('Tin Học', 'Phím tắt Ctrl + C dùng để làm gì?', '''Cắt''', '''Dán''', '''Sao chép''', '''Lưu''', '''Sao chép''')," +
                "('Tin Học', 'Phần mềm nào sau đây là trình duyệt web?', '''Word''', '''Excel''', '''Chrome''', '''PowerPoint''', '''Chrome''')," +
                "('Tin Học', 'Mạng cục bộ LAN thường được sử dụng ở đâu?', '''Khu dân cư lớn''', '''Một quốc gia''', '''Một văn phòng hoặc tòa nhà''', '''Toàn cầu''', '''Một văn phòng hoặc tòa nhà''')");

// Thêm 15 câu hỏi Ngữ văn
        db.execSQL("INSERT INTO questions (subject, question, optionA, optionB, optionC, optionD, answer) VALUES " +
                "('Ngữ Văn', 'Bài thơ “Sóng” là của tác giả nào?', '''Xuân Diệu''', '''Huy Cận''', '''Tố Hữu''', '''Xuân Quỳnh''', '''Xuân Quỳnh''')," +
                "('Ngữ Văn', 'Trong tác phẩm “Lão Hạc”, nhân vật Lão Hạc bán gì để kiếm sống?', '''Ruộng''', '''Vườn''', '''Con chó Vàng''', '''Trâu''', '''Con chó Vàng''')," +
                "('Ngữ Văn', 'Thể loại văn học nào sử dụng ngôn ngữ có vần điệu, nhịp điệu?', '''Truyện ngắn''', '''Tiểu thuyết''', '''Thơ''', '''Kịch''', '''Thơ''')," +
                "('Ngữ Văn', 'Câu tục ngữ “Ăn quả nhớ kẻ trồng cây” khuyên chúng ta điều gì?', '''Tiết kiệm''', '''Biết ơn''', '''Trung thực''', '''Yêu thương''', '''Biết ơn''')," +
                "('Ngữ Văn', 'Tác phẩm “Chí Phèo” của nhà văn nào?', '''Nam Cao''', '''Vũ Trọng Phụng''', '''Ngô Tất Tố''', '''Tô Hoài''', '''Nam Cao''')," +
                "('Ngữ Văn', 'Nhân vật Tấm trong truyện cổ tích “Tấm Cám” là người như thế nào?', '''Hiền lành, chăm chỉ''', '''Lười biếng, độc ác''', '''Thông minh, láu cá''', '''Mạnh mẽ, quyết đoán''', '''Hiền lành, chăm chỉ''')," +
                "('Ngữ Văn', 'Biện pháp tu từ nào được sử dụng trong câu “Mặt trời xuống biển như hòn lửa”?', '''So sánh''', '''Ẩn dụ''', '''Hoán dụ''', '''Nhân hóa''', '''So sánh''')," +
                "('Ngữ Văn', 'Bài hát “Tiến quân ca” là quốc ca của nước nào?', '''Trung Quốc''', '''Hoa Kỳ''', '''Việt Nam''', '''Nga''', '''Việt Nam''')," +
                "('Ngữ Văn', 'Tác phẩm “Đoàn thuyền đánh cá” được sáng tác bởi nhà thơ nào?', '''Tế Hanh''', '''Huy Cận''', '''Xuân Diệu''', '''Chế Lan Viên''', '''Huy Cận''')," +
                "('Ngữ Văn', 'Trong truyện “Dế Mèn phiêu lưu ký”, Dế Mèn có tính cách gì nổi bật?', '''Hiền lành, nhút nhát''', '''Kiêu căng, xốc nổi''', '''Thông minh, tốt bụng''', '''Lười biếng, ích kỷ''', '''Kiêu căng, xốc nổi''')," +
                "('Ngữ Văn', '“Bút pháp tả cảnh ngụ tình” thường được nhắc đến trong thể loại văn học nào?', '''Kịch''', '''Truyện thơ''', '''Thơ Đường luật''', '''Văn nghị luận''', '''Thơ Đường luật''')," +
                "('Ngữ Văn', 'Câu thành ngữ nào sau đây có nghĩa là “gần mực thì đen, gần đèn thì sáng”?', '''Ếch ngồi đáy giếng''', '''Nước chảy đá mòn''', '''Đi một ngày đàng học một sàng khôn''', '''Ở bầu thì tròn, ở ống thì dài''', '''Ở bầu thì tròn, ở ống thì dài''')," +
                "('Ngữ Văn', 'Tác phẩm nào sau đây không phải của Nguyễn Nhật Ánh?', '''Kính vạn hoa''', '''Tôi thấy hoa vàng trên cỏ xanh''', '''Cho tôi xin một vé đi tuổi thơ''', '''Dế Mèn phiêu lưu ký''', '''Dế Mèn phiêu lưu ký''')," +
                "('Ngữ Văn', 'Nhân vật Thúy Kiều trong “Truyện Kiều” nổi tiếng với tài năng nào?', '''Hát''', '''Đàn''', '''Thơ''', '''Vẽ''', '''Đàn''')," +
                "('Ngữ Văn', 'Dòng thơ “Tre xanh xanh tự bao giờ” nằm trong bài thơ nào?', '''Tre Việt Nam''', '''Lượm''', '''Bánh trôi nước''', '''Ánh trăng''', '''Tre Việt Nam''')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS questions");
        db.execSQL("DROP TABLE IF EXISTS Results");
        onCreate(db);
    }
    public void insertResult(String subject, int score, String date, String userId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("subject", subject);
        values.put("score", score);
        values.put("date", date);
        values.put("userId", userId); // giả sử userId lưu là username
        db.insert("Results", null, values);
        db.close();
    }
    public List<Result> getUserResults(String userId) {
        List<Result> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Results WHERE userId = ? ORDER BY date DESC", new String[]{userId});
        if (cursor.moveToFirst()) {
            do {
                int subjectIndex = cursor.getColumnIndex("subject");
                int scoreIndex = cursor.getColumnIndex("score");
                int dateIndex = cursor.getColumnIndex("date");

                if (subjectIndex != -1 && scoreIndex != -1 && dateIndex != -1) {
                    String subject = cursor.getString(subjectIndex);
                    int score = cursor.getInt(scoreIndex);
                    String date = cursor.getString(dateIndex);

                    list.add(new Result(subject, score, date));
                }
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }


    public boolean registerUser(String username, String password, String role) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM users WHERE username=?", new String[]{username});
        try {
            if (c.getCount() > 0) return false;
        } finally {
            c.close();
        }

        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        values.put("role", role);
        long result = db.insert("users", null, values);
        return result != -1;
    }

    public String checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT role FROM users WHERE username=? AND password=?", new String[]{username, password});
        try {
            if (c.moveToFirst()) {
                return c.getString(0);
            }
            return null;
        } finally {
            c.close();
        }
    }

    public boolean addQuestion(String subject, String question, String a, String b, String c, String d, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("subject", subject);
        values.put("question", question);
        values.put("optionA", a);
        values.put("optionB", b);
        values.put("optionC", c);
        values.put("optionD", d);
        values.put("answer", answer);
        Log.d("DB_INSERT", "Thêm câu hỏi: " + subject + " | " + question + " | A: " + a + " | Đúng: " + answer);
        long result = db.insert("questions", null, values);
        return result != -1;
    }

    // XÓA câu hỏi theo ID
    public void deleteQuestion(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("questions", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM questions", null);
        if (cursor.moveToFirst()) {
            do {
                Question q = new Question(
                        cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                        cursor.getString(cursor.getColumnIndexOrThrow("question")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionA")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionB")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionC")),
                        cursor.getString(cursor.getColumnIndexOrThrow("optionD")),
                        cursor.getString(cursor.getColumnIndexOrThrow("answer")),
                        cursor.getString(cursor.getColumnIndexOrThrow("subject"))
                );
                list.add(q);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void updateQuestion(int id, String question, String a, String b, String c, String d, String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("question", question);
        values.put("optionA", a);
        values.put("optionB", b);
        values.put("optionC", c);
        values.put("optionD", d);
        values.put("answer", answer);
        db.update("questions", values, "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Question> getQuestionsBySubject(String subject) {
        List<Question> questions = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM questions WHERE subject=?", new String[]{subject});

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String ques = cursor.getString(cursor.getColumnIndexOrThrow("question"));
                String a = cursor.getString(cursor.getColumnIndexOrThrow("optionA"));
                String b = cursor.getString(cursor.getColumnIndexOrThrow("optionB"));
                String c = cursor.getString(cursor.getColumnIndexOrThrow("optionC"));
                String d = cursor.getString(cursor.getColumnIndexOrThrow("optionD"));
                String answer = cursor.getString(cursor.getColumnIndexOrThrow("answer"));

                questions.add(new Question(id, subject, ques, a, b, c, d, answer));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questions;
    }
}