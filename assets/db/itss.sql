drop database itss;
create database itss;
use itss;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

CREATE TABLE `phong_tap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ten_phong` varchar(30)
);

CREATE TABLE `thiet_bi` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_phong_tap` int,
  `ten` varchar(30),
  `ngay_nhap_ve` varchar(30),
  `xuat_xu` varchar(30),
  `tinh_trang` varchar(30)
);

CREATE TABLE `nhan_vien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_phong_tap` int,
  `ho_va_ten` varchar(30)
);

CREATE TABLE `phan_hoi` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_hoi_vien` int,
  `noi_dung` text
);

CREATE TABLE `hoi_vien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ho_ten` varchar(30),
  `sinh_nhat` date,
  `nghe_nghiep` varchar(30),
  `gioi_tinh` varchar(10),
  `loai_thanh_vien` varchar(30)
);

CREATE TABLE `dang_ki_goi_tap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_hoi_vien` int,
  `id_goi_tap` int,
  `ngay_dang_ki` date,
  `loai_dang_ki` varchar(30)
);

CREATE TABLE `goi_tap` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ten_goi_tap` varchar(30),
  `so_tien` int,
  `loai_goi_tap` varchar(30)
);

CREATE TABLE `thu_phi` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_hoi_vien` int,
  `id_goi_tap` int
);

CREATE TABLE `role` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ten_role` varchar(30)
);

CREATE TABLE `tai_khoan` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `tai_khoan` varchar(30),
  `mat_khau` varchar(30),
  `id_hoi_vien` int,
  `id_nhan_vien` int,
  `id_role` int
);

CREATE TABLE `lich_su` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_hoi_vien` int,
  `id_goi_tap` int,
  `ngay_su_dung` date
);



ALTER TABLE `lich_su` ADD FOREIGN KEY (`id_hoi_vien`) REFERENCES `hoi_vien` (`id`);

ALTER TABLE `dang_ki_goi_tap` ADD FOREIGN KEY (`id_hoi_vien`) REFERENCES `hoi_vien` (`id`);

ALTER TABLE `phan_hoi` ADD FOREIGN KEY (`id_hoi_vien`) REFERENCES `hoi_vien` (`id`);

ALTER TABLE `tai_khoan` ADD FOREIGN KEY (`id_hoi_vien`) REFERENCES `hoi_vien` (`id`);

ALTER TABLE `thu_phi` ADD FOREIGN KEY (`id_hoi_vien`) REFERENCES `hoi_vien` (`id`);

ALTER TABLE `tai_khoan` ADD FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhan_vien` (`id`);

ALTER TABLE `dang_ki_goi_tap` ADD FOREIGN KEY (`id_goi_tap`) REFERENCES `goi_tap` (`id`);

ALTER TABLE `thiet_bi` ADD FOREIGN KEY (`id_phong_tap`) REFERENCES `phong_tap` (`id`);

ALTER TABLE `nhan_vien` ADD FOREIGN KEY (`id_phong_tap`) REFERENCES `phong_tap` (`id`);

ALTER TABLE `tai_khoan` ADD FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);


INSERT INTO role (id, ten_role) VALUES 
(1, "Chủ phòng gym"),
(2, "Nhân viên quản lý"),
(3, "Huấn luyện viên"),
(4, "Nhân viên"),
(5, "Hội viên");

INSERT INTO phong_tap (id, ten_phong) VALUES 
(1, "Phòng tập gym"),
(2, "Phòng tập yoga"),
(3, "Phòng tập sức bền"),
(4, "Phòng tập thiền");

INSERT INTO nhan_vien (id_phong_tap, ho_va_ten) VALUES
(1, "Hoàng Danh Quân"),
(2, "Trần Tiến Ngọc"),
(2, "Phạm Quang Nhật"),
(3, "Nguyễn Hùng Tiến"),
(3, "Nguyễn Tuấn Thành"),
(4, "Phạm Thị Hải Yến");

INSERT INTO `hoi_vien`(`ho_ten`, `sinh_nhat`, `loai_thanh_vien`, `gioi_tinh`, `nghe_nghiep`) VALUES 
("Hoàng Như Nghĩa", "2002-12-01", "VIP1", "Nam", "Developer"),
("Hoàng Vân Trường", "2002-11-09", "VIP1", "Nữ", "Coder"),
("Nguyễn Quang Trường", "2002-11-11", "VIP2", "Nam", "Game thủ"),
("Trần Minh Tuấn", "2009-02-02", "VIP3", "Nam", "Sinh viên");

INSERT INTO `goi_tap`(`ten_goi_tap`, `so_tien`, `loai_goi_tap`) VALUES 
("Giảm mỡ bụng", "1000000", "Theo tháng"),
("Tăng cơ", "90000", "Theo ngày"),
("Tăng sự dẻo dai của cơ thể", "9000000", "Theo năm"),
("Tăng sức bền", "90000", "Theo ngày");

INSERT INTO `thiet_bi`(`id_phong_tap`, `ten`, `ngay_nhap_ve`, `xuat_xu`, `tinh_trang`) VALUES 
(1, "Máy chạy bộ", "2022-12-11", "Trung Quốc", "Còn sử dụng được"),
(1, "Máy chạy bộ", "2022-12-12", "Trung Quốc", "Còn sử dụng được"),
(1, "Máy tập chân", "2022-12-11", "Việt Nam", "Còn sử dụng được"),
(1, "Tạ tay", "2022-12-11", "Trung Quốc", "Còn sử dụng được"),
(1, "Tạ tay", "2022-12-11", "Trung Quốc", "Hỏng"),
(2, "Máy chạy bộ", "2022-12-11", "Trung Quốc", "Còn sử dụng được");

INSERT INTO `tai_khoan`(`tai_khoan`, `mat_khau`, `id_nhan_vien`, `id_role`) VALUES 
('admin', "1", 1, 1),
('quanly', "1", 2, 2),
('huanluyenvien', "1", 3, 3),
('nhanvien1', "1", 4, 4),
('nhanvien2', "1", 5, 4),
('nhanvien3', "1", 6, 4);

INSERT INTO `tai_khoan`(`tai_khoan`, `mat_khau`, `id_hoi_vien`, `id_role`) VALUES 
('hoivien', "1", 1, 5);

COMMIT;