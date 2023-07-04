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
  `id_role` int,
  `id_phong_tap` int
);

CREATE TABLE `phan_hoi` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `id_hoi_vien` int
);

CREATE TABLE `hoi_vien` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `ho_ten` varchar(30),
  `tuoi` int,
  `sinh_nhat` date,
  `loai_thanh_vien` varchar(30),
  `id_role` int
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
  `id_hoi_vien` int
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
  `id_nhan_vien` int
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

ALTER TABLE `nhan_vien` ADD FOREIGN KEY (`id_role`) REFERENCES `role` (`id`);

ALTER TABLE `tai_khoan` ADD FOREIGN KEY (`id_nhan_vien`) REFERENCES `nhan_vien` (`id`);

ALTER TABLE `dang_ki_goi_tap` ADD FOREIGN KEY (`id_goi_tap`) REFERENCES `goi_tap` (`id`);

ALTER TABLE `thiet_bi` ADD FOREIGN KEY (`id_phong_tap`) REFERENCES `phong_tap` (`id`);

ALTER TABLE `nhan_vien` ADD FOREIGN KEY (`id_phong_tap`) REFERENCES `phong_tap` (`id`);
