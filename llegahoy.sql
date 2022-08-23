-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-08-2022 a las 07:45:51
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `llegahoy`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formulario`
--

CREATE TABLE `formulario` (
  `id_formulario` int(100) NOT NULL,
  `nombre_formulario` varchar(30) NOT NULL,
  `apellido_formulario` varchar(30) NOT NULL,
  `email_formulario` varchar(50) NOT NULL,
  `mensaje_formulario` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `formulario`
--

INSERT INTO `formulario` (`id_formulario`, `nombre_formulario`, `apellido_formulario`, `email_formulario`, `mensaje_formulario`) VALUES
(1, 'Alberto', 'Perez', 'perezalberto@hotmail.com', 'Me gustaría saber precios gracias'),
(2, 'Julian', 'Olavarria', 'olavarriajulian@hotmail.com', 'Quiero contratar sus servicios por favor llamenme'),
(3, 'Micaela', 'Gutierrez', 'micaguti@hotmail.com', 'En que zonas trabajan?'),
(4, 'Pedro', 'Miguel', 'pmiguel@hotmail.com', 'Busco trabajo puedo mandarles un cv?'),
(5, 'Omar', 'Don', 'donomar@gmail.com', 'aaaaaaaaaaaaaaaaaaaaaaaa'),
(7, 'alberto', 'paredes', 'paredes@hotmail.com', 'Necesito más inforamcion de los precios gracias'),
(8, 'horacio', 'oneto', 'horacioneto@hotmail.com', 'Hola hackers los extraño!'),
(9, 'alberto', 'art', 'a@saaaaaa.com', 'aaaaaaaaaaaaaaaaaaaaaaaaaaa'),
(10, 'Pedro', 'Gustavo', 'pedro@hotmail.com', 'Estamos probando gracias'),
(11, 'Lucas', 'Skywalker', 'luke@gmail.com', 'este mensaje es muy importante'),
(12, 'Matias', 'Felix', 'matias@hotmail.com', 'Hola santi como estas');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`username`, `password`) VALUES
('fernando', 'marvel1212'),
('horacio', 'hacker2'),
('horacio1', 'elperroseescapa'),
('julian', 'torres14'),
('lucas', 'mateo12'),
('oliver', 'atom12'),
('pablo', 'boca14'),
('ulises', 'troya1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `formulario`
--
ALTER TABLE `formulario`
  ADD PRIMARY KEY (`id_formulario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `formulario`
--
ALTER TABLE `formulario`
  MODIFY `id_formulario` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
