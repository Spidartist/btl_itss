## Điều kiện tiên quyết
Máy tính đã có cài sẵn Eclipse IDE, Maven tích hơn trong Eclipse IDE.

## Tải source code về máy
Sử dụng git clone để tải source code về máy
Sau đó giải nén và mở thư mục chứa source code ra dưới dạng project bằng Eclipse IDE

## Cài đặt Xampp và MySQL
Cài đặt Xampp theo hướng dẫn tại đường link sau: [Xampp](https://www.apachefriends.org/download.html) (Khi cài Xampp thì sẽ bao gồm cả cài đặt MySQL luôn)

## Bật MySQL server từ Xampp
Sau khi cài đặt Xampp thành công, nhấn vào Xampp Control Panel (có thể tìm kiếm bằng thanh tìm kiếm) và nhấn Start ở 2 module Apache và MySQL
Sau đó nhấn vào nút Admin của module MySQL để có thể mở local server của MySQL

![image](https://github.com/Spidartist/btl_itss/assets/72654978/9e59ed12-d0e6-4983-8bdc-c27c28282973)

![image](https://github.com/Spidartist/btl_itss/assets/72654978/463c127c-e3b3-4bc2-b8e6-6ab6765bea21)

![image](https://github.com/Spidartist/btl_itss/assets/72654978/672c18c4-ab8f-474b-ab5b-3255af8af18e)

## Nhập dữ liệu từ MySQL
Tạo mới database bằng cách chọn New ở màn hình local server MySQL 
![Screenshot 2023-07-22 174410](https://github.com/Spidartist/btl_itss/assets/72654978/aa80d74d-e57e-4b97-aa12-a012a63ad5b2)

Copy nội dung từ file src/views/assets/db/itss.sql và chọn vào dán vào 
![Screenshot 2023-07-22 174539](https://github.com/Spidartist/btl_itss/assets/72654978/79481dfd-062a-4186-9592-ab8440cf274f)

![Screenshot 2023-07-22 174602](https://github.com/Spidartist/btl_itss/assets/72654978/3642b457-f0da-4433-941c-e8f8a1d1cea2)
Rồi ấn nút Go để thực thi câu lệnh MySQL

Sau đó chúng ta có thể thấy 1 database mới đã được tạo ra tên là "itss" bao gồm cấu trúc các bảng và các dữ liệu đi kèm
![image](https://github.com/Spidartist/btl_itss/assets/72654978/b4a15a85-bcdd-4cac-a14c-1b1c0800f97e)

## Chạy chương trình JAVA
Tải các thư viện cần thiết sử dụng Maven. Bạn nhấn chuột phải vào file pom.xml và chọn Maven -> Update Project. Sau đó Maven sẽ tiến hành tải các thư viện cần thiệt, việc bạn cần làm là đi pha 1 cốc cà phê.
![image](https://github.com/Spidartist/btl_itss/assets/72654978/15c5848f-36dd-4445-b4ac-5cd8f742f1ef)

Chạy chương trình bằng cách chọn file src/App.java
Bạn chuột phải vào và chọn Run Configuration
![image](https://github.com/Spidartist/btl_itss/assets/72654978/a7404bcd-cf60-4721-8b73-44194a29c9ac)

Bạn chọn sang phần Argument và paste dòng sau: --module-path
${project_classpath:btl_itss} --add-modules javafx.controls,javafx.fxml
![Screenshot 2023-07-22 175218](https://github.com/Spidartist/btl_itss/assets/72654978/8d7e55fa-c984-4a0a-aeb3-c6c834a98d89)

Sau đó nhấn vào nút Run để chạy chương trình, màn hình đăng nhập hiện ra
![image](https://github.com/Spidartist/btl_itss/assets/72654978/e8acc27c-a9fe-4e9b-8b36-91d1d5e58fea)

Bạn có thể vào table taikhoan ở database để có thể thấy thông tin đăng nhập 1 số tài khoản như sau:
![image](https://github.com/Spidartist/btl_itss/assets/72654978/10b27ffc-5ab8-47ea-aee2-7ed3ab7c9671)

Với mỗi loại tài khoản khác nhau thì bạn sẽ có các chức năng khác nhau, đó là tất cả về việc cài đặt chương trình của chúng mình!

Chúc bạn 1 ngày vui vẻ!!!!




