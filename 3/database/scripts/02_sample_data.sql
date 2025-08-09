INSERT INTO sedes (nombre, direccion, latitud, longitud, horario, capacidad)
VALUES 
  ('PILARES Centro', 'Av. Juárez 123, Centro Histórico', 19.4326, -99.1332, 'L-V 9:00-18:00', 100),
  ('PILARES Norte', 'Av. Insurgentes Norte 456', 19.4926, -99.1332, 'L-S 8:00-17:00', 80);

INSERT INTO actividades (nombre, sede_id, horario, cupo)
VALUES
  ('Taller de pintura', 1, 'Martes y Jueves 16:00-18:00', 15),
  ('Clases de computación', 1, 'Lunes a Viernes 10:00-12:00', 20),
  ('Yoga', 2, 'Miércoles y Viernes 9:00-10:30', 10);