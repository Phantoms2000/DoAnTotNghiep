create database QLCB

create table TaiKhoan
(
	TenTaiKhoan nvarchar(50) not null primary key,
	MatKhau nvarchar(50) not null
)

create table CongNhan
(
	MaCN nvarchar(50) not null primary key,
	HoTenCN nvarchar(50) not null,
	GioiTinh char(10) not null,
	DiaChi nvarchar(50) not null,
	NamSinh int not null,
	Bac int not null
)

create table KySu
(
	MaKS nvarchar(50) not null primary key,
	HoTenKS nvarchar(50) not null,
	GioiTinh char(10) not null,
	DiaChi nvarchar(50) not null,
	NamSinh int not null,
	NganhDT nvarchar(50) not null,
	LoaiBang nvarchar(50) not null
)

create table NhanVien
(
	MaNV nvarchar(50) not null primary key,
	HoTenNV nvarchar(50) not null,
	GioiTinh char(10) not null,
	DiaChi nvarchar(50) not null,
	NamSinh int not null,
	CongViec nvarchar(50) not null
)

select * from NhanVien
select * from TaiKhoan
select * from CongNhan
select * from KySu
select * from NhanVien