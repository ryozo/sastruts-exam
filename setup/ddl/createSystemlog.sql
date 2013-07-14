CREATE TABLE `systemlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `preinfo` text,
  `postinfo` text,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8