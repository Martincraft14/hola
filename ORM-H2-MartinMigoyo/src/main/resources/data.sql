-- Insertar categorías (description puede ser nulo)
INSERT INTO categories (name, description) VALUES
                                               ('Electrónica', 'Productos electrónicos y dispositivos inteligentes'),
                                               ('Ropa', 'Ropa para hombres, mujeres y niños'),
                                               ('Hogar', 'Muebles y artículos para el hogar'),
                                               ('Deportes', 'Artículos deportivos y equipamiento');

-- Insertar productos (description puede ser nulo)
INSERT INTO products (name, description, sku, price, stock) VALUES
                                                                ('Smartphone X', 'Un smartphone avanzado', 'SMX123', 699.99, 100),
                                                                ('Laptop Pro', 'Laptop de alto rendimiento', 'LPT456', 1299.99, 50),
                                                                ('Camiseta Casual', 'Camiseta cómoda y elegante', 'CCT789', 29.99, 200),
                                                                ('Pantalón Jeans', 'Jeans modernos', 'PJN012', 49.99, 150),
                                                                ('Sofá Cama', 'Sofá convertible en cama', 'SFC345', 399.99, 30),
                                                                ('Mesa de Centro', 'Mesa de centro moderna', 'MDC678', 149.99, 40),
                                                                ('Balón de Fútbol', 'Balón oficial de fútbol', 'BDF901', 19.99, 300),
                                                                ('Raqueta de Tenis', 'Raqueta profesional', 'RDT234', 89.99, 60),
                                                                ('Reloj Inteligente', 'Reloj con seguimiento de salud', 'RIN567', 199.99, 80),
                                                                ('Auriculares Inalámbricos', 'Auriculares con cancelación de ruido', 'AIN890', 149.99, 120),
                                                                ('Chaqueta de Invierno', 'Chaqueta abrigada', 'CDI123', 99.99, 70),
                                                                ('Zapatillas Running', 'Zapatillas para correr', 'ZRN456', 79.99, 90),
                                                                ('Cafetera Automática', 'Cafetera programable', 'CFA789', 89.99, 60),
                                                                ('Batidora Profesional', 'Batidora de alta potencia', 'BDP012', 129.99, 40),
                                                                ('Cinta de Correr', 'Cinta de correr plegable', 'CDC345', 499.99, 20),
                                                                ('Mancuernas Ajustables', 'Mancuernas de peso variable', 'MAN678', 59.99, 100),
                                                                ('Teclado Mecánico', 'Teclado para gaming', 'TKM901', 79.99, 150),
                                                                ('Monitor Curvo', 'Monitor curvo 32"', 'MNC234', 299.99, 30),
                                                                ('Impresora Láser', 'Impresora láser monocromo', 'IML567', 129.99, 50),
                                                                ('Router WiFi', 'Router de doble banda', 'RTW890', 79.99, 80);

-- Asignar categorías a productos
-- 10 productos en una categoría
INSERT INTO products_categories (product_id, category_id) VALUES
                                                              (1, 1), (2, 1), (3, 2), (4, 2), (5, 3), (6, 3), (7, 4), (8, 4), (9, 1), (10, 1);

-- 10 productos en dos categorías
INSERT INTO products_categories (product_id, category_id) VALUES
                                                              (11, 2), (11, 4), (12, 2), (12, 4), (13, 1), (13, 3), (14, 1), (14, 3), (15, 3), (15, 4),
                                                              (16, 3), (16, 4), (17, 1), (17, 2), (18, 1), (18, 3), (19, 1), (19, 3), (20, 1), (20, 3);

-- Insertar clientes (phone_number puede ser nulo)
INSERT INTO customers (first_name, last_name, email, password, phone_number, address) VALUES
                                                                                          ('Juan', 'Pérez', 'juan.perez@example.com', 'password123', '1234567890', 'Calle Falsa 123'),
                                                                                          ('Ana', 'Gómez', 'ana.gomez@example.com', 'password456', '0987654321', 'Avenida Siempre Viva 456'),
                                                                                          ('Carlos', 'López', 'carlos.lopez@example.com', 'password789', NULL, 'Boulevard de los Sueños 789'),
                                                                                          ('María', 'Martínez', 'maria.martinez@example.com', 'password012', '5566778899', 'Plaza Central 012');

-- Insertar un pedido con tres productos distintos
INSERT INTO orders (customer_id, order_total, order_date) VALUES
    (1, 899.97, '2023-10-01 10:00:00');

INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
                                                                         (1, 1, 1, 699.99),
                                                                         (1, 3, 2, 29.99),
                                                                         (1, 7, 1, 19.99);

-- Insertar una lista de deseos (wish_lists)
INSERT INTO wish_lists (wish_list_id, customer_id, shared,name) VALUES (1,2, true,'vellako');

-- Insertar productos en la lista de deseos
INSERT INTO  whislist_products  (product_id, wish_lists_id ) VALUES (2, 1);
INSERT INTO whislist_products  (product_id, wish_lists_id ) VALUES (5, 1);
INSERT INTO  whislist_products  (product_id, wish_lists_id ) VALUES (9, 1);

-- Insertar productos en el carro de la compra
INSERT INTO cart_items (customer_id, product_id, quantity) VALUES
                                                               (3, 4, 1),
                                                               (3, 10, 2),
                                                               (4, 12, 1),
                                                               (4, 18, 1);
-- Insertar un envío (shipment) asociado al pedido
INSERT INTO shipments (order_id, shipment_date, zip_code, city, country, state, address) VALUES
    (1, '2023-10-02 12:00:00', '28001', 'Madrid', 'España', 'Madrid', 'Calle Falsa 123');
