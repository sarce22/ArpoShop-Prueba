-- 📄 ARCHIVO NUEVO: src/main/resources/data.sql
-- 🎯 Spring Boot ejecuta este archivo automáticamente

-- Insertar roles si no existen
INSERT INTO rol (id_rol, name_rol) VALUES (1, 'Cliente') ON CONFLICT DO NOTHING;
INSERT INTO rol (id_rol, name_rol) VALUES (2, 'Administrador') ON CONFLICT DO NOTHING;

-- PostgreSQL version (más compatible):
INSERT INTO rol (id_rol, name_rol) 
SELECT 1, 'Cliente' 
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE id_rol = 1);

INSERT INTO rol (id_rol, name_rol) 
SELECT 2, 'Administrador' 
WHERE NOT EXISTS (SELECT 1 FROM rol WHERE id_rol = 2);