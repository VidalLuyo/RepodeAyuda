create database T08_SistemaVentas;
use T08_SistemaVentas;


--Tabla Proveedores
create table Suppliers (
    id int identity(1,1),
    document_type char(3) not null check (document_type in ('DNI', 'CNE')),
    document_number varchar(15) not null,
    gender char(1) not null check (gender in ('M', 'F')),
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    phone char(9) not null,
    location varchar(100) not null,
    status char(1) default 'A' check (status in ('A', 'I')),
    CONSTRAINT pk_suppliers_id PRIMARY KEY (id)
);

-- Restricciones adicionales
ALTER TABLE Suppliers ADD CONSTRAINT chk_document_number 
CHECK (
    (document_type = 'DNI' AND document_number like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]' AND len(document_number) = 8) OR 
    (document_type = 'CNE' AND document_number like '[0-9]%' AND len(document_number) <= 15)
);

ALTER TABLE Suppliers ADD CONSTRAINT chk_first_name_letters 
CHECK (first_name like '%[A-Za-zñÑáéíóúÁÉÍÓÚ]%');

ALTER TABLE Suppliers ADD CONSTRAINT chk_last_name_letters 
CHECK (last_name like '%[A-Za-zñÑáéíóúÁÉÍÓÚ]%');

ALTER TABLE Suppliers ADD CONSTRAINT chk_phone_digits
CHECK (phone like '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]');
    
-- Inserción de 10 datos reales 
insert into Suppliers (document_type, document_number, gender, first_name, last_name, phone, location) 
values 
('DNI', '12345678', 'M', 'Juan', 'Pérez', '912345678', 'Lima, Peru'),
('CNE', '987654321012345', 'F', 'Maria', 'Gonzalez', '923456789', 'Arequipa, Peru'),
('DNI', '23456789', 'F', 'Ana', 'Sanchez', '934567891', 'Cusco, Peru'),
('DNI', '34567890', 'M', 'Carlos', 'Ramirez', '945678912', 'Trujillo, Peru'),
('CNE', '54321678912345', 'F', 'Luisa', 'Fernandez', '956789123', 'Piura, Peru'),
('DNI', '45678901', 'M', 'Miguel', 'Torres', '967891234', 'Chiclayo, Peru'),
('DNI', '56789012', 'F', 'Patricia', 'Flores', '978912345', 'Huancayo, Peru'),
('CNE', '87654321098765', 'M', 'Alberto', 'Vega', '989123456', 'Tacna, Peru'),
('DNI', '67890123', 'M', 'Ricardo', 'Medina', '991234567', 'Chimbote, Peru'),
('CNE', '65432109876543', 'F', 'Laura', 'Rios', '912345678', 'Ica, Peru');


select * from Suppliers;

-- Tabla registro

CREATE TABLE Registro (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT GETDATE(),
    status CHAR(1) DEFAULT 'A' CHECK (status IN ('A', 'I')) -- 'A' para activo, 'I' para inactivo
);

INSERT INTO Registro (username, password, email, first_name, last_name)
VALUES ('VidalLuyo', 'admin123', 'vidal.luyo@gmail.com', 'Vidal', 'Luyo');

select * from Registro;

-- Tabla Cliente
drop table Client
CREATE TABLE Client (
    ClientID INT IDENTITY(1,1) PRIMARY KEY,
    ClientCode CHAR(10) NULL,
    DocumentType CHAR(3) NOT NULL,
    DocumentNumber VARCHAR(20) NOT NULL UNIQUE,
    FirstName VARCHAR(150) NOT NULL,
    LastName VARCHAR(150) NOT NULL,
    BirthDate DATE NOT NULL,
    Email VARCHAR(100) NULL,
    Phone CHAR(9) NULL,
    Phone2 CHAR(9) NULL,
    Address VARCHAR(200) NULL,
    Status CHAR(1) default 'A' NOT NULL,
    RegistrationDate DATETIME DEFAULT GETDATE()
);


ALTER TABLE Client
ADD CONSTRAINT CK_DocumentType CHECK (DocumentType IN ('DNI', 'CNE'));

ALTER TABLE Client
ADD CONSTRAINT CK_DocumentNumber CHECK (
    (DocumentType = 'DNI' AND LEN(DocumentNumber) = 8 AND DocumentNumber NOT LIKE '%[^0-9]%') OR
    (DocumentType = 'CNE' AND LEN(DocumentNumber) <= 20 AND DocumentNumber NOT LIKE '%[^0-9]%')
);

ALTER TABLE Client
ADD CONSTRAINT CK_FirstName CHECK (FirstName NOT LIKE '%[^a-zA-ZñÑáéíóúÁÉÍÓÚ ]%');

ALTER TABLE Client
ADD CONSTRAINT CK_LastName CHECK (LastName NOT LIKE '%[^a-zA-ZñÑáéíóúÁÉÍÓÚ ]%');

ALTER TABLE Client
ADD CONSTRAINT CK_Email CHECK (Email IS NULL OR Email LIKE '%_@__%.__%');

ALTER TABLE Client
ADD CONSTRAINT CK_Phone CHECK (Phone LIKE '9%' AND LEN(Phone) = 9);

ALTER TABLE Client
ADD CONSTRAINT CK_Phone2 CHECK (Phone2 IS NULL OR (Phone2 LIKE '9%' AND LEN(Phone2) = 9));

ALTER TABLE Client
ADD CONSTRAINT CK_Status CHECK (Status IN ('A', 'I'));

-- Validating date format (dd-MM-yyyy)
ALTER TABLE Client
ADD CONSTRAINT CK_BirthDate CHECK (
    FORMAT(BirthDate, 'dd-MM-yyyy') IS NOT NULL AND
    BirthDate >= '1900-01-01' AND 
    BirthDate <= GETDATE()
);

-- Adding constraint to ensure ClientCode format like 'C0001'
ALTER TABLE Client
ADD CONSTRAINT CK_ClientCode CHECK (ClientCode LIKE 'C[0-9][0-9][0-9][0-9]');


INSERT INTO Client (ClientCode, DocumentType, DocumentNumber, FirstName, LastName, BirthDate, Email, Phone, Phone2, Address) 
VALUES 
('C0001', 'DNI', '81654321', 'John', 'Smith', '01-01-1990', 'john.smith@example.com', '912345678', '912345679', 'New York, USA'),
('C0002', 'DNI', '77654321', 'Vidal', 'Luyo', '01-01-1990', 'vidal.luyo@example.com', '912345678', '912345679', 'New York, USA');

SELECT * FROM Client