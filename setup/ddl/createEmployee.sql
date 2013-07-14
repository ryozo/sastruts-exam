CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employeeno` varchar(10) NOT NULL,
  `employeename` varchar(255) DEFAULT NULL,
  `entranceday` date DEFAULT NULL,
  `retireday` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `employeeno` (`employeeno`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8