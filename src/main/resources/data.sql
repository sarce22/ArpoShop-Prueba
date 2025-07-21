-- 📄 ARCHIVO CORREGIDO: src/main/resources/data.sql
-- 🎯 Spring Boot ejecuta este archivo automáticamente

-- Insertar roles si no existen (usando nombre de tabla correcto)
INSERT INTO rol (id_rol, name_rol) 
SELECT 1, 'Cliente' 
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE id_rol = 1);

INSERT INTO rol (id_rol, name_rol) 
SELECT 2, 'Administrador' 
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE id_rol = 2);

INSERT INTO rol (id_rol, name_rol) 
SELECT 3, 'Empleado' 
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE id_rol = 3);