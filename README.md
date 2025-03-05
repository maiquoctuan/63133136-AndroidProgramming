# 63133136-AndroidProgramming
Lưu các bài thực hành, bài tập AndroidProgram
<h1 align="center">👋 Hi there! I'm Mai Quốc Tuấn </h1>
<h3 align="center">💻 Android Developer | Information Systems Student </h3>

---

### 🧑‍💻 About Me
- 🎓 I'm currently a student at **Nha Trang University** majoring in **Information Systems**.
- 🔍 Passionate about **Web Development**, **Mobile App Development** and **Information Systems**.
- 📌 Working on my **Graduation Thesis: Job Recruitment System in Nha Trang City**.

---

### 🌐 Connect with me:
[![Facebook](https://img.shields.io/badge/Facebook-1877F2?style=for-the-badge&logo=facebook&logoColor=white)](https://www.facebook.com/tuan.mq.5/)
[![GitHub](https://img.shields.io/badge/GitHub-171515?style=for-the-badge&logo=github&logoColor=white)](https://github.com/maiquoctuan)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/maiquoctuan)

---

### 📈 GitHub Stats
<p align="center">
<img src="https://github-readme-stats.vercel.app/api?username=maiquoctuan&show_icons=true&theme=radical" alt="GitHub Stats"/>
<img src="https://github-readme-streak-stats.herokuapp.com/?user=maiquoctuan&theme=radical" alt="GitHub Streak"/>
</p>

---

### 💪 Languages and Tools:
<p align="center">
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
<img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
<img src="https://img.shields.io/badge/SQLite-07405E?style=for-the-badge&logo=sqlite&logoColor=white"/>
<img src="https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white"/>
</p>

## Ex4_AddSubMulDiv_Onclick

### Mô tả
Ứng dụng thực hiện các phép tính cộng, trừ, nhân, chia giữa hai số sử dụng sự kiện `OnClickListener`.

### Giao diện ứng dụng

| Phép tính | Kết quả |
|-----------|---------|
| Cộng      | 28.0    |
| Trừ       | 16.0    |
| Nhân      | 132.0   |
| Chia      | 3.6667  |

### Hình ảnh minh họa

- Phép cộng:

![Phép cộng](C:\Users\ASUS\Pictures\Screenshots\Screenshot 2025-03-05 163027.png)

- Phép trừ:

![Phép trừ](C:\Users\ASUS\Pictures\Screenshots\Screenshot 2025-03-05 163044.png)

- Phép nhân:

![Phép nhân](C:\Users\ASUS\Pictures\Screenshots\Screenshot 2025-03-05 163100.png)

- Phép chia:

![Phép chia](C:\Users\ASUS\Pictures\Screenshots\Screenshot 2025-03-05 163126.png)

### Code chính

```java
public class MainActivity extends AppCompatActivity {
    EditText edtSo1, edtSo2;
    TextView txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSo1 = findViewById(R.id.edtSo1);
        edtSo2 = findViewById(R.id.edtSo2);
        txtResult = findViewById(R.id.txtResult);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(view -> calculate("+") );
        btnSub.setOnClickListener(view -> calculate("-") );
        btnMul.setOnClickListener(view -> calculate("*") );
        btnDiv.setOnClickListener(view -> calculate("/") );
    }

    private void calculate(String operator) {
        double so1 = Double.parseDouble(edtSo1.getText().toString());
        double so2 = Double.parseDouble(edtSo2.getText().toString());
        double result = 0;

        switch (operator) {
            case "+": result = so1 + so2; break;
            case "-": result = so1 - so2; break;
            case "*": result = so1 * so2; break;
            case "/": result = so1 / so2; break;
        }
        txtResult.setText(String.valueOf(result));
    }
}
```

### Nhận xét
- Ứng dụng hoạt động đúng với yêu cầu bài tập.
- Giao diện đơn giản, dễ sử dụng.
---

⭐️ *Cảm ơn bạn đã ghé thăm!* 😊
