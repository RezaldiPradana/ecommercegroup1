INSERT INTO m_user (username, password, role, created_by, created_on)
VALUES
	('admin', 'admin', 'admin', 1, NOW()),
	('customer', 'customer', 'customer', 1, NOW());
INSERT INTO stock (item_code, product_name, product_type, quantity, price, created_by, created_on)
VALUES
    ('CLN001', 'Celana Panjang Jeans', 'Celana', 20, 150000, 1, NOW()),
    ('BJU001', 'Baju Batik Pria', 'Baju', 25, 200000, 1, NOW()),
    ('TOP001', 'Topi Trucker Hitam', 'Topi', 30, 80000, 1, NOW()),
    ('CLN002', 'Celana Pendek Cargo', 'Celana', 18, 120000, 1, NOW()),
    ('BJU002', 'Baju Kemeja Wanita', 'Baju', 22, 180000, 1, NOW()),
    ('TOP002', 'Topi Snapback Keren', 'Topi', 35, 95000, 1, NOW()),
    ('CLN003', 'Celana Kulot Putih', 'Celana', 16, 110000, 1, NOW()),
    ('BJU003', 'Baju Muslimah Modern', 'Baju', 28, 220000, 1, NOW()),
    ('BJU004', 'Baju Koko Pria Dewasa', 'Baju', 26, 190000, 1, NOW()),
    ('CLN004', 'Celana Training Olahraga', 'Celana', 19, 140000, 1, NOW()),
    ('BJU005', 'Baju Kaos Polos Anak', 'Baju', 24, 170000, 1, NOW());
 insert into cart (id_user, created_by, created_on)
 values
 	(1, 1, NOW());
 INSERT INTO cart_detail (id_cart, item_code, quantity, price, created_by, created_on)
 VALUES
 	(1, 'CLN001', 2, '30000', 1, NOW()),
 	(1, 'TOP001', 3, '240000', 1, NOW());
 