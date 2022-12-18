-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 06-Nov-2022 às 12:33
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `task app`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `projects`
--

CREATE TABLE `projects` (
  `ID` int(11) NOT NULL,
  `NAME` varchar(100) COLLATE latin1_bin NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE latin1_bin NOT NULL,
  `CREATED_AT` datetime NOT NULL,
  `UPDATE_AT` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Extraindo dados da tabela `projects`
--

INSERT INTO `projects` (`ID`, `NAME`, `DESCRIPTION`, `CREATED_AT`, `UPDATE_AT`) VALUES
(1, 'projeto teste', 'descrição', '2022-09-03 00:00:00', '2022-09-03 00:00:00'),
(2, 'projeto teste', 'descrição', '2022-09-03 00:00:00', '2022-09-03 00:00:00'),
(20, 'hoje', 'hoje', '2022-09-21 00:00:00', '2022-09-21 00:00:00'),
(21, 'tt', 'tt', '2022-09-23 00:00:00', '2022-09-23 00:00:00'),
(22, 'projeto editar', 'projeto que edita as taerfas', '2022-09-25 00:00:00', '2022-09-25 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `ID` int(11) NOT NULL,
  `ID_PROJECT` int(11) NOT NULL,
  `NAME` varchar(100) COLLATE latin1_bin NOT NULL,
  `DESCRIPTION` varchar(250) COLLATE latin1_bin NOT NULL,
  `COMPLETED` tinyint(1) NOT NULL,
  `NOTES` varchar(150) COLLATE latin1_bin DEFAULT NULL,
  `DEADLINE` date NOT NULL,
  `CREATED_AT` datetime NOT NULL,
  `UPDATE_AT` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_bin;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`ID`, `ID_PROJECT`, `NAME`, `DESCRIPTION`, `COMPLETED`, `NOTES`, `DEADLINE`, `CREATED_AT`, `UPDATE_AT`) VALUES
(21, 1, 'tarefa', 'tarefas', 0, 'tarerfas', '2023-10-10', '2022-09-21 00:00:00', '2022-09-21 00:00:00'),
(23, 20, 'tarefa', 'tarefa', 0, 'tarefa', '2023-10-10', '2022-09-21 00:00:00', '2022-09-21 00:00:00'),
(25, 2, 'tarefa 2', 'tarefa 2', 0, 'tarefa 2', '0002-11-30', '2022-09-21 00:00:00', '2022-09-21 00:00:00'),
(32, 1, 'tttt', 'ttt', 0, 'ttt', '2023-10-10', '2022-09-23 00:00:00', '2022-09-23 00:00:00'),
(40, 1, 'yyyy', 'yyyy', 0, 'yyyy', '2025-10-10', '2022-11-05 00:00:00', '2022-11-05 00:00:00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `projects`
--
ALTER TABLE `projects`
  ADD PRIMARY KEY (`ID`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_PROJECT` (`ID_PROJECT`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `projects`
--
ALTER TABLE `projects`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `tasks_ibfk_1` FOREIGN KEY (`ID_PROJECT`) REFERENCES `projects` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
